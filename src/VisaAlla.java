import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class VisaAlla {
    private JFrame frame;

    public VisaAlla(BibliotekData bibliotekData){
        frame = new JFrame("Visa alla böcker");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setMargin(new Insets(10, 10, 10, 10));
        textArea.setEditable(false);

        StringBuilder text = new StringBuilder();
        for (int i=0; i < bibliotekData.getLista().size(); i++) {
            text.append(i + 1)
                    .append(", ")
                    .append(bibliotekData.getLista().get(i).toString())
                    .append("\n");
        }

        if (bibliotekData.getLista().isEmpty()) {
            text.append("Inga böcker i biblioteket.");
        }

        textArea.setText(text.toString());

        JButton tillbakaKnapp = new JButton("Tillbaka");
        tillbakaKnapp.addActionListener(e -> {
            frame.dispose();
            new Meny(bibliotekData);
        });

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(tillbakaKnapp, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

    }
}
