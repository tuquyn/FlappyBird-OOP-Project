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
    public static int gameState;
    private BackGround backGround;
    private Bird bird;

    private boolean keySpaceReleased = true;

    private CloudControl cloudControl;
    private PipeControl pipeControl;
    private Welcome welcome;
    private GameOver gameOver;
    public static Score score;
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
        gameOver = new GameOver();
        score = new Score();
        background.start();
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
    public void setBirdStatus(int state){ bird.setStatus(state);}

    private final BufferedImage bufImg = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_4BYTE_ABGR);

    public void update(Graphics g){
        Graphics bufG = bufImg.getGraphics();
        backGround.draw(bufG);
        cloudControl.draw(bufG);
        if(gameState == welcomeState){
            welcome.draw(bufG);
            bird.drawWelcome(bufG);
            if(buttonChoose == buttonThree)
            {
                score.drawScoreBoard(bufG);
            }
        }
        if(gameState == playGameState){
            bird.draw(bufG);
            pipeControl.draw(bufG);
            if(bird.CheckHitGround()||bird.CheckHitPipe(pipeControl))
            {
                gameOver = new GameOver();
                setGameState(gameOverState);
                gameOver.setLabel1(score.score);
                if(score.score > score.getBest()) gameOver.setBest();
                gameOver.show(true);
                //score.NewScore("Test2");
                die.start();
                die = new Sound("",false);
                die.initialize(DIE);// also for hit pipe
            }
            if(bird.CheckEatCoin(pipeControl)) {
                score.score += 1;
                fie.start();
                fie = new Sound("",false);
                fie.initialize(FLYUP);
            }
            score.drawScore(bufG);
        }

        if(gameState == gameOverState){
            pipeControl.draw(bufG);
            bird.drawDie(bufG);
            gameOver.draw(bufG);
        }
//        bufG.setColor(Color.RED);
//        bufG.drawLine(0,400,frameWidth, 400);


        g.drawImage(bufImg, 0, 0, null);
    }
    private Sound background = BG;
    private Sound button = BUTTON;
    private Sound fie = FLYUP; // change sound birdFly into birdEatCoin
    private Sound play = PLAY;
    private Sound die = DIE;

    @Override
    public void keyPressed(KeyEvent e) {
        switch (gameState) {
            case welcomeState:
                if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                    if(buttonChoose != buttonThree)
                        if(buttonChoose == buttonOne) buttonChoose = buttonTwo; else buttonChoose = buttonThree;
                }
                if(e.getKeyCode()  == KeyEvent.VK_LEFT){
                    if(buttonChoose != buttonOne)
                        if(buttonChoose == buttonTwo) buttonChoose = buttonOne; else buttonChoose = buttonTwo;
                }
                if(e.getKeyCode()  == KeyEvent.VK_UP){
                    if(buttonChoose == buttonOne){
                        birdType++; birdType %= 4;
                    }else {
                            score.noScore = ((score.noScore - 1) + score.scoreBoard.size() ) % score.scoreBoard.size();

                    }
                }
                if(e.getKeyCode()  == KeyEvent.VK_DOWN){
                    if(buttonChoose == buttonOne){
                        birdType--; birdType = (birdType + 4) % 4;
                    }else {
                        score.noScore = ((score.noScore + 1) + score.scoreBoard.size() ) % score.scoreBoard.size();
                    }
                }
                if(e.getKeyCode()  == KeyEvent.VK_SPACE && buttonChoose == buttonTwo){
                    bird.setImg();
                    setGameState(playGameState);
                    play.start();
                    play = new Sound("",false);
                    play.initialize(PLAY);
                }else {
                    button.start();
                    button = new Sound("",false);
                    button.initialize(BUTTON);
                }
                break;
            case playGameState:
                if (e.getKeyCode() == KeyEvent.VK_SPACE && keySpaceReleased){
                    keySpaceReleased = false;
                    setBirdStatus(1);
                }
                break;
            case gameOverState:
                if(e.getKeyCode()  == KeyEvent.VK_ENTER){
                    setGameState(welcomeState);
                    bird.Reset();
                    birdType = 0;
                    pipeControl = new PipeControl();
                    gameOver.show(false);
                    gameOver = new GameOver();
                    score = new Score();
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
        if(e.getKeyCode() == KeyEvent.VK_SPACE ){
            keySpaceReleased = true;

        }
    }
    /**
     * When other buttons are pressed,no action happens
     */
    @Override
    public void keyTyped(KeyEvent e) {
       // System.out.println(e.getKeyChar());
    }
}
