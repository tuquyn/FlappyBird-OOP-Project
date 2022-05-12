package FlappyBird.Control;

import FlappyBird.Game;
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
    private int status; // 0 is down, 1 is up, 2 is die
    private int coutFrameUp;

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
        coutFrameUp = 0;
        cnt = 1;
        index = 0;
        img = new BufferedImage[BIRD_PATH[birdType].length];
        for(int i = 0; i < img.length; i++)
            img[i] = Util.loadBufferedImage(BIRD_PATH[birdType][i]);
        x = frameWidth / 20;
        y = frameHeight / 2;
    }
    public void Reset()
    {
        status = 0;
        coutFrameUp = 0;
        cnt = 1;
        index = 0;
        x = frameWidth / 20;
        y = frameHeight / 2;
    }
    public void draw(Graphics g){
        if(status== 1)
        {drawUp(g);}
        else if(status == 0)
        {drawDown(g);}
        else if (status == 2)
        {
            DrawDie(g);
        }


    }
    public void DrawDie(Graphics g)
    {
        g.drawImage(img[img.length -1], x, y, birdWidth, birdHeight, null);
    }
    public  void DrawWelcome(Graphics g)
    {
        g.drawImage(img[index+= cnt], x, y, birdWidth, birdHeight, null);
        if(index == 9)cnt = -1;
        if(index == 0)cnt = 1;
    }
    public void drawUp(Graphics g){

        y-= 12;
        CheckHitTop();
        index = 0;
        coutFrameUp += 1;

        g.drawImage(img[index], x, y, birdWidth, birdHeight, null);
        if(coutFrameUp > 5)
        { setStatus(0);
            coutFrameUp = 0;
        }


    }
    public void drawDown(Graphics g){
        if(index + 1 < img.length)
        {
            index += 1;
        }
        y+= 8;
        g.drawImage(img[index], x, y, birdWidth, birdHeight, null);
    }
    public boolean CheckHitGround()
    {
        if(y > 400 - img[0].getHeight())
        {
            status = 2;
            return  true;
        }
        return  false;
    }
    public boolean CheckHitTop()
    {
        if(y <= img[0].getHeight())
        {
            setStatus(0);
            return  true;
        }
        return  false;
    }
    public boolean CheckEatCoin(PipeControl o){
        if(o.getPipes().isEmpty())return false;
        for(Pipe p : o.getPipes()) {
            Coin c = p.getCoin();
            if(!c.isAppear())continue;
            if(c.getX() <= x + birdSize && x + birdSize <= c.getX() + birdSize * 3 / 2
                && ((c.getY() <= y && y <= c.getY() + birdSize * 3 / 2)
                    || (c.getY() <= y + birdSize && y + birdSize <= c.getY() + birdSize * 3 / 2))){
                c.setAppear(false);
                return true;
            }
        }
        return false;
    }
}
