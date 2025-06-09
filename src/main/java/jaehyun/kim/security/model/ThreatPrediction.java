package jaehyun.kim.security.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ThreatPrediction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "위협 점수는 필수입니다")
    @Min(value = 0, message = "위협 점수는 0 이상이어야 합니다")
    @Max(value = 1, message = "위협 점수는 1 이하여야 합니다")
    private Double threatScore;

    @NotBlank(message = "위협 유형은 필수입니다")
    @Pattern(regexp = "^(MALWARE|SCAN|SUSPICIOUS|NORMAL)$", message = "유효한 위협 유형이어야 합니다")
    private String threatType;

    @NotBlank(message = "설명은 필수입니다")
    @Size(max = 255, message = "설명은 255자를 초과할 수 없습니다")
    private String description;

    @NotNull(message = "타임스탬프는 필수입니다")
    private Long timestamp;

    @NotBlank(message = "응답 전략은 필수입니다")
    @Pattern(regexp = "^(BLOCK_AND_ALERT|ALERT_AND_MONITOR|MONITOR|ALLOW)$", message = "유효한 응답 전략이어야 합니다")
    private String responseStrategy;

    @NotNull(message = "신뢰도는 필수입니다")
    @Min(value = 0, message = "신뢰도는 0 이상이어야 합니다")
    @Max(value = 1, message = "신뢰도는 1 이하여야 합니다")
    private Double confidence;

    @NotNull(message = "우선순위 레벨은 필수입니다")
    @Min(value = 1, message = "우선순위 레벨은 1 이상이어야 합니다")
    @Max(value = 4, message = "우선순위 레벨은 4 이하여야 합니다")
    private Integer priorityLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "network_data_id", nullable = false)
    private NetworkData networkData;

    public void determineThreatType() {
        if (threatScore == null) {
            throw new IllegalStateException("위협 점수가 설정되지 않았습니다");
        }

        if (threatScore >= 0.8) {
            threatType = "MALWARE";
            responseStrategy = "BLOCK_AND_ALERT";
            priorityLevel = 1;
        } else if (threatScore >= 0.6) {
            threatType = "SCAN";
            responseStrategy = "ALERT_AND_MONITOR";
            priorityLevel = 2;
        } else if (threatScore >= 0.4) {
            threatType = "SUSPICIOUS";
            responseStrategy = "MONITOR";
            priorityLevel = 3;
        } else {
            threatType = "NORMAL";
            responseStrategy = "ALLOW";
            priorityLevel = 4;
        }
    }
} 