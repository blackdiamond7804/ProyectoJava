/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<Tarea> tareas = new ArrayList<>();
    private int idCounter = 1;

    public void agregarTarea(String nombre, String descripcion) {
        tareas.add(new Tarea(idCounter++, nombre, descripcion));
    }

    public ArrayList<Tarea> listarTareas() {
        return tareas;
    }

    public void completarTarea(int id) {
        for (Tarea t : tareas) {
            if (t.getId() == id) {
                t.setCompletada(true);
                break;
            }
        }
    }

    public void eliminarTarea(int id) {
        tareas.removeIf(t -> t.getId() == id);
    }
}