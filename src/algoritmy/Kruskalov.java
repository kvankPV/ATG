package algoritmy;

import zaklad.Graf;
import zaklad.Hrana;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kruskalov {
    private final Graf graf;
    private final List<List<Hrana>> poleZoradenychHranPodlaVrchola;
    private final int pocetVrcholov;

    public Kruskalov(Graf graf) {
        this.graf = graf;
        this.poleZoradenychHranPodlaVrchola = this.graf.getZoradenieODeg();
        this.pocetVrcholov = graf.getPocetVrcholov();
    }

    public void hladanieKostry (boolean najvacsia) {

        long startCas = System.nanoTime();

        int[] poleVrcholov = new int[this.pocetVrcholov];

        for (int i = 0; i < this.pocetVrcholov; i++) {
            poleVrcholov[i] = i;
        }

        int pocetHran = 0;
        long cena = 0;

        // PriorityQueue je pomalsi ako ArrayList

        List<Hrana> vsetkyHrany = new ArrayList<>();
        List<Hrana> kostra = new ArrayList<>();


        for (List<Hrana> hrany : this.poleZoradenychHranPodlaVrchola) {
            vsetkyHrany.addAll(hrany);
        }

        if (najvacsia) {
            vsetkyHrany.sort(Comparator.comparingInt(Hrana::getCena).reversed());

        } else {
            vsetkyHrany.sort(Comparator.comparingInt(Hrana::getCena));
        }

        for (Hrana hrana : vsetkyHrany) {

            int zaciatocnyVrchol = hrana.getZaciatocnyVrchol();
            int konecnyVrchol = hrana.getKonecnyVrchol();

            int startDruhyVrchol = this.najdi(poleVrcholov, zaciatocnyVrchol);
            int endDruhyVrchol = this.najdi(poleVrcholov, konecnyVrchol);

            if (startDruhyVrchol != endDruhyVrchol) {

                poleVrcholov[startDruhyVrchol] = endDruhyVrchol;
                cena += hrana.getCena();
                kostra.add(hrana);
                pocetHran++;
            }

            if (pocetHran == this.pocetVrcholov - 1) {
                break;
            }
        }

        long koniecCas = System.nanoTime();

        System.out.println();
        System.out.println("Graf: " + this.graf.getNazovGrafu());

        if (najvacsia) {
            System.out.println("Nadrahsia kostra: " + cena);
        } else {
            System.out.println("Najlacnejsia kostra: " + cena);
        }

        /**
         * Vypis kostry pri obhajobe, inak zakomentovat
         */
//        System.out.print("Kostra: ");
//        for (Hrana h : kostra) {
//            System.out.printf("[%d, %d] ", h.getZaciatocnyVrchol(), h.getKonecnyVrchol());
//        }

        System.out.println();

        System.out.println("Cas: " + (koniecCas - startCas) / 1000000000.0 + " s");
    }

    private int najdi(int[] poleVrcholov, int vrchol) {

        if (poleVrcholov[vrchol] == vrchol) {
            return vrchol;
        }

        poleVrcholov[vrchol] = this.najdi(poleVrcholov, poleVrcholov[vrchol]);
        return poleVrcholov[vrchol];

    }
}