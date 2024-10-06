# ConnectionSimulator
## 디자인패턴 과제: 연결 시뮬레이션 테스트

### 프로젝트 구조 

```
├── connectionsimulator.java (main)
├── devices/
│   ├── device.java
│   ├── directconnector.java
│   ├── blutoothkeyboard.java
│   ├── directconnector.java
│   ├── smartphone.java
│   ├── wifirouter.java
│   └── macbook.java
└── behaviors/
    ├── connectbehavior.java
    ├── connectbehaviortype.java
    ├── wifibehavior.java
    ├── directconnectbehavior.java
    └── bluetoothbehavior.java`
```



## 1.  코드 설명

### 1. Device
1. 맥북 (블루투스, 다이렉트 커넥트, Wifi 가능)
2. 와이파이 라우터 (Wifi 가능)
3. 다이렉트 커넥터 (다이렉트 커넥트 가능)
4. 스마트폰 (Wifi, 블루투스 가능)
5. 블루투스 키보드 (블루투스 가능)

### 2. Behavior
1. BluetoothBehavior (여러개의 Device와 연결할 수 있음)
2. WifiBehavior (연결 가능한 Wifi 중 속도가 가장 빠른 Wifi 와 연결)
3. DirectConnectBehavior (포트가 최대 2개이기때문에, 랜덤으로 최대 두개를 뽑아 연결)


<br>

다음 다섯가지 항목은 **Device** 라는 interface를 상속 받고 있습니다.
**Device**는 **connect**, **disconnect**, **disconnectAll** 함수가 포함 되어있고, 출력을 위한 기타 함수 몇가지가 포함되어있고
**connectionDevice**, **hehaviors** 라는 인스턴스가 있습니다.

- **connectionDevice**:  현재 연결을 하고있는 디바이스들을 나타냅니다
-  **hehaviors**: 수업시간에 배운 strategy 전략을 활용했습니다. **맥북**과 **스마트폰** 같은 경우,
여러 연결이 가능하기 때문에 behavior 를 List 로 세팅해 구현해 보았습니다.

**behavior**들을 **List** 로 구현 했기때문에 각 **behavior**를 구분하기 위한 **enum** 타입인 **ConnectBehaviorType** 을 구현 했습니다.


## 2.  구현 결과

### main 함수의 다음과 같은 순서로 시뮬레이션을 실행 합니다.

```
       // main.java

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

```
<br>

### 실행 결과

```
두개의 블루투스 키보드 생성 및 연결 방법 출력: 

블루투스 키보드이 지원하는 연결 방식: 블루투스

맥북 생성 및 두개의 블루투스 키보드와 연결: 

블루투스 키보드와 Macbook연결 성공
블루투스 키보드와 Macbook연결 성공
Macbook에 연결된 디바이스들: 블루투스 키보드, 블루투스 키보드

속도가 다른 네개의 와이파이 라우터 생성 후 맥북과 연결: 

와이파이 공유기 와 Macbook연결 성공속도: 500
Macbook에 연결된 디바이스들: 블루투스 키보드, 블루투스 키보드, 와이파이 공유기

스마트폰 생성 후 연결방법 출력: 

스마트폰이 지원하는 연결 방식: 블루투스, Wifi

스마트폰과 맥북, 와이파이 라우터와 연결: 

Macbook와 스마트폰연결 성공
와이파이 공유기 와 스마트폰연결 성공속도: 500
스마트폰에 연결된 디바이스들: Macbook, 와이파이 공유기

맥북의 연결 상태 출력: 

Macbook에 연결된 디바이스들: 블루투스 키보드, 블루투스 키보드, 와이파이 공유기, 스마트폰

맥북에 블루투스 키보드 연결 해제후 출력: 

블루투스 키보드와 Macbook연결 해제
블루투스 키보드와 Macbook연결 해제
블루투스 키보드와 Macbook연결 해제
Macbook에 연결된 디바이스들: 블루투스 키보드, 와이파이 공유기, 스마트폰

맥북, 스마트폰의 모든 연결 해제 : 

스마트폰에 연결된 디바이스들: 
Macbook에 연결된 디바이스들: 

맥북, 스마트폰에 다이렉트 커넥트 시도 : 

다이렉트 커넥터와 Macbook연결 성공
스마트폰에 연결된 디바이스들: 
Macbook에 연결된 디바이스들: 다이렉트 커넥터

```


