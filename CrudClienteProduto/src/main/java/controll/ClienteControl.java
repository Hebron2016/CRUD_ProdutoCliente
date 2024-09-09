package controll;

import model.ClienteEntity;
import java.sql.SQLException;
import persistence.ClienteDao;
import persistence.GenericDao;
import java.util.List;

public class ClienteControl {
	public void cadastrarCliente(ClienteEntity cliente) throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		ClienteDao cDao = new ClienteDao(gDao);
		
		cDao.cadastrar(cliente);
	}
	public void alterarCliente(ClienteEntity cliente)throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		ClienteDao cDao = new ClienteDao(gDao);
		
		cDao.atualizar(cliente);
	}
	public List<ClienteEntity> listarCliente()throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		ClienteDao cDao = new ClienteDao(gDao);
		ClienteEntity cliente = new ClienteEntity();
		List<ClienteEntity> listaCliente = cDao.buscarTudo(cliente);		

		return listaCliente;
	}
	public ClienteEntity buscarCliente(int codigo)throws ClassNotFoundException, SQLException{
		GenericDao gDao = new GenericDao();
		ClienteDao cDao = new ClienteDao(gDao);
		ClienteEntity cliente = new ClienteEntity();
		cliente.setCodigoCliente(codigo);
		
		return cDao.consultarUm(cliente);
		
	}
}
