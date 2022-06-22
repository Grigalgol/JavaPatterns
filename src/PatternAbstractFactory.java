public class PatternAbstractFactory {
    public static void main(String[] args) {
        FactoryAnimal home = AbstractFactory.create("home");
        FactoryAnimal wild = AbstractFactory.create("wild");

        HomeAnimal zebra = home.createh("zebra");
        HomeAnimal horse = home.createh("zebra");

        zebra.runAway();
        horse.runAway();

        WildAnimal lion = wild.createw("lion");
        WildAnimal tiger = wild.createw("tiger");

        lion.kill();
        tiger.kill();
    }

}

interface WildAnimal {
    void kill();
}

interface HomeAnimal {
    void runAway();
}

class Lion implements WildAnimal {

    @Override
    public void kill() {
        System.out.println("Лев убиваает");
    }
}

class Tiger implements WildAnimal {

    @Override
    public void kill() {
        System.out.println("Тигр убивает");
    }
}

class Zebra implements HomeAnimal {

    @Override
    public void runAway() {
        System.out.println("Зебра спасается от хищника");
    }
}

class Horse implements HomeAnimal {

    @Override
    public void runAway() {
        System.out.println("Лошадь убегает");
    }
}

class WildAnimalFactory implements FactoryAnimal{

    @Override
    public WildAnimal createw(String typeOfAnimal) {
        switch (typeOfAnimal) {
            case "lion" : return new Lion();
            case "tiger" : return new Tiger();
            default: return null;
        }
    }

    @Override
    public HomeAnimal createh(String typeOfAnimal) {
        return null;
    }

}

class HomeAnimalFactory implements FactoryAnimal{
    @Override
    public WildAnimal createw(String typeOfAnimal) {
        return null;
    }

    public HomeAnimal createh(String typeOfAnimal) {
        switch (typeOfAnimal) {
            case "zebra" : return new Zebra();
            case "horse" : return new Horse();
            default: return null;
        }
    }
}

interface FactoryAnimal {
    WildAnimal createw(String typeOfAnimal);
    HomeAnimal createh(String typeOfAnimal);
}

class AbstractFactory {
    public static FactoryAnimal create(String typeOfFactory) {
        switch(typeOfFactory) {
            case "home" : return new HomeAnimalFactory();
            case "wild" : return new WildAnimalFactory();
            default: return null;
        }
    }
}