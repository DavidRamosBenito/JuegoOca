package org.vipsion.oca.modelo;

/**
 *Representa una casilla del juego.
 * @author David
 */
public class Casilla {

    /**
     *Creación de la variable posición
     */
    protected int posicion;

    /**
     *Instancia una casilla con una posición.
     * @param posicion es el número de casilla que se le asigna a casilla.
     */
    public Casilla(int posicion) {
        this.posicion = posicion;
    }

    /**
     *Devuelve el valor de la posición de la instancia.
     * @return Devuelve un entero entre <code>1</code> y <code>63</code>
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     *<p>Asigna el valor de la posición de la instancia</p>
     * @param posicion Número entero del valor de la posición
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     *<p>Cuando es invocado por la instancia ficha se le asigna la posición de la casilla</p> 
     * @param ficha Representa la instancia ficha que se posa en esa casilla
     * @see Ficha#setPosicion(int) 
     */
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion);
     }

}
