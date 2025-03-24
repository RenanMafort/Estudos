package features.java.java16;

import javax.swing.*;
import java.awt.*;

public class PackageTools {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Minha janela");
        frame.setMinimumSize(new Dimension(800,600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jLabel = new JLabel("Hello world!",SwingUtilities.CENTER);
        frame.getContentPane().add(jLabel);

        frame.pack();
        frame.setVisible(true);


    }
}
