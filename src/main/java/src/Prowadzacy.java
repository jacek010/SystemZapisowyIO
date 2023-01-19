package src;
public class Prowadzacy {
    private String imie;
    private String nazwisko;
    private int numerLegitymacji;
    private String tytul;

    public Prowadzacy(String imie, String nazwisko, String tytul, int numerLegitymacji) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.tytul = tytul;
        this.numerLegitymacji=numerLegitymacji;

    }

    public String wypiszNazweProwadzacego()//funkcja zwraca w czytelnej formie pełną nazwę prowadzącego
    {
        return tytul+" "+imie+" "+nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getNumerLegitymacji() {
        return numerLegitymacji;
    }

    public void setNumerLegitymacji(int numerLegitymacji) {
        this.numerLegitymacji = numerLegitymacji;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}
