package Behaviors;


//behavior 의 타입을 명시적으로 나타내는 클래스가 필요해 Enum 타입을 하나 제작
public enum ConnectBehaviorType {
    WIFI("Wifi"),
    DIRECT_CONNECT("다이렉트"),
    BLUETOOTH("블루투스");


    private final String name;



    ConnectBehaviorType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
