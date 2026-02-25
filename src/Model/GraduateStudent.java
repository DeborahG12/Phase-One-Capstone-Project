package Model;

public class GraduateStudent extends Student {

    private static final double PER_CREDIT = 300;
    private static final double RESEARCH_FEE = 500;

    private int credits;

    public GraduateStudent(String name, String email, String id, String dept, int credits) {
        super(name, email, id, dept);
        this.credits = credits;
    }

    @Override
    public double calculateTuition() {
        return (credits * PER_CREDIT) + RESEARCH_FEE;
    }
}

