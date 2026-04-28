import javax.swing.*;
import java.awt.*;

public class Meny {
    private JFrame frame;

    public Meny(BibliotekData bibliotekData) {
        frame = new JFrame("Bibliotek");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel label = new JLabel("Vad vill du göra?", SwingConstants.CENTER);

        JButton button1 = new JButton("Visa Alla");
        JButton button2 = new JButton("Lägg till Bok");
        JButton button3 = new JButton("Ta bort Bok");
        JButton button4 = new JButton("Avsluta");
        JButton button5 = new JButton("Sök bok online");

        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        button1.addActionListener(e -> {
            frame.dispose();
            new VisaAlla(bibliotekData);
        });

        button2.addActionListener(e -> {
            frame.dispose();
            new LaggTillBok(bibliotekData);

        });

        button3.addActionListener(e -> {
            frame.dispose();
            new TaBortBok(bibliotekData);
        });

        button4.addActionListener(e -> System.exit(0));

        frame.add(panel);
        frame.setVisible(true);
        button5.addActionListener(e -> {
            String sokord = JOptionPane.showInputDialog(frame, "Skriv boktitel:");

            if (sokord != null && !sokord.isEmpty()) {
                Bok bok = ApiHamtaBok.sokBok(sokord);

                if (bok != null) {
                    int svar = JOptionPane.showConfirmDialog(
                            frame,
                            "Hittade:\n" + bok + "\n\nVill du lägga till boken?",
                            "Bok hittad",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (svar == JOptionPane.YES_OPTION) {
                        bibliotekData.laggTillBok(bok.titel, bok.år, bok.forfattare);
                        JOptionPane.showMessageDialog(frame, "Boken lades till!");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Ingen bok hittades.");
                }
            }
        });
    }
}
