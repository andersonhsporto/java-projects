/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.anderson.clientes.sistema.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ahigo
 */
public class ConnectionFactory {

//	static final String JDBC_DRIVER = "org.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/BDVENDAS";

	static final String USER = "teste";
	static final String PASS = "123";

	private Connection con;

	public Connection getConnection() {
		try {
//			Class.forName(JDBC_DRIVER);

			this.con = DriverManager.getConnection(DB_URL, USER, PASS);

			this.makeClientTable();
			this.makeEmployeeTable();
			this.makeVendorTable();
			this.makeProductTable();

			return con;
		} catch (Exception e) {
                    System.out.println(e.getMessage());
			throw new RuntimeException();
		}
	}

	private void makeClientTable() {
		String createTableQuery = "CREATE TABLE IF NOT EXISTS `tb_clientes` (  "
				+ "id int auto_increment primary key,\n"
				+ "  nome varchar(100),\n"
				+ "  rg varchar (30),\n"
				+ "  cpf varchar (20),\n"
				+ "  email varchar(200),\n"
				+ "  telefone varchar(30),\n"
				+ "  celular varchar(30),\n"
				+ "  cep varchar(100),\n"
				+ "  endereco varchar (255),\n"
				+ "  numero int,\n"
				+ "  complemento varchar (200),\n"
				+ "  bairro varchar (100),\n"
				+ "  cidade varchar (100),\n"
				+ "  estado varchar (2))";

		try {
			assert this.con != null;
			con.createStatement().executeUpdate(createTableQuery);
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}

	private void makeEmployeeTable() {
		String createTableQuery = "CREATE TABLE IF NOT EXISTS `tb_funcionarios` (  "
				+ "id int auto_increment primary key,\n"
				+ "  nome varchar(100),\n"
				+ "  rg varchar (30),\n"
				+ "  cpf varchar (20),\n"
				+ "  email varchar(200),\n"
				+ "  senha varchar(254), \n"
				+ "  cargo varchar (20), \n"
				+ "  nivel_acesso varchar(20), \n"
				+ "  telefone varchar(30),\n"
				+ "  celular varchar(30),\n"
				+ "  cep varchar(100),\n"
				+ "  endereco varchar (255),\n"
				+ "  numero int,\n"
				+ "  complemento varchar (200),\n"
				+ "  bairro varchar (100),\n"
				+ "  cidade varchar (100),\n"
				+ "  estado varchar (2))";

		try {
			assert this.con != null;
			con.createStatement().executeUpdate(createTableQuery);
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}

	private void makeVendorTable() {
		String createTableQuery = "CREATE TABLE IF NOT EXISTS `tb_fornecedores` (  "
				+ "id int auto_increment primary key,\n"
				+ "  nome varchar(100),\n"
				+ "  cnpj varchar (100),\n"
				+ "  email varchar(200),\n"
				+ "  senha varchar(254), \n"
				+ "  cargo varchar (20), \n"
				+ "  nivel_acesso varchar(20), \n"
				+ "  telefone varchar(30),\n"
				+ "  celular varchar(30),\n"
				+ "  cep varchar(100),\n"
				+ "  endereco varchar (255),\n"
				+ "  numero int,\n"
				+ "  complemento varchar (200),\n"
				+ "  bairro varchar (100),\n"
				+ "  cidade varchar (100),\n"
				+ "  estado varchar (2))";

		try {
			assert this.con != null;
			con.createStatement().executeUpdate(createTableQuery);
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}

	public void makeProductTable() {
		String createTableQuery = "CREATE TABLE IF NOT EXISTS `tb_produtos` ( "
				+ "id int auto_increment primary key,\n"
				+ "  descricao varchar(100),\n"
				+ "  preco decimal (10,2),"
				+ "  qtd_estoque int,\n"
				+ "  for_id int,\n"
				+ "  FOREIGN KEY (for_id) REFERENCES tb_fornecedores(id)\n"
				+ ")";

		try {
			assert this.con != null;
			con.createStatement().executeUpdate(createTableQuery);
		} catch (SQLException e) {
			System.out.println("Error");
		}
	}

}
