package org.vipsion.oca.modelo;

/**
 * <p>Tipo de Casilla que representa las Ocas</p>
 * @author David
 * @see Casilla
 */
public class Oca extends Casilla {

    private final int desplazamiento;
    private final int turnosExtra;

    /**
     * <p>Instancia de la Casilla Oca con su posición y desplazamiento determinado</p>
     * <p>Se le añade un turno extra.</p>
     * @param posicion es el número de casilla que se le asigna a casilla.
     * @param desplazamiento El valor ha de ser el que haga que su desplazamiento le posicione en la siguiente Casilla Oca
     */
    public Oca(int posicion, int desplazamiento) {
        super(posicion);
        this.desplazamiento = desplazamiento;
        this.turnosExtra = 1;
    }

    /**
     * <p>{@inheritDoc }</p>
     * <p>Se le añade un turno extra a la instancia ficha.</p>
     * @param ficha {@inheritDoc}
     * @see Ficha#setPosicion(int) 
     * @see Ficha#setTurnosExtra(int) 
     */
    
    
    
    @Override
    public void posaFicha(Ficha ficha) {
        ficha.setPosicion(posicion + desplazamiento);
        ficha.setTurnosExtra(turnosExtra);
    }
}
