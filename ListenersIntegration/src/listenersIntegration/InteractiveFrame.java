package listenersIntegration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InteractiveFrame extends JFrame {
    private JButton button;
    private JTextField textField;
    private JTextField textField_1;
    private JSlider slider;
    private JLabel sliderLabel;
    private JComboBox<String> comboBox;
    private JLabel comboBoxLabel;

    public InteractiveFrame() {
        setTitle("Interactive Listeners Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout());

        button = new JButton("Hover over me!");
        textField = new JTextField(20);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.PINK);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(UIManager.getColor("Button.background"));
            }
        });

        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setBackground(Color.YELLOW);
            }

            @Override
            public void focusLost(FocusEvent e) {
                textField.setBackground(Color.WHITE);
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                textField.setText("You pressed: " + keyChar);
            }
        });

        getContentPane().add(textField);
        getContentPane().add(button);

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        sliderLabel = new JLabel("Valor del slider: " + slider.getValue());

        slider.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int newValue = slider.getValue() - e.getWheelRotation();
                slider.setValue(newValue);
                sliderLabel.setText("Valor del slider: " + newValue);
            }
        });

        getContentPane().add(slider);
        getContentPane().add(sliderLabel);

        comboBox = new JComboBox<>(new String[]{"Opcion 1", "Opcion 2", "Opcion 3"});
        comboBoxLabel = new JLabel("Opción seleccionada: ");

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    comboBoxLabel.setText("Selected Option: " + comboBox.getSelectedItem());
                }
            }
        });

        getContentPane().add(comboBox);
        getContentPane().add(comboBoxLabel);

        textField_1 = new JTextField(20);
        getContentPane().add(textField_1);
        textField_1.requestFocusInWindow();
        setVisible(true);
    }

    public static void main(String[] args) {
        InteractiveFrame ifra = new InteractiveFrame();
        ifra.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                ifra.textField_1.requestFocusInWindow();
            }
        });
    }
}
