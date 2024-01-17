package Restaurante;
import javax.swing.*;
import java.awt.*;

public class ReservaRestaurante {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Reservas Restaurante");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel nameLabel = new JLabel("Nombre:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nameLabel, constraints);

        JTextField nameText = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(nameText, constraints);

        JLabel dateLabel = new JLabel("Fecha:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(dateLabel, constraints);

        JTextField dateText = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(dateText, constraints);

        JLabel timeLabel = new JLabel("Hora:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(timeLabel, constraints);

        JTextField timeText = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(timeText, constraints);

        JLabel peopleLabel = new JLabel("Número de personas:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(peopleLabel, constraints);

        JTextField peopleText = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(peopleText, constraints);

        JLabel tableLabel = new JLabel("Tipo de mesa:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(tableLabel, constraints);

        String[] tableTypes = {"Normal", "VIP", "Terraza"};
        JComboBox<String> tableDropdown = new JComboBox<>(tableTypes);
        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(tableDropdown, constraints);

        JButton reserveButton = new JButton("Reservar");
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        panel.add(reserveButton, constraints);

        // Añadir tooltips
        nameText.setToolTipText("Ingrese su nombre");
        dateText.setToolTipText("Ingrese la fecha en formato dd/mm/yyyy");
        timeText.setToolTipText("Ingrese la hora en formato hh:mm");
        peopleText.setToolTipText("Ingrese el número de personas");
        tableDropdown.setToolTipText("Seleccione el tipo de mesa");
        reserveButton.setToolTipText("Haga clic para realizar la reserva");

        // Mejorar la paleta de colores
        panel.setBackground(new Color(240, 240, 240));
        nameLabel.setForeground(Color.PINK);
        dateLabel.setForeground(Color.PINK);
        timeLabel.setForeground(Color.PINK);
        peopleLabel.setForeground(Color.PINK);
        tableLabel.setForeground(Color.PINK);
        reserveButton.setBackground(Color.PINK); // Verde lima

        // Mejorar legibilidad y estética
        Font labelFont = new Font("Arial", Font.BOLD, 12);
        nameLabel.setFont(labelFont);
        dateLabel.setFont(labelFont);
        timeLabel.setFont(labelFont);
        peopleLabel.setFont(labelFont);
        tableLabel.setFont(labelFont);

        reserveButton.setForeground(Color.WHITE);
        reserveButton.setFont(new Font("Arial", Font.BOLD, 14));
    }
}
