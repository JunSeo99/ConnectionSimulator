package Behaviors;

import Devices.Device;

import java.util.*;


// device 와 ConnectBehavior 을 분리한 이유는 주체적으로 연결을 하는 객체 그리고 연결을 받는 객체 이 두가지 타입의 객체를 분리하기 위해서
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

        System.out.println("모든 연결 기기 해제");
    }
    ConnectBehaviorType getType();
}


