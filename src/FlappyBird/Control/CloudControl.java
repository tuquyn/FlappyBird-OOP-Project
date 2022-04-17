package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    public void init(){
//        Cloud cl = new Cloud(frameWidth / 2, frameHeight / 2, Util.loadBufferedImage(Cloud_PATH[0]));
//        clouds.add(cl);
//        cl = new Cloud(frameWidth / 3, frameHeight / 3, Util.loadBufferedImage(Cloud_PATH[0]));
//        clouds.add(cl);
    }
}
