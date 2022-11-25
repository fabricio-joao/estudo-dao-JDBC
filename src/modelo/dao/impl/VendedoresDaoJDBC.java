package modelo.dao.impl;

import conexaojdbc.BdConexaoJDBC;
import conexaojdbc.BdExcecao;

import modelo.dao.VendedoresDao;
import modelo.entidades.Departamentos;
import modelo.entidades.Vendedores;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendedoresDaoJDBC implements VendedoresDao {

    private Connection conexao;

    public VendedoresDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Vendedores obj) {
        PreparedStatement ps = null;
        try{
            ps = conexao.prepareStatement(
                    "INSERT INTO Vendedores "
                            +"(Nome, Email, Nascimento, Salario, DepartamentoId) "
                            +"VALUES "
                            +"(?,?,?,?,?)");
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setDate(3, obj.getNascimento());
            ps.setDouble(4, obj.getSalario());
            ps.setInt(5, obj.getDepartamentos().getId());

            int linha = ps.executeUpdate();
            System.out.println("Total de linhas alteradas: " + linha);
        }
        catch (SQLException e){
            throw new BdExcecao(e.getMessage());
        }
        finally {
            BdConexaoJDBC.fecharConexaoStatement(ps);
            BdConexaoJDBC.fecharConexao();
        }
    }

    @Override
    public void atualizar(Vendedores obj) {
        PreparedStatement ps = null;
        try{
            ps = conexao.prepareStatement(
                    "update Vendedores "
                            +"set Nome = ?, Email = ?, Nascimento = ?, Salario = ?, DepartamentoId = ? "
                            +"where Id = ?	");

            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getEmail());
            ps.setDate(3, obj.getNascimento());
            ps.setDouble(4, obj.getSalario());
            ps.setInt(5, obj.getDepartamentos().getId());
            ps.setInt(6, obj.getId());

            int linha = ps.executeUpdate();
            System.out.println("Total de linhas alteradas: " + linha);
        }
        catch (SQLException e){
            throw new BdExcecao(e.getMessage());
        }
        finally {
            BdConexaoJDBC.fecharConexaoStatement(ps);
            BdConexaoJDBC.fecharConexao();
        }
    }

    @Override
    public void deletar(Vendedores obj) {
        PreparedStatement ps = null;
        try{
            ps = conexao.prepareStatement(
                    "delete from Vendedores "
                    +"where Id = ? ");

            ps.setInt(1, obj.getId());

            int linha = ps.executeUpdate();
            System.out.println("Total de linhas alteradas: " + linha);
        }
        catch (SQLException e){
            throw new BdExcecao(e.getMessage());
        }
        finally {
            BdConexaoJDBC.fecharConexaoStatement(ps);
            BdConexaoJDBC.fecharConexao();
        }
    }

    @Override
    public Vendedores procuraPorId(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
              ps = conexao.prepareStatement(
                      "SELECT Vendedores.*,Departamentos.Setor as DepSetor "
                              +"FROM Vendedores INNER JOIN Departamentos "
                              +"ON Vendedores.DepartamentoId = Departamentos.Id "
                              +"WHERE Vendedores.id = ? ");
              ps.setInt(1, id);
              rs = ps.executeQuery();
              if(rs.next()){
                  Departamentos dep = new Departamentos();
                  dep.setId(rs.getInt("DepartamentoId"));
                  dep.setSetor(rs.getString("DepSetor"));

                  Vendedores obj = new Vendedores();
                  obj.setId(rs.getInt("id"));
                  obj.setNome(rs.getString("Nome"));
                  obj.setEmail(rs.getString("Email"));
                  obj.setNascimento(rs.getDate("Nascimento"));
                  obj.setSalario(rs.getDouble("Salario"));
                  obj.setDepartamentos(dep);
                  return obj;
              }
              return null;
        }
        catch (SQLException e){
            throw new BdExcecao(e.getMessage());
        }
        finally {
            BdConexaoJDBC.fecharConexaoStatement(ps);
            BdConexaoJDBC.fecharConexaoResultSet(rs);
            BdConexaoJDBC.fecharConexao();
        }
    }

    @Override
    public List<Vendedores> procurarPorTodosId() {
        return null;
    }

    @Override
    public List<Vendedores> procurarDepartamentosPorId(Departamentos departamentos) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexao.prepareStatement(
                    "select Vendedores.*,Departamentos.Setor as DepSetor "
                            +"from Vendedores INNER JOIN Departamentos "
                            +"on Vendedores.DepartamentoId = Departamentos.Id "
                            +"where DepartamentoId = ? "
                            +"ORDER BY Nome ");
            ps.setInt(1, departamentos.getId());
            rs = ps.executeQuery();

            List<Vendedores> lista = new ArrayList<>();
            Map<Integer, Departamentos> map = new HashMap<>();
            while (rs.next()){
                Departamentos dep = map.get(rs.getInt("DepartamentoId"));
                if(dep == null){
                    dep = new Departamentos();
                    dep.setId(rs.getInt("DepartamentoId"));
                    dep.setSetor(rs.getString("DepSetor"));
                    map.put(rs.getInt("DepartamentoId"), dep);
                }

                Vendedores obj = new Vendedores();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("Nome"));
                obj.setEmail(rs.getString("Email"));
                obj.setNascimento(rs.getDate("Nascimento"));
                obj.setSalario(rs.getDouble("Salario"));
                obj.setDepartamentos(dep);
                lista.add(obj);
            }
            return lista;
        }
        catch (SQLException e){
            throw new BdExcecao(e.getMessage());
        }
        finally {
            BdConexaoJDBC.fecharConexaoStatement(ps);
            BdConexaoJDBC.fecharConexaoResultSet(rs);
            BdConexaoJDBC.fecharConexao();
        }

    }
}
