package Behaviors;

import Devices.Device;

import java.util.List;

public class BluetoothBehavior implements ConnectBehavior {
    @Override
    public void connect(Device self, List<Device> devices) {
        List<Device> enableDevices = devices.stream()
                .filter(device ->
                        !device.behaviors.stream()
                                .filter(connectBehavior -> connectBehavior.getType() == ConnectBehaviorType.BLUETOOTH).toList().isEmpty()
                ).toList(); // WIFI 연결 가능한 Device(아마 와이파이 라우터) 들만 필터링
        if (enableDevices.isEmpty()){
            return;
        }
        enableDevices.forEach(enableDevice -> {
            // 양쪽 디바이스에 연결
            enableDevice.connectionDevices.add(self);
            self.connectionDevices.add(enableDevice);
            System.out.println(enableDevice + "와 " + self + "연결 성공");
        });


    }


    @Override
    public ConnectBehaviorType getType() {
        return ConnectBehaviorType.BLUETOOTH;
    }
}
