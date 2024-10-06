package Devices;

import Behaviors.*;
import java.util.List;

public class SmartPhone extends Device {


    public SmartPhone() {
        super(List.of(new BluetoothBehavior(), new WifiBehavior()));
    }

    @Override
    String getName() {
        return "스마트폰";
    }
}


