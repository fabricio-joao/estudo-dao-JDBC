package aplicativo;

import conexaojdbc.BdConexaoJDBC;
import modelo.dao.DepartamentosDao;
import modelo.dao.FabricaDao;
import modelo.entidades.Departamentos;

import java.sql.Connection;

public class Programa {
    public static void main(String[] args) {

        System.out.println("TESTE 1: INSERIR DEPARTAMENTOS");
        DepartamentosDao depDao = FabricaDao.criarDepartamentoDao();
        Departamentos dep = new Departamentos(2, "Vestuarios");
        depDao.inserir(dep);
        System.out.println(dep);
    }
}
