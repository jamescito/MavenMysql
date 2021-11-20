package com.yesser.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class VentanaPrincipal extends JFrame {
    static JDesktopPane desktopPane;

    // Singleton
    static VentanaPrincipal miVentana;

    public VentanaPrincipal()
    {
        inicializar();
        miVentana = this;
    }

    private void inicializar() {
        setTitle("Mi Aplicación DAO _ Segunda Evaluación Parcial _ Implementación de software");
        setName("vPrincipal");
        setBounds(100, 100, 630, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);

        JToolBar toolBar = new JToolBar();
        getContentPane().add(toolBar, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("Nuevo");
        toolBar.add(btnNewButton);

        desktopPane = new JDesktopPane();
        getContentPane().add(desktopPane, BorderLayout.CENTER);
    }

    public void mostrar() {
        setVisible(true);
    }

    public static void agregar(JInternalFrame ventanaInterna) {
        VentanaPrincipal.getInstancia().add(ventanaInterna);
    }

    private static VentanaPrincipal getInstancia() {
        return (null == miVentana) ? new VentanaPrincipal() : miVentana;
    }
}
