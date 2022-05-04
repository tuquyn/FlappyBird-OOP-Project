package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.EventListener;

import static FlappyBird.Util.Constant.*;

public class Bird {
    private BufferedImage[] img;
    private int index;
    private int cnt;
    private int x;
    private int y;
    private int status; // 0 is down, 1 is up

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        if(status == 0)
        {
          cnt = 1;
        }
        else
        {
            cnt = -1;
        }
    }

    public Bird(){
        status = 0;
        cnt = 1;
        index = 0;
        img = new BufferedImage[BIRD_PATH[birdType].length];
        for(int i = 0; i < img.length; i++)
            img[i] = Util.loadBufferedImage(BIRD_PATH[birdType][i]);
        x = frameWidth / 20;
        y = frameHeight / 2;
    }
    public void draw(Graphics g){
        g.drawImage(img[index+= cnt], x, y, birdWidth, birdHeight, null);
        if(index == 9)cnt = -1;
        if(index == 0)cnt = 1;
    }
    public void drawUp(Graphics g){
        y-= 20;
        index = 0;
        g.drawImage(img[index], x, y, birdWidth, birdHeight, null);

    }
    public void drawDown(Graphics g){
        g.drawImage(img[index+= cnt], x, y, birdWidth, birdHeight, null);
        y+= 5;
        if(index + 1  == img.length)
        {
            index = 0;
        }
    }
    public boolean CheckHitGround()
    {
        return  y > 400;
    }
}
