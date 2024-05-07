package algoritmy;

import zaklad.Graf;
import zaklad.Hrana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CPM {
    private final Graf graf;
    private List<List<Hrana>> poleZoradenychHranPodlaVrchola;
    private final int pocetVrcholov;
    private final int[] monotonne;
    private final int[] trvanie;

    public CPM (Graf graf, int[] trvanie) {

        this.graf = graf;
        this.pocetVrcholov = graf.getPocetVrcholov();
        this.trvanie = trvanie;

        System.out.println("Graf : " + this.graf.getNazovGrafu());

        this.poleZoradenychHranPodlaVrchola = this.graf.getZoradenieIDeg();
        this.monotonne = new int[this.pocetVrcholov];
        int pocitadlo = 0;
        boolean prejdene = false;

        while (!prejdene) {

            prejdene = true;

            for (List<Hrana> list : this.poleZoradenychHranPodlaVrchola) {

                int index = 0;

                if (list.isEmpty()) {

                    for (List<Hrana> h : this.poleZoradenychHranPodlaVrchola) {

                        if (h == list) {
                            break;
                        }

                        index++;
                    }

                }

                if (this.jeVMonotonom(this.monotonne, index)) {

                    this.monotonne[pocitadlo] = index;
                    pocitadlo++;

                    List<Hrana> docasneNaOdstranenie = new ArrayList<>();

                    for (List<Hrana> hranas : this.poleZoradenychHranPodlaVrchola) {

                        for (Hrana hrana : hranas) {

                            if (hrana.getZaciatocnyVrchol() == index) {

                                docasneNaOdstranenie.add(hrana);

                            }
                        }

                        hranas.removeAll(docasneNaOdstranenie);

                    }

                    prejdene = false;
                    break;

                }

            }

        }

        this.kontrola(this.monotonne);

        System.out.println("Monotonne usporiadanie: ");
        for (int i = 0; i < this.poleZoradenychHranPodlaVrchola.size() - 1; i++) {
            System.out.print(this.monotonne[i] + " -> ");
        }
        System.out.println();
    }

    public void vykonajCPM() {

        this.poleZoradenychHranPodlaVrchola = this.graf.getZoradenieODeg();

        int[] zaciatky = new int[this.pocetVrcholov];

        Arrays.fill(zaciatky, 0);

        for (int i = 0; i < this.pocetVrcholov - 1; i++) {

            for (Hrana hrana : this.poleZoradenychHranPodlaVrchola.get(this.monotonne[i])) {

                if (zaciatky[hrana.getZaciatocnyVrchol()] + this.trvanie[this.monotonne[i] - 1] > zaciatky[hrana.getKonecnyVrchol()]) {

                    zaciatky[hrana.getKonecnyVrchol()] = zaciatky[hrana.getZaciatocnyVrchol()] + this.trvanie[this.monotonne[i] - 1];

                }

            }

        }

        int time = 0;

        for (int i = 1; i < zaciatky.length; i++) {
            if (time < zaciatky[i] && this.poleZoradenychHranPodlaVrchola.get(i).isEmpty()) {
                time = zaciatky[i] + this.trvanie[i - 1];
            }
        }

        System.out.println("Trvanie projektu: " + (time));

        System.out.print("Najskor mozne zaciatky:" + System.lineSeparator() + "[");

        for (int i = 1; i < zaciatky.length; i++) {
            System.out.printf("%d, ", zaciatky[i]);
        }

        System.out.println("]");

        int[] konce = new int[this.pocetVrcholov];
        Arrays.fill(konce, time);

        this.poleZoradenychHranPodlaVrchola = this.graf.getZoradenieIDeg();

        for (int i = this.pocetVrcholov - 1; i > 0; i--) {

            for (Hrana hrana : this.poleZoradenychHranPodlaVrchola.get(this.monotonne[i])) {

                if (konce[hrana.getKonecnyVrchol()] - this.trvanie[this.monotonne[i] - 1] < konce[hrana.getZaciatocnyVrchol()]) {

                    konce[hrana.getZaciatocnyVrchol()] = konce[hrana.getKonecnyVrchol()] - this.trvanie[this.monotonne[i] - 1];

                }

            }

        }

        System.out.print("Najneskor nutne konce:" + System.lineSeparator() + "[");

        for (int i = 1; i < konce.length; i++) {
            System.out.printf("%d, ", konce[i]);
        }

        System.out.println("]");

        ArrayList<Integer> kritickeVrcholy = new ArrayList<>();

        for (int i = 1; i < this.pocetVrcholov; i++) {
            if (konce[i] - zaciatky[i] - this.trvanie[i - 1] == 0) {
                kritickeVrcholy.add(i);
            }
        }

        System.out.println("Kriticke vrcholy: ");
        for (int j : kritickeVrcholy) {
            System.out.printf("%d, ", j);
        }

    }

    private boolean jeVMonotonom(int[] monotonne, int index) {
        for (int j : monotonne) {
            if (j == index) {
                return false;
            }
        }
        return true;
    }

    private void kontrola(int[] monotonne) {
        for (int i = 0; i < monotonne.length - 1; i++) {
            if (monotonne[i] == 0) {
                System.out.println("Graf nie je acyklicky");
                System.exit(0);
            }
        }
    }
}
