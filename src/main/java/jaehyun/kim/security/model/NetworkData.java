package jaehyun.kim.security.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Data
@NoArgsConstructor
public class NetworkData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "소스 IP는 필수입니다")
    @Pattern(regexp = "^127\\.0\\.0\\.[1-9][0-9]*$", message = "유효한 로컬호스트 IP 주소여야 합니다")
    private String sourceIp;

    @NotBlank(message = "목적지 IP는 필수입니다")
    @Pattern(regexp = "^127\\.0\\.0\\.[1-9][0-9]*$", message = "유효한 로컬호스트 IP 주소여야 합니다")
    private String destinationIp;

    @NotNull(message = "포트는 필수입니다")
    @Min(value = 1, message = "포트는 1 이상이어야 합니다")
    @Max(value = 65535, message = "포트는 65535 이하여야 합니다")
    private Integer port;

    @NotBlank(message = "프로토콜은 필수입니다")
    @Pattern(regexp = "^(HTTP|HTTPS|SSH|FTP|TELNET)$", message = "지원되는 프로토콜이어야 합니다")
    private String protocol;

    @NotNull(message = "타임스탬프는 필수입니다")
    private Long timestamp;

    @NotNull(message = "대역폭 사용량은 필수입니다")
    @Min(value = 0, message = "대역폭 사용량은 0 이상이어야 합니다")
    private Double bandwidthUsage;

    @NotBlank(message = "연결 상태는 필수입니다")
    @Pattern(regexp = "^(ESTABLISHED|CLOSED|LISTENING)$", message = "유효한 연결 상태여야 합니다")
    private String connectionStatus;

    @NotNull(message = "위험도 점수는 필수입니다")
    @Min(value = 0, message = "위험도 점수는 0 이상이어야 합니다")
    @Max(value = 1, message = "위험도 점수는 1 이하여야 합니다")
    private Double riskScore;

    @Transient
    private Map<String, Object> packetData;

    private int packetCount;

    public boolean isLocalhost() {
        return sourceIp.startsWith("127.0.0.") && destinationIp.startsWith("127.0.0.");
    }

    public void calculateRiskScore() {
        if (sourceIp == null || destinationIp == null || protocol == null || port == null || bandwidthUsage == null) {
            throw new IllegalStateException("위험도 계산에 필요한 데이터가 누락되었습니다");
        }

        double score = 0.0;
        
        // 프로토콜 기반 위험도
        switch (protocol) {
            case "SSH": score += 0.3; break;
            case "HTTP": score += 0.1; break;
            case "HTTPS": score += 0.05; break;
            case "FTP": score += 0.4; break;
            case "TELNET": score += 0.5; break;
            default: throw new IllegalArgumentException("지원하지 않는 프로토콜입니다: " + protocol);
        }

        // 포트 기반 위험도
        if (port < 1024) score += 0.2;
        if (port == 22) score += 0.1;
        if (port == 23) score += 0.2;
        if (port == 21) score += 0.15;

        // 대역폭 사용량 기반 위험도
        if (bandwidthUsage > 2000) score += 0.2;
        else if (bandwidthUsage > 1000) score += 0.1;

        // IP 주소 기반 위험도
        if (isLocalhost()) score -= 0.1;

        this.riskScore = Math.min(Math.max(score, 0.0), 1.0);
    }

    // 네트워크 트래픽 패턴 분석을 위한 메서드
    public boolean isAnomaly() {
        // 이상 패턴 감지 로직
        return false;
    }
} 