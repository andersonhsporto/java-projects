/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.anderson.clientes.sistema.dao;

import dev.anderson.clientes.sistema.jdbc.ConnectionFactory;
import dev.anderson.clientes.sistema.model.VendorEntity;
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
public class VendorDAO {
    private final Connection con;

    public VendorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void saveVendor(VendorEntity vendor) {
        String saveQuery = "insert into tb_fornecedores (nome,cnpj,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                + " values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(saveQuery);

            stmt.setString(1, vendor.getName());
            stmt.setString(2, vendor.getCnpj());
            stmt.setString(3, vendor.getEmail());
            stmt.setString(4, vendor.getTelephone());
            stmt.setString(5, vendor.getMobile());
            stmt.setString(6, vendor.getCEP());
            stmt.setString(7, vendor.getAddress());
            stmt.setInt(8, vendor.getNumber());
            stmt.setString(9, vendor.getAddressComplement());
            stmt.setString(10, vendor.getNeighborhood());
            stmt.setString(11, vendor.getCity());
            stmt.setString(12, vendor.getState());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor Cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }
    
    public void deleteVendor(VendorEntity vendorEntityt) {
        String query = "delete from tb_fornecedores where id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setInt(1, vendorEntityt.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor Deletado Com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }
    
    public void updateVendor(VendorEntity vendor) {
        String saveQuery = "update tb_fornecedores set  nome=?, cnpj=?, email=?, telefone=?, celular=?, cep=?, "
                + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=?  where id =?";

        try {
            PreparedStatement stmt = con.prepareStatement(saveQuery);

            stmt.setString(1, vendor.getName());
            stmt.setString(2, vendor.getCnpj());
            stmt.setString(3, vendor.getEmail());
            stmt.setString(4, vendor.getTelephone());
            stmt.setString(5, vendor.getMobile());
            stmt.setString(6, vendor.getCEP());
            stmt.setString(7, vendor.getAddress());
            stmt.setInt(8, vendor.getNumber());
            stmt.setString(9, vendor.getAddressComplement());
            stmt.setString(10, vendor.getNeighborhood());
            stmt.setString(11, vendor.getCity());
            stmt.setString(12, vendor.getState());
            stmt.setInt(13, vendor.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Fornecedor Editado Com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }
    
    public List<VendorEntity> findAllVendor() {
        try {
            String findAllQuery = "select * from tb_fornecedores";
            List<VendorEntity> list = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(findAllQuery);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                VendorEntity obj = new VendorEntity();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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
    
    public List<VendorEntity> findAllVendorByName(String name) {
        try {
            String findAllQuery = "select * from tb_fornecedores where nome = ?";
            List<VendorEntity> list = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(findAllQuery);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                VendorEntity obj = new VendorEntity();

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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
    
    public VendorEntity findByName(String name) {
        try {
            String sql = "select * from tb_fornecedores where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            VendorEntity obj = new VendorEntity();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
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
