package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProdutoEntity;

public class ProdutoDao implements ICrud<ProdutoEntity> {
	private GenericDao gDao;
	
	public ProdutoDao(GenericDao gDao) {
		this.gDao = gDao;
	}
	
	@Override
	public void cadastrar(ProdutoEntity produto)throws ClassNotFoundException, SQLException{
		Connection c = gDao.getConnection();
		String sql = "INSERT INTO Produto (codigo, nome, valor) VALUES (?,?,?)";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, produto.getCodigoProduto());
		ps.setString(2, produto.getNomeProduto());
		ps.setDouble(3, produto.getVlrProduto());
		
		ps.execute();
		ps.close();
		c.close();
	}
	
	@Override
	public void atualizar(ProdutoEntity produto)throws ClassNotFoundException, SQLException{
		Connection c = gDao.getConnection();
		String sql = "";
		PreparedStatement ps = null;

		if(produto.getNomeProduto() != null) {
			sql = "UPDATE Produto SET nome=? valor=? WHERE id =?";
			ps = c.prepareStatement(sql);
			ps.setString(1, produto.getNomeProduto());
			ps.setDouble(2, produto.getVlrProduto());
			ps.setInt(2, produto.getCodigoProduto());
			
			ps.execute();
		}
	}
	
	@Override
	public void excluir(ProdutoEntity produto)throws ClassNotFoundException, SQLException{
		Connection c = gDao.getConnection();
		String sql = "DELETE FROOM Produto WHERE id=?";
	
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, produto.getCodigoProduto());
		ps.execute();
		ps.close();
		c.close();
	}
	
	@Override
 	public ProdutoEntity consultarUm(ProdutoEntity produto)throws ClassNotFoundException, SQLException{
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM Produto WHERE id = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, produto.getCodigoProduto());
		
		ResultSet rs = ps.executeQuery();
		ProdutoEntity cProduto = null;
		if(rs.next()) {
			cProduto = new ProdutoEntity();
			cProduto.setCodigoProduto(rs.getInt("codigo"));
			cProduto.setNomeProduto(rs.getString("nome"));
		}
		rs.close();
		ps.close();
		c.close();
		
		return cProduto;
		}
	
	@Override
	public List<ProdutoEntity> buscarTudo(ProdutoEntity produto) throws ClassNotFoundException, SQLException{
		List<ProdutoEntity> produtos = new ArrayList<>();
		Connection c = gDao.getConnection();
		String sql = "SELECT * FROM Produto";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			ProdutoEntity clProduto = new ProdutoEntity();
			clProduto.setCodigoProduto(rs.getInt("codigo"));
			clProduto.setNomeProduto(rs.getString("nome"));
			produtos.add(clProduto);
		}
		rs.close();
		ps.close();
		c.close();
		
		return produtos;
	}
}

