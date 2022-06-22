public class PatternAdapter {
    public static void main(String[] args) {
        Мойка мойка = new Мойка();
        Автомобиль лада = new Лада();
        Танк танк = new Т51();
        мойка.мойка(new ТанкОбертка(танк));
    }
}

class ТанкОбертка implements Автомобиль {

    Танк танк;

    public ТанкОбертка(Танк танк) {
        this.танк = танк;
    }

    @Override
    public void мыть() {
        танк.мыть();
    }
}

interface Автомобиль {
    void мыть();
}

class Лада implements Автомобиль {

    @Override
    public void мыть() {
        System.out.println("Лада в мойке");
    }
}

class Мойка {
    public void мойка(Автомобиль автомобиль) {
        автомобиль.мыть();
    }
}

interface Танк {
    void мыть();
}

class Т51 implements Танк {

    @Override
    public void мыть() {
        System.out.println("Танк в мойке");
    }
}