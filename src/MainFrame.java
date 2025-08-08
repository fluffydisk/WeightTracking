import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    private JButton addWeightButton;
    private JButton showGraphButton;

    public MainFrame(){
        setTitle("Main Menu");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2, 5, 0));

        addWeightButton = new JButton("Add weight");
        showGraphButton = new JButton("Show graph");
        add(addWeightButton);
        add(showGraphButton);

        addWeightButton.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new AddWeight().setVisible(true));
        });

        showGraphButton.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new ShowGraph());
        });

        pack();
    }
}
