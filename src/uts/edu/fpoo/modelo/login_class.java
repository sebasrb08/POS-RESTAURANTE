/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.fpoo.modelo;

import java.util.HashMap;
import uts.edu.fpoo.vista.login_frame;

/**
 *
 * @author Usuario
 */
public class login_class {
    private HashMap<String, String> usuarios = new HashMap<>();

    public login_class() {
        usuarios.put("admin", "1234");
        usuarios.put("mesero", "abcd");
        usuarios.put("mesero2", "2468");
    }

    public boolean validarUsuario(String usuario, String contrasena) {
        if (usuarios.containsKey(usuario)) {
            return usuarios.get(usuario).equals(contrasena);
        }
        return false;
    }
}
