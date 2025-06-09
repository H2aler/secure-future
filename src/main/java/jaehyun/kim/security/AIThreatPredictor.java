package jaehyun.kim.security;

import jaehyun.kim.security.model.NetworkData;
import jaehyun.kim.security.model.ThreatPrediction;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AIThreatPredictor {
    
    public ThreatPrediction predictThreat(NetworkData networkData) {
        // 위험도 점수 계산
        networkData.calculateRiskScore();
        
        // 위협 예측 생성
        ThreatPrediction prediction = new ThreatPrediction();
        prediction.setThreatScore(networkData.getRiskScore());
        prediction.setNetworkData(networkData);
        prediction.setTimestamp(System.currentTimeMillis());
        
        // 위협 유형 결정
        prediction.determineThreatType();
        
        // 신뢰도 계산 (개발 환경에서는 고정값 사용)
        prediction.setConfidence(0.9);
        
        log.info("위협 예측 생성: {} - 네트워크 데이터: {}", 
                prediction.getThreatType(), networkData.getSourceIp());
        
        return prediction;
    }
} 