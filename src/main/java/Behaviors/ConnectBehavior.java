package Behaviors;

import Devices.Device;

import java.util.*;



// Connect 의 방식을 관장하기 위해 ConnectBehavior에 connect, disconnect 구현.
// disconnect 함수 같은 경우, 상속받는 객체마다 다르지 않을 것 같아 interface 내부에서 default 함수로 정의했습니다.
// Strategy 패턴을 사용해 구현했습니다.
public interface ConnectBehavior {
    List<Device> connectedDevice = null;
    void connect(Device self, List<Device> devices);
    default void disconnect(Device self, Device device) {
        device.connectionDevices.remove(self);
        self.connectionDevices.remove(device);
        System.out.println(device + "와 " + self + "연결 해제");
    }

    default void disconnectAll(Device self) {
        // 먼저, self 에 연결되어있는 다른 device 에서 self 를 제거
        self.connectionDevices.forEach(device1 -> {
            device1.connectionDevices.remove(self);
        });
        // self 에 있는 연결된 모든 device 제거
        self.connectionDevices = new ArrayList<>();
    }
    ConnectBehaviorType getType();
}


