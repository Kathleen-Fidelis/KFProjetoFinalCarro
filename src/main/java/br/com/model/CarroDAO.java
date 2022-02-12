package br.com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroDAO {

	public CarroDAO() {

	}
	
	public void inserir(Carro carro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into carro (modelo, ano) values (?, ?)");
			p.setString(1, carro.getModelo());
			p.setInt(2, carro.getAno());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Carro> consultar(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		List<Carro> carros = new ArrayList<Carro>();
		
		try {
			PreparedStatement p = con.prepareStatement("select * from carro");
			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				int id = r.getInt("id");
				String modelo = r.getString("modelo");
				Integer ano = r.getInt("ano");
				Carro carro = new Carro(modelo, ano);
				carro.setId(id);
				carros.add(carro);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carros;
	}
	
	public void deletar(int id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from carro where id = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Carro carro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update carro set modelo = ?, ano = ? where id = ?");
			p.setString(1, carro.getModelo());
			p.setInt(2, carro.getAno());
			p.setInt(3, carro.getId());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Carro consultarCarro(int id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Carro carro = null;
		
		try {
			PreparedStatement p = con.prepareStatement("select * from carro where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();	
			
			while (r.next()) {
				String modelo = r.getString("modelo");
				Integer ano = r.getInt("ano");
				carro = new Carro(modelo, ano);
				carro.setId(id);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carro;
	}
	
//------------------------------------------------------IPVA--------------------------------------------------------------
	public void inserirIPVA(IPVA ipva) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into ipva (ano) values (?)");
			p.setInt(1, ipva.getAno());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<IPVA> IPVAconsultar(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		List<IPVA> listaIpva = new ArrayList<IPVA>();
		
		try {
			PreparedStatement p = con.prepareStatement("select * from ipva");
			ResultSet r = p.executeQuery();
			
			while (r.next()) {
				int id = r.getInt("id");
				Integer ano = r.getInt("ano");
				IPVA ipva = new IPVA(ano);
				ipva.setId(id);
				listaIpva.add(ipva);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(listaIpva);
		}
		return listaIpva;
		
	}
	
	public void deletarIPVA(int id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from ipva where id = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarIPVA(IPVA ipva) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update ipva set ano = ? where id = ?");
			p.setInt(1, ipva.getAno());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public IPVA consultarIPVA(int id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		IPVA ipva = null;
		
		try {
			PreparedStatement p = con.prepareStatement("select * from ipva where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();	
			
			while (r.next()) {
				Integer ano = r.getInt("ano");
				ipva = new IPVA(ano);
				ipva.setId(id);
			}
			r.close();
			p.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ipva;
	}
}
