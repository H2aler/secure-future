package jaehyun.kim.iot;

import jaehyun.kim.iot.model.IoTDevice;
import jaehyun.kim.iot.model.SecurityPolicy;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.ArrayList;

@Component
@Slf4j
public class IoTDeviceManager {
    
    private final List<IoTDevice> devices = new ArrayList<>();
    
    public void registerDevice(IoTDevice device) {
        devices.add(device);
        log.info("디바이스 등록 완료: {}", device.getDeviceId());
    }
    
    public void updateDeviceStatus(String deviceId, String status) {
        devices.stream()
            .filter(d -> d.getDeviceId().equals(deviceId))
            .findFirst()
            .ifPresent(device -> {
                device.setStatus(status);
                device.setLastSeen(System.currentTimeMillis());
                log.info("디바이스 상태 업데이트: {} - {}", deviceId, status);
            });
    }
    
    public void applySecurityPolicy(String deviceId, SecurityPolicy policy) {
        devices.stream()
            .filter(d -> d.getDeviceId().equals(deviceId))
            .findFirst()
            .ifPresent(device -> {
                device.updateSecurityPolicy(policy);
                log.info("보안 정책 적용 완료: {}", deviceId);
            });
    }
    
    public List<IoTDevice> getUnhealthyDevices() {
        return devices.stream()
            .filter(device -> !device.isHealthy())
            .toList();
    }
} 