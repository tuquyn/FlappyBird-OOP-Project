package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class Welcome{
    private BufferedImage[] imgTitle;
    private BufferedImage[] button;
    private BufferedImage space;
    private int index;
    private int cnt;
    public Welcome(){
        
        // input the title (the game name) "Flappy bird"
        imgTitle = new BufferedImage[12];
        // input the button
        button = new BufferedImage[3 + 4];
        for(int i = 0; i <= 11; i++)
            imgTitle[i] = Util.loadBufferedImage(titlePATH[i]);
        for(int i = 0; i < 3; i++)
            button[i] = Util.loadBufferedImage(buttonPATH[i]);
        
        // input the signal to move (the arrow flashes) and the space 
        button[3] = Util.loadBufferedImage(UP);
        button[4] = Util.loadBufferedImage(DOWN);
        button[5] = Util.loadBufferedImage(RIGHT);
        button[6] = Util.loadBufferedImage(LEFT);
        space = Util.loadBufferedImage(SPACE);
        index = 0;
        cnt = 1;
    }

    public void draw(Graphics g){
        // draw the title "Flappy bird"
        g.drawImage(imgTitle[index+=cnt], frameWidth / 2 - imgTitle[index].getWidth()/2, frameHeight * 2 / 10, null);
        if(index == 11) cnt = -1;
        if(index == 0)  cnt = 1;

        // draw three buttons in the welcome screen
        g.drawImage(button[0], frameWidth / 2 - imgTitle[index].getWidth() / 2, frameHeight - buttonSize * 2, buttonSize, buttonSize,null);
        g.drawImage(button[1], frameWidth / 2 - imgTitle[index].getWidth() / 2 + buttonSize * 3 / 2, frameHeight - buttonSize * 2, buttonSize, buttonSize,null);
        g.drawImage(button[2], frameWidth / 2 - imgTitle[index].getWidth() / 2 + buttonSize * 6 / 2, frameHeight - buttonSize * 2, buttonSize, buttonSize,null);
        BufferedImage p = Util.loadBufferedImage(BIRD_PATH[birdType][1]);
        
        // draw the selected bird
        g.drawImage(p, frameWidth / 2 - imgTitle[index].getWidth() / 2 + buttonSize * 1 / 4, frameHeight - buttonSize * 2 + buttonSize / 4, birdWidth, birdHeight,null);

        // this part is shown to choose the button:
        // 1. if you choose buttonOne: to select bird (in case you have unclocked that bird)
        // 2. if you choose buttonTwo: to play the game 
        // 3. if you choose buttonThree: to get to the leaderboard
        if(buttonChoose == buttonOne && index % 5 != 0) {
            g.drawImage(button[3], frameWidth / 2 - imgTitle[index].getWidth() / 2, frameHeight - buttonSize * 2 - buttonSize / 2, buttonSize, buttonSize, null);
            g.drawImage(button[4], frameWidth / 2 - imgTitle[index].getWidth() / 2, frameHeight - buttonSize * 2 + buttonSize / 2 , buttonSize, buttonSize, null);
            g.drawImage(button[5], frameWidth / 2 - imgTitle[index].getWidth() / 2 + buttonSize / 2, frameHeight - buttonSize * 2, buttonSize, buttonSize, null);
        }
        if(buttonChoose == buttonTwo && index % 5 != 0) {
            g.drawImage(button[5], frameWidth / 2 - imgTitle[index].getWidth() / 2 + buttonSize * 3 / 2 + buttonSize / 2, frameHeight - buttonSize * 2, buttonSize, buttonSize, null);
            g.drawImage(button[6], frameWidth / 2 - imgTitle[index].getWidth() / 2 + buttonSize * 3 / 2 - buttonSize / 2, frameHeight - buttonSize * 2, buttonSize, buttonSize, null);
            g.drawImage(space, frameWidth / 2 - imgTitle[index].getWidth() / 2, frameHeight - buttonSize * 2 - buttonSize, space.getWidth() / 2, space.getHeight() / 2, null);
        }
        if(buttonChoose == buttonThree && index % 5 != 0){
            g.drawImage(button[3], frameWidth / 2 - imgTitle[index].getWidth() / 2 + buttonSize * 6 / 2, frameHeight - buttonSize * 2 - buttonSize / 2, buttonSize, buttonSize,null);
            g.drawImage(button[4], frameWidth / 2 - imgTitle[index].getWidth() / 2 + buttonSize * 6 / 2, frameHeight - buttonSize * 2 + buttonSize / 2, buttonSize, buttonSize,null);
            g.drawImage(button[6], frameWidth / 2 - imgTitle[index].getWidth() / 2 + buttonSize * 6 / 2 - buttonSize / 2, frameHeight - buttonSize * 2, buttonSize, buttonSize,null);
        }
    }
}
