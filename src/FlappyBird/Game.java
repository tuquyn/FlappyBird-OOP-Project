package FlappyBird;

import FlappyBird.Control.*;
import FlappyBird.Util.Constant;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class Game {

    private static int gameState;

    private BackGround backGround;
    private Bird bird;
    private CloudControl cloudControl;
    private PipeControl pipeControl;
    private WelcomeWindow welcomeWindow;

    public Game(){
        initFrame();
        initGame();
    }

    public void initFrame(){
        // Create the frame
        JFrame frame = new JFrame();
        // Set the title
        frame.setTitle(Constant.frameTitle);
        // Set size of the frame
        frame.setSize(Constant.frameWidth, Constant.frameHeight);
        // Set location of component
        frame.setLocation(Constant.frameX,Constant.frameY);
        // Not change the window size
        frame.setResizable(false);
        // Set icon image
        frame.setIconImage(img.getImage());
        // Exit when close program
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Show it
        frame.setVisible(true);
    }

    public void initGame(){
        backGround = new BackGround();
        bird = new Bird();
        cloudControl = new CloudControl();
        pipeControl = new PipeControl();
        welcomeWindow = new WelcomeWindow();
    }
}
