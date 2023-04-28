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

    public int px = 230;
    public int py = 230;

    private JPanel fondo;

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 700);
        this.setResizable(false);
        this.setVisible(true);

        fondo = new JPanel();
        fondo.setBackground(new Color(45, 45, 45));
        fondo.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(fondo);
        fondo.setLayout(null);

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(new Color(128, 0, 0));
        panelInferior.setBounds(0, 602, 684, 59);
        panelInferior.setLayout(null);
        fondo.add(panelInferior);


        JButton btnNewButton = new JButton("Reiniciar");
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setBounds(291, 11, 107, 37);
        panelInferior.add(btnNewButton);

        JPanel panelJuego = new JPanel();
        panelJuego.setBackground(new Color(255, 255, 255));
        panelJuego.setBounds(10, 11, 664, 580);
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

        //Arriba
        if(e.getKeyCode() == 87 && py > 10) {
            py = py - 10;
        }

        //Abajo
        if(e.getKeyCode() == 83 && py < 551) {
            py = py + 10;
        }

        //Izquierda
        if(e.getKeyCode() == 65 && px > 10 ) {
            px = px - 10;
        }

        //Derecha
        if(e.getKeyCode() == 68 && px < 640) {
            px= px + 10;
        }

        this.repaint();
        this.revalidate();
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

            Rect r = new Rect(px, py , 20 , 20, new Color(0,0,0));
            g.setColor(r.c);
            g.fillRect(r.x, r.y, r.w, r.h);

            //PARED
            Rect wall = new Rect(30,30,100,200,Color.gray);
            g.setColor(wall.c);
            g.fillRect(wall.x, wall.y, wall.w, wall.h);

            //Colisión
            if(r.Colision(wall)){
                g.setColor(Color.red);
                g.drawString("Colisión", 10, 20);
            }

            /*
            Rect p = new Rect(600,60,40,200, Color.decode("#0a8cbd"));
            g.setColor(p.c);
            g.fillRect(p.w, p.y, p.w, p.h);

            */

            System.out.println(r.Colision(wall));
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