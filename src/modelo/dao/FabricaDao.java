package modelo.dao;

import conexaojdbc.BdConexaoJDBC;
import modelo.dao.impl.DepartamentosDaoJDBC;
import modelo.dao.impl.VendedoresDaoJDBC;

public class FabricaDao {
    public static VendedoresDao criarVendedoresDao() {
        return new VendedoresDaoJDBC(BdConexaoJDBC.carregarConexao());
    }

    public static DepartamentosDao criarDepartamentoDao() {
        return new DepartamentosDaoJDBC(BdConexaoJDBC.carregarConexao());
    }
}
