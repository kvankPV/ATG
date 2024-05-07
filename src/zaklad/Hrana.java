package zaklad;

/**
 * Trieda zaklad.Hrana predstavuje hranu v grafe.
 */
public class Hrana {
    /**
     * Zaciatocny vrchol hrany
     */
    private final int zacVrchol;
    /**
     * Koncovy vrchol hrany
     */
    private final int konVrchol;
    /**
     * Cena hrany
     */
    private int cena;

    private int kapacitaCeny;
    private int tok;

    /**
     * Konstruktor hrany
     * @param zacVrchol zaciatocny vrchol
     * @param konVrchol koncovy vrchol
     * @param cena cena hrany
     */
    public Hrana(int zacVrchol, int konVrchol, int cena) {
        this.zacVrchol = zacVrchol;
        this.konVrchol = konVrchol;
        this.cena = cena;
    }

    public Hrana(int zacVrchol, int konVrchol, int kapacitaCeny, int tok) {
        this.zacVrchol = zacVrchol;
        this.konVrchol = konVrchol;
        this.kapacitaCeny = kapacitaCeny;
        this.tok = tok;
    }

    public Hrana(int zacVrchol, int konVrchol, int cena, int kapacitaCeny, int tok) {
        this.zacVrchol = zacVrchol;
        this.konVrchol = konVrchol;
        this.cena = cena;
        this.kapacitaCeny = kapacitaCeny;
        this.tok = tok;
    }

    public Hrana(int zacVrchol, int konVrchol) {
        this.zacVrchol = zacVrchol;
        this.konVrchol = konVrchol;
    }

    /**
     * Vrati zaciatocny vrchol hrany
     * @return zaciatocny vrchol
     */
    public int getZaciatocnyVrchol() {
        return this.zacVrchol;
    }

    /**
     * Vrati koncovy vrchol hrany
     * @return koncovy vrchol
     */
    public int getKonecnyVrchol() {
        return this.konVrchol;
    }

    /**
     * Vrati cenu hrany
     * @return cena hrany
     */
    public int getCena() {
        return this.cena;
    }

    public int getKapacitaCeny() {
        return this.kapacitaCeny;
    }

    public void setTok(int tok) {
        this.tok = tok;
    }

    public int getTok() {
        return this.tok;
    }
}
