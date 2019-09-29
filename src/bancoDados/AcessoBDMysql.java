package bancoDados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class AcessoBDMysql {

    public Connection getConnection(){
        try{
        	Class.forName("com.mysql.jdbc.Driver");
            String Servidor ="jdbc:mysql://localhost:3307/projetoweb";
            String user = "root";
            String senha = "usbw";
            return DriverManager.getConnection(Servidor,user,senha);
        }catch(SQLException | ClassNotFoundException ex){
        	System.out.println("ERRO"+ex.toString());
            throw new RuntimeException(ex);
        }
    }
}
