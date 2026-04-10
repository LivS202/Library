import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException; //ger felmeddelande ifall filen inte finns istället för att avsluta/krascha

  public class Filhanterare {

    public static void readFile(ArrayList<Bok>lista) {
        try {
            File file = new File("books.txt");
            Scanner filScanner = new Scanner(file);

         while (filScanner.hasNextLine()) {
            String titel = filScanner.nextLine();
            int år = filScanner.nextInt();
            filScanner.nextLine();
            String forfattare = filScanner.nextLine();

            Bok b = new Bok(titel, år, forfattare);
            lista.add(b);
        }
         filScanner.close();

    }catch (FileNotFoundException e) {
            System.out.println("Ingen fil hittades! ");
          }
       }

       public static void saveFile(ArrayList<Bok>lista) {

        try {
            FileWriter writer = new FileWriter("src/books.txt");

            for (Bok b : lista) {
                writer.write(b.titel + "\n");
                writer.write(b.år + "\n");
                writer.write(b.forfattare + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("Fel vid sparning ");
        }
    }
}
