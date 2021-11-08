package pl.lab;

public class Login {

    private final String imie;
    private final String haslo;

    Login(String imie, String haslo){
        this.haslo=haslo;
        this.imie=imie;
    }

    public String getImie() {
        return imie;
    }

    public String getHaslo() {
        return haslo;
    }
}
