package zaklad;

public enum GrafEnum {
    PR1("grafy/HladanieCesty/pr1.hrn", "Pr1"),
    SLOVAKIA("grafy/HladanieCesty/SlovRep.hrn", "Slovakia"),
    FLORIDA("grafy/HladanieCesty/Florida.hrn", "Florida"),
    STRAKONICE("grafy/HladanieCesty/Strakonice.hrn", "Strakonice"),
    MINI("grafy/HladanieCesty/Mini.txt", "Mini"),
    TEST_CESTA("grafy/Obhajoba/CestaTEST.txt", "Najkratsia cesta"),
    TEST_KOSTRA("grafy/Obhajoba/KostraTEST.txt", "Najlacnejsia kostra"),
    CPM_MINI("grafy/CPM/CPM_mini.hrn", "CPM mini"),
    CPM_MIDI("grafy/CPM/CPM_midi.hrn", "CPM midi"),
    CPM_STRED("grafy/CPM/CPM_stred.hrn", "CPM stred"),
    CPM_MINI_TRVANIE("grafy/CPM/CPM_mini.tim", "CPM mini trvanie"),
    CPM_MIDI_TRVANIE("grafy/CPM/CPM_midi.tim", "CPM midi trvanie"),
    CPM_STRED_TRVANIE("grafy/CPM/CPM_stred.tim", "CPM stred trvanie"),
    TOK_MIDI("grafy/Tok/Tok_midi.hrn", "Tok midi"),
    TOK_MINI("grafy/Tok/Tok_mini.hrn", "Tok mini"),
    TOK_MINI2("grafy/Tok/Tok_mini2.hrn", "Tok mini2"),
    CPM_TEST("grafy/obhajoba/CPM.txt", "CPM test"),
    CPM_Trvanie("grafy/obhajoba/CPMTrvanie.txt", "CPM trvanie"),
    CPM_TOKY_TEST("grafy/obhajoba/TokyTEST.txt", "CPM Toky"),;

    private final String cesta;
    private final String meno;

    GrafEnum(String cesta, String meno) {
        this.cesta = cesta;
        this.meno = meno;
    }

    public String getCesta() {
        return this.cesta;
    }

    public String getMeno() {
        return this.meno;
    }
}
