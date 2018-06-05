import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame{
    private Container cp ;
    private JLabel air = new JLabel();
    private ImageIcon icon = new ImageIcon("picachuL.png");
    private ImageIcon icon2 = new ImageIcon("picachuR.png");
    private ImageIcon icon3 = new ImageIcon("rock.png");

    private Timer t;
    private JLabel rocket =new JLabel();

    Frame(){
        init();
    }

    private void init() {
        this.setBounds(100,100,600,600);
        cp = this.getContentPane();
        cp.setLayout(null);
        air.setBounds(300,50,200,200);
        air.setIcon(icon);
        cp.add(air);
        Image img = icon.getImage();
        Image  img2 =img.getScaledInstance(200,230,Image.SCALE_SMOOTH);
        icon.setImage(img2);
        Image img3 = icon2.getImage();
        Image  img4 =img3.getScaledInstance(200,230,Image.SCALE_SMOOTH);
        icon2.setImage(img4);
        Image img5 = icon3.getImage();
        Image  img6 =img5.getScaledInstance(110,160,Image.SCALE_SMOOTH);
        icon3.setImage(img6);

        t = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rocket.setLocation(rocket.getX(),rocket.getY()+10);
                if (rocket.getY()>500){
                    t.stop();
                }
            }
        });


        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        air.setLocation(air.getX()-10,air.getY());
                        air.setIcon(icon2);
                        break;
                    case KeyEvent.VK_RIGHT:
                        air.setLocation(air.getX()+10,air.getY());
                        air.setIcon(icon);
                        break;
                    case KeyEvent.VK_SPACE:
                        rocket.setBounds(air.getX(),air.getY(),100,150);
                        rocket.setIcon(icon3);
                        cp.add(rocket);
                        t.start();


                }
            }
        });



    }



}
