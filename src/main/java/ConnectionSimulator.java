import Devices.*;

import java.util.List;

public class ConnectionSimulator {

    public static void main(String[] args) {
        System.out.println("\n두개의 블루투스 키보드 생성 및 연결 방법 출력: \n");
        BluetoothKeyboard bluetoothKeyboard1 = new BluetoothKeyboard();
        bluetoothKeyboard1.displayConnectionMethods();
        BluetoothKeyboard bluetoothKeyboard2 = new BluetoothKeyboard();

        System.out.println("\n맥북 생성 및 두개의 블루투스 키보드와 연결: \n");
        Macbook macbook = new Macbook();
        macbook.connect(List.of(bluetoothKeyboard1, bluetoothKeyboard2));
        macbook.displayConnectedDevice();

        System.out.println("\n속도가 다른 네개의 와이파이 라우터 생성 후 맥북과 연결: \n");
        WifiRouter wifiRouter1 = new WifiRouter(100);
        WifiRouter wifiRouter2 = new WifiRouter(300);
        WifiRouter wifiRouter3 = new WifiRouter(400);
        WifiRouter wifiRouter4 = new WifiRouter(500);
        macbook.connect(List.of(wifiRouter1, wifiRouter2, wifiRouter3, wifiRouter4));
        
        macbook.displayConnectedDevice();


        System.out.println("\n스마트폰 생성 후 연결방법 출력: \n");
        SmartPhone smartPhone = new SmartPhone();
        smartPhone.displayConnectionMethods();

        System.out.println("\n스마트폰과 맥북, 와이파이 라우터와 연결: \n");
        smartPhone.connect(List.of(macbook, wifiRouter2, wifiRouter3, wifiRouter4));
        smartPhone.displayConnectedDevice();

        System.out.println("\n맥북의 연결 상태 출력: \n");
        macbook.displayConnectedDevice();


        System.out.println("\n맥북에 블루투스 키보드 연결 해제후 출력: \n");
        macbook.disconnect(bluetoothKeyboard1);
        macbook.displayConnectedDevice();

        System.out.println("\n맥북, 스마트폰의 모든 연결 해제 : \n");
        macbook.disconnectAll();
        smartPhone.disconnectAll();
        smartPhone.displayConnectedDevice();
        macbook.displayConnectedDevice();

        System.out.println("\n맥북, 스마트폰에 다이렉트 커넥트 시도 : \n");
        DirectConnector directConnector = new DirectConnector();
        smartPhone.connect(List.of(directConnector));
        macbook.connect(List.of(directConnector));
        smartPhone.displayConnectedDevice();
        macbook.displayConnectedDevice();

    }
}
