public class PatternBuilder {
    public static void main(String[] args) {
        SportCar car = new SportCar.BuilderCar().setColor("black").build();
    }
}

class SportCar {
    String name;
    int maxSpeed = 200;
    String color = "black";

    private SportCar(BuilderCar car) {
        this.name = car.name;
        this.color = car.color;
        this.maxSpeed = car.maxSpeed;
    }

    static class BuilderCar {
        static String name;
        int maxSpeed;
        String color;

        public BuilderCar setName(String name) {
            this.name = name;
            return this;
        }


        public BuilderCar setMaxSpeed(int maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        public BuilderCar setColor(String color) {
            this.color = color;
            return this;
        }

        public SportCar build() {
            return new SportCar(this);
        }
    }
}