/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

/**
 *
 * @author Cali
 */
public class Usuario {

    
    protected String name;
    protected int phone;
    protected String email;
    protected String password;
    protected String tipo;

    public Usuario() {
    }

    public Usuario( String name, int phone, String email, String password, String tipo) {
       
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

}
