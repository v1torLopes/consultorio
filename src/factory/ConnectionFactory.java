
package factory;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author Vitor
 */
public class ConnectionFactory {
    
    private static final String USERNAME = "root";
    
    private static final String PASSWORD = "";
    
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bancodyv";

    /*
    Conexao com o banco de dados
    */
    
    public static Connection getConnection() throws Exception {
        //Faz com que a classe seja carregada pela JVM 
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //Criar conexão com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        
        return connection;
    }
 
}
