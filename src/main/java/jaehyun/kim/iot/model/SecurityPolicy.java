package jaehyun.kim.iot.model;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class SecurityPolicy {
    private String policyId;
    private String policyName;
    private LocalDateTime lastModified;
    private Map<String, String> accessRules;
    private List<String> allowedProtocols;
    private int maxConnections;
    private boolean encryptionRequired;
    private String authenticationMethod;
    private Map<String, Object> customRules;
    
    public SecurityPolicy() {
        this.policyId = generatePolicyId();
        this.lastModified = LocalDateTime.now();
        this.policyName = "Default Policy";
        this.maxConnections = 100;
        this.encryptionRequired = true;
        this.authenticationMethod = "MULTI_FACTOR";
    }
    
    private String generatePolicyId() {
        return "POL-" + System.currentTimeMillis();
    }
    
    public boolean validateAccess(String resource, String user) {
        // 접근 제어 검증 로직
        return true;
    }
    
    public void updateRules(Map<String, String> newRules) {
        this.accessRules = newRules;
        this.lastModified = LocalDateTime.now();
    }
} 