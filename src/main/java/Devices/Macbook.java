package Devices;

import Behaviors.BluetoothBehavior;
import Behaviors.DirectConnectBehavior;
import Behaviors.WifiBehavior;

import java.util.List;

public class Macbook extends Device {


    public Macbook() {
        super(List.of(new WifiBehavior(), new BluetoothBehavior(), new DirectConnectBehavior()));
    }

    @Override
    String getName() {
        return "Macbook";
    }
}


