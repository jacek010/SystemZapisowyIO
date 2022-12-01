import java.util.Scanner;

public class Main {
    public static int ID;
    private static Aplikacja aplikacja;
    static void initData() //funkcja wypełnia na starcie bazę przykładowymi wartościami
    {
        System.out.println("Wypełniam bazę początkowymi wartościami");
    }

    private static void printMainMenu()
    {
        System.out.println("Zalogowano jako ID: "+ID);
        System.out.println("Wybierz co chcesz zrobić: ");
        if(ID==1)//menu dla administratora
        {
            System.out.println("\t1. Zarządzaj studentem");
            System.out.println("\t2. Zarządzaj kursami");
        }
        else //menu dla studenta
        {
            System.out.println("\t1. Pokaż dostepne kursy");
            System.out.println("\t2. Wyświetl liste prowadzących");
            System.out.println("\t3. Dokonaj zapisu na kurs");
            System.out.println("\t4. Wyświetl kursy na które jestem zapisany");
        }

        System.out.println("0. ZAKOŃCZ działanie programu");
    }

    public static void main(String[] args)
    {
        aplikacja = new Aplikacja();
        initData();

        System.out.println("\n\nWitaj w systemie zapisowym uczelni wyższej\n");

        System.out.println("Podaj swoje ID: ");
        Scanner input = new Scanner(System.in);
        ID = input.nextInt();
        do { //główna pętla programu
            printMainMenu();



        }while(input.nextInt()!=0);
        System.out.println("Zapraszamy ponownie!");
    }
}