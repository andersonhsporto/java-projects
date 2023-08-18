/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dev.anderson.clientes.sistema;

import dev.anderson.clientes.sistema.jdbc.ConnectionFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author ahigo
 */
public class ClientesSistema {

    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Falha na conexão");
        }
    }
}
