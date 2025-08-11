package Main;


import AddWeightWindow.AddWeight;
import ShowEntriesWindow.*;
import ShowGraphWindow.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {
    public MainFrame(){
        setTitle("Main Menu");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 3, 5, 0));


        JButton addWeightButton = new JButton("Add weight");
        JButton showGraphButton = new JButton("Show graph");
        JButton showEntries = new JButton("Show Entries");

        add(addWeightButton);
        add(showGraphButton);
        add(showEntries);

        addWeightButton.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new AddWeight().setVisible(true));
        });

        showGraphButton.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new ShowGraph());
        });

        showEntries.addActionListener((ActionEvent e) -> {
            SwingUtilities.invokeLater(() -> new ShowEntries().setVisible(true));
        });

        pack();
    }
}
