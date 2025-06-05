package jaehyun.kim.iot.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;

@Data
public class IoTDevice {
    private String deviceId;
    private String deviceType;
    private String manufacturer;
    private String firmwareVersion;
    private LocalDateTime lastUpdateTime;
    private boolean isHealthy;
    private Map<String, Object> deviceMetrics;
    private SecurityPolicy currentPolicy;
    private String connectionStatus;
    private String location;
    
    public boolean isHealthy() {
        return isHealthy;
    }
    
    public void updateSecurityPolicy(SecurityPolicy policy) {
        this.currentPolicy = policy;
        this.lastUpdateTime = LocalDateTime.now();
    }
    
    public boolean isVulnerable() {
        // 취약점 검사 로직
        return false;
    }
    
    public void updateMetrics(Map<String, Object> newMetrics) {
        this.deviceMetrics = newMetrics;
        this.lastUpdateTime = LocalDateTime.now();
    }
} 