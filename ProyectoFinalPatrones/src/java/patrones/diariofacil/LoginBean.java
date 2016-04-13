/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author miker.sb7
 */
@ManagedBean (name="Login", eager= true)
@RequestScoped
public class LoginBean {
    
    String email;
    String password;
    UsuarioTO userTO = new UsuarioTO();

    public LoginBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void verificar() throws Exception{
        Usuario user = new Cliente();
        //----------------------------
        user.setEmail(this.email);
        user.setEmail(this.email);
        //----------------------------
        
        
        
    }
    
    public void ingresar(){
        
    }
    
}
