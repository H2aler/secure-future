package kr.jaehyun.security.repository;

import kr.jaehyun.security.model.NetworkData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NetworkDataRepository extends JpaRepository<NetworkData, Long> {
    
    // 위험도가 높은 네트워크 트래픽 조회
    List<NetworkData> findByRiskScoreGreaterThanEqualOrderByRiskScoreDesc(double riskScore);
    
    // 특정 IP 주소의 트래픽 조회
    List<NetworkData> findBySourceIpOrDestinationIp(String sourceIp, String destinationIp);
    
    // 프로토콜별 평균 위험도 조회
    @Query("SELECT n.protocol, COUNT(n) as count, AVG(n.riskScore) as avgRiskScore, MAX(n.riskScore) as maxRiskScore " +
           "FROM NetworkData n GROUP BY n.protocol ORDER BY avgRiskScore DESC")
    List<Object[]> findProtocolRiskStats();
    
    // 최근 1시간 동안의 트래픽 조회
    @Query("SELECT n FROM NetworkData n WHERE n.timestamp > :timestamp ORDER BY n.timestamp DESC")
    List<NetworkData> findRecentTraffic(long timestamp);
    
    // 대역폭 사용량이 높은 트래픽 조회
    List<NetworkData> findByBandwidthUsageGreaterThanOrderByBandwidthUsageDesc(double threshold);
} 