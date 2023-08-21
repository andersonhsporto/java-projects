/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.anderson.clientes.sistema.dao;

import com.password4j.Hash;
import com.password4j.Password;

import dev.anderson.clientes.sistema.jdbc.ConnectionFactory;
import dev.anderson.clientes.sistema.model.ClientEntity;
import dev.anderson.clientes.sistema.model.EmployeeEntity;
import dev.anderson.clientes.sistema.model.enums.AccessEnum;
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
public class EmployeeDAO {

    private final Connection con;

    public EmployeeDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void saveEmployee(EmployeeEntity obj) {
        String saveQuery = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(saveQuery);

            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            this.hashPassword(stmt, obj.getPassword());
            stmt.setString(6, obj.getPosition());
            stmt.setString(7, obj.getAccessEnum().toString());
            stmt.setString(8, obj.getTelephone());
            stmt.setString(9, obj.getMobile());
            stmt.setString(10, obj.getCEP());
            stmt.setString(11, obj.getAddress());
            stmt.setInt(12, obj.getNumber());
            stmt.setString(13, obj.getAddressComplement());
            stmt.setString(14, obj.getNeighborhood());
            stmt.setString(15, obj.getCity());
            stmt.setString(16, obj.getState());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    public List<EmployeeEntity> findAllEmployee() {
        try {
            String findAllQuery = "select * from tb_funcionarios";
            List<EmployeeEntity> list = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(findAllQuery);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EmployeeEntity obj = new EmployeeEntity();

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
                obj.setPassword(rs.getString("senha"));
                obj.setPosition(rs.getString("cargo"));
                obj.setAccessEnum(AccessEnum.fromString(rs.getString("nivel_acesso")));

                list.add(obj);
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage());
        }
        return null;
    }

    public List<EmployeeEntity> findAllEmployeeByName(String name) {
        try {
            String findAllQuery = "select * from tb_funcionarios where nome = ?";
            List<EmployeeEntity> list = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(findAllQuery);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EmployeeEntity obj = new EmployeeEntity();

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
                obj.setPassword(rs.getString("senha"));
                obj.setPosition(rs.getString("cargo"));
                obj.setAccessEnum(AccessEnum.fromString(rs.getString("nivel_acesso")));

                list.add(obj);
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage());
        }
        return null;

    }

    public EmployeeEntity findByName(String name) {
        try {
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            EmployeeEntity obj = new EmployeeEntity();

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
                obj.setPassword(rs.getString("senha"));
                obj.setPosition(rs.getString("cargo"));
                obj.setAccessEnum(AccessEnum.fromString(rs.getString("nivel_acesso")));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }
    }

    public void updateEmployee(EmployeeEntity obj) {
        String saveQuery = "update tb_funcionarios set  nome=?, rg=?, cpf=?, email=?, senha=?,cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?, "
                + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=?  where id =?";

        try {
            PreparedStatement stmt = con.prepareStatement(saveQuery);

            stmt.setString(1, obj.getName());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            this.hashPassword(stmt, obj.getPassword());
            stmt.setString(6, obj.getPosition());
            stmt.setString(7, obj.getAccessEnum().toString());
            stmt.setString(5, obj.getTelephone());
            stmt.setString(6, obj.getMobile());
            stmt.setString(7, obj.getCEP());
            stmt.setString(8, obj.getAddress());
            stmt.setInt(9, obj.getNumber());
            stmt.setString(10, obj.getAddressComplement());
            stmt.setString(11, obj.getNeighborhood());
            stmt.setString(12, obj.getCity());
            stmt.setString(13, obj.getState());
            stmt.setInt(14, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cliente Editado Com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    private void hashPassword(PreparedStatement stmt, String password) throws SQLException {
        Hash hash = Password.hash(password).addRandomSalt().withArgon2();

        stmt.setString(5, hash.getResult());
    }

    private boolean isPasswordValid(String password, EmployeeEntity entity) {
        return Password
                .check(password, entity.getPassword())
                .withArgon2();
    }

    public void deleteEmployee(EmployeeEntity obj) {
        String saveQuery = "delete from tb_funcionarios where id = ?";

        try {
            PreparedStatement stmt = con.prepareStatement(saveQuery);

            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Funcionário Deletado Com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

}
