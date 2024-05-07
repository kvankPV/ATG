public record Cintorin() {

/*
  Prvy pokus nakodit algoritmus algoritmy.LabelSet
  @param startVrchol
 * @param koniecVrchol
 */

//    public void najkratsiaCesta(int startVrchol, int koniecVrchol) {
//        int[] cenaHrany = new int[this.zoznamHran.size()];
//        int[] znacka = new int[this.zoznamHran.size()];
//        ArrayList<Integer> epsilon = new ArrayList<>();
//
//        int zaciatocnaVzdialenost = 0;
//        int zvysnyZaciatok = Integer.MAX_VALUE / 2;
//
//        for (int i = 0; i < this.zoznamHran.size(); i++) {
//            cenaHrany[i] = zvysnyZaciatok;
//            znacka[i] = 0;
//        }
//        if (startVrchol <= 0) {
//            System.out.println("Zaciatocny zacVrchol musi byt vacsi ako 0");
//            return;
//        } else {
//            znacka[startVrchol - 1] = zaciatocnaVzdialenost;
//            epsilon.add(startVrchol);
//            cenaHrany[startVrchol - 1] = zaciatocnaVzdialenost;
//        }
//
//        while (!epsilon.isEmpty()) {
//            int zacinajuciVrchol = epsilon.get(0);
//            epsilon.remove(0);
//
//            for (int i = 0; i < this.zoznamHran.size(); i++) {
//
//                for (int j = 0; j < this.zoznamHran.size(); j++) {
//
//                    if ((zacinajuciVrchol == this.zoznamHran.get(i).getZaciatocnyVrchol())
//                            && (this.zoznamHran.get(i).getKonecnyVrchol() == this.zoznamHran.get(j).getZaciatocnyVrchol())
//                            && (this.zoznamHran.get(j).getKonecnyVrchol() == zacinajuciVrchol)
//                            && (!this.zoznamHran.get(i).jePrejdene() || !this.zoznamHran.get(j).jePrejdene())) {
//
//                        if ((cenaHrany[i] + this.zoznamHran.get(i).getCena()) < cenaHrany[j]) {
//
//                            cenaHrany[i] += cenaHrany[i] + this.zoznamHran.get(i).getCena();
//                            cenaHrany[j] = cenaHrany[i];
//                            znacka[i] = this.zoznamHran.get(i).getZaciatocnyVrchol();
//                            znacka[j] = znacka[i];
//
//                            epsilon.add(this.zoznamHran.get(i).getKonecnyVrchol());
//                            this.zoznamHran.get(i).setPrejdene(true);
//                            this.zoznamHran.get(j).setPrejdene(true);
//
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println("test");
//    }

/*
  Druhy pokus nakodit algoritmus algoritmy.LabelSet

  @param startVrchol
 * @param koniecVrchol
 */
//    public void najkratsiaCesta(int startVrchol, int koniecVrchol) {
//
//        if (startVrchol <= 0) {
//            System.out.println("Zaciatocny vrchol musi byt vacsi ako 0");
//            return;
//        }
//
//        HashMap<Integer, ArrayList<zaklad.Hrana>> poleVrcholov = new HashMap<>();
//        ArrayList<zaklad.Hrana> zoznamJednotlivychHran = new ArrayList<>();
//
//        int pocetVrcholov = this.graf.getPocetVrcholov();
//        int j = 0;
//
//        for (int i = 1; i < pocetVrcholov; i++) {
//            while (j < this.graf.getZoznamHran().size() &&
//                    i == this.graf.getZoznamHran().get(j).getZaciatocnyVrchol()) {
//                zoznamJednotlivychHran.add(this.graf.getZoznamHran().get(j));
//                j++;
//            }
//            poleVrcholov.put(i - 1, new ArrayList<>(zoznamJednotlivychHran));
//            zoznamJednotlivychHran.clear();
//        }
//
////        int[] znacka = new int[this.graf.pocetVrcholov()];
////        int[] cenaHrany = new int[this.graf.pocetVrcholov()];
//        HashMap<Integer, Integer> tabulka = new HashMap<>();
//
//        for (int k = 0; k < poleVrcholov.size(); k++) {
////            cenaHrany[k] = Integer.MAX_VALUE / 2;
////            znacka[k] = 0;
//            tabulka.put(k, Integer.MAX_VALUE / 2);
//        }
//
////        cenaHrany[startVrchol - 1] = 0;
////        znacka[startVrchol - 1] = 0;
//        tabulka.put(startVrchol - 1, 0);
//
//        ArrayList<Integer> epsilon = new ArrayList<>();
//        epsilon.add(startVrchol);
//
//        while (!epsilon.isEmpty()) {
//            int zacinajuciVrchol = epsilon.remove(0);
//
////            for (int k = 0; k < this.graf.pocetVrcholov(); k++) {
////
////                if ((poleVrcholov.get(zacinajuciVrchol - 1).size() > k)
////                        && (zacinajuciVrchol == poleVrcholov.get(zacinajuciVrchol - 1).get(k).getZaciatocnyVrchol())
////                        && ((cenaHrany[zacinajuciVrchol - 1] + poleVrcholov.get(zacinajuciVrchol - 1).get(k).getCena()) < cenaHrany[poleVrcholov.get(zacinajuciVrchol - 1).get(k).getKonecnyVrchol() - 1])) {
////
////                    for (int l = 0; l < poleVrcholov.get(poleVrcholov.get(zacinajuciVrchol - 1).get(l).getKonecnyVrchol() - 1).size(); l++) {
////
////                        if (!poleVrcholov.get(zacinajuciVrchol - 1).get(k).jePrejdene() || !poleVrcholov.get(poleVrcholov.get(zacinajuciVrchol - 1).get(k).getKonecnyVrchol() - 1).get(l).jePrejdene()) {
////
////                            cenaHrany[poleVrcholov.get(zacinajuciVrchol - 1).get(k).getKonecnyVrchol() - 1] = cenaHrany[zacinajuciVrchol - 1] + poleVrcholov.get(zacinajuciVrchol - 1).get(k).getCena();
////                            znacka[poleVrcholov.get(zacinajuciVrchol - 1).get(k).getKonecnyVrchol() - 1] = zacinajuciVrchol;
////
////                            if ((poleVrcholov.get(poleVrcholov.get(zacinajuciVrchol - 1).get(k).getKonecnyVrchol() - 1).get(l).getZaciatocnyVrchol() == poleVrcholov.get(zacinajuciVrchol - 1).get(l).getKonecnyVrchol())
////                                    && (poleVrcholov.get(poleVrcholov.get(zacinajuciVrchol - 1).get(k).getKonecnyVrchol() - 1).get(l).getKonecnyVrchol() == zacinajuciVrchol)) {
////
////                                poleVrcholov.get(zacinajuciVrchol - 1).get(k).setPrejdene(true);
////                                poleVrcholov.get(poleVrcholov.get(zacinajuciVrchol - 1).get(k).getKonecnyVrchol() - 1).get(l).setPrejdene(true);
////
////                            }
////
////                            epsilon.add(poleVrcholov.get(zacinajuciVrchol - 1).get(k).getKonecnyVrchol());
////                            break;
////                        }
////                    }
////                }
////            }
//
//            for (zaklad.Hrana h : poleVrcholov.get(zacinajuciVrchol - 1)) {
//                int novaVzdialenost = tabulka.get(zacinajuciVrchol - 1) + h.getCena();
//                try {
//                    if (novaVzdialenost < tabulka.get(h.getKonecnyVrchol() - 1)) {
//                        tabulka.put(h.getKonecnyVrchol() - 1, novaVzdialenost);
//                        epsilon.add(h.getKonecnyVrchol());
//                    }
//                } catch (NullPointerException e) {
//                    System.out.println("Nastala chyba na " + h.getKonecnyVrchol());
//                }
//            }
//        }
//        System.out.println("Dlzka medzi vrcholmi " + startVrchol + " a " + koniecVrchol + " je " + tabulka.get(koniecVrchol - 1));
//    }





}
