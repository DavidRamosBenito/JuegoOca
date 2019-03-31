package org.vipsion.oca.modelo;

import java.util.ArrayList;
import java.util.List;
import org.vipsion.oca.controlador.Coordinador;

/**
 * <p>Se encaga de la creación y definición de los jugadores,el tablero y el turno.</p>
 * @author David
 */
public class Juego {

    private Coordinador coordinador;
    private final List<Jugador> jugadores;
    private int turno;
    private final Tablero tablero;
    private int numJugadores;

    /**
     *<p>Instancia un juego y crea un turno con valor a 0 y dos instancias jugadores y las añade a un <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html">arrayList</a>.</p>
     * @see Jugador
     * @see Tablero
     */
    public Juego() {
        numJugadores=2;
        turno=0;
        jugadores = new ArrayList<>();
        tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
    }

    /**
     *<p>Establece la conexión de la instancia con una instancia Coordinador</p>
     * @param coordinador Instancia de Coordinador que se le asigna a la instancia Juego.
     * @see Coordinador
     */
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    /**
     * <p>Calcula el valor del siguiente turno teniendo en cuenta el turno actual.</p>
     * <p>Tiene en cuenta si hay turnos extra para no variar el valor del turno y en su lugar decrementa los turnos extra</p>
     * <p>El valor turno equivale a la posición del ArrayList de Jugador</p>
     * @return Devuelve un número comprendido entre <code>0</code> y <code>1</code>
     * @see Jugador#getTurnosExtra() 
     * @see Jugador#decrementaTurnosExtra() 
     */
    public int sigTurno() {
        int sigTurno;
        sigTurno = (turno + 1) % numJugadores;
        if (jugadores.get(turno).getTurnosExtra() > 0) {
            sigTurno = turno;
            jugadores.get(turno).decrementaTurnosExtra();
        }
        return (sigTurno);
    }

    /**
     *<p>Fija el valor de la propiedad turno por el valor devuelto por sigTurno()</p>
     * @return Devuelve el valor actual del turno.
     * @see Juego#sigTurno()
     */
    public int avanzaTurno() {
        turno = sigTurno();
        return turno;
    }

    /**
     *<p>Fija un valor introducido por parámetros a la propiedad turno.</p>
     * @param turno Valor entero comprendido entre <code>0</code> y <code>1</code>
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     *<p>Devuelve el valor de la propiedad turno.</p>
     * @return Devuelve un valor entero comprendido entre <code>0</code> y <code>1</code>
     */
    public int getTurno() {
        return (turno);
    }

    /**
     *<p>Devuelve el ultimo valor generado por la instancia dado teniendo en cuenta el Jugador que tenía el turno</p>
     * @return Devuelve un valor entero comprendido entre <code>1</code> y <code>6</code>
     * @see Jugador#getUltimoValorDado() 
     */
    public int ultimoValorDado() {
        return jugadores.get(turno).getUltimoValorDado();
    }

    /**
     *<p>Devuelve el ultimo valor de la posición del tablero teniendo en cuenta el Jugador que tenía el turno.</p>
     * @return Devuelve un valor entero comprendido entre <code>1</code> y <code>63</code>
     * @see Jugador#getUltimaPosicionTablero() 
     */
    public int ultimaPosicionTablero() {
        return jugadores.get(turno).getUltimaPosicionTablero();
    }

    /**
     *<p>El jugador inicia juegaTurno delegando en tablero el mover ficha</p>
     * @see Jugador#juegaTurno(org.vipsion.oca.modelo.Tablero) 
     */
    public void juega() {
        jugadores.get(turno).juegaTurno(tablero);
    }

    /**
     *<p>Comprueba el estado de la propiedad fin de la instancia Ficha a través de su Jugador</p><br>
     * <p>La instancia coordinador comprueba si es <code>true or false</code></p>
     * @return <code>true or false</code> dependiendo de si ha llegado a las casillas Fin u OcaFin o no.
     * @see Ficha#getFin() 
     * @see Coordinador#juega() 
     */
    public Boolean esFin() {
        return jugadores.get(turno).esGanador();
    }
}
