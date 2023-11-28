package fatec.sp.gov.br.sistemaescolarbackend.resources.connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class MysqlConnection {
    public Connection connectDb(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/projeto_integrador?user=admin&password=Admin12345678";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        MysqlConnection mysqlConnection = new MysqlConnection();
        Connection connection = mysqlConnection.connectDb();

        if (connection != null) {
            System.out.println("Conexão estabelecida com sucesso!");
            // Faça algo com a conexão, se necessário
        } else {
            System.out.println("Falha ao estabelecer a conexão.");
        }
    }
}
