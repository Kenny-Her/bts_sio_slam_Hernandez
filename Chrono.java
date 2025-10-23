public class Chrono {
    private int secondes;
    private int minutes;
    private int heures;

    public Chrono(int heures, int minutes, int secondes) {
        this.heures = heures;
        this.minutes = minutes;
        this.secondes = secondes;
    }

    public int getSecondes() {
        return secondes;
    }

    public void setSecondes(int secondes) {
        this.secondes = secondes;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getHeures() {
        return heures;
    }

    public void setHeures(int heures) {
        this.heures = heures;
    }

    public void decompte() {
        if (this.heures == 0 && this.minutes == 0 && this.secondes == 0) {
            return;
        }

        this.secondes--;
        if (this.secondes < 0) {
            this.secondes = 59;
            this.minutes--;
            if (this.minutes < 0) {
                this.minutes = 59;
                this.heures--;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.heures, this.minutes, this.secondes);
    }
}

class TestChrono {
    public static void main(String[] args) {
        Chrono chrono = new Chrono(0, 1, 5);

        while (chrono.getHeures() > 0 || chrono.getMinutes() > 0 || chrono.getSecondes() > 0) {
            System.out.println(chrono);
            chrono.decompte();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(chrono);
    }
}