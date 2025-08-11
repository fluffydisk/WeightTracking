package AddWeightWindow;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FilePicker extends JPanel {
    private final JTextField textField;
    private final JButton browseButton;

    /**
     * @param columns   JTextField sütun sayısı (genişlik)
     * @param buttonIcon  Browse butonu için ikon (null ise metinli buton olur)
     */
    public FilePicker(int columns, Icon buttonIcon) {
        super(new BorderLayout(4, 0));

        // Text field
        textField = new JTextField(columns);
        add(textField, BorderLayout.CENTER);


        // Browse butonu
        if (buttonIcon != null) {
            browseButton = new JButton(buttonIcon);
        } else {
            browseButton = new JButton("…");
        }
        add(browseButton, BorderLayout.EAST);

        // Butona tıklanınca JFileChooser aç
        browseButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int result = chooser.showOpenDialog(SwingUtilities.getWindowAncestor(this));
            if (result == JFileChooser.APPROVE_OPTION) {
                File selected = chooser.getSelectedFile();
                textField.setText(selected.getAbsolutePath());
            }
        });
    }

    /** Seçili dosya yolunu döner; yoksa boş string döner */
    public String getSelectedPath() {
        return textField.getText().trim();
    }

    /** Seçili File objesini döner; boşsa null döner */
    public File getSelectedFile() {
        String path = getSelectedPath();
        return path.isEmpty() ? null : new File(path);
    }

    @Override public void setEnabled(boolean bool){
        textField.setEnabled(bool);
        browseButton.setEnabled(bool);
    }

    public boolean is_enabled(){
        return textField.isEnabled();
    }
}
