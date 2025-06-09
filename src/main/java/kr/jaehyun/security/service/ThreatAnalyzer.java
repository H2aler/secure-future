package kr.jaehyun.security.service;

import kr.jaehyun.security.model.NetworkData;
import kr.jaehyun.security.model.ThreatPrediction;
import kr.jaehyun.security.repository.NetworkDataRepository;
import kr.jaehyun.security.repository.ThreatPredictionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ThreatAnalyzer {
    
    @Autowired
    private NetworkDataRepository networkDataRepository;
    
    @Autowired
    private ThreatPredictionRepository threatPredictionRepository;
    
    @Scheduled(fixedRate = 300000) // 5분마다 실행
    @Transactional
    public void analyzeThreats() {
        try {
            log.info("위협 분석 시작");
            
            // 위험도가 높은 네트워크 트래픽 조회
            List<NetworkData> highRiskTraffic = networkDataRepository
                .findByRiskScoreGreaterThanEqualOrderByRiskScoreDesc(0.7);
            
            for (NetworkData traffic : highRiskTraffic) {
                // 이미 분석된 트래픽은 건너뛰기
                if (traffic.getThreatPrediction() != null) {
                    continue;
                }
                
                // 위협 예측 생성
                ThreatPrediction prediction = analyzeTraffic(traffic);
                if (prediction != null) {
                    prediction.setNetworkData(traffic);
                    threatPredictionRepository.save(prediction);
                    log.info("위협 예측 생성 완료: {}", prediction);
                }
            }
            
            log.info("위협 분석 완료");
        } catch (Exception e) {
            log.error("위협 분석 중 오류 발생", e);
        }
    }
    
    private ThreatPrediction analyzeTraffic(NetworkData traffic) {
        ThreatPrediction prediction = new ThreatPrediction();
        prediction.setTimestamp(System.currentTimeMillis());
        
        // 위협 점수 계산
        double threatScore = calculateThreatScore(traffic);
        prediction.setThreatScore(threatScore);
        
        // 위협 유형 판단
        String threatType = determineThreatType(traffic, threatScore);
        prediction.setThreatType(threatType);
        
        // 위협 설명 생성
        String description = generateThreatDescription(traffic, threatType);
        prediction.setDescription(description);
        
        // 응답 전략 결정
        String responseStrategy = determineResponseStrategy(threatScore, threatType);
        prediction.setResponseStrategy(responseStrategy);
        
        // 신뢰도 계산
        double confidence = calculateConfidence(traffic, threatType);
        prediction.setConfidence(confidence);
        
        // 우선순위 결정
        int priorityLevel = determinePriorityLevel(threatScore, threatType);
        prediction.setPriorityLevel(priorityLevel);
        
        return prediction;
    }
    
    private double calculateThreatScore(NetworkData traffic) {
        double score = traffic.getRiskScore();
        
        // 추가 위험 요소 고려
        if (traffic.getBandwidthUsage() > 2000) {
            score += 0.1;
        }
        
        if (traffic.getPort() < 1024) {
            score += 0.1;
        }
        
        return Math.min(score, 1.0);
    }
    
    private String determineThreatType(NetworkData traffic, double threatScore) {
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
    
    private String generateThreatDescription(NetworkData traffic, String threatType) {
        switch (threatType) {
            case "MALWARE":
                return String.format("의심스러운 파일 전송 감지 (IP: %s, 포트: %d)", 
                    traffic.getSourceIp(), traffic.getPort());
            case "SCAN":
                return String.format("포트 스캔 감지 (IP: %s)", traffic.getSourceIp());
            case "SUSPICIOUS":
                return String.format("비정상적인 트래픽 패턴 감지 (IP: %s, 프로토콜: %s)", 
                    traffic.getSourceIp(), traffic.getProtocol());
            default:
                return "정상적인 트래픽";
        }
    }
    
    private String determineResponseStrategy(double threatScore, String threatType) {
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
    
    private double calculateConfidence(NetworkData traffic, String threatType) {
        double confidence = 0.5; // 기본 신뢰도
        
        // 위협 유형별 신뢰도 조정
        switch (threatType) {
            case "MALWARE":
                confidence += 0.3;
                break;
            case "SCAN":
                confidence += 0.2;
                break;
            case "SUSPICIOUS":
                confidence += 0.1;
                break;
        }
        
        // 추가 요소 고려
        if (traffic.getBandwidthUsage() > 2000) {
            confidence += 0.1;
        }
        
        return Math.min(confidence, 1.0);
    }
    
    private int determinePriorityLevel(double threatScore, String threatType) {
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