package algoritmy;

import zaklad.Graf;
import zaklad.Hrana;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Tok {

    private final Graf graf;
    private final List<List<Hrana>> poleZoradenychHranPodlaVrchola;
    private final int[] znacky;
    private final int zdroj;
    private final int ustie;


    public Tok(Graf graf) {

        this.graf = graf;
        int pocetVrcholov = this.graf.getPocetVrcholov();
        this.poleZoradenychHranPodlaVrchola = this.graf.getZoradenieODeg();
        this.znacky = new int[pocetVrcholov];
        this.zdroj = this.najdiVrchol(this.graf.getZoradenieIDeg());
        this.ustie = this.najdiVrchol(this.graf.getZoradenieODeg());

    }

    public void hladanieMaxToku() {

        while (this.najdiZvacsujucuPolocestu()) {

            int rezerva = this.rezerva();
            int zacVrchol = this.ustie;

            while (true) {

                int konVrchol = this.znacky[zacVrchol];

                if (konVrchol > 0) {

                    Hrana hrana = this.najdiHranu(konVrchol, zacVrchol);
                    assert hrana != null;
                    hrana.setTok(hrana.getTok() + rezerva);

                } else if (konVrchol == 0) {

                    break;

                } else {

                    Hrana hrana = this.najdiHranu(zacVrchol, -konVrchol);
                    assert hrana != null;
                    hrana.setTok(hrana.getTok() - rezerva);

                }

                zacVrchol = konVrchol;

            }
        }

        System.out.println("Meno grafu : " + this.graf.getNazovGrafu());
        System.out.println("Zdroj: " + this.zdroj);
        System.out.println("Ustie: " + this.ustie);

        int tokFinal = 0;

        System.out.println();

        for (List<Hrana> hranas : this.poleZoradenychHranPodlaVrchola) {
            for (Hrana h : hranas) {
                System.out.println(h.getZaciatocnyVrchol() + " " + h.getKonecnyVrchol() + " tok je " + h.getTok());
            }
        }

        System.out.println();

        for (Hrana h : this.poleZoradenychHranPodlaVrchola.get(this.zdroj)) {
            tokFinal += h.getTok();
        }

        System.out.println("Max tok je: " + tokFinal);

    }

    private int rezerva() {

        int rezerva = Integer.MAX_VALUE;
        int zacVrchol = this.ustie;

        while (true) {

            int konVrchol = this.znacky[zacVrchol];

            if (konVrchol > 0) {

                Hrana hrana = this.najdiHranu(konVrchol, zacVrchol);
                assert hrana != null;

                if (rezerva > hrana.getKapacitaCeny() - hrana.getTok()) {
                    rezerva = hrana.getKapacitaCeny() - hrana.getTok();
                }

            } else if (konVrchol == 0) {

                break;

            } else {

                Hrana hrana = this.najdiHranu(zacVrchol, -konVrchol);
                assert hrana != null;

                if (rezerva > hrana.getTok()) {
                    rezerva = hrana.getTok();
                }

            }
            zacVrchol = Math.abs(konVrchol);
        }

        return rezerva;
    }

    private boolean najdiZvacsujucuPolocestu() {

        ArrayList<Integer> epsilon = new ArrayList<>();

        Arrays.fill(this.znacky, Integer.MAX_VALUE / 2);
        this.znacky[this.zdroj] = 0;
        epsilon.add(this.zdroj);

        while (!epsilon.isEmpty() && this.znacky[this.ustie] == Integer.MAX_VALUE / 2) {

            int vrchol = epsilon.remove(0);

            for (Hrana h : this.graf.getZoradenieODeg().get(vrchol)) {

                if (h.getKapacitaCeny() > h.getTok() && this.znacky[h.getKonecnyVrchol()] == Integer.MAX_VALUE / 2) {

                    this.znacky[h.getKonecnyVrchol()] = vrchol;
                    epsilon.add(h.getKonecnyVrchol());

                }

            }

            for (Hrana hrana : this.graf.getZoradenieIDeg().get(vrchol)) {

                if (hrana.getTok() > 0 && this.znacky[hrana.getZaciatocnyVrchol()] == Integer.MAX_VALUE / 2) {

                    this.znacky[hrana.getZaciatocnyVrchol()] = -vrchol;
                    epsilon.add(hrana.getZaciatocnyVrchol());

                }
            }
        }
        return this.znacky[this.ustie] != Integer.MAX_VALUE / 2;
    }

    private int najdiVrchol(List<List<Hrana>> pole) {
        int index = 0;
        for (List<Hrana> list : pole) {
            if (list.isEmpty()) {
                for (List<Hrana> h : pole) {
                    if (h == list) {
                        break;
                    }
                    index++;
                }
            }
        }
        return index;
    }

    private Hrana najdiHranu(int zaciatocnyVrchol, int koncovyVrchol) {
        for (Hrana h : this.poleZoradenychHranPodlaVrchola.get(zaciatocnyVrchol)) {
            if (h.getKonecnyVrchol() == Math.abs(koncovyVrchol)) {
                return h;
            }
        }
        return null;
    }
}

