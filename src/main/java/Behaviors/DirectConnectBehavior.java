package Behaviors;

import Devices.Device;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DirectConnectBehavior implements ConnectBehavior {
    @Override
    public void connect(Device self, List<Device> devices) {
        List<Device> enableDevice = new ArrayList<>(devices.stream()
                .filter(device ->
                        !device.behaviors.stream()
                                .filter(connectBehavior -> connectBehavior.getType() == ConnectBehaviorType.DIRECT_CONNECT).toList().isEmpty()
                ).toList()); // WIFI 연결 가능한 Device(아마 와이파이 라우터) 들만 필터링


        if (enableDevice.isEmpty()){
            return;
        }
        // 기존 포트에 연결돼있던 device 와 새로 연결 할 수 있는 device 와 병합
        enableDevice.addAll(self.connectionDevices);

        // 병합된 결과를 섞음
        Collections.shuffle(enableDevice);

        if (enableDevice.size() > 1) {
            self.connectionDevices.add(enableDevice.get(0)); // array 에 추가
            self.connectionDevices.add(enableDevice.get(1)); // array 에 추가
            enableDevice.get(0).connectionDevices.add(self); // array 에 추가
            enableDevice.get(1).connectionDevices.add(self); // array 에 추가
            System.out.println(enableDevice.get(0) + ", " + enableDevice.get(1) + " 기기들과 " + self + " 연결 성공");

        } else {
            self.connectionDevices.add(enableDevice.get(0)); // array 에 추가
            enableDevice.get(0).connectionDevices.add(self); // array 에 추가
            System.out.println(enableDevice.get(0) + "와 " + self + "연결 성공");
        }


    }


    @Override
    public ConnectBehaviorType getType() {
        return ConnectBehaviorType.DIRECT_CONNECT;
    }
}
