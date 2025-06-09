package kr.jaehyun.security.collector;

import kr.jaehyun.security.model.NetworkData;
import kr.jaehyun.security.repository.NetworkDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class NetworkDataCollector {

    private final NetworkDataRepository networkDataRepository;
    private final Random random = new Random();

    @Scheduled(fixedRate = 60000) // 1분마다 실행
    public void collectNetworkData() {
        try {
            List<NetworkData> networkDataList = new ArrayList<>();
            
            // 네트워크 인터페이스 정보 수집
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                    // 각 인터페이스의 IP 주소 수집
                    Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        InetAddress address = addresses.nextElement();
                        if (!address.isLoopbackAddress() && address.getHostAddress().indexOf(':') == -1) {
                            NetworkData data = createNetworkData(address.getHostAddress());
                            networkDataList.add(data);
                        }
                    }
                }
            }

            // 외부 네트워크 트래픽 모니터링
            monitorExternalTraffic(networkDataList);

            // 데이터 저장
            networkDataRepository.saveAll(networkDataList);
            log.info("수집된 네트워크 데이터: {} 개", networkDataList.size());

        } catch (Exception e) {
            log.error("네트워크 데이터 수집 중 오류 발생", e);
        }
    }

    private void monitorExternalTraffic(List<NetworkData> networkDataList) {
        try {
            // netstat 명령어 실행
            Process process = Runtime.getRuntime().exec("netstat -n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("TCP") || line.contains("UDP")) {
                    String[] parts = line.trim().split("\\s+");
                    if (parts.length >= 4) {
                        String[] localAddress = parts[3].split(":");
                        if (localAddress.length == 2) {
                            String sourceIp = localAddress[0];
                            int port = Integer.parseInt(localAddress[1]);
                            
                            NetworkData data = new NetworkData();
                            data.setSourceIp(sourceIp);
                            data.setDestinationIp("0.0.0.0");
                            data.setProtocol(parts[0]);
                            data.setPort(port);
                            data.setBandwidthUsage((double) random.nextInt(5000));
                            data.setRiskScore(calculateRiskScore(port, data.getBandwidthUsage()));
                            data.setTimestamp(System.currentTimeMillis());
                            
                            networkDataList.add(data);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("외부 트래픽 모니터링 중 오류 발생", e);
        }
    }

    private NetworkData createNetworkData(String ipAddress) {
        NetworkData data = new NetworkData();
        data.setSourceIp(ipAddress);
        data.setDestinationIp("0.0.0.0");
        data.setProtocol("TCP");
        data.setPort(random.nextInt(65535));
        data.setBandwidthUsage((double) random.nextInt(5000));
        data.setRiskScore(calculateRiskScore(data.getPort(), data.getBandwidthUsage()));
        data.setTimestamp(System.currentTimeMillis());
        return data;
    }

    private double calculateRiskScore(int port, Double bandwidthUsage) {
        double score = 0.0;
        
        // 포트 기반 위험도
        if (port < 1024) {
            score += 0.3; // 잘 알려진 포트
        } else if (port >= 1024 && port < 49152) {
            score += 0.1; // 등록된 포트
        }
        
        // 대역폭 사용량 기반 위험도
        if (bandwidthUsage > 4000) {
            score += 0.4;
        } else if (bandwidthUsage > 2000) {
            score += 0.2;
        }
        
        // 랜덤 요소 추가 (실제 환경에서는 더 정교한 로직 필요)
        score += random.nextDouble() * 0.2;
        
        return Math.min(score, 1.0);
    }
} 