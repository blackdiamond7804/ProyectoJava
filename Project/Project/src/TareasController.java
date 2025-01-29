/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TareasController {
    private GestorTareas modelo;
    private MainView vista;

    public TareasController(GestorTareas modelo, MainView vista) {
        this.modelo = modelo;
        this.vista = vista;
        initController();
    }

    private void initController() {
        vista.getBtnAgregar().addActionListener(e -> agregarTarea());
        vista.getBtnCompletar().addActionListener(e -> completarTarea());
        vista.getBtnEliminar().addActionListener(e -> eliminarTarea());
    }

    private void agregarTarea() {
        String nombre = vista.getTxtNombre().getText();
        String descripcion = vista.getTxtDescripcion().getText();
        if (!nombre.isEmpty()) {
            modelo.agregarTarea(nombre, descripcion);
            actualizarTabla();
            vista.getTxtNombre().setText("");
            vista.getTxtDescripcion().setText("");
        } else {
            JOptionPane.showMessageDialog(vista, "El nombre no puede estar vacío.");
        }
    }

    private void completarTarea() {
        int filaSeleccionada = vista.getTablaTareas().getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = (int) vista.getModeloTabla().getValueAt(filaSeleccionada, 0);
            modelo.completarTarea(id);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(vista, "Selecciona una tarea para completar.");
        }
    }

    private void eliminarTarea() {
        int filaSeleccionada = vista.getTablaTareas().getSelectedRow();
        if (filaSeleccionada != -1) {
            int id = (int) vista.getModeloTabla().getValueAt(filaSeleccionada, 0);
            modelo.eliminarTarea(id);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(vista, "Selecciona una tarea para eliminar.");
        }
    }

    private void actualizarTabla() {
        vista.getModeloTabla().setRowCount(0);
        for (Tarea t : modelo.listarTareas()) {
            vista.getModeloTabla().addRow(new Object[]{
                t.getId(), t.getNombre(), t.getDescripcion(), t.isCompletada() ? "✅ Completada" : "⏳ Pendiente"
            });
        }
    }
}