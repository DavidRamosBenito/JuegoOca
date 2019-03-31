package org.vipsion.oca.modelo;

/**
 *<p>Representa al jugador</p>
 * @author David
 */
public class Jugador {

    private final Ficha ficha;
    private int ultimoValorDado;

    /**
     *<p>Instancia una ficha en su creación</p>
     * @see Ficha
     */
    public Jugador() {
        this.ficha = new Ficha();
    }

    /**
     * <p>Inicia una jugada pidiendo un valor al dado</p><br>
     * <p>Le pasa el valor obtenido del dado al tablero para que actualice su posición</p>
     * @param tablero instancia de tablero que sea utilizada para el juego.
     * @return Devuelve el valor entero de la posición de la ficha. Es la casilla la que fija este valor cuando una ficha se posa en ella.
     * @see Dado
     * @see Tablero#mueveFicha(org.vipsion.oca.modelo.Ficha, int) 
     * @see Ficha#getPosicion() 
     * @see Casilla#posaFicha(org.vipsion.oca.modelo.Ficha) 
     */
    public int juegaTurno(Tablero tablero) {
        ultimoValorDado = Dado.dameNumero();
        tablero.mueveFicha(ficha, ultimoValorDado);
        return ficha.getPosicion();
    }

    /**
     * <p>El valor devuelto por Dado después de iniciar juegaTurno()</p>
     * @return valor entero entre <code>1</code> y <code>6</code>
     * @see Dado#dameNumero() 
     */
    public int getUltimoValorDado() {
        return ultimoValorDado;
    }

    /**
     * <p>Fija el valor de la propiedad ultimoValorDado;</p>
     * @param ultimoValorDado parámetro que representa el entero obtenido por la tirada del dado.
     * @see Dado#dameNumero() 
     */
    public void setUltimoValorDado(int ultimoValorDado) {
        this.ultimoValorDado = ultimoValorDado;
    }

    /**
     * <p>Valor de la posición de la Ficha.</p>
     * @return Devuelve el valor de la posición de la ficha en el tablero
     * @see Ficha#getPosicion() 
     */
    public int getUltimaPosicionTablero() {
        return ficha.getPosicion();
    }

    /**
     * <p>Valor de turnos extra acumulados en ficha</p>
     * @return Devuelve el valor de la cantidad de turnos extra acumulados en ficha
     * @see Ficha#getTurnosExtra() 
     */
    public int getTurnosExtra() {
        return (ficha.getTurnosExtra());
    }

    /**
     * <p>Resta en caso de tenerlos, turnos extra en ficha. Lo controla Juego.</p>
     * @see Juego#sigTurno() 
     * @see Ficha#decrementaTurnosExtra() 
     */
    public void decrementaTurnosExtra() {
        ficha.decrementaTurnosExtra();
    }

    /**
     * <p>Determina si la ficha ha finalizado el juego</p>
     * @return <code>true or false</code> Si la ficha se ha posado en las casillas Fin u OcaFin o no.
     * @see Ficha#getFin() 
     * @see Fin#posaFicha(org.vipsion.oca.modelo.Ficha) 
     * @see OcaFin#posaFicha(org.vipsion.oca.modelo.Ficha) 
     */
    public Boolean esGanador() {
        return ficha.getFin();
    }
}
