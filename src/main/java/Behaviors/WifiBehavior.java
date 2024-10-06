package Behaviors;

import Devices.Device;
import Devices.WifiRouter;

import java.util.List;

public class WifiBehavior implements ConnectBehavior {
    @Override
    public void connect(Device self, List<Device> devices) {
        List<Device> enableDevice = devices.stream()
                .filter(device ->
                        !device.behaviors.stream()
                                .filter(connectBehavior -> connectBehavior.getType() == ConnectBehaviorType.WIFI).toList().isEmpty()
                ).toList(); // WIFI 연결 가능한 Device(아마 와이파이 라우터) 들만 필터링

        if (enableDevice.isEmpty()){
            return;
        }
        // 속도가 가장 빠른 와이파이를 구하는 로직  reduce 로 구현
        Device maxSpeedDevice = enableDevice.stream().reduce(devices.get(0), (max, device) -> {
            if (device instanceof WifiRouter) {
                if (max instanceof WifiRouter maxRouter) {
                    if (maxRouter.getSpeed() > ((WifiRouter) device).getSpeed()) {
                        return max;
                    }
                }
            }
            return device;
        });


        // 양쪽 디바이스에 연결
        self.connectionDevices.add(maxSpeedDevice); // array 에 추가
        maxSpeedDevice.connectionDevices.add(self); // array 에 추가

        System.out.println(maxSpeedDevice + "와 " + self + "연결 성공");
    }

    @Override
    public ConnectBehaviorType getType() {
        return ConnectBehaviorType.WIFI;
    }
}
