package org.vipsion.oca.modelo;

/**
 *<p>Representa una casilla que indica el final del juego.</p>
 *<p>Hereda de la Clase Casilla</p>
 * @author David
 * @see Casilla
 */
public class Fin extends Casilla {

    /**
     *<p>Instancia una casilla</p>
     * @param posicion es el número de casilla que se le asigna a casilla.
     */
    public Fin(int posicion) {
        super(posicion);
    }

    /**
     *<p>Método heredado</p>
     *<p>Fija la propiedad fin de la ficha a <code>true</code></p> 
     * @param ficha {@inheritDoc}
     * @see Ficha#setFin(java.lang.Boolean) 
     */
    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setFin(true);
    }
}
