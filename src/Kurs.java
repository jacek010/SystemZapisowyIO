import java.util.TreeMap;

public class Kurs {
    private int idKursu;
    private String nazwaKursu;
    private int liczbaMiejsc;
    private TreeMap<Integer, Student> listaStudentow;
    private String dzienTygodnia;
    private String termin;
    private Prowadzacy prowadzacy;


    public Kurs(int idKursu, String nazwaKursu, int liczbaMiejsc, String dzienTygodnia, String termin, String imieProwadzacego, String nazwiskoProwadzacego, String tytul, int numerLegitymacji) {
        this.idKursu = idKursu;
        this.nazwaKursu = nazwaKursu;
        this.liczbaMiejsc = liczbaMiejsc;
        this.listaStudentow = new TreeMap<>();
        this.dzienTygodnia = dzienTygodnia;
        this.termin = termin;
        this.prowadzacy = new Prowadzacy(imieProwadzacego, nazwiskoProwadzacego, tytul, numerLegitymacji);
    }


    public Kurs(int idKursu, String nazwaKursu, int liczbaMiejsc, String dzienTygodnia, String termin, Prowadzacy prowadzacy) {
        this.idKursu = idKursu;
        this.nazwaKursu = nazwaKursu;
        this.liczbaMiejsc = liczbaMiejsc;
        this.listaStudentow = new TreeMap<>();
        this.dzienTygodnia = dzienTygodnia;
        this.termin = termin;
        this.prowadzacy = prowadzacy;
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

    public int getIdKursu() {
        return idKursu;
    }

    public void setIdKursu(int idKursu) {
        this.idKursu = idKursu;
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

    public TreeMap<Integer, Student> getListaStudentow() {
        return listaStudentow;
    }

    public void setListaStudentow(TreeMap<Integer, Student> listaStudentow) {
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

    public void dodajStudentaDoListyKursu(String imie, String nazwisko, int numerIndeksu)
    {
        Student nowyStudent = new Student(imie, nazwisko, numerIndeksu);
        listaStudentow.put(numerIndeksu, nowyStudent);
        liczbaMiejsc--;
    }

    public void dodajStudentaDoListyKursu(Student student)
    {
        listaStudentow.put(student.getNumerIndeksu(), student);
        liczbaMiejsc--;
    }

    public boolean przeszukajListeStudentowKursu(int idStudenta)
    {
        return listaStudentow.containsKey(idStudenta);
    }

    public Student zwrocStudenta(int idStudenta)
    {
        return listaStudentow.get(idStudenta);
    }

    public void usunStudentaZListyKursu(Student student)
    {
        listaStudentow.remove(student.getNumerIndeksu());
        liczbaMiejsc++;
    }
}
