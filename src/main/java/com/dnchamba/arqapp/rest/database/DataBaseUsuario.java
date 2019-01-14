/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.database;

import com.dnchamba.arqapp.adapter.ConexionUsuario;
import com.dnchamba.arqapp.rest.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dayana
 */
public class DataBaseUsuario {
        static ConexionUsuario conUs;    
    public static List<Usuario> getUsuario(){        
        return conUs.getUsuarios();
    }
}
