package tp4Layers.ejercicio1.UI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new AgregarParticipante();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}