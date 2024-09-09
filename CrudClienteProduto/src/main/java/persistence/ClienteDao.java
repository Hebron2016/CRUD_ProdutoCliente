package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ClienteEntity;

public class ClienteDao implements ICrud<ClienteEntity> {
	private GenericDao gDao;
	
	public ClienteDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public void cadastrar(ClienteEntity cliente)throws ClassNotFoundException, SQLException{
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO Cliente (codigo, nome) VALUES (?,?)";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cliente.getCodigoCliente());
		ps.setString(1, cliente.getNomeCliente());
		
		ps.execute();
		ps.close();
		c.close();
	}
	
	@Override
	public void atualizar(ClienteEntity cliente)throws ClassNotFoundException, SQLException{
		Connection c = gDao.getConnection();
		String sql = "";
		PreparedStatement ps = null;

		if(cliente.getNomeCliente() != null) {
			sql = "UPDATE Cliente SET nome=? WHERE id =?";
			ps = c.prepareStatement(sql);
			ps.setString(1, cliente.getNomeCliente());
			ps.setInt(2, cliente.getCodigoCliente());
			ps.execute();
		}
	}
	
	@Override
	public void excluir(ClienteEntity cliente)throws ClassNotFoundException, SQLException{
		Connection c = gDao.getConnection();
		String sql = "DELETE FROOM Cliente WHERE id=?";
	
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cliente.getCodigoCliente());
		ps.execute();
		ps.close();
		c.close();
	}
	
	@Override
 	public ClienteEntity consultarUm(ClienteEntity cliente)throws ClassNotFoundException, SQLException{
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM Cliente WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, cliente.getCodigoCliente());
		
		ResultSet rs = ps.executeQuery();
		ClienteEntity cCliente = null;
		if(rs.next()) {
			cCliente = new ClienteEntity();
			cCliente.setCodigoCliente(rs.getInt("codigo"));
			cCliente.setNomeCliente(rs.getString("nome"));
		}
		rs.close();
		ps.close();
		c.close();
		
		return cCliente;
		}
	
	@Override
	public List<ClienteEntity> buscarTudo(ClienteEntity cliente) throws ClassNotFoundException, SQLException{
		List<ClienteEntity> clientes = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM Cliente";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			ClienteEntity clCliente = new ClienteEntity();
			clCliente.setCodigoCliente(rs.getInt("codigo"));
			clCliente.setNomeCliente(rs.getString("nome"));
			clientes.add(clCliente);
		}
		rs.close();
		ps.close();
		c.close();
		
		return clientes;
	}
}
