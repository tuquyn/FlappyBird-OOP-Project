package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class Bird {
    private BufferedImage[] img;
    private int index;
    private int cnt;
    public Bird(){
        cnt = 1;
        index = -1;
        img = new BufferedImage[10];
        for(int i = 0; i < 10; i++)
            img[i] = Util.loadBufferedImage(birdFlyWelcome[i]);
    }
    public void draw(Graphics g){
        g.drawImage(img[index+= cnt], frameWidth / 20, frameHeight / 2, 50, 50, null);
        if(index == 9)cnt = -1;
        if(index == 0)cnt = 1;

    }
}
