/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

import java.util.List;
import pat.proyecto.DiarioFacil.Usuario;

/**
 *
 * @author Cali
 */
public interface IUsuarioDAO {

    public Usuario create(long Id, String nombre) throws Exception;

    public void delete(long Id) throws Exception;

    public void update(long Id, Usuario model) throws Exception;

    public Usuario[] findByName(String nombre) throws Exception;

    public Usuario findById(long Id) throws Exception;
}
