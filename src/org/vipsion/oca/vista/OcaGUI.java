package org.vipsion.oca.vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import org.vipsion.oca.controlador.Coordinador;

/**
 * <p>Representa la clase que contiene la ventana con los <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html">arrayList</a> de paneles de jugador.</p><br>
 * <p>Se le asocia un Coordinador.</p>
 * @author David
 * @see Coordinador
 * @see PanelJugador
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/JLabel.html">JLabel</a>
 */
public class OcaGUI extends JFrame {

    private List<PanelJugador> panelesJugador;
    private JLabel label;
    private Coordinador coordinador;

    /**
     * <p>Establece una instancia de coordinador a OcaGUI y a cada panel de jugador.</p>
     * @param coordinador Instancia de coordinador a asignar.
     * @see Coordinador
     * @see PanelJugador
     * @see PanelJugador#setCoordinador(org.vipsion.oca.controlador.Coordinador) 
     */
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
        for (PanelJugador panelJugador : panelesJugador) {
            panelJugador.setCoordinador(coordinador);
        }
    }

    /**
     * <p>Inicializa componentes y sale del programa al cerrar la ventana.</p>
     * <p><a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/JPanel.html">JPanel</a></p>
     * <p><a href="https://docs.oracle.com/javase/tutorial/uiswing/components/frame.html">JFrame</a>.</p>
     */
    public OcaGUI() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * <p>Fija el valor obtenido por Dado el campo del panel de jugador. Obtenidiendo primero el panel correspondiente al turno.</p>
     * @param turno Valor entero que determina el oden de actuación que coincide con su posición dentro de la colección.
     * @param valor Valor entero que representa el dato obtenido por la tirada de Dado
     * @see PanelJugador#setValorDado(int)
     * @see org.vipsion.oca.modelo.Dado#dameNumero() 
     */
    public void setValorDado(int turno, int valor) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setValorDado(valor);
    }

    /**
     * <p>Fija el valor entero de la posición de la Ficha del jugador en su respectivo panel.Actualiza información.</p>
     * @param turno Valor entero que determina el oden de actuación que coincide con su posición dentro de la colección.
     * @param valor Valor entero que representa el dato obtenido por la posición de la ficha.
     * @see PanelJugador#setPosicionTablero(int) 
     * @see org.vipsion.oca.modelo.Ficha#getPosicion() 
     */
    public void setPosicionTablero(int turno, int valor) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setPosicionTablero(valor);
    }

    /**
     * <p>Deshabilita el uso del botón de tirar dado del panel del jugador que ha finalizado su jugada.</p>
     * @param turno Representa el valor del turno.
     * @see PanelJugador#disableTiraDado() 
     * @see org.vipsion.oca.modelo.Juego#getTurno() 
     */
    public void disableTurno(int turno) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.disableTiraDado();
    }

    /**
     * <p>Deshabilita el bot&oacute;n de tirar dado en el panel de todos los jugadores y después se lo activa al que tenga el turno.</p>
     * @param turno Valor entero que determina el oden de actuación que coincide con su posición dentro de la colección.
     * @see PanelJugador#disableTiraDado() 
     * @see PanelJugador#enableTiraDado() 
     */
    public void sigTurno(int turno) {
        for (PanelJugador panelJugador : panelesJugador) {
            panelJugador.disableTiraDado();
        }
        panelesJugador.get(turno).enableTiraDado();
    }

    /**
     * <p>Determina que PanelJugador tiene el turno para as&iacute; activar su bot&oacute;n de tirar dado.</p>
     * @param turno Valor entero que determina el oden de actuación que coincide con su posición dentro de la colección.
     * @see PanelJugador#enableTiraDado() 
     */
    public void enableTurno(int turno) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.enableTiraDado();
    }

    /**
     * <p>Cuando es invocado obtiene el PanelJugador correspondiente al turno y llama al m&eacute;todo que mostrará el mensaje de qui&eacute;n ha ganado.</p>
     * @param turno Valor entero que determina el oden de actuación que coincide con su posición dentro de la colección.
     * @see PanelJugador#setGanador() 
     */
    public void setGanador(int turno) {
        PanelJugador panelJugador = panelesJugador.get(turno);
        panelJugador.setGanador();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        panelesJugador = new ArrayList<>();
        PanelJugador panelJugador1 = new PanelJugador(1);
        PanelJugador panelJugador2 = new PanelJugador(2);
        panelesJugador.add(panelJugador1);
        panelesJugador.add(panelJugador2);
        label = new JLabel();
        label.setText("OCA");
        label.setFont(label.getFont().deriveFont(50.0f));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(panelJugador1, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelJugador2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(label)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(panelJugador1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelJugador2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))));
        pack();
    }

    /**
     * <p>Main principal encargado de la parte de generar la interfaz gr&aacute;fica del juego.</p>
     * <P>Se capturan excepciones relacionadas con la interfaz</p>
     * <p><a href="https://docs.oracle.com/javase/7/docs/api/java/lang/ClassNotFoundException.html">ClassNotFoundException</a></p>
     * <p><a href="https://docs.oracle.com/javase/7/docs/api/java/lang/InstantiationException.html">InstantiationException</a></p>
     * <p><a href="https://docs.oracle.com/javase/7/docs/api/java/lang/IllegalAccessException.html">IllegalAccessException</a></p>
     * <p><a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/UnsupportedLookAndFeelException.html">javax.swing.UnsupportedLookAndFeelException</a></p>
     * @param args Argumentos de <a href="https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html">l&iacute;neas de comandos.</a>
     */
    public static void main(String args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OcaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new OcaGUI().setVisible(true);
            }
        });
    }
}
