import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotek {

    public static void main(String[] args) {

        //flödesschema i draw.io

        Scanner scan = new Scanner(System.in);

        // Skapa en lista med böcker
        ArrayList<Bok> lista = new ArrayList<>();

        // Lägg till tre böcker
        lista.add(new Bok("Java Basics", 2020, "Anders"));
        lista.add(new Bok("Programming 1", 2019, "Maria"));
        lista.add(new Bok("Coding Guide", 2022, "Ali"));

        System.out.println("\nVälkommen till biblioteket. Vill du:");

        while (true) {
            System.out.println("\n1. Visa alla böcker \n2. Lägg till en bok \n3. Ta bort en bok \n4. Avsluta");

            int val = scan.nextInt();
            scan.nextLine(); // rensa bufferten

            if (val == 1) {
                System.out.println("\nBöcker i biblioteket:");
                for (int i = 0; i < lista.size(); i++) {
                    System.out.print((i + 1) + ". ");
                    lista.get(i).visaInfo();
                }
            } else if (val == 2) {
                System.out.println("Skriv titel:");
                String titel = scan.nextLine();
                System.out.println("Skriv år:");
                int år = scan.nextInt();
                scan.nextLine();
                System.out.println("Skriv författare:");
                String forfattare = scan.nextLine();

                lista.add(new Bok(titel, år, forfattare));
                System.out.println("Boken är tillagd!");
            } else if (val == 3) {
                System.out.println("Vilken bok vill du ta bort? (nummer)");
                int index = scan.nextInt();
                scan.nextLine();
                lista.remove(index - 1); //ta bort en bok från listan
                System.out.println("Boken är borttagen!");
            } else if (val == 4) {
                System.out.println("Programmet avslutas.");
                break;
            } else {
                System.out.println("Fel val, försök igen.");
            }
        }
    }
}