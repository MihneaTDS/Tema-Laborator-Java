package labs.ip.tema;

public class Profesor extends PersoanaFacultate{
    protected String materie;

    public Profesor(String nume, String prenume, String acronimFacultate, Short varsta, String materie) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronimFacultate = acronimFacultate;
        this.varsta = varsta;
        this.materie = materie;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    @Override
    public void greeting() {
        System.out.println("Buna ziua, studenti!");
    }

    @Override
    public void doWork() {
        System.out.println("Hai sa facem subiecte de examen.");
    }

    @Override
    public String toString() {
        return "[Prof. " + nume + " " + prenume + ", Fac. " + acronimFacultate
                +", Varsta " + varsta + ", Materie predata " + materie + "]";
    }
}
