/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vipsion.oca.modelo;

/**
 *
 * @author David
 */
public class CasillaDado extends Casilla{
    
    private int turnoextra;
    public CasillaDado(int posicion) {
        super(posicion);
    }
    //Modificacion para ejercicio git
    @Override
    public void posaFicha(Ficha ficha) {
        turnoextra=1;
        ficha.setTurnosExtra(turnoextra);
    }
}
