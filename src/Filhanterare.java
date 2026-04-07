import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException; //ger felmeddelande ifall filen inte finns istället för att avsluta/krascha

public class Filhanterare {

    public static void readFile(ArrayList <Bok> lista) {
        try {
            File file = new File("Book.txt");
            Scanner filScanner = new Scanner(file); //?

            while (filScanner.hasNextLine()) { //fortsätter köra loop ifall mer text finns
                String titel = filScanner.nextLine();
                int år = filScanner.nextInt();
                filScanner.nextLine();
                String författare = filScanner.nextLine();
                lista.add(new Bok(titel, år, författare));
        }
    }catch (FileNotFoundException e){
        System.out.println("Filen finns inte! ");
      }
    }
}
