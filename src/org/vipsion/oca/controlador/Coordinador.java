package org.vipsion.oca.controlador;

import org.vipsion.oca.modelo.Juego;
import org.vipsion.oca.vista.OcaGUI;

/**
 * <p>Sirve para intermediar entre las peticiones provenientes
 * del GUI (vistas) y los objetos que implementan la lógica de la aplicación
 * (Modelo).</p>
 * 
 * <p>Nota: Componente del patrón (MVC o Modelo-Vista-Controlador)</p>
 *
 * @author David
 * @see Juego
 * @see OcaGUI
 * @see <a href="https://es.wikipedia.org/wiki/Modelo%E2%80%93vista%E2%80%93controlador">MVC</a>
 */
public class Coordinador {

    private OcaGUI GUI;

    private Juego juego;

    /**
     * <p>Asocia al objeto a cargo del GUI con este coordinador</p>
     * @param GUI Objeto a cargo del GUI (Vista)
     * @see OcaGUI
     */
    public void setGUI(OcaGUI GUI) {
        this.GUI = GUI;
    }

    /**
     * <p>Asocia al objeto a cargo de la lógica del juego con este coordinador</p>
     * @param juego Objeto a cargo de la lógica del juego (Modelo)
     * @see Juego
     */
    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    /**
     *<p>Asocia a una variable el turno pedido a Juego</p><br>
     * <p>Le pasa ese valor a la instancia de OcaGUI para que se encargue de activar o desactivar los botones de tirar dado de los paneles</p><br>
     *@see  OcaGUI#sigTurno(int) 
     *@see Juego#getTurno() 
     */
    public void inicia() {
        int turnoInicio = juego.getTurno();
        GUI.sigTurno(turnoInicio);
    }

    /**
     *<p>La instancia juego invoca a su método juega()</p><br>
     *<p>Recoge los valores de la posiciòn del tablero,valor del dado y turno a través de la instancia juego</p><br>
     *<p>Estos valores se pasan como parámetros a la instancia de OcaGUI para asignarlos a los paneles.</p><br>
     *<p>Controla el fin del juego y despues cambia el turno.</p>
     * @see Juego#juega() 
     * @see Juego#ultimaPosicionTablero() 
     * @see Juego#ultimoValorDado()
     * @see Juego#getTurno() 
     * @see OcaGUI#setValorDado(int, int) 
     * @see OcaGUI#setPosicionTablero(int, int)
     * @see Juego#esFin()
     * @see OcaGUI#setGanador(int) 
     * @see OcaGUI#sigTurno(int)
     * @see Juego#avanzaTurno() 
     */
    public void juega() {
        juego.juega();
        int posicionTablero = juego.ultimaPosicionTablero();
        int valorDado = juego.ultimoValorDado();
        int turno = juego.getTurno();
        GUI.setValorDado(turno, valorDado);
        GUI.setPosicionTablero(turno, posicionTablero);
        if (juego.esFin()) {
            GUI.setGanador(turno);
        } else {
            int sigTurno = juego.avanzaTurno();
            GUI.sigTurno(sigTurno);
        }
    }

}
