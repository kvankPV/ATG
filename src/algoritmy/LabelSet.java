package algoritmy;

import zaklad.Graf;
import zaklad.Hrana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Trieda na najdenie najkratsej cesty v grafe
 */
public class LabelSet {

    /**
     * zaklad.Graf
     */
    private final Graf graf;
    private final List<List<Hrana>> poleZoradenychHranPodlaVrchola;
    private final int pocetVrcholov;

    /**
     * Konstruktor na inicializaciu grafu
     *
     * @param graf graf
     */
    public LabelSet(Graf graf) {

        this.graf = graf;
        this.pocetVrcholov = this.graf.getPocetVrcholov();
        this.poleZoradenychHranPodlaVrchola = this.graf.getZoradenieODeg();

    }

    /**
     * Najdenie najkratsej cesty v grafe
     *
     * @param startVrchol zaciatocny vrchol
     * @param endVrchol   konecny vrchol
     */
    public void najkratsiaCesta(int startVrchol, int endVrchol) {

        /*
          Ak je zaciatocny vrchol mensi alebo rovny 0, vypise sa chybova hlaska
         */
        if (startVrchol <= 0) {
            throw new IllegalArgumentException("Zaciatocny vrchol musi byt vacsi ako 0");
        }

        long startCas = System.nanoTime();

        /*
         Inicializacia poli
        */

        int[] poleVrcholov = new int[this.pocetVrcholov];
        int nekonecno = Integer.MAX_VALUE / 2;

        Arrays.fill(poleVrcholov, nekonecno);
        poleVrcholov[startVrchol - 1] = 0;

        boolean[] pridanyDoEpsilonu = new boolean[this.pocetVrcholov];
        pridanyDoEpsilonu[startVrchol - 1] = true;

        int[] poleCien = new int[this.pocetVrcholov];
        Arrays.fill(poleCien, -1);

        PriorityQueue<Integer> epsilon = new PriorityQueue<>(Comparator.comparingInt(i -> poleVrcholov[i - 1]));
        epsilon.offer(startVrchol);

        /*
         Algoritmus algoritmy.LabelSet
        */

        while (!epsilon.isEmpty()) {

            int zacinajuciVrchol = epsilon.poll();

            if (zacinajuciVrchol == endVrchol) {
                break;
            }

            for (Hrana hrana : this.poleZoradenychHranPodlaVrchola.get(zacinajuciVrchol)) {

                int novaVzdialenost = poleVrcholov[zacinajuciVrchol - 1] + hrana.getCena();
                int konecnyVrchol = hrana.getKonecnyVrchol();

                if (novaVzdialenost < poleVrcholov[konecnyVrchol - 1]) {

                    poleVrcholov[konecnyVrchol - 1] = novaVzdialenost;
                    poleCien[konecnyVrchol - 1] = zacinajuciVrchol;


                    if (!pridanyDoEpsilonu[konecnyVrchol - 1]) {

                        pridanyDoEpsilonu[konecnyVrchol - 1] = true;
                        epsilon.offer(konecnyVrchol);

                    }
                }
            }
        }

        long endCas = System.nanoTime();
        /*
            Vypis vysledkov
        */
        StringBuilder sb = new StringBuilder();

        sb.append(System.lineSeparator());
        sb.append("Graf : ").append(this.graf.getNazovGrafu()).append(System.lineSeparator());

        if (poleCien[endVrchol - 1] != nekonecno) {

            List<Integer> cestaVrcholov = new ArrayList<>();
            int vrchol = endVrchol;

            while (vrchol != startVrchol) {
                cestaVrcholov.add(0, vrchol);
                vrchol = poleCien[vrchol - 1];
            }

            cestaVrcholov.add(0, startVrchol);

            sb.append("Cesta : ").append(cestaVrcholov.get(0));

            for (int i = 1; i < cestaVrcholov.size(); i++) {
                sb.append(" -> ").append(cestaVrcholov.get(i));
            }

            sb.append(System.lineSeparator());
            sb.append("Dlzka medzi vrcholmi : ");
            sb.append(startVrchol).append(" a ").append(endVrchol).append(" je ").append(poleVrcholov[endVrchol - 1]).append(System.lineSeparator());

        } else {
            sb.append("Cesta medzi vrcholmi ").append(startVrchol).append(" a ").append(endVrchol).append(" neexistuje").append(System.lineSeparator());
        }

        sb.append("Cas : ").append((endCas - startCas) / 1000000000.0).append(" s").append(System.lineSeparator());
        System.out.print(sb);
    }
}
