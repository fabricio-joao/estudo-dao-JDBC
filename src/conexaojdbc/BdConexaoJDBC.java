package conexaojdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class BdConexaoJDBC {

    private static Connection conexao = null;

    public static Connection carregarConexao(){
        if(conexao == null){
            try{
                Properties props = carregarDadosConexao();
                String url = props.getProperty("bdurl");
                conexao = DriverManager.getConnection(url, props);
            }
            catch (SQLException e){
                throw new BdExcecao(e.getMessage());
            }
        }
        return conexao;
    }

    public static void fecharConexao(){
        if(conexao == null){
            try{
                conexao.close();
            }
            catch (SQLException e){
                throw new BdExcecao(e.getMessage());
            }
        }
    }

    //fecha conexao do metodo Statement; PreparedStatement..
    public static void fecharConexaoStatement(Statement st){
        if(st == null){
            try{
                st.close();
            }
            catch (SQLException e){
                throw new BdExcecao(e.getMessage());
            }
        }
    }

    //fecha conexao do metodo ResultSet...
    public static void fecharConexaoResultSet(ResultSet rs){
        if(rs == null){
            try{
                rs.close();
            }
            catch (SQLException e){
                throw new BdExcecao(e.getMessage());
            }
        }
    }
    private static Properties carregarDadosConexao(){
        try(FileInputStream fs = new FileInputStream("db.propriedades")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e){
            throw new BdExcecao(e.getMessage());
        }
    }
}
