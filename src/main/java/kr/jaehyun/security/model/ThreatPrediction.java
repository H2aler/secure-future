package kr.jaehyun.security.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "threat_prediction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreatPrediction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "threat_score", nullable = false)
    private Double threatScore;
    
    @Column(name = "threat_type", nullable = false)
    private String threatType;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private Long timestamp;
    
    @Column(name = "response_strategy")
    private String responseStrategy;
    
    @Column
    private Double confidence;
    
    @Column(name = "priority_level")
    private Integer priorityLevel;
    
    @OneToOne
    @JoinColumn(name = "network_data_id")
    private NetworkData networkData;

    // 위협 점수, 유형, 설명을 받는 생성자
    public ThreatPrediction(double threatScore, String threatType, String description) {
        this.threatScore = threatScore;
        this.threatType = threatType;
        this.description = description;
        this.timestamp = System.currentTimeMillis();
    }
} 