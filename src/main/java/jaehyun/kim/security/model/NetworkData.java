package jaehyun.kim.security.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class NetworkData {
    private String sourceIp;
    private String destinationIp;
    private int sourcePort;
    private int destinationPort;
    private String protocol;
    private LocalDateTime timestamp;
    private Map<String, Object> packetData;
    private double bandwidthUsage;
    private int packetCount;
    private String connectionStatus;
    
    // 네트워크 트래픽 패턴 분석을 위한 메서드
    public boolean isAnomaly() {
        // 이상 패턴 감지 로직
        return false;
    }
    
    public double calculateRiskScore() {
        // 위험도 점수 계산 로직
        return 0.0;
    }
} 