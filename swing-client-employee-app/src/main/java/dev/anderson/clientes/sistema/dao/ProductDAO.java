/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.anderson.clientes.sistema.dao;

import dev.anderson.clientes.sistema.jdbc.ConnectionFactory;
import dev.anderson.clientes.sistema.model.ProductEntity;
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
public class ProductDAO {

    private final Connection con;

    private final VendorDAO vendorDAO;

    public ProductDAO() {
        this.con = new ConnectionFactory().getConnection();
        this.vendorDAO = new VendorDAO();
    }

    public void saveProduct(ProductEntity obj) {
        try {
            String query = "insert into tb_produtos (descricao, preco, qtd_estoque, for_id) values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, obj.getDescription());
            stmt.setBigDecimal(2, obj.getPrice());
            stmt.setInt(3, obj.getStockQuantity());
            stmt.setInt(4, obj.getVendor().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto Cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }

    }

    public List<ProductEntity> findAll() {
        try {
            String query = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id)";
            
            List<ProductEntity> list = new ArrayList<>();
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ProductEntity obj = new ProductEntity();
                VendorEntity f = new VendorEntity();

                obj.setId(rs.getInt("p.id"));
                obj.setDescription(rs.getString("p.descricao"));
                obj.setPrice(rs.getBigDecimal("p.preco"));
                obj.setStockQuantity(rs.getInt("p.qtd_estoque"));

                f.setName(rs.getString(("f.nome")));
                obj.setVendor(f);

                list.add(obj);
            }

            stmt.close();

            return list;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage());
        }
        return null;
    }

    public void update(ProductEntity obj) {
        try {
            String sql = "update tb_produtos  set descricao=?, preco=?, qtd_estoque=?, for_id=?  where id=?";
            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescription());
            stmt.setBigDecimal(2, obj.getPrice());
            stmt.setInt(3, obj.getStockQuantity());

            stmt.setInt(4, obj.getVendor().getId());

            stmt.setInt(5, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto Atualizado com Sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro :" + e.getMessage());
        }
    }

    public void delete(ProductEntity obj) {
        try {

            String sql = "delete from tb_produtos  where id=?";
            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto excluido com Sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro : " + e.getMessage());
        }
    }

    public List<ProductEntity> findAllByName(String name) {
        try {

            List<ProductEntity> list = new ArrayList<>();

            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductEntity obj = new ProductEntity();
                VendorEntity f = new VendorEntity();
                obj.setId(rs.getInt("p.id"));
                obj.setDescription(rs.getString("p.descricao"));
                obj.setPrice(rs.getBigDecimal("p.preco"));
                obj.setStockQuantity(rs.getInt("p.qtd_estoque"));

                f.setName(rs.getString(("f.nome")));

                obj.setVendor(f);

                list.add(obj);
            }

            return list;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }

    public ProductEntity findByName(String name) {
        try {
            //1 passo - criar o sql , organizar e executar.

            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao =  ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            ProductEntity obj = new ProductEntity();
            VendorEntity f = new VendorEntity();

            if (rs.next()) {

                obj.setId(rs.getInt("p.id"));
                obj.setDescription(rs.getString("p.descricao"));
                obj.setPrice(rs.getBigDecimal("p.preco"));
                obj.setStockQuantity(rs.getInt("p.qtd_estoque"));

                f.setName(rs.getString(("f.nome")));

                obj.setVendor(f);
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return null;
        }
    }

}
