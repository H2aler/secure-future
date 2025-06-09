package kr.jaehyun.iot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private long lastSeen;
    private boolean isSecure;
    private String metrics;
    
    @ManyToOne
    private SecurityPolicy securityPolicy;
    
    public boolean isHealthy() {
        return "ACTIVE".equals(status) && 
               (System.currentTimeMillis() - lastSeen) < 300000; // 5분 이내 접속
    }
    
    public void updateSecurityPolicy(SecurityPolicy policy) {
        this.securityPolicy = policy;
        this.isSecure = policy != null && 
                       policy.isRequiresEncryption() && 
                       policy.isRequiresAuthentication();
    }
} 