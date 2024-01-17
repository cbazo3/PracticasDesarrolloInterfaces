package svg;

import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.JSVGScrollPane;
import javax.swing.*;
import java.awt.*;

public class SVGViewerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("SVG Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JSVGCanvas svgCanvas = new JSVGCanvas();
            JSVGScrollPane svgScrollPane = new JSVGScrollPane(svgCanvas);
            frame.getContentPane().add(svgScrollPane, BorderLayout.CENTER);

            // Reemplaza "path/to/your/file.svg" con la ruta de tu archivo SVG
           String userHome = System.getenv("USERPROFILE");
           String filePath = userHome + "\\Desktop\\2 dam\\Sistemas de gestión empresarial\\coche.svg";
           svgCanvas.setURI("file:" + filePath);
            frame.setVisible(true);
        });
    }
}