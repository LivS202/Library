import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException; //ger felmeddelande ifall filen inte finns istället för att avsluta/krascha

  public class Filhanterare {

    public static void readFile(ArrayList<Bok>lista) {
        lista.clear(); //hindrar att samma böcker läggs till 2 gånger (skapar dubletter)

        try {
            File file = new File("books.txt");
            Scanner filScanner = new Scanner(file);

         while (filScanner.hasNextLine()) { //loopar och undviker krasch, finns inte fler rader (t ex bara 2 ist för 3) avslutas loopen direkt
            String titel = filScanner.nextLine();

            if (!filScanner.hasNextLine()) break; //undviker krasch, finns inte fler rader (t ex bara 2 ist för 3) avslutas loopen direkt
            String årRad = filScanner.nextLine();

            if (!filScanner.hasNextLine()) break; //undviker krasch, finns inte fler rader (t ex bara 2 ist för 3) avslutas loopen direkt
            String forfattare = filScanner.nextLine();

            int år = Integer.parseInt(årRad); //omvandlar text till heltal

            //skapar objekt av klassen Bok, konstruktorn i Bok klassen skickar värden till klassen, lägger objektet i lista
            lista.add(new Bok(titel, år, forfattare));
        }

         filScanner.close();

    }catch (FileNotFoundException e) {
            System.out.println("Ingen fil hittades! ");
          }
       }

       public static void saveFile(ArrayList<Bok>lista) {

        try {
            File file = new File("src/books.txt");

            if (!file.exists()){ //kollar om filen redan finns
                file.createNewFile(); //skapar ny tom fil på datorn
            }

            FileWriter writer = new FileWriter("src/books.txt");

            for (Bok b : lista) {
                writer.write(b.titel + "\n");
                writer.write(b.år + "\n");
                writer.write(b.forfattare + "\n");
            }
            writer.close();

        //om något går fel med in eller utmatning fångas felet och hanteras här
        } catch (IOException e) { //typ av fel (input/output)
            System.out.println("Fel vid sparningen ");
        }
    }
}
