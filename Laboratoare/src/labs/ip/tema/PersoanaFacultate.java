package labs.ip.tema;

public abstract class PersoanaFacultate implements Human, Comparable<PersoanaFacultate>{
    protected String nume;
    protected String prenume;
    protected String acronimFacultate;
    protected Short varsta;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAcronimFacultate() {
        return acronimFacultate;
    }

    public void setAcronimFacultate(String acronimFacultate) {
        this.acronimFacultate = acronimFacultate;
    }

    public Short getVarsta() {
        return varsta;
    }

    public void setVarsta(Short varsta) {
        this.varsta = varsta;
    }

    @Override
    public int compareTo(PersoanaFacultate o) {
       return this.varsta.compareTo(o.varsta);
    }
}
