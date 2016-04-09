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

    protected int id;
    protected String name;
    protected int phone;
    protected String email;
    protected String password;
    protected String tipo;

    public Usuario() {
    }

    public Usuario(int id, String name, String email, String password, String tipo, int phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Memento saveToMemento() {

        System.err.println("Guardando Memento....");
        return new Memento(name);
    }

    public void restoreFromMemento(Memento m) {
        name = m.getEstado();
    }

}
