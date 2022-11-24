package aplicativo;

import conexaojdbc.BdConexaoJDBC;
import modelo.dao.DepartamentosDao;
import modelo.dao.FabricaDao;
import modelo.entidades.Departamentos;

import java.sql.Connection;
import java.util.List;

public class Programa {
    public static void main(String[] args) {

      /*  System.out.println("TESTE 1: INSERIR DEPARTAMENTOS");
        DepartamentosDao depDao = FabricaDao.criarDepartamentoDao();
        Departamentos dep = new Departamentos(4, "Acessórios");
        depDao.inserir(dep);
        System.out.println(dep);*/

      /*  System.out.println("\nTESTE 2: ATUALIZAR DEPARTAMENTOS");
        DepartamentosDao depDao = FabricaDao.criarDepartamentoDao();
        Departamentos dep = new Departamentos(4, "Acessórios");
        depDao.atualizar(dep);
        System.out.println(dep);*/

       /* System.out.println("\nTESTE 3: DELETAR DEPARTAMENTOS");
        DepartamentosDao depDao = FabricaDao.criarDepartamentoDao();
        Departamentos dep = new Departamentos();
        dep.setId(4);
        depDao.deletar(dep);
        System.out.println(dep);*/

        /*System.out.println("\nTESTE 4: PROCURAR DEPARTAMENTOS POR ID");
        DepartamentosDao depDao = FabricaDao.criarDepartamentoDao();
        Departamentos dep = depDao.procuraPorId(2);
        System.out.println(dep);*/

        System.out.println("\nTESTE 4: PROCURAR TODOS DEPARTAMENTOS POR ID");
        DepartamentosDao depDao = FabricaDao.criarDepartamentoDao();
        List<Departamentos> departamentos = depDao.procurarPorTodosId();
        for (Departamentos dep: departamentos){
            System.out.println(dep);
        }
    }
}
