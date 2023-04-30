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
    public int py = 50;

    private JPanel fondo;
    private boolean colision = false;  // variable para indicar si ha ocurrido una colisión

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 988, 988);
        this.setResizable(false);
        this.setVisible(true);

        fondo = new JPanel();
        fondo.setBackground(new Color(45, 45, 45));
        fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(fondo);
        fondo.setLayout(null);

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(128, 0, 0));
        panelInferior.setBounds(0, 890, 972, 59);
        panelInferior.setLayout(null);
        fondo.add(panelInferior);


        JButton btnNewButton = new JButton("Reiniciar");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(448, 11, 107, 37);
        panelInferior.add(btnNewButton);

        JPanel panelJuego = new JPanel();
        panelJuego.setBackground(new Color(255, 255, 255));
        panelJuego.setBounds(10, 11, 952, 868);
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
                Rect jugador = new Rect(px + dx, py + dy, 20, 20, new Color(0,0,0));

                //PAREDES HORIZONTALES -------------------------------------------------------------------------------------------------------
                Rect pared = new Rect(5, 5, 930, 5, Color.gray);
                //FIN PAREDES HORIZONTALES ---------------------------------------------------------------------------------------------------



                //PAREDES VERTICALES -------------------------------------------------------------------------------------------------------
                Rect pared2 = new Rect(940, 10, 5, 710,Color.gray);
                Rect pared3 = new Rect(5, 5, 5, 40,Color.gray);
                //FIN PAREDES VERTICALES ---------------------------------------------------------------------------------------------------


                if (!jugador.Colision(pared) && !jugador.Colision(pared2)) {
                    px += dx;
                    py += dy;
                    this.repaint();
                    this.revalidate();
                }


            }
            /*
            this.repaint();
            this.revalidate();
            */

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
            g.fillRect(px,py,20,20);


            Rect jugador = new Rect(px, py , 20 , 20, new Color(0,0,0));
            g.setColor(jugador.c);
            g.fillRect(jugador.x, jugador.y, jugador.w, jugador.h);



            //PAREDES HORIZONTALES -----------------------------------------------------------------------------------------------------------
            Rect wall = new Rect(10, 10, 930, 5,Color.gray);
            g.setColor(wall.c);
            g.fillRect(wall.x, wall.y, wall.w, wall.h);

            Rect pared5 = new Rect(10, 855, 930, 5,Color.gray);
            g.setColor(pared5.c);
            g.fillRect(pared5.x, pared5.y, pared5.w, pared5.h);

            Rect pared6 = new Rect(10, 820, 930, 5,Color.gray);
            g.setColor(pared6.c);
            g.fillRect(pared6.x, pared6.y, pared6.w, pared6.h);

            // FIN PAREDES HORIZONTALES ------------------------------------------------------------------------------------------------------


            //PAREDES VERTICALES -----------------------------------------------------------------------------------------------------------
            Rect pared2 = new Rect(940, 10, 5, 710,Color.gray);
            g.setColor(pared2.c);
            g.fillRect(pared2.x, pared2.y, pared2.w, pared2.h);

            Rect pared3 = new Rect(5, 10, 5, 40,Color.gray);
            g.setColor(pared3.c);
            g.fillRect(pared3.x, pared3.y, pared3.w, pared3.h);

            Rect pared4 = new Rect(5, 80, 5, 780,Color.GRAY);
            g.setColor(pared4.c);
            g.fillRect(pared4.x, pared4.y, pared4.w, pared4.h);
            // FIN PAREDES VERTICALES ------------------------------------------------------------------------------------------------------


            /*
            //Colisión
            if(jugador.Colision(wall)){
                g.setColor(Color.red);
                g.drawString("Colisión", 10, 20);
            }

            // Verificar si ha ocurrido una colisión
            if (jugador.Colision(wall)) {
                colision = true;
            } else {
                colision = false;
            }

            System.out.println(jugador.Colision(wall));
            */
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
