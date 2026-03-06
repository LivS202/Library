public class Bok {
    public String titel;
    public int år;
    public String forfattare;

    public Bok(String titel, int år, String forfattare) {
        this.titel = titel;
        this.år = år;
        this.forfattare = forfattare;
    }

    public void visaInfo() {
        System.out.println(titel + " - " + forfattare + " (" + år + ")");
    }
}