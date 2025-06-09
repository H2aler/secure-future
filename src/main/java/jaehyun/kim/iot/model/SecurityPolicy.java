package jaehyun.kim.iot.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class SecurityPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyId;
    private String policyName;
    private String deviceType;
    private Boolean requiresEncryption;
    private Boolean requiresAuthentication;
    private Integer maxConnections;
    private String accessRules;
    private String authenticationMethod;
    private Boolean isDynamic;

    @ElementCollection
    private Set<String> allowedProtocols;

    public boolean isCompliant(String protocol) {
        return allowedProtocols.contains(protocol);
    }
} 