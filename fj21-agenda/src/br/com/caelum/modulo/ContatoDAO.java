package br.com.caelum.modulo;

import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import java.sql.*;


public class ContatoDAO {

	private java.sql.Connection connection;
	
	
	
	public ContatoDAO() {

		this.connection = new ConnectionFactory().getConnection();

	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos"+" (nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			System.out.println("ate aqui eu vim...");
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date (contato.getDataNascimento().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		
		} catch (SQLException e) {
			System.out.println("pifou!");
			e.printStackTrace();
			throw  new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//usado para fechar sempre a conexão
		}
		
	}

	public ArrayList<Contato> getLista (){
		try {
			ArrayList<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()){
				Contato cnt = new Contato();
				cnt.setId(rs.getLong("id"));
				cnt.setNome(rs.getString("nome"));
				cnt.setEmail(rs.getString("email"));
				cnt.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				cnt.setDataNascimento(data);
				
				contatos.add(cnt);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			System.out.println("pifou!");
			e.printStackTrace();
			throw  new RuntimeException(e);
		} finally {
			//usado para fechar sempre a conexão
		}
	}

	public void altera (Contato contato){
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("pifou!");
			e.printStackTrace();
			throw  new RuntimeException(e);
		} finally {
			//usado para fechar sempre a conexão
		}
	}
	
	public void remove (Contato contato){
		String sql = "delete from contatos where id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("pifou!");
			e.printStackTrace();
			throw  new RuntimeException(e);
		} finally {
			//usado para fechar sempre a conexão
		}
	}
}
