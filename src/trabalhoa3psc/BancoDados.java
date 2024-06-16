package trabalhoa3psc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe responsável pela conexão com o banco de dados SQLite e criação de
 * tabelas.
 */
public class BancoDados {

    private static final String URL = "jdbc:sqlite:loja.db";

    /**
     * Conecta ao banco de dados SQLite.
     *
     * @return a conexão com o banco de dados ou null se a conexão falhar
     */
    public static Connection conectar() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL);
            System.out.println("Conexão com o banco de dados estabelecida.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conexao;
    }

    /**
     * Cria um novo banco de dados SQLite. Se o banco de dados já existir,
     * apenas estabelece uma conexão com ele.
     */
    public static void criarNovoBanco() {
        try (Connection conexao = conectar()) {
            if (conexao != null) {
                DatabaseMetaData meta = conexao.getMetaData();
                System.out.println("O driver do banco de dados é " + meta.getDriverName());
                System.out.println("Um novo banco de dados foi criado.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Cria as tabelas necessárias no banco de dados. A tabela 'produtos' será
     * criada se não existir.
     */
    public static void criarTabelas() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (\n"
                + "    id integer PRIMARY KEY,\n"
                + "    nome text NOT NULL,\n"
                + "    codigo text NOT NULL,\n"
                + "    preco real,\n"
                + "    quantidade integer,\n"
                + "    tipo text\n"
                + ");";

        try (Connection conexao = conectar();
                Statement stmt = conexao.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela 'produtos' criada ou já existe.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
