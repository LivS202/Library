import javax.swing.*;
import java.awt.*;

public class LaggTillBok {
    private JFrame frame;

    public LaggTillBok(BibliotekData bibliotekData){
        frame = new JFrame();
        frame.setSize(400,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10,10));

        JLabel titleLabel = new JLabel("Titel:");
        JTextField titelField = new JTextField();

        JLabel arLabel = new JLabel("År:");
        JTextField arField = new JTextField();

        JLabel forfattareLabel = new JLabel("Författare:");
        JTextField forfattareField = new JTextField();

        JButton sparaKnapp = new JButton("Spara");
        JButton tillbakaKnapp = new JButton("Tillbaka");

        sparaKnapp.addActionListener(e -> {
            try {
                String titel = titelField.getText();
                int ar = Integer.parseInt(arField.getText());
                String forfattare = forfattareField.getText();

                bibliotekData.laggTillBok(titel, ar, forfattare);

                JOptionPane.showMessageDialog(frame, "Boken lades till!");
                frame.dispose();
                new Meny(bibliotekData);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "År måste vara ett heltal.");
            }
        });
        tillbakaKnapp.addActionListener(e -> {
            frame.dispose();
            new Meny(bibliotekData);
        });

        panel.add(titleLabel);
        panel.add(titelField);
        panel.add(arLabel);
        panel.add(arField);
        panel.add(forfattareLabel);
        panel.add(forfattareField);
        panel.add(sparaKnapp);
        panel.add(tillbakaKnapp);

        frame.add(panel);
        frame.setVisible(true);
    }
}
