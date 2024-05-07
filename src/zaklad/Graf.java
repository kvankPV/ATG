package zaklad;

import java.util.*;

/**
 * Trieda grafu
 */
public class Graf {

    /**
     * Zoznam hran
     */
    private final ArrayList<Hrana> zoznamHran;
    /**
     * Nazov grafu
     */
    private final String nazovGrafu;

    private List<List<Hrana>> poleZoradenychHranPodlaVrchola;
    private int pocetVrcholov;

    /**
     * Konstruktor grafu
     * @param nazovGrafu nazov grafu
     */
    public Graf(String nazovGrafu) {
        this.nazovGrafu = nazovGrafu;
        this.zoznamHran = new ArrayList<>();
    }

    /**
     * Pridanie hrany do grafu
     * @param h hrana
     */
    public void pridajHranu(Hrana h) {
        this.zoznamHran.add(h);
    }

    /**
     * Vrati pocet vrcholov v grafe
     * @return pocet vrcholov
     */
    public int getPocetVrcholov() {

        Set<Integer> vrcholy = new HashSet<>();

        for (Hrana h : this.zoznamHran) {
            vrcholy.add(h.getZaciatocnyVrchol());
            vrcholy.add(h.getKonecnyVrchol());
        }

        /*
            treba + 1 pretoze vrcholy su od 1 a nie od 0
        */
        this.pocetVrcholov = vrcholy.size() + 1;

        return this.pocetVrcholov;

    }

    public int getPocetHran() {
        return this.zoznamHran.size();
    }

    public List<List<Hrana>> getZoradenieIDeg() {

        this.poleZoradenychHranPodlaVrchola = new ArrayList<>(this.pocetVrcholov);

        for (int i = 0; i < this.pocetVrcholov; i++) {
            this.poleZoradenychHranPodlaVrchola.add(new ArrayList<>());
        }

        for (Hrana hrana : this.zoznamHran) {
            this.poleZoradenychHranPodlaVrchola.get(hrana.getKonecnyVrchol()).add(hrana);
        }

        return this.poleZoradenychHranPodlaVrchola;
    }

    public List<List<Hrana>> getZoradenieODeg() {


        this.poleZoradenychHranPodlaVrchola = new ArrayList<>(this.pocetVrcholov);

        for (int i = 0; i < this.pocetVrcholov; i++) {
            this.poleZoradenychHranPodlaVrchola.add(new ArrayList<>());
        }

        for (Hrana hrana : this.zoznamHran) {
            this.poleZoradenychHranPodlaVrchola.get(hrana.getZaciatocnyVrchol()).add(hrana);
        }

        return this.poleZoradenychHranPodlaVrchola;
    }

    /**
     * Vrati nazov grafu
     * @return nazov grafu
     */
    public String getNazovGrafu() {
        return this.nazovGrafu;
    }
}
