package org.vipsion.oca.modelo;

/**
 * <p>Representa un dado de 6 valores</p>
 * @author David
 */
public class Dado {

    /**
     *<p>Genera un número aleatorio</p>
     * @return <code>[1-6]</code>
     */
    static public int dameNumero() {
        return (int) (Math.random() * 6) + 1;
    }
}
