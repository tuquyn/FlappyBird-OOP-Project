package FlappyBird;

import FlappyBird.Control.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class Game extends Frame implements KeyListener {
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

        addKeyListener(this);
        setFocusable(true);
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
                    Thread.sleep(FPS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void setGameState(int state){
        gameState = state;
    }

    private final BufferedImage bufImg = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_4BYTE_ABGR);

    public void update(Graphics g){
        Graphics bufG = bufImg.getGraphics();
        backGround.draw(bufG);
        cloudControl.draw(bufG);
        if(gameState == welcomeState){
            welcome.draw(bufG);
            bird.draw(bufG);
        }
        g.drawImage(bufImg, 0, 0, null);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (gameState) {
            case welcomeState:
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(buttonChoose != buttonThree)
                        if(buttonChoose == buttonOne) buttonChoose = buttonTwo;
                    else
                        buttonChoose = buttonThree;
                }
                if(e.getKeyCode()  == KeyEvent.VK_LEFT){
                    if(buttonChoose != buttonOne)
                        if(buttonChoose == buttonTwo) buttonChoose = buttonOne;
                    else
                        buttonChoose = buttonTwo;
                }
                if(e.getKeyCode()  == KeyEvent.VK_UP){
                    if(buttonChoose == buttonOne){
                        birdType++; birdType %= 4;
                    }else {
                            // buttonChoose == buttonThree => rank
                    }
                }
                if(e.getKeyCode()  == KeyEvent.VK_DOWN){
                    if(buttonChoose == buttonOne){
                        birdType--; birdType = (birdType + 4) % 4;
                    }else {
                        // buttonChoose == buttonThree => rank
                    }
                }
                if(e.getKeyCode()  == KeyEvent.VK_SPACE && buttonChoose == buttonTwo){
                    setGameState(playGameState);
                }
                break;
            case playGameState:
                if (e.getKeyCode() == KeyEvent.VK_SPACE){
                }
                break;
            case gameOverState:
                if(e.getKeyCode()  == KeyEvent.VK_SPACE){
                }
                break;
        }
    }
    /**
     * When the space button is released,
     * the state needs to be changed manually
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyChar();
        if(keycode == KeyEvent.VK_SPACE){
        }
    }
    /**
     * When other buttons are pressed,no action happens
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
