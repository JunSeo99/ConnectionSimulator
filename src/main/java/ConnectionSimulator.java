import Devices.BluetoothKeyboard;
import Devices.Macbook;
import Devices.SmartPhone;
import Devices.WifiRouter;

import java.util.List;

public class ConnectionSimulator {

    public static void main(String[] args) {
        BluetoothKeyboard bluetoothKeyboard1 = new BluetoothKeyboard();
        bluetoothKeyboard1.displayConnectionMethods();
        BluetoothKeyboard bluetoothKeyboard2 = new BluetoothKeyboard();

        System.out.println("\n");
        Macbook macbook = new Macbook();
        macbook.connect(List.of(bluetoothKeyboard1, bluetoothKeyboard2));
        macbook.displayConnectedDevice();

        System.out.println("\n");
        WifiRouter wifiRouter1 = new WifiRouter(100);
        WifiRouter wifiRouter2 = new WifiRouter(300);
        WifiRouter wifiRouter3 = new WifiRouter(400);
        WifiRouter wifiRouter4 = new WifiRouter(500);
        macbook.connect(List.of(wifiRouter1, wifiRouter2, wifiRouter3, wifiRouter4));
        macbook.displayConnectedDevice();

        System.out.println("\n");
        SmartPhone smartPhone = new SmartPhone();
        smartPhone.displayConnectionMethods();

        System.out.println("\n");
        smartPhone.connect(List.of(macbook, wifiRouter2, wifiRouter3, wifiRouter4));
        smartPhone.displayConnectedDevice();

        System.out.println("\n");
        macbook.displayConnectedDevice();

    }
}
