import java.util.ArrayList;

public class Kurs {
    private String nazwaKursu;
    private int liczbaMiejsc;
    private ArrayList<Student> listaStudentow;
    private String dzienTygodnia;
    private String termin;
    private Prowadzacy prowadzacy;


    public Kurs(String nazwaKursu, int liczbaMiejsc, String dzienTygodnia, String termin, String imieProwadzacego, String nazwiskoProwadzacego, String tytul, int numerLegitymacji) {
        this.nazwaKursu = nazwaKursu;
        this.liczbaMiejsc = liczbaMiejsc;
        this.listaStudentow = new ArrayList<>();
        this.dzienTygodnia = dzienTygodnia;
        this.termin = termin;
        this.prowadzacy = new Prowadzacy(imieProwadzacego, nazwiskoProwadzacego, tytul, numerLegitymacji);
    }

    public void wyswietlInformacjeOKursie()
    {
        System.out.println(nazwaKursu+" | "+dzienTygodnia+" "+termin+" | "+"Prowadzący "+prowadzacy.wypiszNazweProwadzacego());
    }

    public Prowadzacy getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(String imie, String nazwisko, String tytul, int numerLegitymacji) {
        this.prowadzacy = new Prowadzacy(imie, nazwisko, tytul, numerLegitymacji);
    }

    public String getNazwaKursu() {
        return nazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        this.nazwaKursu = nazwaKursu;
    }

    public int getLiczbaMiejsc() {
        return liczbaMiejsc;
    }

    public void setLiczbaMiejsc(int liczbaMiejsc) {
        this.liczbaMiejsc = liczbaMiejsc;
    }

    public ArrayList<Student> getListaStudentow() {
        return listaStudentow;
    }

    public void setListaStudentow(ArrayList<Student> listaStudentow) {
        this.listaStudentow = listaStudentow;
    }

    public String getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(String dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    public String getTermin() {
        return termin;
    }
    public void setTermin(String termin) {
        this.termin = termin;
    }
}
