import java.util.*;
import java.util.function.Consumer;

public class Aplikacja {

    private TreeMap<Integer, Kurs> listaKursow;
    private Set<Student> studenciNaUczelni;
    public Aplikacja() {
        this.listaKursow = new TreeMap<Integer, Kurs>() {
        };
        this.studenciNaUczelni= new HashSet<>();
    }

    public void dodajKurs(int idKursu, String nazwaKursu, int liczbaMiejsc, String dzienTygodnia, String termin, String imieProwadzacego, String nazwiskoProwadzacego, String tytul, int numerLegitymacji)
    {
        Kurs nowyKurs = new Kurs(idKursu, nazwaKursu,liczbaMiejsc, dzienTygodnia, termin, imieProwadzacego, nazwiskoProwadzacego, tytul, numerLegitymacji);
        listaKursow.put(idKursu, nowyKurs);
    }

    public void wyswietlKursy(int ID, boolean czyWszystkie)
    {
        System.out.printf("| %-10s | %25s | %25s | %40s | %25s |%n","ID KURSU", "NAZWA KURSU", "TERMIN", "PROWADZĄCY", "LICZBA DOSTĘPNYCH MIEJSC");
        System.out.printf("| %-10s | %25s | %25s | %40s | %25s |%n","---------", "-------------------------", "-------------------------", "----------------------------------------", "-------------------------");
        for (var entry : listaKursow.entrySet()) {
            if(ID!=1)
            {
                //wyświetlanie studenta
                if(czyWszystkie)
                {
                    if(entry.getValue().getLiczbaMiejsc()>0&&!entry.getValue().getListaStudentow().containsKey(ID))System.out.printf("| %-10s | %25s | %25s | %40s | %25s |%n",entry.getValue().getIdKursu(), entry.getValue().getNazwaKursu(), entry.getValue().getDzienTygodnia()+" "+entry.getValue().getTermin(), entry.getValue().getProwadzacy().wypiszNazweProwadzacego(), entry.getValue().getLiczbaMiejsc());
                }
                else
                {
                    if(entry.getValue().getListaStudentow().containsKey(ID))System.out.printf("| %-10s | %25s | %25s | %40s | %25s |%n",entry.getValue().getIdKursu(), entry.getValue().getNazwaKursu(), entry.getValue().getDzienTygodnia()+" "+entry.getValue().getTermin(), entry.getValue().getProwadzacy().wypiszNazweProwadzacego(), entry.getValue().getLiczbaMiejsc());
                }
            }
            else
            {
                //wyświetlanie administratora
                System.out.printf("| %-10s | %25s | %25s | %40s | %25s |%n",entry.getValue().getIdKursu(), entry.getValue().getNazwaKursu(), entry.getValue().getDzienTygodnia()+" "+entry.getValue().getTermin(), entry.getValue().getProwadzacy().wypiszNazweProwadzacego(), entry.getValue().getLiczbaMiejsc());
            }
            if(entry.getValue().getLiczbaMiejsc()<1|| !czyWszystkie)continue;

        }
    }

    public void wyswietlListeProwadzacych()
    {
        Set<String> listaProwadzacychKursy = new HashSet<>();
        for(var entry : listaKursow.entrySet())
        {
            listaProwadzacychKursy.add(entry.getValue().getProwadzacy().wypiszNazweProwadzacego());
        }

        listaProwadzacychKursy.forEach(new Consumer<String>() {
            @Override
            public void accept(String prowadzacy) {
                System.out.println(prowadzacy);
            }
        });

    }
    public void dopiszStudenta(int idKursu, String imieStudenta, String nazwiskoStudenta, int numerIndeksu)
    {
        Student student = new Student(imieStudenta, nazwiskoStudenta, numerIndeksu);
        studenciNaUczelni.add(student);
        Kurs tempKurs = zwrocKurs(idKursu);
        tempKurs.dodajStudentaDoListyKursu(student);
        listaKursow.replace(idKursu,tempKurs);
    }
    
    public void przeniesStudenta(int idStudenta, int idOUT, int idIN)
    {
        //sprawdzenie czy takie kursy w ogóle istnieją
        if(!szukajKursu(idOUT) || !szukajKursu(idIN))
        {
            System.out.println("Podano nieprawidłowe ID kursu, operacja przeniesienia nie została wykonana");
            return;
        }
        //sprawdzenie czy student jest zapisany na kurs z którego chcemy go wypisać
        if(!listaKursow.get(idOUT).przeszukajListeStudentowKursu(idStudenta))
        {
            System.out.println("Ten student nie jest zapisany na kurs z którego chcesz go wypisać");
            return;
        }

        //sprawdzenie czy na kursie są jeszcze miejsca oraz czy student nie jest już tam zapisany
        if(listaKursow.get(idIN).przeszukajListeStudentowKursu(idStudenta))
        {
            System.out.println("Ten student już jest zapisany na ten kurs");
            return;
        }
        if (listaKursow.get(idIN).getLiczbaMiejsc()<1)
        {
            System.out.println("Na tym kursie nie ma już miejsc");
            return;
        }


        //jeśli wszystko spełnione to wywołanie usunięcia studenta z jednego kursu i dopisania go do drugiego
        Student przenoszonyStudent = listaKursow.get(idOUT).zwrocStudenta(idStudenta);
        listaKursow.get(idOUT).usunStudentaZListyKursu(przenoszonyStudent);
        listaKursow.get(idIN).dodajStudentaDoListyKursu(przenoszonyStudent);
    }
    
    public boolean szukajKursu(int idKursu)
    {
        return listaKursow.containsKey(idKursu);
    }

    public Kurs zwrocKurs(int idKursu)
    {
        return listaKursow.get(idKursu);
    }

    public void usunKurs(int idKursu)
    {
        listaKursow.remove(idKursu);
    }
}
