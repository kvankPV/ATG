import algoritmy.CPM;
import algoritmy.Kruskalov;
import algoritmy.LabelSet;
import algoritmy.Tok;
import zaklad.Graf;
import zaklad.GrafEnum;
import zaklad.InicializaciaSuboru;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        InicializaciaSuboru ini = new InicializaciaSuboru();

        try {
            ini.inicializaciaSuboruTEST(GrafEnum.CPM_TEST.getCesta(), GrafEnum.CPM_TEST.getMeno());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ini.inicializujTrvanie(GrafEnum.CPM_Trvanie.getCesta());
        new CPM(ini.getGraf(), ini.getTrvanie()).vykonajCPM();

        System.out.println();

        ini.inicializaciaToku(GrafEnum.CPM_TOKY_TEST.getCesta(), GrafEnum.CPM_TOKY_TEST.getMeno());
        new Tok(ini.getGraf()).hladanieMaxToku();
    }

}