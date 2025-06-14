package jaehyun.kim.iot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class IoTDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private String deviceType;
    private String manufacturer;
    private String firmwareVersion;
    private String status;
    private String ipAddress;
    private Long lastSeen;
    private Boolean isSecure;
    private String metrics;

    @ManyToOne
    @JoinColumn(name = "security_policy_id")
    private SecurityPolicy securityPolicy;

    public boolean isHealthy() {
        return "ACTIVE".equals(status) && isSecure;
    }

    public void updateSecurityPolicy(SecurityPolicy policy) {
        this.securityPolicy = policy;
        this.isSecure = policy != null && policy.getRequiresEncryption() && policy.getRequiresAuthentication();
    }
    
    public boolean isVulnerable() {
        // 취약점 검사 로직
        return false;
    }
    
    public void updateMetrics(Map<String, Object> newMetrics) {
        this.metrics = newMetrics.toString();
    }
} 