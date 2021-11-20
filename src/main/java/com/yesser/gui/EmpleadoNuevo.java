package com.yesser.gui;

import com.yesser.conexion.Conexion;
import com.yesser.dao.EmpleadoDao;
import com.yesser.dao.EmpleadoDaoImpl;
import com.yesser.dao.PersonaDao;
import com.yesser.dao.PersonaDaoImpl;
import com.yesser.modelo.Empleado;
import com.yesser.modelo.Persona;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EmpleadoNuevo extends JInternalFrame{
    
    private static EmpleadoNuevo miClase;
    public EmpleadoNuevo()
    {
        miClase = this;
        inicializarCambiarClase();
    }

    public static EmpleadoNuevo getInstancia()
    {
        return (miClase == null) ? new EmpleadoNuevo() : miClase;
    }

    protected void cerrar()
    {
        this.dispose();
        miClase = null;
    }

    private void inicializarCambiarClase() {
        //Caracteristicas del formulario
        setToolTipText("Formulario personalizado");
        setOpaque(true);
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setIconifiable(false);
        setTitle("Cambiar Clase");
        setClosable(true);
        setName("Cambiar_Clase");

        //se crear una etiqueta para titulo del formulario
        JLabel lblTitle = new JLabel("CambiarClase - Crear/Editar ");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setPreferredSize(new Dimension(80, 40));

        //Instanciar objetos contenidos en el formulario
        JLabel lblCambiarClase = new JLabel("Clase:");
        JPanel pnlTitle = new JPanel(); //Panel que contiene el titulo del formulario
        JPanel pnlCentral = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JPanel pnlButton = new JPanel();

        //se define caracteristicas de objetos del formulario
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, Color.black));
        pnlTitle.setLayout(new BoxLayout(pnlTitle, BoxLayout.LINE_AXIS));
        pnlTitle.setBackground(new Color(0, 117, 175));
        lblCambiarClase.setToolTipText("Descripcion de este titulo");
        panel.add(lblCambiarClase);

        // label nombre
        JLabel texto = new JLabel("Nombre");

        // JTextField
        JTextField entradaTexto = new JTextField();
        entradaTexto.setText("James Reyes");

        // agregar al panel central
        panel.add(texto);
        panel.add(entradaTexto);

        // boton guardar
        JButton btnGuardar = new JButton();
        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new Dimension(120, 50));
        btnGuardar.setFocusable(false);
        btnGuardar.setEnabled(true);
        btnGuardar.setToolTipText("Guarda los cambios de los campos del Formulario");

        JButton btnCerrar = new JButton();
        btnCerrar.setText("Cerrar");
        btnCerrar.setPreferredSize(new Dimension(120, 50));
        btnCerrar.setFocusable(false);
        btnCerrar.setEnabled(true);
        btnCerrar.setToolTipText("Cierrar el Formulario");

        btnCerrar.addActionListener((ActionEvent arg0) -> {
            cerrar();
        });
        btnGuardar.addActionListener((ActionEvent arg0) -> {
            guardar();
            Empleado empleado= new Empleado(entradaTexto.getText());
            EmpleadoDao daoimpl = new EmpleadoDaoImpl();
            daoimpl.insert(empleado);
            btnGuardar.setEnabled(false);
        });

        //Agrega los componentes al formulario
        pnlTitle.add(Box.createRigidArea(new Dimension(10, 10)));
        pnlTitle.add(lblTitle);

        pnlButton.add(Box.createRigidArea(new Dimension(60, 10)));
        pnlButton.add(btnCerrar);
        pnlButton.add(btnGuardar);

        pnlCentral.add(panel);

        getContentPane().add(pnlTitle, BorderLayout.NORTH);
        getContentPane().add(pnlCentral, BorderLayout.CENTER);
        getContentPane().add(pnlButton, BorderLayout.SOUTH);
        pack();
    }

    private void guardar() {

    }
}
