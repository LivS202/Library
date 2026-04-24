import javax.print.attribute.standard.JobName;
import javax.swing.*;
import java.awt.*;

public class TaBortBok {
    JFrame frame;

    public TaBortBok(BibliotekData bibliotekData){
        frame = new JFrame("Ta bort bok");
        frame.setSize(500,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        StringBuilder text = new StringBuilder();
        for (int i = 0; i < bibliotekData.getLista().size(); i++){
            text.append(i + 1)
                    .append(". ")
                    .append(bibliotekData.getLista().get(i).toString())
                    .append("\n");
        }
        if (bibliotekData.getLista().isEmpty()){
            text.append("Inga böcker att ta bort.");
        }
        textArea.setText(text.toString());

        JPanel bottomPanel = new JPanel();
        JLabel label = new JLabel("Ange nummer på boken");
        JTextField indexField = new JTextField(5);
        JButton taBortKnapp = new JButton("Ta bort");
        JButton tillbakaKnapp = new JButton("Tillbaka");

        taBortKnapp.addActionListener(e -> {
            try {
                int index = Integer.parseInt(indexField.getText()) - 1;
                bibliotekData.taBortBok(index);
                JOptionPane.showMessageDialog(frame, "Boken togs bort.");
                frame.dispose();
                new TaBortBok((bibliotekData));
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(frame, "Skriv ett giltigt nummer");
            }
        });

        tillbakaKnapp.addActionListener(e -> {
            frame.dispose();
            new Meny(bibliotekData);
        });

        bottomPanel.add(label);
        bottomPanel.add(indexField);
        bottomPanel.add(taBortKnapp);
        bottomPanel.add(tillbakaKnapp);

        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
