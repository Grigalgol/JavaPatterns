public class PatternSingleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
    }
}

class Singleton {
    private static final Singleton singleton = new Singleton();

    private Singleton(){}

    public static Singleton getInstance() {
        return singleton;
    }
}
