public class PatternStrategy {
    public static void main(String[] args) {
        Auto electroCar = new ElectroCar();
        Auto truckAuto = new TruckCar();
        Auto defaultCar = new DefaultCar();
        electroCar.setStrategy(new Strategy1Impl());
        truckAuto.setStrategy(new Strategy2Impl());
        defaultCar.setStrategy(new Strategy3Impl());

        electroCar.fill();
        truckAuto.fill();
        defaultCar.fill();
    }
}

class Auto {

    Strategy stategy;

    public void start() {
        System.out.println("Начало движения");
    }
    public void stop() {
        System.out.println("Остановка движения");
    }

    public void setStrategy(Strategy stategy) {
        this.stategy = stategy;
    }

    public void fill() {
        this.stategy.fill();
    }
}

class ElectroCar extends Auto { }

class TruckCar extends Auto { }

class DefaultCar extends Auto { }

interface Strategy {
    void fill();
}

class Strategy1Impl implements Strategy{
    @Override
    public void fill() {
        System.out.println("Заправляюсь газом");
    }
}

class Strategy2Impl implements Strategy{
    @Override
    public void fill() {
        System.out.println("Заправляюсь бензином");
    }
}

class Strategy3Impl implements Strategy {
    @Override
    public void fill() {
        System.out.println("Заправляюсь электричеством");
    }
}