package org.vipsion.oca;

import org.vipsion.oca.vista.OcaGUI;
import org.vipsion.oca.controlador.Coordinador;
import org.vipsion.oca.modelo.Juego;

/**
 *<p>Contiene el main con las creaciones de Coordinador,Juego y OcaGUI</p> 
 * @since 0.5
 * @version 0.5
 * @author David
 */
public class Principal {

    /**
    * <p>A la instancia de Juego se le asigna una instancia coordinador</p>
    * <p>A la instancia de OcaGUI se le asigna una instancia coordinador</p>
    * <p>A la instacia de Coordinador se le asignan las instancias de OcaGUI y Juego.</p>
    * <p>Se habilita la visibilidad de la interfaz gráfica</p>
    * <p>miCoordinador inicia el juego</p><br>
    * @param args Argumentos de <a href="https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html">l&iacute;neas de comandos.</a>
    * @author David
    * @see Juego
    * @see Coordinador
    * @see OcaGUI
    * @see Coordinador#inicia()
    */
    public static void main(String[] args) {
        Coordinador miCoordinador = new Coordinador();
        Juego miJuego = new Juego();
        OcaGUI miGUI = new OcaGUI();
        miJuego.setCoordinador(miCoordinador);
        miGUI.setCoordinador(miCoordinador);
        miCoordinador.setGUI(miGUI);
        miCoordinador.setJuego(miJuego);
        miGUI.setVisible(true);
        miCoordinador.inicia();
    }
}
