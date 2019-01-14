package com.dnchamba.arqapp.rest.dao;
import com.dnchamba.arqapp.rest.database.DataBaseUsuario;
import com.dnchamba.arqapp.rest.model.Usuario;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author Dayana
 */
public class UsuarioDAO {
    private static List<Usuario> usuario= DataBaseUsuario.getUsuario();
    
    public List<Usuario> getProducts(){
        return usuario;
    } 
}
