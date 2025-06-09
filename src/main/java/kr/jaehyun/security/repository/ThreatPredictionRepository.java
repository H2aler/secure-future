package kr.jaehyun.security.repository;

import kr.jaehyun.security.model.ThreatPrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreatPredictionRepository extends JpaRepository<ThreatPrediction, Long> {
    
    // 위협 점수가 높은 예측 결과 조회
    List<ThreatPrediction> findByThreatScoreGreaterThanEqualOrderByThreatScoreDesc(double threatScore);
    
    // 특정 위협 유형의 예측 결과 조회
    List<ThreatPrediction> findByThreatTypeOrderByTimestampDesc(String threatType);
    
    // 최근 1시간 동안의 위협 예측 결과 조회
    @Query("SELECT t FROM ThreatPrediction t WHERE t.timestamp > :timestamp ORDER BY t.timestamp DESC")
    List<ThreatPrediction> findRecentPredictions(long timestamp);
    
    // 위협 유형별 통계 조회
    @Query("SELECT t.threatType, COUNT(t) as count, AVG(t.threatScore) as avgScore, " +
           "AVG(t.confidence) as avgConfidence FROM ThreatPrediction t " +
           "GROUP BY t.threatType ORDER BY count DESC")
    List<Object[]> findThreatTypeStats();
    
    // 우선순위가 높은 위협 예측 결과 조회
    List<ThreatPrediction> findByPriorityLevelLessThanEqualOrderByPriorityLevelAsc(int priorityLevel);
} 