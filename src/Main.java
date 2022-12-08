import java.util.Scanner;

public class Main {
    public static int ID;
    private static Aplikacja aplikacja = InitData.createSampleAplicationWithData();

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
            case 1:

                break;

            case 2:

                break;

            default:
                System.out.println("Takiej opcji nie ma!");
                break;
        }
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
                        case 1:
                            //printZarzadzajStudentemMenu();
                            //
                            //
                            //test
                            break;
                        case 2:
                            //printZarzadzajStudentemMenu();
                            break;
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
                            aplikacja.wyswietlKursy(ID, false);//wyświetla kursy w których jest student
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
