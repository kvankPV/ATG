package zaklad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Trieda na inicializaciu grafu zo suboru
 */
public class InicializaciaSuboru {
    private Graf graf;
    private int[] trvanie;

    public InicializaciaSuboru() {

    }

    /**
     * Konstruktor na inicializaciu grafu zo suboru
     * @param menoSuboru meno suboru
     * @throws IOException vynimka
     */
    public void inicializaciaSuboru(String menoSuboru, String menoGrafu) throws IOException {

        this.graf = new Graf(menoGrafu);
        Scanner citac = new Scanner(new File(menoSuboru));

        while (citac.hasNextInt()) {

            int zacVrchol = citac.nextInt();
            int konVrchol = citac.nextInt();
            int cena = citac.nextInt();

            Hrana hrana = new Hrana(zacVrchol, konVrchol, cena);
            this.graf.pridajHranu(hrana);

        }
        citac.close();
    }

    public void inicializujTrvanie(String menoSuboru) {

        this.trvanie = new int[this.graf.getPocetVrcholov()];

        try {

            Scanner citac = new Scanner(new File(menoSuboru));
            int pocitadlo = 0;

            while (citac.hasNextInt()) {

                int cas = citac.nextInt();
                this.trvanie[pocitadlo] = cas;
                pocitadlo++;

            }

            citac.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void inicializaciaToku(String menoSuboru, String menoGrafu) {

        this.graf = new Graf(menoGrafu);

        try {

            Scanner citac = new Scanner(new File(menoSuboru));

            while (citac.hasNextInt()) {

                int zacVrchol = citac.nextInt();
                int konVrchol = citac.nextInt();
                int cena = citac.nextInt();
                int tok = citac.nextInt();

                Hrana hrana = new Hrana(zacVrchol, konVrchol, cena, tok);
                this.graf.pridajHranu(hrana);

            }

            citac.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inicializaciaTokuTEST(String menoSuboru, String menoGrafu) {

        this.graf = new Graf(menoGrafu);

        try {

            Scanner citac = new Scanner(new File(menoSuboru));

            while (citac.hasNextInt()) {

                int zacVrchol = citac.nextInt();
                int konVrchol = citac.nextInt();
                int kapacita = citac.nextInt();
                int tok = citac.nextInt();

                Hrana hrana = new Hrana(zacVrchol, konVrchol, kapacita, tok);
                this.graf.pridajHranu(hrana);

            }

            citac.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inicializaciaSuboruTEST(String menoSuboru, String menoGrafu) throws FileNotFoundException {

        this.graf = new Graf(menoGrafu);
        Scanner citac = new Scanner(new File(menoSuboru));

        while (citac.hasNextInt()) {

            int zacVrchol = citac.nextInt();
            int konVrchol = citac.nextInt();

            Hrana hrana = new Hrana(zacVrchol, konVrchol);
            this.graf.pridajHranu(hrana);

        }
        citac.close();

    }

    /**
     * Vrati graf
     * @return graf
     */
    public Graf getGraf() {
        return this.graf;
    }

    public int[] getTrvanie() {
        return this.trvanie;
    }
}

