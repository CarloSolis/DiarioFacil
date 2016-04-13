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
@ManagedBean (name = "Signup", eager =  true)
@RequestScoped
public class SignupBean {
 
    String name;
    String lastname;
    String email;
    String password;
    int phone;
    String type;
    UsuarioTO userTO = new UsuarioTO();

    public SignupBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public void register() throws Exception{
        Usuario user = new Cliente();
        //---------------------------------
        user.setName(this.name);
        //((Cliente)user).setLastName(this.lastname);
        user.setEmail(this.email);
        user.setPassword(this.password);
        user.setPhone(this.phone);
        user.setTipo(this.type);
        //---------------------------------
        userTO.insertar(user);
    }
    
    
}
