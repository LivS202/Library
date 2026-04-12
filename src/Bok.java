public class Bok {
    public String titel;
    public int år;
    public String forfattare;

    public Bok(String titel, int år, String forfattare) {
        this.titel = titel;
        this.år = år;
        this.forfattare = forfattare;
    }
    @Override
   public String toString() {
        return titel + " - " + forfattare + " (" + år + ")";
    }
}