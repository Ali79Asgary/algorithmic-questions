package shining_star_question;

public class ShiningStar {

    private double shineFactor;
    private boolean isFaded;
    private String name;

    public ShiningStar(double shineFactor) {
        this.shineFactor = shineFactor;
        this.isFaded = false;
    }

    public double shine() {
        if (isFaded) {
            throw new IllegalStateException();
        }

        return shineFactor;
    }

    public void fadeOut() {
        isFaded = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
