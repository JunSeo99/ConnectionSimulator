package Devices;

import Behaviors.DirectConnectBehavior;

import java.util.List;

public class DirectConnector extends Device {

    public DirectConnector() {
        super(List.of(new DirectConnectBehavior()));
    }

    @Override
    String getName() {
        return "다이렉트 커넥터";
    }
}
