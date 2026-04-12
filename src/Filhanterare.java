import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException; //ger felmeddelande ifall filen inte finns istället för att avsluta/krascha

  public class Filhanterare {

    public static void readFile(ArrayList<Bok>lista) {
        lista.clear();

        try {
            File file = new File("books.txt");
            Scanner filScanner = new Scanner(file);

         while (filScanner.hasNextLine()) {
            String titel = filScanner.nextLine();

            if (!filScanner.hasNextLine()) break; //undviker krasch, finns inte fler rader (t ex bara 2 ist för 3) avslutas loopen direkt
            String årRad = filScanner.nextLine();

            if (!filScanner.hasNextLine()) break; //undviker krasch, finns inte fler rader (t ex bara 2 ist för 3) avslutas loopen direkt
            String forfattare = filScanner.nextLine();

            int år = Integer.parseInt(årRad); //omvandlar text till heltal

            lista.add(new Bok(titel, år, forfattare));

        }
         filScanner.close();

    }catch (FileNotFoundException e) {
            System.out.println("Ingen fil hittades! ");
          }
       }

       public static void saveFile(ArrayList<Bok>lista) {

        try {
            File file = new File("books.txt");

            if (!file.exists()){
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file);

            for (Bok b : lista) {
                writer.write(b.titel + "\n");
                writer.write(b.år + "\n");
                writer.write(b.forfattare + "\n");
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("Fel vid sparningen ");
        }
    }
}
