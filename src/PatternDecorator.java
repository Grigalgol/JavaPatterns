import java.util.ArrayList;
import java.util.List;

public class PatternDecorator {
    public static void main(String[] args) {
        Developer javaDev = new JavaDeveloper();
        Developer seniorDev = new SeniorDeveloper(javaDev);
        Developer teamLeadDev = new TeamLeadDeveloper(new SeniorDeveloper(new JavaDeveloper()));

        List<Developer> list = new ArrayList<>();

        list.add(javaDev);
        list.add(seniorDev);
        list.add(teamLeadDev);

        for (var dev: list) {
            dev.makeJob();
        }
    }
}

interface Developer {
    void makeJob();
}

class JavaDeveloper implements Developer {

    @Override
    public void makeJob() {
        System.out.println("Write Java code");
    }
}

class DeveloperDecorator implements Developer {

    Developer developer;

    public DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public void makeJob() {
        developer.makeJob();
    }
}

class SeniorDeveloper extends DeveloperDecorator {

    public SeniorDeveloper(Developer developer) {
        super(developer);
    }

    public void makeCodeReview() {
        System.out.println("Make Code Review");
    }

    @Override
    public void makeJob() {
        super.makeJob();
        makeCodeReview();
    }
}

class TeamLeadDeveloper extends DeveloperDecorator {

    public TeamLeadDeveloper(Developer developer) {
        super(developer);
    }

    public void reportToCustomer() {
        System.out.println("Send report to customer");
    }

    @Override
    public void makeJob() {
        super.makeJob();
        reportToCustomer();
    }
}