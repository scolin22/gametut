package kiloboltgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;

public class StartingClass extends Applet implements Runnable {
    @Override
    public void init() {
        // TODO Auto-generated method stub
        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);

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
}