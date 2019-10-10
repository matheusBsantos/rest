
package br.rev.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoDB {
    
    private static String url="jdbc:mysql://localhost:3306/restaurante";
    private static String usu="root";
    private static String senha="";
    private static Connection con;
    
    public static Connection abrirConexao(){
        
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            con= DriverManager.getConnection(url, usu, senha);
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
}
