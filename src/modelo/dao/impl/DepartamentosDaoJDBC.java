package modelo.dao.impl;

import conexaojdbc.BdConexaoJDBC;
import conexaojdbc.BdExcecao;
import modelo.dao.DepartamentosDao;
import modelo.entidades.Departamentos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentosDaoJDBC implements DepartamentosDao {

    private Connection conexao;

    public DepartamentosDaoJDBC(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Departamentos obj) {
        PreparedStatement ps = null;

        try{
            ps = conexao.prepareStatement(
                    "INSERT INTO Departamentos "
                            +"(ID, Setor) "
                            +"VALUES "
                            +"(?,?)");
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getSetor());

            int linha = ps.executeUpdate();
            System.out.println("Total de linhas alterada(s): " + linha);
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
    public void atualizar(Departamentos obj) {

        PreparedStatement ps = null;

        try{
            ps = conexao.prepareStatement(
                    "update Departamentos "
                            +"set Setor = ? "
                            +"where Id = ? ");
            ps.setString(1, obj.getSetor());
            ps.setInt(2, obj.getId());
            int linha = ps.executeUpdate();
            System.out.println("Total de linhas alterada(s): " + linha);
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
    public void deletar(Departamentos obj) {
        PreparedStatement ps = null;
        try{
            ps = conexao.prepareStatement(
                    "delete from Departamentos "
                            +"where "
                            +"Id = ? ");
            ps.setInt(1, obj.getId());
            int linha = ps.executeUpdate();
            System.out.println("Total de linhas alterada(s): " + linha);
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
    public Departamentos procuraPorId(Integer id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conexao.prepareStatement(
                    "select * from Departamentos "
                            +"WHERE Id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()){
                Departamentos departamentos = new Departamentos();
                departamentos.setId(rs.getInt("Id"));
                departamentos.setSetor(rs.getString("Setor"));
                return departamentos;
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
    public List<Departamentos> procurarPorTodosId() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
             ps = conexao.prepareStatement(
                "select * from Departamentos ");

            rs = ps.executeQuery();

            List<Departamentos> lista = new ArrayList<>();
        while(rs.next()){
            Departamentos departamentos = new Departamentos();
            departamentos.setId(rs.getInt("Id"));
            departamentos.setSetor(rs.getString("Setor"));
            lista.add(departamentos);
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
