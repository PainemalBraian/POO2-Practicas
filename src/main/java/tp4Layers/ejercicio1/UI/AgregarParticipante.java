package tp4Layers.ejercicio1.UI;

import tp4Layers.ejercicio1.model.FRONTAPI;
import tp4Layers.ejercicio1.model.BackController;
import tp4Layers.ejercicio1.model.ValidacionException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AgregarParticipante extends JFrame {
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private FRONTAPI controller;

    public AgregarParticipante() throws Exception {
        controller = new BackController();
        setupUI();
    }

    private void setupUI() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nombre = new JTextField(10);
        telefono = new JTextField(10);
        region = new JTextField(10);

        nombre.setText("");
        telefono.setText("");
        region.setText("China");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Teléfono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Región: "));
        contentPane.add(region);

        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener((ActionEvent e) -> {
            onBotonCargar();
        });

        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() {
        try {
            controller.agregarParticipante(nombre.getText(),
                    telefono.getText(),
                    region.getText());
            JOptionPane.showMessageDialog(this, "Participante guardado exitosamente");
            dispose();
        } catch (ValidacionException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validación", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}