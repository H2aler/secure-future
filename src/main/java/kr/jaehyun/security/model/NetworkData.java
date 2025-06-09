package kr.jaehyun.security.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "network_data")
@Data
@NoArgsConstructor
public class NetworkData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "source_ip", nullable = false)
    private String sourceIp;
    
    @Column(name = "destination_ip", nullable = false)
    private String destinationIp;
    
    @Column(nullable = false)
    private Integer port;
    
    @Column(nullable = false)
    private String protocol;
    
    @Column(nullable = false)
    private Long timestamp;
    
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] payload;
    
    @Column(name = "bandwidth_usage")
    private Double bandwidthUsage;
    
    @Column(name = "connection_status")
    private String connectionStatus;
    
    @Column(name = "risk_score")
    private Double riskScore;
    
    @OneToOne(mappedBy = "networkData", cascade = CascadeType.ALL)
    private ThreatPrediction threatPrediction;
} 