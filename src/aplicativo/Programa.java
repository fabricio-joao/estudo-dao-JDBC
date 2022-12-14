package aplicativo;

import conexaojdbc.BdConexaoJDBC;
import modelo.dao.DepartamentosDao;
import modelo.dao.FabricaDao;
import modelo.dao.VendedoresDao;
import modelo.entidades.Departamentos;
import modelo.entidades.Vendedores;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Programa {
    public static void main(String[] args) throws ParseException {

        /*System.out.println("TESTE 1: INSERIR DEPARTAMENTOS");
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

        /*System.out.println("\nTESTE 5: PROCURAR TODOS DEPARTAMENTOS");
        DepartamentosDao depDao = FabricaDao.criarDepartamentoDao();
        List<Departamentos> departamentos = depDao.procurarPorTodosId();
        for (Departamentos dep: departamentos){
            System.out.println(dep);
        }*/

        /*System.out.println("TESTE 6: INSERIR VENDEDORES");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        VendedoresDao vdao = FabricaDao.criarVendedoresDao();
        Departamentos dep = new Departamentos(2, "Vestuario");
        Vendedores vendedores = new Vendedores( null,"rita Moraes", "km@gmail.com", new java.sql.Date(sdf.parse("14/12/2007").getTime()), 2500.0, dep);
        vdao.inserir(vendedores);
        System.out.println(vendedores);*/

        /*System.out.println("TESTE 7: ATUALIZAR VENDEDORES");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        VendedoresDao vdao = FabricaDao.criarVendedoresDao();
        Departamentos dep = new Departamentos(1, "Calçado");
        Vendedores vendedores = new Vendedores( 5,"Gilson Martins", "gm@gmail.com", new java.sql.Date(sdf.parse("05/05/1999").getTime()), 1500.0, dep);
        vdao.atualizar(vendedores);
        System.out.println(vendedores);*/

        /*System.out.println("TESTE 8: DELETAR VENDEDORES");
        VendedoresDao vdao = FabricaDao.criarVendedoresDao();
        Vendedores vendedores = new Vendedores();
        vendedores.setId(7);
        vdao.deletar(vendedores);
        System.out.println(vendedores);*/

        /*System.out.println("TESTE 9: PROCURAR VENDEDORES POR ID");
        VendedoresDao vdao = FabricaDao.criarVendedoresDao();
        Vendedores vendedores = vdao.procuraPorId(3);
        System.out.println(vendedores);*/

        System.out.println("TESTE 10: PROCURAR VENDEDORES POR ID DO DEPARTAMENTO");
        VendedoresDao vdao = FabricaDao.criarVendedoresDao();
        Departamentos departamentos = new Departamentos();
        departamentos.setId(3);
        List<Vendedores> lista = vdao.procurarDepartamentosPorId(departamentos);
        for(Vendedores v: lista){
            System.out.println(v);
        }

    }
}
