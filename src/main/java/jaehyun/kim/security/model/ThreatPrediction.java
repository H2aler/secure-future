package jaehyun.kim.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ThreatPrediction {
    private double threatScore;
    private String threatType;
    private String mitigationStrategy;
    private LocalDateTime predictionTime;
    private String confidenceLevel;
    private String affectedSystems;
    
    public ThreatPrediction(double threatScore, String threatType, String mitigationStrategy) {
        this.threatScore = threatScore;
        this.threatType = threatType;
        this.mitigationStrategy = mitigationStrategy;
        this.predictionTime = LocalDateTime.now();
        this.confidenceLevel = "MEDIUM";
        this.affectedSystems = "ALL";
    }
    
    public boolean requiresImmediateAction() {
        return threatScore > 0.7;
    }
    
    public String getPriorityLevel() {
        if (threatScore > 0.8) return "CRITICAL";
        if (threatScore > 0.6) return "HIGH";
        if (threatScore > 0.4) return "MEDIUM";
        return "LOW";
    }
} 