package controll;

import model.ProdutoEntity;
import persistence.ProdutoDao;
import persistence.GenericDao;
import java.util.List;
import java.sql.SQLException;

public class ProdutoControl {
	public void cadastrarProduto(ProdutoEntity produto) throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		ProdutoDao cDao = new ProdutoDao(gDao);
		
		cDao.cadastrar(produto);
	}
	public void alterarProduto(ProdutoEntity produto)throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		ProdutoDao cDao = new ProdutoDao(gDao);
		
		cDao.atualizar(produto);
	}
	public List<ProdutoEntity> listarProduto()throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		ProdutoDao cDao = new ProdutoDao(gDao);
		ProdutoEntity produto = new ProdutoEntity();
		List<ProdutoEntity> listaProduto = cDao.buscarTudo(produto);		

		return listaProduto;
	}
	public ProdutoEntity buscarProduto(int codigo)throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		ProdutoDao cDao = new ProdutoDao(gDao);
		ProdutoEntity produto = new ProdutoEntity();
		produto.setCodigoProduto(codigo);
		
		return cDao.consultarUm(produto);
		
	}
}
