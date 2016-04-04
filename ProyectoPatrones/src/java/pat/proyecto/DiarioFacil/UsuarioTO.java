/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

import java.io.Serializable;
import java.util.List;
import pat.proyecto.DiarioFacil.ServicioUsuario;
import pat.proyecto.DiarioFacil.Usuario;
import pat.proyecto.DiarioFacil.Usuario;

/**
 *
 * @author laboratorio
 */
public class UsuarioTO implements Serializable {

    private ServicioUsuario servicio = new ServicioUsuario();
    
    public UsuarioTO() {
    }
    
    public void insertar(Usuario persona) throws Exception {
        servicio.insertar(persona);
    }
    
    public void update(Usuario persona) throws Exception {
        servicio.Update(persona);
    }
    
    public void delete(Usuario persona) throws Exception {
        servicio.Delete(persona);
    }
    
    public List<Usuario> buscaTodos() throws Exception {
        return servicio.buscaTodos();
    }
}
