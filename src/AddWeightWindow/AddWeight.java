package AddWeightWindow;

import javax.swing.*;
import java.awt.*;
import org.jdesktop.swingx.JXDatePicker;

import java.awt.event.ActionEvent;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;



public class AddWeight extends JFrame {
    private final JLabel WeightText = new JLabel("Enter Weight*:");
    private final JTextField WeightInput = new JTextField(20);
    private final JLabel DateText = new JLabel("Date*:");
    private final JXDatePicker DatePicker = new JXDatePicker();
    private final JCheckBox IsToday = new JCheckBox("Today");
    private final JLabel PhotoText = new JLabel("Photo:");
    private final FilePicker PhotoPicker = new FilePicker(1, null);
    private final JCheckBox IsPhotoAdd = new JCheckBox("Add Photo");
    private final JButton Enter = new JButton("Enter");

    public AddWeight(){
        setTitle("Add Weight");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setAppView();

        DatePicker.setDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
        IsToday.setSelected(true);
        DatePicker.setEditable(!IsToday.isSelected());
        PhotoPicker.setEnabled(IsPhotoAdd.isSelected());

        IsToday.addActionListener((ActionEvent e) -> {
            if(IsToday.isSelected()){
                DatePicker.setDate(new Date());
            }
            DatePicker.setEditable(!IsToday.isSelected());
        });;

        IsPhotoAdd.addActionListener((ActionEvent e) -> {
            PhotoPicker.setEnabled(IsPhotoAdd.isSelected());
        });;

        Enter.addActionListener((ActionEvent e)-> {
            Date date = DatePicker.getDate();
            String path = IsPhotoAdd.isSelected() ? PhotoPicker.getSelectedPath() : "";
            double weight = Double.parseDouble(WeightInput.getText());

            new CsvData(date, path, weight);
        });


        pack();
        setLocationRelativeTo(null);
    }

    private void setAppView(){
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        // Satır 1
        c.gridx = 0; c.gridy = 0; c.weightx = 0;
        panel.add(WeightText, c);
        c.gridx = 1; c.weightx = 1.0;
        panel.add(WeightInput, c);

        // Satır 2
        c.gridy = 1;
        c.gridx = 0; c.weightx = 0;
        panel.add(DateText, c);
        c.gridx = 1; c.weightx = 1.0;
        panel.add(DatePicker, c);
        c.gridx = 2; c.weightx = 0;
        panel.add(IsToday, c);
        c.gridx = 3; c.weightx = 1.0;

        // Satir 3 - File Chooser + Checkbox
        c.gridy = 2;
        c.gridx = 0; c.weightx = 0;
        panel.add(PhotoText, c);
        c.gridx = 1; c.weightx = 1.0;
        panel.add(PhotoPicker, c);
        c.gridx = 2; c.weightx = 0;
        panel.add(IsPhotoAdd, c);

        // Satır 4 – Button
        c.gridy = 3;
        c.gridx = 1; c.weightx = 0; c.gridwidth = 1;
        panel.add(Enter, c);

        add(panel);
    }
}