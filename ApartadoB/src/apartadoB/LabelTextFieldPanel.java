package apartadoB;

import javax.swing.*;
import java.awt.*;

public class LabelTextFieldPanel extends JPanel {
    private JLabel label;
    private JTextField textField;

    public LabelTextFieldPanel() {
        label = new JLabel("Label");
        textField = new JTextField(10);
        
        setLayout(new BorderLayout());
        add(label, BorderLayout.WEST);
        add(textField, BorderLayout.CENTER);
    }

    public String getLabelText() {
        return label.getText();
    }

    public void setLabelText(String text) {
        label.setText(text);
    }

    public String getTextFieldContent() {
        return textField.getText();
    }

    public void setTextFieldContent(String content) {
        textField.setText(content);
    }
}