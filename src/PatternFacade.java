public class PatternFacade {
    public static void main(String[] args) {
        Facade.sayHello("Niga");
    }
}

class Facade {
    public static void sayHello(String name) {
        System.out.println(name + " hello");
    }
}
