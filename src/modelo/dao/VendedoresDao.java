package modelo.dao;

import modelo.entidades.Departamentos;
import modelo.entidades.Vendedores;

import java.util.List;

public interface VendedoresDao {
    void inserir(Vendedores obj);
    void atualizar(Vendedores obj);
    void deletar(Vendedores obj);
    Vendedores procuraPorId(Integer id);
    List<Vendedores> procurarPorTodosId();
    List<Vendedores> procurarDepartamentosPorId(Departamentos departamentos);
}
