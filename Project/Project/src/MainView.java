/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame {
    private JTextField txtNombre;
    private JTextArea txtDescripcion;
    private JButton btnAgregar, btnCompletar, btnEliminar;
    private JTable tablaTareas;
    private DefaultTableModel modeloTabla;

    public MainView() {
        setTitle("Gestor de Tareas");
        setSize(700, 500);
        setMinimumSize(new Dimension(600, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(220, 235, 245));

        JLabel titulo = new JLabel("Gestor de Tareas", SwingConstants.CENTER);
        titulo.setFont(new Font("Sans-Serif", Font.BOLD, 24));
        titulo.setForeground(new Color(0, 102, 204));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel panelSuperior = new JPanel(new GridBagLayout());
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        panelSuperior.setBackground(new Color(200, 220, 240));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        panelSuperior.add(lblNombre, gbc);

        gbc.gridx = 1;
        txtNombre = new JTextField();
        txtNombre.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        panelSuperior.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        panelSuperior.add(lblDescripcion, gbc);

        gbc.gridx = 1;
        txtDescripcion = new JTextArea(2, 20);
        txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        panelSuperior.add(new JScrollPane(txtDescripcion), gbc);

        JPanel panelCentro = new JPanel(new BorderLayout());
        panelCentro.setBackground(new Color(200, 220, 240));
        panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        String[] columnas = {"ID", "Nombre", "Descripción", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaTareas = new JTable(modeloTabla);
        tablaTareas.setRowHeight(25);
        tablaTareas.getTableHeader().setFont(new Font("Sans-Serif", Font.BOLD, 14));
        JScrollPane scrollTabla = new JScrollPane(tablaTareas);
        scrollTabla.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelCentro.add(scrollTabla, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.setBackground(new Color(200, 220, 240));
        
        btnAgregar = createStyledButton("Agregar");
        btnCompletar = createStyledButton("Completar");
        btnEliminar = createStyledButton("Eliminar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnCompletar);
        panelBotones.add(btnEliminar);

        panelCentro.add(panelBotones, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        configurarRenderizadoEstado();
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Sans-Serif", Font.BOLD, 14));
        button.setBackground(new Color(0, 102, 204));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(0, 82, 164));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(0, 102, 204));
            }
        });
        return button;
    }

    private void configurarRenderizadoEstado() {
        tablaTareas.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public void setValue(Object value) {
                if ("✅ Completada".equals(value)) {
                    setForeground(Color.GREEN);
                } else {
                    setForeground(Color.BLACK);
                }
                setText((value == null) ? "" : value.toString());
            }
        });
    }

    public JTextField getTxtNombre() { return txtNombre; }
    public JTextArea getTxtDescripcion() { return txtDescripcion; }
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnCompletar() { return btnCompletar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JTable getTablaTareas() { return tablaTareas; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }
}