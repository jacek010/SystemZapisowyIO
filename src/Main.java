import java.util.Scanner;

public class Main {
    public static int ID;
    private static final Aplikacja aplikacja = InitData.createSampleAplicationWithData();

    private static void printMainMenu() {
        System.out.println("Zalogowano jako ID: " + ID);
        System.out.println("Wybierz co chcesz zrobić: ");
        if (ID == 1)//menu dla administratora
        {
            System.out.println("\t1. Zarządzaj studentem");
            System.out.println("\t2. Zarządzaj kursami");
        } else //menu dla studenta
        {
            System.out.println("\t1. Pokaż dostepne kursy");
            System.out.println("\t2. Wyświetl liste prowadzących");
            System.out.println("\t3. Dokonaj zapisu na kurs");
            System.out.println("\t4. Wyświetl kursy na które jestem zapisany");

        }
        System.out.println("\t0. WYLOGUJ");
    }

    private static void printAdminMenu(int option) {
        switch (option) {
            case 1 -> {//lista opcji do zarządzania studentem
                System.out.println("\t--ZARZĄDZANIE STUDENTEM--");
                System.out.println("\t1. Dodaj studenta do kursu");
                System.out.println("\t2. Usun studenta z kursu");
                System.out.println("\t3. Przenies studenta między kursami");
            }
            case 2 -> {//lista opcji do zarządzania kursami
                System.out.println("\t--ZARZĄDZANIE KURSAMI--");
                System.out.println("\t1. Dodaj kurs");
                System.out.println("\t2. Wyświetl listę studentów zapisanych na kurs");
                System.out.println("\t2. Przenieś studenta między kursami");
            }
        }
        System.out.println("0. POWRÓT");
        System.out.println("Wybierz opcję: ");
    }
    private static void zarzadzanieStudentem()
    {
        int choice;
        Scanner input = new Scanner(System.in);

        do {
            printAdminMenu(1);
            choice = input.nextInt();
            if(choice==0) break;
            switch (choice){
                case 1->{
                    //zapisanie studenta na kurs
                    String imieStudenta, nazwiskoStudenta;
                    int idKursu, numerIndeksuStudenta;

                    System.out.println("Podaj numer indeksu studenta");
                    numerIndeksuStudenta=input.nextInt();
                    System.out.println("Podaj imie studenta");
                    imieStudenta=input.nextLine();
                    System.out.println("Podaj nazwisko studenta");
                    nazwiskoStudenta=input.nextLine();

                    aplikacja.wyswietlKursy(numerIndeksuStudenta, true);

                    System.out.println("Podaj ID kursu");
                    idKursu=input.nextInt();

                    aplikacja.dopiszStudenta(idKursu, imieStudenta, nazwiskoStudenta, numerIndeksuStudenta);

                }
                case 2 ->{
                    //usunięcie studenta z kursu
                     int idKursu, numerIndeksuStudenta;
                     System.out.println("Podaj numer indeksu studenta");
                     numerIndeksuStudenta=input.nextInt();
                     aplikacja.wyswietlKursy(numerIndeksuStudenta, false);
                     System.out.println("Podaj ID kursu");
                     idKursu=input.nextInt();


                    aplikacja.usunStudentaZKursu(idKursu, numerIndeksuStudenta);
                }
                case 3 ->{
                    //przeniesienie studenta pomiędzy kursami
                    int idKursuIN, idKursuOUT, numerIndeksuStudenta;
                    System.out.println("Podaj numer indeksu studenta");
                    numerIndeksuStudenta=input.nextInt();
                    aplikacja.wyswietlKursy(numerIndeksuStudenta, false);
                    System.out.println("Podaj ID kursu z którego chcesz wypisać studenta");
                    idKursuOUT=input.nextInt();
                    aplikacja.wyswietlKursy(numerIndeksuStudenta, true);
                    System.out.println("Podaj ID kursu na który chcesz zapisać studenta");
                    idKursuIN=input.nextInt();

                    aplikacja.przeniesStudenta(numerIndeksuStudenta, idKursuOUT, idKursuIN);
                }
                default -> System.out.println("Takiej opcji nie ma!");
            }
        }while(true);
    }

    private static void zarzadzanieWszystkimiKursami()
    {

    }

    public static void main(String[] args)
    {
        int choice;
        System.out.println("\n\nWitaj w systemie zapisowym uczelni wyższej\n");
        aplikacja.wyswietlKursy(0, true);
        do {//główna pętla programu
            System.out.println("0. ZAKOŃCZ działanie programu");
            System.out.println("Podaj swoje ID: ");
            Scanner input = new Scanner(System.in);
            ID = input.nextInt();
            if(ID==0)break;
            do {
                printMainMenu();
                choice = input.nextInt();
                if(choice==0)break;
                if (ID == 1) //opcje dla administratora
                {
                    switch (choice) {
                        case 1 -> {

                            zarzadzanieStudentem();
                        }
                        case 2 -> {
                            printAdminMenu(2);
                            zarzadzanieWszystkimiKursami();
                        }
                        default -> System.out.println("Takiej opcji nie ma!");
                    }
                } else  //opcje dla studenta
                {
                    switch (choice) {
                        case 1:
                            System.out.println("Kursy, na które możesz się zapisać: ");
                            aplikacja.wyswietlKursy(ID, true);//wyświetla wszystkie dostępne kursy
                            break;
                        case 2:
                            System.out.println("Prowadzący na naszej uczelni: ");
                            aplikacja.wyswietlListeProwadzacych();
                            break;
                        case 3:
                            //aplikacja.zapiszStudentaNaKurs(ID);
                            break;
                        case 4:
                            System.out.println("Kursy, na które jesteś zapisany: ");
                            aplikacja.wyswietlKursy(ID, false);//wyświetla kursy, w których jest student
                            break;
                        default:
                            break;
                    }
                }
            }while (true) ;
        } while (true);
        System.out.println("Zapraszamy ponownie!");
    }
}
