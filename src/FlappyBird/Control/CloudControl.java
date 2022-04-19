package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import static FlappyBird.Util.Constant.*;

public class CloudControl {
    private ArrayList<Cloud> clouds;
    public CloudControl(){
        clouds = new ArrayList<>();
        init();
    }
    public void draw(Graphics g){
        for(Cloud cloud : clouds){
            cloud.draw(g);
        }
    }

    public void newCloud(){
        Random rand = new Random();
        int x = rand.nextInt(frameWidth + 2000 - frameWidth + 100) + (frameWidth + 100);
        int y = rand.nextInt(frameHeight/3);

        Cloud cl = new Cloud(x, y, Util.loadBufferedImage(Cloud_PATH[0]));
        clouds.add(cl);

    }
    public void newThreeCloud(){
        Random rand = new Random();
        int maxX = frameWidth / 3;
        int minX = 0;
        for(int i = 0; i < 3; i++){
            int x = rand.nextInt(maxX - minX) + minX;
            int y = rand.nextInt(frameHeight / 3);
            Cloud cl = new Cloud(x, y, Util.loadBufferedImage(Cloud_PATH[i]));
            clouds.add(cl);
            minX = maxX;
            maxX += frameWidth / 3;

        }



    }




    public void init(){
        newThreeCloud();

    }
}
