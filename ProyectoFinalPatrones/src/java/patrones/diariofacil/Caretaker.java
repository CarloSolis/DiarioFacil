/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.util.ArrayList;

/**
 *
 * @author Cali
 */
public class Caretaker {

    private ArrayList<Memento> estados = new ArrayList<Memento>();

    public void addMemento(Memento m) {
        estados.add(m);
    }

    public Memento getMemento(int index) {
        return estados.get(index);
    }

}
