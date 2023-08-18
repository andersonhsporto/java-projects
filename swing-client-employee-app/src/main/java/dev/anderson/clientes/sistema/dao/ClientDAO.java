/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.anderson.clientes.sistema.dao;

import dev.anderson.clientes.sistema.jdbc.ConnectionFactory;
import dev.anderson.clientes.sistema.model.ClientEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ahigo
 */
public class ClientDAO {

    private final Connection con;

    public ClientDAO() {
        this.con = new ConnectionFactory().getConnection();

    }

    public void saveClient(ClientEntity client) {
        String saveQuery = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(saveQuery);

            stmt.setString(1, client.getName());
            stmt.setString(2, client.getRg());
            stmt.setString(3, client.getCpf());
            stmt.setString(4, client.getEmail());
            stmt.setString(5, client.getTelephone());
            stmt.setString(6, client.getMobile());
            stmt.setString(7, client.getCEP());
            stmt.setString(8, client.getAddress());
            stmt.setInt(9, client.getNumber());
            stmt.setString(10, client.getAddressComplement());
            stmt.setString(11, client.getNeighborhood());
            stmt.setString(12, client.getCity());
            stmt.setString(13, client.getState());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    public void updateClient(ClientEntity client) {
        String saveQuery = "update tb_clientes set  nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, "
                + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=?  where id =?";

        try {
            PreparedStatement stmt = con.prepareStatement(saveQuery);

            stmt.setString(1, client.getName());
            stmt.setString(2, client.getRg());
            stmt.setString(3, client.getCpf());
            stmt.setString(4, client.getEmail());
            stmt.setString(5, client.getTelephone());
            stmt.setString(6, client.getMobile());
            stmt.setString(7, client.getCEP());
            stmt.setString(8, client.getAddress());
            stmt.setInt(9, client.getNumber());
            stmt.setString(10, client.getAddressComplement());
            stmt.setString(11, client.getNeighborhood());
            stmt.setString(12, client.getCity());
            stmt.setString(13, client.getState());
            stmt.setInt(14, client.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente Editado Com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    public void deleteClient(ClientEntity clientEntity) {
        String saveQuery = "delete from tb_clientes where id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(saveQuery);

            stmt.setInt(1, clientEntity.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente Deletado Com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    public List<ClientEntity> findAllClients() {
        try {
            String findAllQuery = "select * from tb_clientes";
            List<ClientEntity> list = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(findAllQuery);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ClientEntity obj = new ClientEntity();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelephone(rs.getString("telefone"));
                obj.setMobile(rs.getString("celular"));
                obj.setCEP(rs.getString("cep"));
                obj.setAddress(rs.getString("endereco"));
                obj.setNumber(rs.getInt("numero"));
                obj.setAddressComplement(rs.getString("complemento"));
                obj.setNeighborhood(rs.getString("bairro"));
                obj.setCity(rs.getString("cidade"));
                obj.setState(rs.getString("estado"));

                list.add(obj);
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage());
        }
        return null;
    }

    public List<ClientEntity> findAllClientsByName(String name) {
        try {
            String findAllQuery = "select * from tb_clientes where nome = ?";
            List<ClientEntity> list = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(findAllQuery);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ClientEntity obj = new ClientEntity();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelephone(rs.getString("telefone"));
                obj.setMobile(rs.getString("celular"));
                obj.setCEP(rs.getString("cep"));
                obj.setAddress(rs.getString("endereco"));
                obj.setNumber(rs.getInt("numero"));
                obj.setAddressComplement(rs.getString("complemento"));
                obj.setNeighborhood(rs.getString("bairro"));
                obj.setCity(rs.getString("cidade"));
                obj.setState(rs.getString("estado"));

                list.add(obj);
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage());
        }
        return null;
    }

    public ClientEntity findByName(String name) {
        try {
            String sql = "select * from tb_clientes where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            ClientEntity obj = new ClientEntity();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelephone(rs.getString("telefone"));
                obj.setMobile(rs.getString("celular"));
                obj.setCEP(rs.getString("cep"));
                obj.setAddress(rs.getString("endereco"));
                obj.setNumber(rs.getInt("numero"));
                obj.setAddressComplement(rs.getString("complemento"));
                obj.setNeighborhood(rs.getString("bairro"));
                obj.setCity(rs.getString("cidade"));
                obj.setState(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }
}
