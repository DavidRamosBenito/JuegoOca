package org.vipsion.oca.modelo;

/**
 *<p>Representa una ficha que le es asignada a un jugador determinado.</p>
 * @author David
 */
public class Ficha {

    private int posicion;
    private int turnosExtra;
    private Boolean fin;
    

    
    /**
     *<p>Instancia e inicializa una ficha.</p>
     */
    public Ficha() {
        posicion = 1;
        fin = false;
        turnosExtra = 0;
    }
    
    
    /**
     *<p>Indica si la ficha ha llegado al fin del juego</p>
     * @return Devuelve <code>true or false</code> por defecto <code>false</code>
     */
    public Boolean getFin() {
        return fin;
    }

    /**
     *<p>Fija el valor de su propiedad fin.</p>
     * @param fin Es <code>true</code> en caso de haber llegado a la casilla final.
     */
    public void setFin(Boolean fin) {
        this.fin = fin;
    }

    

    /**
     *<p>Devuelve un entero con la posición de la instancia ficha.</p>
     * @return N&uacute;mero entero comprendido entre <code>1</code> y <code>63</code>
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     *<p>Fija el valor de la posición de la instancia ficha</p>
     * @param posicion valor relativo a la posición de la instancia, un entero.
     */
    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    /**
     * <p>Devuelve el valor de los turnos extra acumulados.</p>
     * @return turnosExtra es un valor entero que representa las tiradas extra.
     */
    public int getTurnosExtra() {
        return turnosExtra;
    }

    /**
     *<p>Fija el valor de turnos extra.</p>
     * @param turnosExtra Es un valor entero que representa el número de tiradas adicionales.
     */
    public void setTurnosExtra(int turnosExtra) {
        this.turnosExtra = turnosExtra;
    }

    /**
     *<p>En caso de tener turnos extra, con cada turno jugado se decrementaría este valor.</p>
     */
    public void decrementaTurnosExtra() {
        turnosExtra--;
    }

}
