package com.dnchamba.arqapp.adapter;

import com.dnchamba.arqapp.dominio.UsuarioCn;
import com.dnchamba.arqapp.rest.model.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dayana
 */
public class ConexionUsuario implements UsuarioCn{
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
    private static Connection con = null;
    private final String tabla = "usuario";
    public Connection  conexionBase(){          
        //Connection con = null;
        String sURL = "jdbc:mysql://localhost:3306/reserva_lab?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";      
        try {        
            con = DriverManager.getConnection(sURL, "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
    public static void cerrar() throws SQLException {
      if (con != null) {
         con.close();
      }
   }

    @Override
    public List<Usuario> getUsuarios() {
        List<Usuario> usuario = new ArrayList<>();
      try{          
         PreparedStatement consulta = conexionBase().prepareStatement("SELECT Id_usuario, cedula, nombres, usuario, constrasenia, tipo FROM " + this.tabla);
         ResultSet resultado = consulta.executeQuery();
         while(resultado.next()){
            usuario.add(new Usuario(resultado.getInt("Id_usuario"), resultado.getString("cedula"), resultado.getString("nombres"), resultado.getString("usuario"), resultado.getString("constrasenia"), resultado.getInt("tipo")));
         }
      }catch(SQLException ex){           
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionUsuario.class.getName()).log(Level.SEVERE, null, ex1);
            }
           
      }
        for (int i = 0; i < usuario.size(); i++) {
            System.out.println("usuario: "+ usuario.get(i).getCedula());
        }
      return usuario;    
    }

  
    
}
