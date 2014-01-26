package kiloboltgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class StartingClass extends Applet implements Runnable, KeyListener {
    private Robot robot;
    private Image image, currentSprite, character, characterJumped,
            characterDown, background;
    private Graphics second;
    private URL base;
    private static Background bg1, bg2;

    @Override
    public void init() {
        // TODO Auto-generated method stub
        setSize(800, 480);
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        Frame frame = (Frame) this.getParent().getParent();
        frame.setTitle("Q-Bot Alpha");
        try {
            base = getDocumentBase();
        } catch (Exception e) {
            // TODO: handle exception
        }

        // Image setups
        characterJumped = getImage(base, "data/Jumped.png");
        characterDown = getImage(base, "data/down.png");
        character = getImage(base, "data/character.png");
        currentSprite = character;

        background = getImage(base, "data/background.png");
    }

    @Override
    public void start() {
        bg1 = new Background(0, 0);
        bg2 = new Background(2160, 0);
        robot = new Robot();
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
            bg1.update();
            bg2.update();
            robot.update();
            currentSprite = character;
            if (robot.isJumped()) {
                currentSprite = characterJumped;
            } else if (robot.isDucked()) {
                currentSprite = characterDown;
            }
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Graphics g) {
        // TODO Auto-generated method stub
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            second = image.getGraphics();
        }
        second.setColor(getBackground());
        second.fillRect(0, 0, getWidth(), getHeight());
        second.setColor(getForeground());
        paint(second);

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
        g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
        g.drawImage(currentSprite, robot.getCenterX() - 61,
                robot.getCenterY() - 63, this);
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
            currentSprite = characterDown;
            robot.duck();
            break;
        case KeyEvent.VK_LEFT:
            System.out.println("Pressed LEFT");
            robot.moveLeft();
            break;
        case KeyEvent.VK_RIGHT:
            System.out.println("Pressed RIGHT");
            robot.moveRight();
            break;
        case KeyEvent.VK_SPACE:
            System.out.println("Pressed SPACE");
            robot.jump();
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
            robot.unduck();
            break;
        case KeyEvent.VK_LEFT:
            System.out.println("Released LEFT");
            robot.stopLeft();
            break;
        case KeyEvent.VK_RIGHT:
            System.out.println("Released RIGHT");
            robot.stopRight();
            break;
        case KeyEvent.VK_SPACE:
            System.out.println("Released SPACE");
            break;

        default:
            break;
        }
    }

    public static Background getBg1() {
        return bg1;
    }

    public static Background getBg2() {
        return bg2;
    }
}
