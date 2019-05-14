package com.prjcadcliente.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.prjcadcliente.dominio.Cliente;

/**
 * <b> CRUDCliente</b><br>
 * Essa clase permite manipular as informações do cliente.Aqui você enecontrara os seguintes comados
 * @author yago.assilva
 *<ul>
 *<li>Cadastro</li>
 *<li>Pesquisar por nome e por id</li>
 *<li>Atualizar</li>
 *<li>declarar</li>
 */
public class CRUDCliente {
	//Declaração das instancias de comunicação com o banco de dados
	private Connection con =null;
	private ResultSet rs =null;
	private PreparedStatement pst =null;
	
	public String cadastrar(Cliente cliente) {
		 String msg;
		//Criação dos objetos para a conexão com o banco os dados
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
		 String Consulta = "INSERT INTO tbcliente(nome,email,telefone,idade)values(?,?,?,?)";
		 pst = con.prepareStatement(Consulta);
		 pst.setString(1, cliente.getNome());
		 pst.setString(2, cliente.getEmail());
		 pst.setString(3, cliente.getTelefone());
		 pst.setInt(4, cliente.getIdade());
		 int r = pst.executeUpdate();
		 if(r > 0)
			 msg = "Cadastro Realizado com sucesso!!!";
		 else
			 msg="Não foi possivel cadastrar!!!";
	}
		catch(SQLException ex) {
			msg ="Erro ao tentar cadastrar"+ex.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado:"+e.getMessage();
		}
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		} 
		return msg;
	}
	public String atualizar(Cliente cliente) {
		String msg;
		//Criação dos objetos para a conexão com o banco os dados
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
		 String Consulta = "UPDATE tbcliente SET (nome=?,email=?,telefone=?,idade=? WHERE id=?";
		 pst = con.prepareStatement(Consulta);
		 pst.setString(1, cliente.getNome());
		 pst.setString(2, cliente.getEmail());
		 pst.setString(3, cliente.getTelefone());
		 pst.setInt(4, cliente.getIdade());
		 int r = pst.executeUpdate();
		 if(r > 0)
			 msg = "Atualizado com sucesso";
		 else
			 msg="Não foi possivel Atualizar!!!";
	}
		catch(SQLException ex) {
			msg ="Erro ao tentar Atualizar"+ex.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado:"+e.getMessage();
		}
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		} 
		return msg;
	}
	public String deletar(Cliente cliente) {
		
		String msg;
		//Criação dos objetos para a conexão com o banco os dados
		try {
		 Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3307/clientedb","root","");
		 String Consulta = "DELETE FROM tbcliente WHERE id=?";
		 pst = con.prepareStatement(Consulta);
		 pst.setString(1, cliente.getNome());
		 int r = pst.executeUpdate();
		 if(r > 0)
			 msg = "Deletado com sucesso!!!";
		 else
			 msg="Não foi possivel Deletar!!!";
	}
		catch(SQLException ex) {
			msg ="Erro ao tentar Deletar"+ex.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado:"+e.getMessage();
		}
		finally {
			try{con.close();}catch(Exception e) {e.printStackTrace();}
		} 
		return msg;
	}
	public List<Cliente> pesquisarporNome(String nome) {
		return null;
	}
	public List<Cliente> pesquisarporId(int id) {
		return null;
	}
	public List<Cliente> pesquisarTodos(){
		return null;
	}
}
