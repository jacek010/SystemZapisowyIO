import java.util.ArrayList;

public class Aplikacja {

    private ArrayList<Kurs> listaKursow;
    private ArrayList<Student> studenciNaUczelni;
    public Aplikacja() {
        this.listaKursow = new ArrayList<>();
        this.studenciNaUczelni= new ArrayList<>();
    }

    public void dodajKurs(int idKursu, String nazwaKursu, int liczbaMiejsc, String dzienTygodnia, String termin, String imieProwadzacego, String nazwiskoProwadzacego, String tytul, int numerLegitymacji)
    {
        Kurs nowyKurs = new Kurs(idKursu, nazwaKursu,liczbaMiejsc, dzienTygodnia, termin, imieProwadzacego, nazwiskoProwadzacego, tytul, numerLegitymacji);
        listaKursow.add(nowyKurs);
    }
    
    public void przeniesStudenta(int idStudenta, int idOUT, int idIN)
    {
        //sprawdzenie czy takie kursy w ogóle istnieją
        if(szukajKursu(idOUT)==false || szukajKursu(idIN)==false)
        {
            System.out.println("Podano nieprawidłowe ID kursu, operacja przeniesienia nie została wykonana");
            return;
        }

        //sprawdzenie czy student jest zapisany n kurs z którego chcemy go wypisać


        //sprawdzenie czy na kursie są jeszcze miejsca oraz czy student nie jest już tam zapisany
        //jeśli wszystko spełnione to wywołanie usunięcia studenta z jednego kursu i dopisania go do drugiego

    }
    
    public boolean szukajKursu(int idKursu)
    {
        for (Kurs kurs : listaKursow) {
            if (kurs.getIdKursu() == idKursu) return true;
        }
        return false;
    }
}
