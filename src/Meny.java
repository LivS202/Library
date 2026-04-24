import javax.swing.*;
import java.awt.*;

public class Meny {
    private JFrame frame;

    public Meny(BibliotekData bibliotekData){
        frame = new JFrame ("Bibliotek");
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

        panel.add(label);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

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
    }
}
