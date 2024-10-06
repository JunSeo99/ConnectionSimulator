package Behaviors;

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
