package apartadoB;

import javax.swing.*;

public class interfazGrafica {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi Aplicación");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); 

        LabelTextFieldPanel panel1 = new LabelTextFieldPanel();
        panel1.setLabelText("Nombre:");
        frame.add(panel1);

        LabelTextFieldPanel panel2 = new LabelTextFieldPanel();
        panel2.setLabelText("Edad:");
        frame.add(panel2);

        
        frame.setVisible(true);
    }
}
