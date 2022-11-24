package modelo.dao.impl;

import modelo.dao.DepartamentosDao;
import modelo.entidades.Departamentos;

import java.sql.Connection;
import java.util.List;

public class DepartamentosDaoJDBC implements DepartamentosDao {

    private Connection conexao;

    public DepartamentosDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Departamentos obj) {

    }

    @Override
    public void atualizar(Departamentos obj) {

    }

    @Override
    public void deletar(Departamentos obj) {

    }

    @Override
    public Departamentos procuraPorId(Integer id) {
        return null;
    }

    @Override
    public List<Departamentos> procurarPorTodosId() {
        return null;
    }
}
