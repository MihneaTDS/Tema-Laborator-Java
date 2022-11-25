package labs.ip.tema;

public class Student extends PersoanaFacultate {

    protected Short anStudiu;

    public Student(String nume, String prenume, String acronimFacultate, Short varsta, Short anStudiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronimFacultate = acronimFacultate;
        this.varsta = varsta;
        this.anStudiu = anStudiu;
    }

    public Short getAnStudiu() {
        return anStudiu;
    }

    public void setAnStudiu(Short anStudiu) {
        this.anStudiu = anStudiu;
    }

    @Override
    public void greeting() {
        System.out.println("Sa traiti, sunt student " + nume +
                " " + prenume + "!");
    }

    @Override
    public void doWork() {
        System.out.println("Let's do homework!");
    }

    @Override
    public String toString() {
        return "[Sd. " + nume + " " + prenume + ", Anul " + anStudiu +
                ", Fac. " + acronimFacultate + ", Varsta " + varsta + "]";
    }
}
