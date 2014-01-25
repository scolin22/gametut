package kiloboltgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartingClass extends Applet implements Runnable, KeyListener {
    @Override
    public void init() {
        // TODO Auto-generated method stub
        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("Q-Bot Alpha");
    }

    @Override
    public void start() {
        // TODO Auto-generated method stub
        Thread thread = new Thread(this) {
        };
        thread.start();

    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            System.out.println("Pressed UP");
            break;
        case KeyEvent.VK_DOWN:
            System.out.println("Pressed DOWN");
            break;
        case KeyEvent.VK_LEFT:
            System.out.println("Pressed LEFT");
            break;
        case KeyEvent.VK_RIGHT:
            System.out.println("Pressed RIGHT");
            break;
        case KeyEvent.VK_SPACE:
            System.out.println("Pressed SPACE");
            break;

        default:
            break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:
            System.out.println("Released UP");
            break;
        case KeyEvent.VK_DOWN:
            System.out.println("Released DOWN");
            break;
        case KeyEvent.VK_LEFT:
            System.out.println("Released LEFT");
            break;
        case KeyEvent.VK_RIGHT:
            System.out.println("Released RIGHT");
            break;
        case KeyEvent.VK_SPACE:
            System.out.println("Released SPACE");
            break;

        default:
            break;
        }
    }
}
