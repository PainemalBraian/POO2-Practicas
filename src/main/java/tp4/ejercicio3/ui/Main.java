package tp4.ejercicio3.ui;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void start() {
        new RadioCompetition();
    }
}