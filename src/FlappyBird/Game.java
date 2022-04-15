package FlappyBird;

import FlappyBird.Control.*;
import FlappyBird.Util.Constant;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class Game extends Frame{

    private static int gameState;

    private BackGround backGround;
    private Bird bird;
    private CloudControl cloudControl;
    private PipeControl pipeControl;
    private Welcome welcome;

    public Game(){
        initFrame();
        initGame();
    }

    public void initFrame(){
        // init the frame
        // Set the title
        setTitle(frameTitle);
        // Set size of the frame
        setSize(frameWidth, frameHeight);
        // Set location of component
        setLocation(frameX,frameY);
        // Not change the window size
        setResizable(false);
        // Set icon image
        setIconImage(img.getImage());
        // Exit when close program
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        // Show it
        setVisible(true);
    }

    public void initGame(){
        backGround = new BackGround();
        bird = new Bird();
        cloudControl = new CloudControl();
        pipeControl = new PipeControl();
        welcome = new Welcome();

        new Thread(() ->{
            while(true){
                repaint();
                try {
                    Thread.sleep(Constant.FPS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private final BufferedImage bufImg = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_4BYTE_ABGR);

    public void update(Graphics g){
        Graphics bufG = bufImg.getGraphics();
        backGround.draw(bufG);
        g.drawImage(bufImg, 0, 0, null);
    }
}
