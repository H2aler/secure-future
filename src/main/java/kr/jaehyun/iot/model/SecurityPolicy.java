package kr.jaehyun.iot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

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
    private boolean requiresEncryption;
    private boolean requiresAuthentication;
    private int maxConnections;
    
    @ElementCollection
    @CollectionTable(name = "security_policy_protocols", 
                    joinColumns = @JoinColumn(name = "policy_id"))
    private List<String> allowedProtocols;
    
    private String accessRules;
    private String authenticationMethod;
    private boolean isDynamic;
} 