package aplicativo;

import conexaojdbc.BdConexaoJDBC;

import java.sql.Connection;

public class Programa {
    public static void main(String[] args) {

        Connection conexao = BdConexaoJDBC.carregarConexao();
        BdConexaoJDBC.fecharConexao();
    }
}
