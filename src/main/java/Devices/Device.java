package Devices;

import Behaviors.ConnectBehavior;

import java.util.ArrayList;
import java.util.List;
public abstract class Device {


    public List<Device> connectionDevices;
    public List<ConnectBehavior> behaviors;

    public void connect(List<Device> devices) {
        behaviors.forEach( behavior -> {
            behavior.connect(this, devices);
        });
    }
    public Device(List<ConnectBehavior> connectBehaviors) {
        this.behaviors = connectBehaviors;
        this.connectionDevices = new ArrayList<>();
    }


    public void displayConnectionMethods() {
        System.out.println(getName() + "이 지원하는 연결 방식: " +  String.join(", ", behaviors.stream().map(behavior -> behavior.getType().getName()).toList()));
    }

    public void displayConnectedDevice() {
        System.out.println(getName() + "에 연결된 디바이스들: " +  String.join(", ", connectionDevices.stream().map(Device::getName).toList()));
    }
    abstract String getName();

    @Override
    public String toString() {
        return getName();
    }
}
