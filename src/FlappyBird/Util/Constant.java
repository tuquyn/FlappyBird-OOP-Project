package FlappyBird.Util;

import javax.swing.*;

public class Constant {
    // GameState
    public static final int welcomeState = 0;
    public static final int playGameState = 1;
    public static final int gameOverState = 2;

    public static final int buttonOne = 1;
    public static final int buttonTwo = 2;
    public static final int buttonThree = 3;
    public static int buttonChoose = buttonTwo;

    public static int birdType = 0; // 0..3

    // Window size
    public static final int frameWidth = 1024;
    public static final int frameHeight = 512;
    // Window position
    public static final int frameX = 250;
    public static final int frameY = 200;
    // Game title
    public static final String frameTitle = "Flappy Bird made by We Showed up!";
    // Game refresh rate
    public static final int FPS = 60;
    // icon
    public static final ImageIcon img = new ImageIcon("src/resources/icon.png");
    // background
    public static final String BG_PATH = "src/resources/background.png";
    // cloud
    public static final String[] Cloud_PATH = {"src/resources/cloud(1).png","src/resources/cloud(2).png","resources/cloud(3).png"};
    // speed
    public static final int SPEED = 10;
    // title
    public static final String[] titlePATH ={"src/resources/title/title.png","src/resources/title/title1.png","src/resources/title/title2.png",
            "src/resources/title/title3.png","src/resources/title/title4.png","src/resources/title/title5.png",
            "src/resources/title/title6.png","src/resources/title/title7.png","src/resources/title/title8.png",
            "src/resources/title/title9.png","src/resources/title/title10.png","src/resources/title/title10.png"};
    // button
    public static final String[] buttonPATH = {"src/resources/button/button1.png","src/resources/button/button2.png","src/resources/button/button3.png"};
    public static final int buttonSize = 100;

    public static final String UP = "src/resources/button/up.png";
    public static final String DOWN = "src/resources/button/down.png";
    public static final String LEFT = "src/resources/button/left.png";
    public static final String RIGHT = "src/resources/button/right.png";
    // Bird fly in welcome
    public static final String[] birdFlyWelcome = {"src/resources/bird0/0.png","src/resources/bird0/0.png","src/resources/bird0/1.png",
            "src/resources/bird0/2.png","src/resources/bird0/3.png","src/resources/bird0/4.png",
            "src/resources/bird0/5.png","src/resources/bird0/6.png","src/resources/bird0/7.png","src/resources/bird0/7.png"};

    public static final String SPACE = "src/resources/space.png";

    // Bird
    public  static final int birdSize = 50;
    // BIRD_PATH[i][0] = up, [i][9] = dead, size = 10
    public static final String[][] BIRD_PATH = {{"src/resources/bird0/up.png","src/resources/bird0/down_0.png","src/resources/bird0/down_1.png"
            ,"src/resources/bird0/down_2.png","src/resources/bird0/down_3.png","src/resources/bird0/down_4.png"
            ,"src/resources/bird0/down_5.png","src/resources/bird0/down_6.png","src/resources/bird0/down_7.png"
            ,"src/resources/bird0/dead.png"}, {"src/resources/bird3/Up.png", "src/resources/bird3/down_1.png", "src/resources/bird3/down_2.png"
            ,"src/resources/bird3/down_3.png","src/resources/bird3/down_4.png","src/resources/bird3/down_5.png",
            "src/resources/bird3/down_6.png","src/resources/bird3/down_7.png","src/resources/bird3/down_8.png","src/resources/bird3/down_9.png"
            },{"src/resources/bird2/up.png","src/resources/bird2/down_1.png","src/resources/bird2/down_2.png","src/resources/bird2/down_3.png"
            ,"src/resources/bird2/down_4.png","src/resources/bird2/down_5.png","src/resources/bird2/down_6.png"
            ,"src/resources/bird2/down_7.png","src/resources/bird2/down_8.png","src/resources/bird2/dead.png"
            },{"src/resources/bird1/bird.up.png","src/resources/bird1/bird.1.png","src/resources/bird1/bird.2.png","src/resources/bird1/bird.3.png"
            ,"src/resources/bird1/bird.4.png","src/resources/bird1/bird.5.png","src/resources/bird1/bird.6.png"
            ,"src/resources/bird1/bird.7.png","src/resources/bird1/bird.8.png","src/resources/bird1/bird.dead.png"
            }
    };

}