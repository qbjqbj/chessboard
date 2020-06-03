package Player;

public class Player {
    public String name;
    public int step;

    public Player(String name, int step) {
        this.name = name;
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
