package kr.jaehyun.security;

import kr.jaehyun.security.model.NetworkData;
import kr.jaehyun.security.model.ThreatPrediction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AIThreatPredictor {
    
    public ThreatPrediction predictThreat(NetworkData networkData) {
        // 위협 점수 계산
        double threatScore = calculateThreatScore(networkData);
        
        // 위협 유형 판단
        String threatType = determineThreatType(threatScore);
        
        // 위협 설명 생성
        String description = generateThreatDescription(networkData, threatType);
        
        // ThreatPrediction 객체 생성
        ThreatPrediction prediction = new ThreatPrediction(threatScore, threatType, description);
        
        // 추가 정보 설정
        prediction.setResponseStrategy(determineResponseStrategy(threatScore));
        prediction.setConfidence(calculateConfidence(threatScore));
        prediction.setPriorityLevel(determinePriorityLevel(threatScore));
        prediction.setNetworkData(networkData);
        
        return prediction;
    }
    
    private double calculateThreatScore(NetworkData networkData) {
        double score = networkData.getRiskScore();
        
        // 추가 위험 요소 고려
        if (networkData.getBandwidthUsage() > 2000) {
            score += 0.1;
        }
        
        if (networkData.getPort() < 1024) {
            score += 0.1;
        }
        
        return Math.min(score, 1.0);
    }
    
    private String determineThreatType(double threatScore) {
        if (threatScore >= 0.8) {
            return "MALWARE";
        } else if (threatScore >= 0.6) {
            return "SCAN";
        } else if (threatScore >= 0.4) {
            return "SUSPICIOUS";
        } else {
            return "NORMAL";
        }
    }
    
    private String generateThreatDescription(NetworkData networkData, String threatType) {
        switch (threatType) {
            case "MALWARE":
                return String.format("의심스러운 파일 전송 감지 (IP: %s, 포트: %d)", 
                    networkData.getSourceIp(), networkData.getPort());
            case "SCAN":
                return String.format("포트 스캔 감지 (IP: %s)", networkData.getSourceIp());
            case "SUSPICIOUS":
                return String.format("비정상적인 트래픽 패턴 감지 (IP: %s, 프로토콜: %s)", 
                    networkData.getSourceIp(), networkData.getProtocol());
            default:
                return "정상적인 트래픽";
        }
    }
    
    private String determineResponseStrategy(double threatScore) {
        if (threatScore >= 0.8) {
            return "BLOCK_AND_ALERT";
        } else if (threatScore >= 0.6) {
            return "ALERT_AND_MONITOR";
        } else if (threatScore >= 0.4) {
            return "MONITOR";
        } else {
            return "ALLOW";
        }
    }
    
    private double calculateConfidence(double threatScore) {
        return Math.min(threatScore + 0.2, 1.0);
    }
    
    private int determinePriorityLevel(double threatScore) {
        if (threatScore >= 0.8) {
            return 1; // 최우선
        } else if (threatScore >= 0.6) {
            return 2; // 높음
        } else if (threatScore >= 0.4) {
            return 3; // 중간
        } else {
            return 4; // 낮음
        }
    }
} 