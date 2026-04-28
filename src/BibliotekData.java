import java.util.ArrayList;

public class BibliotekData {
    private ArrayList<Bok> lista;

    public BibliotekData(){
        lista = new ArrayList<>();

        Filhanterare.readFile(lista);

        if (lista.isEmpty()) {
            // Lägg till tre böcker
            lista.add(new Bok("Java Basics", 2020, "Anders"));
            lista.add(new Bok("Programming 1", 2019, "Maria"));
            lista.add(new Bok("Coding Guide", 2022, "Ali"));

            Filhanterare.saveFile(lista);
        }
    }
    public ArrayList<Bok> getLista(){
        return lista;
    }

    public void laggTillBok (String titel, int år, String författare){
        lista.add(new Bok(titel, år, författare));
        Filhanterare.saveFile(lista);
    }
    public void taBortBok (int index){
        if (index >= 0 && index < lista.size()){
            lista.remove(index);
            Filhanterare.saveFile(lista);
        }
    }
}
