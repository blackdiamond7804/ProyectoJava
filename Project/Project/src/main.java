/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import javax.swing.SwingUtilities;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestorTareas modelo = new GestorTareas();
            MainView vista = new MainView();
            new TareasController(modelo, vista);
            vista.setVisible(true);
        });
    }
}

