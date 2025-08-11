package ShowEntriesWindow;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.awt.*;
import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import tech.tablesaw.api.*;
import tech.tablesaw.io.csv.CsvReadOptions;

public class ShowEntries extends JFrame {
    public ShowEntries(){
        setTitle("Show Entries");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createVerticalStrut(10));

        try{
            CsvReadOptions options = CsvReadOptions
                    .builder("Data/data.csv")
                    .dateFormat(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                    .columnTypes(new ColumnType[]{ColumnType.LOCAL_DATE, ColumnType.DOUBLE, ColumnType.STRING})
                    .build();

            Table data = Table.read().csv(options);
            data = data.sortAscendingOn("DATE");
            ArrayList<Entry>entries = new ArrayList<>();
            for (Row row : data) {
                entries.add(new Entry(
                        row.getDate("DATE"),
                        row.getDouble("WEIGHT"),
                        row.getString("PHOTO_PATH")));
            }

            for(Entry entry: entries){
                JButton button = new JButton(entry.getDate().toString());
                button.setAlignmentX(Component.CENTER_ALIGNMENT);
                button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 400));
                panel.add(button);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        getContentPane().add(panel);
        getContentPane().add(new JScrollPane(panel));

        setSize(400, 300);
    }

    void ListEntries(){

    }

}
