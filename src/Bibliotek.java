import java.util.ArrayList;
import java.util.Scanner;

public class Bibliotek {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Skapa en lista med böcker
        ArrayList<Bok> lista = new ArrayList<>();
        Filhanterare.readFile(lista);

        // Om filen är tom läggr den till standrardböcker
        if (lista.isEmpty()) { //om inga böcker finns i listan, gör det som
            lista.add(new Bok("Spanska 3", 2022, "Francisco Cabrera"));
            lista.add(new Bok("Grundläggande hemkunskap", 2019, "Maria Andersson Gibrand"));
            lista.add(new Bok("Andra världskriget", 2024, "Kristoffer Pennegård"));
        }

        System.out.println("\nVälkommen till biblioteket. Vill du:");

        while (true) {
            System.out.println("\n1. Visa alla böcker \n2. Lägg till en bok \n3. Ta bort en bok \n4. Avsluta");

            int val = scan.nextInt();
            scan.nextLine(); // rensa bufferten

            if (val == 1) {
                System.out.println("\nBöcker i biblioteket:");
                for (int i = 0; i < lista.size(); i++) {
                    System.out.println((i + 1) + ". " + lista.get(i));
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
                Filhanterare.saveFile(lista);
                System.out.println("Programmet sparar och avslutas.");
                break;
            } else {
                System.out.println("Fel val, försök igen.");
            }
        }
    }
}