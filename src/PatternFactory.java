public class PatternFactory {
    public static void main(String[] args) {
        Tanks t34 = Factory.create("T34");
        Tanks is2 = Factory.create("IS2");

        t34.shoot();
        is2.shoot();
    }
}

interface Tanks {
    void shoot();
}

class T34 implements Tanks {

    @Override
    public void shoot() {
        System.out.println("T34 is shooting");
    }
}

class IS2 implements Tanks {

    @Override
    public void shoot() {
        System.out.println("IS2 is shooting");
    }
}

class Factory {
    public static Tanks create(String typeOfTanks) {
        switch (typeOfTanks) {
            case "T34" : return new T34();
            case "IS2": return new IS2();
            default: return null;
        }
    }
}
