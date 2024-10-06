package Devices;

import Behaviors.WifiBehavior;

import java.util.List;

public class WifiRouter extends Device {
    private final int speed;

    public int getSpeed() {
        return speed;
    }

    public WifiRouter(int speed) {
        super(List.of(new WifiBehavior()));
        this.speed = speed;
    }


    @Override
    String getName() {
        return "와이파이 공유기";
    }
}
