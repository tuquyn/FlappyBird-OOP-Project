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
    private int status; // 0 is down, 1 is up, 2 is die
    private int coutFrameUp;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
        if(status == 0) cnt = 1; else cnt = -1;
    }

    public Bird(){
        Reset();
    }
    public void Reset(){
        status = 0;
        coutFrameUp = 0;
        cnt = 1;
        index = 0;
        img = new BufferedImage[birdFlyWelcome.length];
        for(int i = 0; i < img.length; i++)
            img[i] = Util.loadBufferedImage(birdFlyWelcome[i]);
        x = frameWidth / 20;
        y = frameHeight / 2;
    }

    public void setImg() {
        img = new BufferedImage[BIRD_PATH[birdType].length];
        for(int i = 0; i < img.length; i++)
            img[i] = Util.loadBufferedImage(BIRD_PATH[birdType][i]);
    }

    public void draw(Graphics g){
        if(status== 1) drawUp(g);
            else
                if(status == 0) drawDown(g);
                    else
                        if (status == 2) drawDie(g);
//        g.drawRect(x + 2, y + 2, birdWidth - 4, birdHeight-4);
    }

    public void drawDie(Graphics g)
    {
        g.drawImage(img[index], x, y, birdWidth, birdHeight, null);
//        g.drawRect(x + 2, y + 2, birdWidth - 4, birdHeight-4);
    }

    public  void drawWelcome(Graphics g)
    {
        g.drawImage(img[index+=cnt], x, y, birdWidth, birdHeight, null);
        if(index == 9)cnt = -1;
        if(index == 0)cnt = 1;
    }
    public void drawUp(Graphics g){
        y-= FPS / 5;
        CheckHitTop();
        index = 0;
        coutFrameUp += 1;

        g.drawImage(img[index], x, y, birdWidth, birdHeight, null);
        if(coutFrameUp > (FPS / 12))
        { setStatus(0);
            coutFrameUp = 0;
        }
    }
    public void drawDown(Graphics g){
        if(index + 1 < img.length)
        {
            index += 1;
        }
        y+= FPS / 15 * 2;
        g.drawImage(img[index], x, y, birdWidth, birdHeight, null);
    }
    public boolean CheckHitGround()
    {
        if(y + birdHeight > frameHeight)
        {
            status = 2;
            return  true;
        }
        return  false;
    }
    public boolean CheckHitTop()
    {
        if(y <= birdHeight)
        {
            setStatus(0);
            return  true;
        }
        return  false;
    }
    public boolean CheckEatCoin(PipeControl o){
        for(Pipe p : o.getPipes()) {
            Coin c = p.getCoin();
            if(!c.isAppear())continue;
            if(c.getX() <= x + birdWidth && x + birdWidth <= c.getX() + birdSize * 3 / 2
                && ((c.getY() <= y && y <= c.getY() + birdHeight * 3 / 2)
                    || (c.getY() <= y + birdHeight && y + birdHeight <= c.getY() + birdSize * 3 / 2))){
                c.setAppear(false);
                return true;
            }
        }
        return false;
    }
    public boolean CheckRectCollison(Rectangle r1, Rectangle r2)
    {
        return r1.intersects(r2);
    }
    public boolean CheckHitPipe(PipeControl o){
        for(Pipe p : o.getPipes()) {
            PipeTest up = p.getPipeUp();
            PipeTest down = p.getPipeDown();
            if(CheckRectCollison(new Rectangle(up.getX(),up.getY(),up.getWidth(),up.getHeigth()),new Rectangle(x+2,y+2,birdWidth - 4,birdHeight - 4)))
            {
                return true;
            }
            if(CheckRectCollison(new Rectangle(down.getX(),down.getY(),down.getWidth(),down.getHeigth()),new Rectangle(x+2,y+2,birdWidth - 4,birdHeight - 4)))
            {
                return true;
            }
//            if(up.getX() <= x + birdWidth && x + birdWidth <= up.getX() + birdSize * 3 / 2
//                    && ((up.getY() <= y && y <= up.getY() + birdHeight * 3 / 2)
//                    || (up.getY() <= y + birdHeight && y + birdHeight <= up.getY() + birdSize * 3 / 2))){
//
//                return true;
//            }
//            if(down.getX() <= x + birdWidth && x + birdWidth <= down.getX() + birdSize * 3 / 2
//                    && ((down.getY() <= y && y <= down.getY() + birdHeight * 3 / 2)
//                    || (down.getY() <= y + birdHeight && y + birdHeight <= down.getY() + birdSize * 3 / 2))){
//
//                return true;
//            }
        }
        return false;
    }

}
