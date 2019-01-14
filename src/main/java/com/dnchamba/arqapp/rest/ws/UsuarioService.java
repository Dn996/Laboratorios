package com.dnchamba.arqapp.rest.ws;
import com.dnchamba.arqapp.rest.dao.UsuarioDAO;
import com.dnchamba.arqapp.rest.model.Usuario;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dayana
 */
@Path("usuario")
public class UsuarioService {
    private static UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public UsuarioService() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getAllUsuarios(){
        return usuarioDAO.getProducts();
    }
    
}
