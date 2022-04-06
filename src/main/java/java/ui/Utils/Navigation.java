package java.ui.Utils;

import javax.swing.*;
import java.awt.*;

public class Navigation {

    public static JFrame initForm(Container panel, int ancho, int alto, String titulo) {

        JFrame frame = new JFrame(titulo);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setContentPane(panel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                frame.setSize(ancho, alto);
                frame.setLocationRelativeTo(null);

                // JFrame FullScreen
                frame.setExtendedState(Frame.MAXIMIZED_BOTH);
            }
        });

        return frame;
    }

}
