package Devices;

import Behaviors.*;
import java.util.List;

public class BluetoothKeyboard extends Device {


    public BluetoothKeyboard() {
        super(List.of(new BluetoothBehavior()));
    }

    @Override
    String getName() {
        return "블루투스 키보드";
    }
}


