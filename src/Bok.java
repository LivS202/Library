public class Bok {
    public String titel;
    public int år;
    public String forfattare;

    public Bok(String titel, int år, String forfattare) {
        this.titel = titel;
        this.år = år;
        this.forfattare = forfattare;
    }

    @Override //skriver över en metod som redan finns i Java
   public String toString() { //gör koden läsbar, du själv bestämmer hur objektet ska skrivas
        return titel + " - " + forfattare + " (" + år + ")";
    }
}