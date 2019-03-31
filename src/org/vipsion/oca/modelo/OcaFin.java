package org.vipsion.oca.modelo;

/**
 * <p>Representa la Casilla última de Oca</p>
 * @author David
 */
public class OcaFin extends Casilla {

    private final int desplazamiento;

    /**
     * <p>Instancia la Casilla OcaFin  con su posición y desplazamiento determinado</p>
     * @param posicion es el número de casilla que se le asigna a casilla.
     * @param desplazamiento El valor ha de ser el que haga que su desplazamiento le posicione en la Casilla fin
     * @see Fin
     */
    public OcaFin(int posicion, int desplazamiento) {
        super(posicion);
        this.desplazamiento = desplazamiento;
    }

    /**
     * <p>{@inheritDoc}</p>
     * @param ficha {@inheritDoc}
     * @see Ficha#setPosicion(int) 
     * @see Ficha#setFin(java.lang.Boolean) 
     */
    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion + desplazamiento);
        ficha.setFin(true);
    }
}
