package org.vipsion.oca.vista;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle;

import org.vipsion.oca.controlador.Coordinador;

/**
 * <p>Clase que representa el frame del panel del jugador.</p>
 * @author David
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/JButton.html">JButton</a>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/JLabel.html">JLabel</a>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/javax/swing/JTextField.html">JTextField</a>
 * @see <a href="https://en.wikipedia.org/wiki/Swing_(Java)">Java Swing</a>
 */
public class PanelJugador extends JPanel {

    private JButton tiraDado;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField valorDado;
    private JTextField posicionTablero;
    private Coordinador coordinador;
    private int id;

    /**
     * <p>Creación de la instancia del panel del jugador e iniciación.</p>
     * @param id número de identificación del panel de cada jugador
     * 
     */
    public PanelJugador(int id) {
        this.id = id;
        initComponents();
    }

    /**
     * <p>Fija el coordinador con el que estará relacionado para su funcionamiento.</p>
     * @param coordinador Instancia de Coordinador que se encargará de gestionar los procesos.
     */
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    /**
     * <p>Fija el valor obtenido por el dado al cuadro de texto</p>
     * @param valor Entero comprendido entre <code>1</code> y <code>6</code>
     * @see OcaGUI#setValorDado(int, int) 
     */
    public void setValorDado(int valor) {
        valorDado.setText(Integer.toString(valor));
    }

    /**
     * <p>Fija el valor de la posición de la ficha del Jugador al cuadro de texto</p>
     * @param posicion Valor entero comprendido entre <code>1</code> y <code>63</code>
     * @see OcaGUI#setPosicionTablero(int, int) 
     */
    public void setPosicionTablero(int posicion) {
        posicionTablero.setText(Integer.toString(posicion));
    }

    /**
     * <p>Deshabilita el botón de tirar dado mientras no sea el turno del Jugador.</p>
     * @see OcaGUI#sigTurno(int) 
     */
    public void disableTiraDado() {
        tiraDado.setEnabled(false);
    }

    /**
     * <p>En caso de terminar el juego muestra una mensaje con el ganador cambiando color del fondo.</p>
     * @see OcaGUI#setGanador(int) 
     */
    public void setGanador() {
        jLabel1.setText("Jugador " + id + " Ganador!!");
        jLabel1.setForeground(Color.RED);
    }

    /**
     * <p>Habilita el botón de tirar dado mientras sea el turno del Jugador.</p>
     * @see OcaGUI#sigTurno(int) 
     */
    public void enableTiraDado() {
        tiraDado.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        valorDado = new JTextField();
        posicionTablero = new JTextField();
        tiraDado = new JButton();
        // setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Jugador " + id);
        jLabel2.setText("Estado de la partida:");
        jLabel3.setText("Posición de la ficha: ");
        tiraDado.setText("TiraDado");
        tiraDado.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                juegaActionPerformed(evt);
            }
        });
        valorDado.setText("0");
        valorDado.setPreferredSize(new Dimension(25, 50));
        posicionTablero.setText("1");
        posicionTablero.setPreferredSize(new Dimension(50, 50));
        jLabel1.setFont(jLabel1.getFont().deriveFont(32.0f));
        jLabel2.setFont(jLabel2.getFont().deriveFont(32.0f));
        jLabel3.setFont(jLabel3.getFont().deriveFont(32.0f));

        tiraDado.setFont(tiraDado.getFont().deriveFont(32.0f));
        valorDado.setFont(valorDado.getFont().deriveFont(32.0f));
        posicionTablero.setFont(posicionTablero.getFont().deriveFont(32.0f));
        GroupLayout jPanel1Layout = new GroupLayout(this);
        this.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(58, 58, 58)
                                                                .addComponent(posicionTablero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(60, 60, 60).addComponent(tiraDado)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(valorDado, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))).addContainerGap(275, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(51, 51, 51)
                                .addComponent(jLabel1)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2)
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(posicionTablero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(85, 85, 85)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(tiraDado)
                                        .addComponent(valorDado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(102, Short.MAX_VALUE)));
    }

    private void juegaActionPerformed(ActionEvent evt) {
        coordinador.juega();
    }

}
