import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Ventana extends JFrame implements KeyListener{

    public int px = 10;
    public int py = 10;

    private JPanel fondo;
    private boolean colision = false;  // variable para indicar si ha ocurrido una colisión

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 988, 1017);
        this.setResizable(false);
        this.setVisible(true);

        fondo = new JPanel();
        fondo.setBackground(new Color(45, 45, 45));
        fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(fondo);
        fondo.setLayout(null);

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(128, 0, 0));
        panelInferior.setBounds(0, 936, 972, 42);
        panelInferior.setLayout(null);
        fondo.add(panelInferior);


        JButton btnNewButton = new JButton("Reiniciar");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(431, 11, 87, 23);
        panelInferior.add(btnNewButton);

        JPanel panelJuego = new JPanel();
        panelJuego.setBackground(new Color(255, 255, 255));
        panelJuego.setBounds(10, 11, 952, 914);
        panelJuego.add(new MyPanel());
        panelJuego.setLayout(new GridLayout(1, 0, 0, 0));
        fondo.add(panelJuego);


        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e.getKeyCode());

        if (!colision) {
            System.out.println(e.getKeyCode());

            int dx = 0;
            int dy = 0;

            //Arriba
            if(e.getKeyCode() == 87 && py > 10) {
                //py = py - 10;
                dy = dy - 10;
            }

            //Abajo
            if(e.getKeyCode() == 83 && py < 870) {
                //py = py + 10;
                dy = dy+10;
            }

            //Izquierda
            if(e.getKeyCode() == 65 && px > 10 ) {
                //px = px - 10;
                dx = dx-10;
            }

            //Derecha
            if(e.getKeyCode() == 68 && px < 950) {
                //px= px + 10;
                dx = dx+10;
            }

            // verificar si la próxima posición del cuadrado está dentro de los límites
            if (px + dx >= 0 && px + dx + 20 <= 950 && py + dy >= 0 && py + dy + 20 <= 870) {


                // verificar si la próxima posición del cuadrado colisiona con la pared
                Rect jugador = new Rect(px + dx, py + dy, 10, 10, Color.RED);

                //PAREDES HORIZONTALES -------------------------------------------------------------------------------------------------------
                Rect pared = new Rect(5, 5, 930, 5, Color.gray);
                //FIN PAREDES HORIZONTALES ---------------------------------------------------------------------------------------------------


                //PAREDES VERTICALES -------------------------------------------------------------------------------------------------------
                Rect pared2 = new Rect(940, 10, 5, 710,Color.gray);
                Rect pared3 = new Rect(5, 5, 5, 40,Color.gray);
                Rect pared5 = new Rect(10, 855, 930, 3, Color.gray);
                Rect pared6 = new Rect(5, 30, 60, 3, Color.gray);
                Rect pared7 = new Rect(105, 30, 60, 3, Color.gray);
                Rect pared8 = new Rect(185, 30, 20, 3, Color.gray);
                Rect pared9 = new Rect(225, 30, 80, 3, Color.gray);
                Rect pared10 = new Rect(385, 30, 60, 3, Color.GRAY);
                Rect pared11 = new Rect(565, 30, 40, 3, Color.GRAY);
                Rect pared12 = new Rect(625, 30, 100, 3, Color.GRAY);
                Rect pared13 = new Rect(745, 30, 40, 3,Color.GRAY);

                //SEGUNDA FILA
                Rect pared14 = new Rect(45, 50, 60, 3, Color.GRAY);
                Rect pared15 = new Rect(225, 50, 60, 3, Color.GRAY);
                Rect pared16 = new Rect(305, 50, 20, 3, Color.GRAY);
                Rect pared17 = new Rect(345, 50, 120, 3, Color.GRAY);
                Rect pared18 = new Rect(505, 50, 40, 3, Color.GRAY);
                Rect pared19 = new Rect(565, 50, 60, 3, Color.GRAY);
                Rect pared20 = new Rect(665, 50, 60, 3, Color.GRAY);
                Rect pared21 = new Rect(785, 50, 20, 3, Color.GRAY);
                Rect pared22 = new Rect(85, 10, 3, 20, Color.gray);
                Rect pared23 = new Rect(185, 10, 3, 20, Color.gray);
                Rect pared24 = new Rect(345, 10, 3, 40, Color.gray);
                Rect pared25 = new Rect(445, 10, 3, 20, Color.gray);
                Rect pared26 = new Rect(505, 10, 3, 40, Color.gray);
                Rect pared27 = new Rect(545, 10, 3, 20, Color.gray);
                Rect pared28 = new Rect(65, 30, 3, 20, Color.gray);
                Rect pared29 = new Rect(105, 30, 3, 20, Color.gray);
                Rect pared30 = new Rect(145, 30, 3, 60, Color.gray);
                Rect pared31 = new Rect(165, 30, 3, 60, Color.gray);
                Rect pared32 = new Rect(165, 50, 20, 3, Color.GRAY);
                Rect pared33 = new Rect(205, 30, 3, 60, Color.gray);
                Rect pared34 = new Rect(285, 30, 3, 20, Color.gray);
                Rect pared35 = new Rect(325, 30, 3, 20, Color.red);
                Rect pared36 = new Rect(465, 30, 3, 20, Color.red);
                Rect pared37 = new Rect(485, 30, 3, 40, Color.gray);
                Rect pared38 = new Rect(525, 30, 3, 20, Color.gray);
                Rect pared39 = new Rect(605, 30, 3, 20, Color.gray);
                Rect pared40 = new Rect(665, 30, 3, 20, Color.gray);
                Rect pared41 = new Rect(745, 30, 3, 100, Color.gray);
                Rect pared42 = new Rect(365, 30, 3, 20, Color.red);
                Rect pared43 = new Rect(785, 30, 3, 20, Color.gray);

                //TERCERA COLUMNA
                Rect pared44 = new Rect(25, 50, 3, 20, Color.gray);
                Rect pared45 = new Rect(125, 50, 3, 40, Color.gray);
                Rect pared46 = new Rect(225, 50, 3, 100, Color.gray);
                Rect pared47 = new Rect(305, 50, 3, 20, Color.gray);
                Rect pared48 = new Rect(325, 50, 3, 20, Color.gray);
                Rect pared49 = new Rect(405, 50, 3, 40, Color.gray);
                Rect pared50 = new Rect(545, 50, 3, 20, Color.gray);
                Rect pared51 = new Rect(565, 50, 3, 20, Color.gray);
                Rect pared52 = new Rect(625, 50, 3, 20, Color.gray);
                Rect pared53 = new Rect(645, 50, 3, 20, Color.gray);
                Rect pared54 = new Rect(725, 50, 3, 40, Color.gray);
                Rect pared55 = new Rect(765, 50, 3, 100, Color.gray);
                Rect pared56 = new Rect(765, 50, 3, 100, Color.gray);

                //CUARTA COLUMNA
                Rect pared57 = new Rect(45, 70, 3, 40, Color.gray);
                Rect pared58 = new Rect(105, 70, 3, 40, Color.gray);
                Rect pared59 = new Rect(245, 70, 3, 20, Color.gray);
                Rect pared60 = new Rect(425, 70, 3, 40, Color.gray);
                Rect pared61 = new Rect(525, 70, 3, 20, Color.gray);
                Rect pared62 = new Rect(565, 70, 3, 60, Color.gray);
                Rect pared63 = new Rect(605, 70, 3, 160, Color.gray);
                Rect pared64 = new Rect(665, 70, 3, 40, Color.gray);
                Rect pared65 = new Rect(685, 70, 3, 80, Color.gray);



                //FIN PAREDES VERTICALES ---------------------------------------------------------------------------------------------------

                if (!jugador.Colision(pared) && !jugador.Colision(pared2) && !jugador.Colision(pared3) && !jugador.Colision(pared5)
                        && !jugador.Colision(pared6) && !jugador.Colision(pared7) && !jugador.Colision(pared8) && !jugador.Colision(pared9)
                        && !jugador.Colision(pared10) && !jugador.Colision(pared11) && !jugador.Colision(pared12) && !jugador.Colision(pared13)
                        && !jugador.Colision(pared14) && !jugador.Colision(pared15) && !jugador.Colision(pared16) && !jugador.Colision(pared17)
                        && !jugador.Colision(pared18) && !jugador.Colision(pared19) && !jugador.Colision(pared20) && !jugador.Colision(pared21)
                        && !jugador.Colision(pared22) && !jugador.Colision(pared23) && !jugador.Colision(pared24) && !jugador.Colision(pared25)
                        && !jugador.Colision(pared26) && !jugador.Colision(pared27) && !jugador.Colision(pared28) && !jugador.Colision(pared29)
                        && !jugador.Colision(pared30) && !jugador.Colision(pared31) && !jugador.Colision(pared32) && !jugador.Colision(pared33)
                        && !jugador.Colision(pared34) && !jugador.Colision(pared35) && !jugador.Colision(pared36) && !jugador.Colision(pared37)
                        && !jugador.Colision(pared38) && !jugador.Colision(pared39) && !jugador.Colision(pared40) && !jugador.Colision(pared41)
                        && !jugador.Colision(pared42) && !jugador.Colision(pared43) && !jugador.Colision(pared44) && !jugador.Colision(pared45)
                        && !jugador.Colision(pared46) && !jugador.Colision(pared47) && !jugador.Colision(pared48) && !jugador.Colision(pared49)
                        && !jugador.Colision(pared50) && !jugador.Colision(pared51) && !jugador.Colision(pared52) && !jugador.Colision(pared53)
                        && !jugador.Colision(pared54) && !jugador.Colision(pared55) && !jugador.Colision(pared56) && !jugador.Colision(pared57)
                        && !jugador.Colision(pared58) && !jugador.Colision(pared59) && !jugador.Colision(pared60) && !jugador.Colision(pared61)
                        && !jugador.Colision(pared62) && !jugador.Colision(pared63) && !jugador.Colision(pared64) && !jugador.Colision(pared65)) {

                    px += dx;
                    py += dy;
                    this.repaint();
                    this.revalidate();
                }


            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            //JUGADOR
            g.setColor(Color.black);
            g.fillRect(px,py,10,10);


            Rect jugador = new Rect(px, py , 10 , 10, Color.RED);
            g.setColor(jugador.c);
            g.fillRect(jugador.x, jugador.y, jugador.w, jugador.h);



            //PAREDES HORIZONTALES -----------------------------------------------------------------------------------------------------------

            //PRIMERA FILA
            Rect pared5 = new Rect(10, 855, 930, 3, Color.gray);
            g.setColor(pared5.c);
            g.fillRect(pared5.x, pared5.y, pared5.w, pared5.h);

            Rect wall = new Rect(5, 10, 932, 3, Color.gray);
            g.setColor(wall.c);
            g.fillRect(wall.x, wall.y, wall.w, wall.h);

            Rect pared6 = new Rect(5, 30, 60, 3, Color.gray);
            g.setColor(pared6.c);
            g.fillRect(pared6.x, pared6.y, pared6.w, pared6.h);

            Rect pared7 = new Rect(105, 30, 60, 3, Color.gray);
            g.setColor(pared7.c);
            g.fillRect(pared7.x, pared7.y, pared7.w, pared7.h);

            Rect pared8 = new Rect(185, 30, 20, 3, Color.gray);
            g.setColor(pared8.c);
            g.fillRect(pared8.x, pared8.y, pared8.w, pared8.h);

            Rect pared9 = new Rect(225, 30, 80, 3, Color.gray);
            g.setColor(pared9.c);
            g.fillRect(pared9.x, pared9.y, pared9.w, pared9.h);

            Rect pared10 = new Rect(385, 30, 60, 3, Color.GRAY);
            g.setColor(pared10.c);
            g.fillRect(pared10.x, pared10.y, pared10.w, pared10.h);

            Rect pared11 = new Rect(565, 30, 40, 3, Color.GRAY);
            g.setColor(pared11.c);
            g.fillRect(pared11.x, pared11.y, pared11.w, pared11.h);

            Rect pared12 = new Rect(625, 30, 100, 3, Color.GRAY);
            g.setColor(pared12.c);
            g.fillRect(pared12.x, pared12.y, pared12.w, pared12.h);

            Rect pared13 = new Rect(745, 30, 40, 3,Color.GRAY);
            g.setColor(pared13.c);
            g.fillRect(pared13.x, pared13.y, pared13.w, pared13.h);

            //SEGUNDA FILA
            Rect pared14 = new Rect(45, 50, 60, 3, Color.GRAY);
            g.setColor(pared14.c);
            g.fillRect(pared14.x, pared14.y, pared14.w, pared14.h);

            Rect pared15 = new Rect(225, 50, 60, 3, Color.GRAY);
            g.setColor(pared15.c);
            g.fillRect(pared15.x, pared15.y, pared15.w, pared15.h);

            Rect pared16 = new Rect(305, 50, 20, 3, Color.GRAY);
            g.setColor(pared16.c);
            g.fillRect(pared16.x, pared16.y, pared16.w, pared16.h);

            Rect pared17 = new Rect(345, 50, 120, 3, Color.GRAY);
            g.setColor(pared17.c);
            g.fillRect(pared17.x, pared17.y, pared17.w, pared17.h);

            Rect pared18 = new Rect(505, 50, 40, 3, Color.GRAY);
            g.setColor(pared18.c);
            g.fillRect(pared18.x, pared18.y, pared18.w, pared18.h);

            Rect pared19 = new Rect(565, 50, 60, 3, Color.GRAY);
            g.setColor(pared19.c);
            g.fillRect(pared19.x, pared19.y, pared19.w, pared19.h);

            Rect pared32 = new Rect(165, 50, 20, 3, Color.GRAY);
            g.setColor(pared32.c);
            g.fillRect(pared32.x, pared32.y, pared32.w, pared32.h);

            Rect pared20 = new Rect(665, 50, 60, 3, Color.GRAY);
            g.setColor(pared20.c);
            g.fillRect(pared20.x, pared20.y, pared20.w, pared20.h);

            Rect pared21 = new Rect(785, 50, 20, 3, Color.GRAY);
            g.setColor(pared21.c);
            g.fillRect(pared21.x, pared21.y, pared21.w, pared21.h);

            //TERCERA FILA
            Rect pared66 = new Rect(25, 70, 20, 3, Color.gray);
            g.setColor(pared66.c);
            g.fillRect(pared66.x, pared66.y, pared66.w, pared66.h);

            Rect pared67 = new Rect(65, 70, 60, 3, Color.gray);
            g.setColor(pared67.c);
            g.fillRect(pared67.x, pared67.y, pared67.w, pared67.h);

            Rect pared68 = new Rect(185, 70, 20, 3, Color.gray);
            g.setColor(pared68.c);
            g.fillRect(pared68.x, pared68.y, pared68.w, pared68.h);

            Rect pared69 = new Rect(245, 70, 60, 3, Color.gray);
            g.setColor(pared69.c);
            g.fillRect(pared69.x, pared69.y, pared69.w, pared69.h);

            Rect pared70 = new Rect(325, 70, 60, 3, Color.gray);
            g.setColor(pared70.c);
            g.fillRect(pared70.x, pared70.y, pared70.w, pared70.h);

            // FIN PAREDES HORIZONTALES ------------------------------------------------------------------------------------------------------


            //PAREDES VERTICALES -----------------------------------------------------------------------------------------------------------

            //PRIMER COLUMNA
            Rect pared2 = new Rect(940, 10, 3, 710, Color.gray);
            g.setColor(pared2.c);
            g.fillRect(pared2.x, pared2.y, pared2.w, pared2.h);

            Rect pared3 = new Rect(5, 10, 3, 780, Color.gray);
            g.setColor(pared3.c);
            g.fillRect(pared3.x, pared3.y, pared3.w, pared3.h);

            Rect pared22 = new Rect(85, 10, 3, 20, Color.gray);
            g.setColor(pared22.c);
            g.fillRect(pared22.x, pared22.y, pared22.w, pared22.h);

            Rect pared23 = new Rect(185, 10, 3, 20, Color.gray);
            g.setColor(pared23.c);
            g.fillRect(pared23.x, pared23.y, pared23.w, pared23.h);

            Rect pared24 = new Rect(345, 10, 3, 40, Color.gray);
            g.setColor(pared24.c);
            g.fillRect(pared24.x, pared24.y, pared24.w, pared24.h);

            Rect pared25 = new Rect(445, 10, 3, 20, Color.gray);
            g.setColor(pared25.c);
            g.fillRect(pared25.x, pared25.y, pared25.w, pared25.h);

            Rect pared26 = new Rect(505, 10, 3, 40, Color.gray);
            g.setColor(pared26.c);
            g.fillRect(pared26.x, pared26.y, pared26.w, pared26.h);

            Rect pared27 = new Rect(545, 10, 3, 20, Color.gray);
            g.setColor(pared27.c);
            g.fillRect(pared27.x, pared27.y, pared27.w, pared27.h);

            Rect pared28 = new Rect(65, 30, 3, 20, Color.gray);
            g.setColor(pared28.c);
            g.fillRect(pared28.x, pared28.y, pared28.w, pared28.h);

            Rect pared29 = new Rect(105, 30, 3, 20, Color.gray);
            g.setColor(pared29.c);
            g.fillRect(pared29.x, pared29.y, pared29.w, pared29.h);

            Rect pared30 = new Rect(145, 30, 3, 60, Color.gray);
            g.setColor(pared30.c);
            g.fillRect(pared30.x, pared30.y, pared30.w, pared30.h);

            Rect pared31 = new Rect(165, 30, 3, 60, Color.gray);
            g.setColor(pared31.c);
            g.fillRect(pared31.x, pared31.y, pared31.w, pared31.h);

            Rect pared33 = new Rect(205, 30, 3, 60, Color.gray);
            g.setColor(pared33.c);
            g.fillRect(pared33.x, pared33.y, pared33.w, pared33.h);

            Rect pared34 = new Rect(285, 30, 3, 20, Color.gray);
            g.setColor(pared34.c);
            g.fillRect(pared34.x, pared34.y, pared34.w, pared34.h);

            Rect pared35 = new Rect(325, 30, 3, 20, Color.gray);
            g.setColor(pared35.c);
            g.fillRect(pared35.x, pared35.y, pared35.w, pared35.h);

            Rect pared42 = new Rect(365, 30, 3, 20, Color.gray);
            g.setColor(pared42.c);
            g.fillRect(pared42.x, pared42.y, pared42.w, pared42.h);

            Rect pared36 = new Rect(465, 30, 3, 20, Color.gray);
            g.setColor(pared36.c);
            g.fillRect(pared36.x, pared36.y, pared36.w, pared36.h);

            Rect pared37 = new Rect(485, 30, 3, 40, Color.gray);
            g.setColor(pared37.c);
            g.fillRect(pared37.x, pared37.y, pared37.w, pared37.h);

            Rect pared38 = new Rect(525, 30, 3, 20, Color.gray);
            g.setColor(pared38.c);
            g.fillRect(pared38.x, pared38.y, pared38.w, pared38.h);

            Rect pared39 = new Rect(605, 30, 3, 20, Color.gray);
            g.setColor(pared39.c);
            g.fillRect(pared39.x, pared39.y, pared39.w, pared39.h);

            Rect pared40 = new Rect(665, 30, 3, 20, Color.gray);
            g.setColor(pared40.c);
            g.fillRect(pared40.x, pared40.y, pared40.w, pared40.h);

            Rect pared41 = new Rect(745, 30, 3, 100, Color.gray);
            g.setColor(pared41.c);
            g.fillRect(pared41.x, pared41.y, pared41.w, pared41.h);

            Rect pared43 = new Rect(785, 30, 3, 20, Color.gray);
            g.setColor(pared43.c);
            g.fillRect(pared43.x, pared43.y, pared43.w, pared43.h);

            //TERCERA COLUMNA
            Rect pared44 = new Rect(25, 50, 3, 20, Color.gray);
            g.setColor(pared44.c);
            g.fillRect(pared44.x, pared44.y, pared44.w, pared44.h);

            Rect pared45 = new Rect(125, 50, 3, 40, Color.gray);
            g.setColor(pared45.c);
            g.fillRect(pared45.x, pared45.y, pared45.w, pared45.h);

            Rect pared46 = new Rect(225, 50, 3, 100, Color.gray);
            g.setColor(pared46.c);
            g.fillRect(pared46.x, pared46.y, pared46.w, pared46.h);

            Rect pared47 = new Rect(305, 50, 3, 20, Color.gray);
            g.setColor(pared47.c);
            g.fillRect(pared47.x, pared47.y, pared47.w, pared47.h);

            Rect pared48 = new Rect(325, 50, 3, 20, Color.gray);
            g.setColor(pared48.c);
            g.fillRect(pared48.x, pared48.y, pared48.w, pared48.h);

            Rect pared49 = new Rect(405, 50, 3, 40, Color.gray);
            g.setColor(pared49.c);
            g.fillRect(pared49.x, pared49.y, pared49.w, pared49.h);

            Rect pared50 = new Rect(545, 50, 3, 20, Color.gray);
            g.setColor(pared50.c);
            g.fillRect(pared50.x, pared50.y, pared50.w, pared50.h);

            Rect pared51 = new Rect(565, 50, 3, 20, Color.gray);
            g.setColor(pared51.c);
            g.fillRect(pared51.x, pared51.y, pared51.w, pared51.h);

            Rect pared52 = new Rect(625, 50, 3, 20, Color.gray);
            g.setColor(pared52.c);
            g.fillRect(pared52.x, pared52.y, pared52.w, pared52.h);

            Rect pared53 = new Rect(645, 50, 3, 20, Color.gray);
            g.setColor(pared53.c);
            g.fillRect(pared53.x, pared53.y, pared53.w, pared53.h);

            Rect pared54 = new Rect(725, 50, 3, 40, Color.gray);
            g.setColor(pared54.c);
            g.fillRect(pared54.x, pared54.y, pared54.w, pared54.h);

            Rect pared55 = new Rect(765, 50, 3, 100, Color.gray);
            g.setColor(pared55.c);
            g.fillRect(pared55.x, pared55.y, pared55.w, pared55.h);

            Rect pared56 = new Rect(765, 50, 3, 100, Color.gray);
            g.setColor(pared56.c);
            g.fillRect(pared56.x, pared56.y, pared56.w, pared56.h);

            //CUARTA COLUMNA
            Rect pared57 = new Rect(45, 70, 3, 40, Color.gray);
            g.setColor(pared57.c);
            g.fillRect(pared57.x, pared57.y, pared57.w, pared57.h);

            Rect pared58 = new Rect(105, 70, 3, 40, Color.gray);
            g.setColor(pared58.c);
            g.fillRect(pared58.x, pared58.y, pared58.w, pared58.h);

            Rect pared59 = new Rect(245, 70, 3, 20, Color.gray);
            g.setColor(pared59.c);
            g.fillRect(pared59.x, pared59.y, pared59.w, pared59.h);

            Rect pared60 = new Rect(425, 70, 3, 40, Color.gray);
            g.setColor(pared60.c);
            g.fillRect(pared60.x, pared60.y, pared60.w, pared60.h);

            Rect pared61 = new Rect(525, 70, 3, 20, Color.gray);
            g.setColor(pared61.c);
            g.fillRect(pared61.x, pared61.y, pared61.w, pared61.h);

            Rect pared62 = new Rect(565, 70, 3, 60, Color.gray);
            g.setColor(pared62.c);
            g.fillRect(pared62.x, pared62.y, pared62.w, pared62.h);

            Rect pared63 = new Rect(605, 70, 3, 160, Color.gray);
            g.setColor(pared63.c);
            g.fillRect(pared63.x, pared63.y, pared63.w, pared63.h);

            Rect pared64 = new Rect(665, 70, 3, 40, Color.gray);
            g.setColor(pared64.c);
            g.fillRect(pared64.x, pared64.y, pared64.w, pared64.h);

            Rect pared65 = new Rect(685, 70, 3, 80, Color.gray);
            g.setColor(pared65.c);
            g.fillRect(pared65.x, pared65.y, pared65.w, pared65.h);
            // FIN PAREDES VERTICALES ------------------------------------------------------------------------------------------------------
        }
    }

    public class Rect{
        int x = 0;
        int y = 0;
        int w = 0;
        int h = 0;
        Color c = Color.black;

        Rect(int x, int y, int w, int h, Color c){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.c = c;
        }

        public Boolean Colision(Rect target) {

            if(this.x < target.x + target.w &&
                    this.x + this.w > target.x &&

                    this.y < target.y + target.h &&
                    this.y + this.h > target.y) {

                return true;

            }
            return false;
        }
    }
}
