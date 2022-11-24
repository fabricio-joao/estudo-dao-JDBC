package modelo.dao.impl;

import modelo.dao.VendedoresDao;
import modelo.entidades.Departamentos;
import modelo.entidades.Vendedores;

import java.sql.Connection;
import java.util.List;

public class VendedoresDaoJDBC implements VendedoresDao {

    private Connection conexao;

    public VendedoresDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Vendedores obj) {

    }

    @Override
    public void atualizar(Vendedores obj) {

    }

    @Override
    public void deletar(Vendedores obj) {

    }

    @Override
    public Vendedores procuraPorId(Integer id) {
        return null;
    }

    @Override
    public List<Vendedores> procurarPorTodosId() {
        return null;
    }

    @Override
    public List<Vendedores> procurarDepartamentosPorId(Departamentos departamentos) {
        return null;
    }
}
