package persistence;

import java.sql.SQLException;
import java.util.List;

public interface ICrud<T> {
	public void cadastrar(T t)throws ClassNotFoundException, SQLException;
	public void atualizar(T t)throws ClassNotFoundException, SQLException;
	public void excluir(T t)throws ClassNotFoundException, SQLException;
 	public T consultarUm(T t)throws ClassNotFoundException, SQLException;
	public List<T> buscarTudo(T t)throws ClassNotFoundException, SQLException;

}
