/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

/**
 *
 * @author Jordan
 */
public class Exceptions extends Exception {

    /**
     * Creates a new instance of <code>Exceptions</code> without detail message.
     */
    public Exceptions() {
    }

    /**
     * Constructs an instance of <code>Exceptions</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public Exceptions(String msg) {
        super(msg);
    }
}
