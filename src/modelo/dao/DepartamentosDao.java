package modelo.dao;

import conexaojdbc.BdConexaoJDBC;
import modelo.entidades.Departamentos;

import java.util.List;

public interface DepartamentosDao {
    void inserir(Departamentos obj);
    void atualizar(Departamentos obj);
    void deletar(Departamentos obj);
    Departamentos procuraPorId(Integer id);
    List<Departamentos> procurarPorTodosId();

}
