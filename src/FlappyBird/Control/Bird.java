package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

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
    }

    public Bird(){
        status = 0;
        cnt = 1;
        index = -1;
        img = new BufferedImage[10];
        for(int i = 0; i < 10; i++)
            img[i] = Util.loadBufferedImage(birdFlyWelcome[i]);
        x = frameWidth / 20;
        y = frameHeight / 2;
    }
    public void draw(Graphics g){
        g.drawImage(img[index+= cnt], x, y, birdWidth, birdHeight, null);
        if(index == 9)cnt = -1;
        if(index == 0)cnt = 1;
    }
    public void drawUp(Graphics g){

    }
    public void drawDown(Graphics g){

    }
}
