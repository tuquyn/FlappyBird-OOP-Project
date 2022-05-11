package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class Coin {
    private int x;
    private int y;
    BufferedImage img;
    private int cnt;

    private boolean r;
    public Coin(int x, int y){
        this.x = x;
        this.y = y;
        this.img = Util.loadBufferedImage(coinPATH);
        cnt = 0;
        r = true;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void draw(Graphics g){
        if(r) {
            if (++cnt == 12) {
                r = false;
                cnt--;
            }
        }else
            if(--cnt == -1){r = true; cnt++;}
        BufferedImage dest = img.getSubimage((cnt / 2) * img.getWidth() / 6, 0, img.getWidth() / 6, img.getHeight());
        g.drawImage(dest, x, y, birdSize * 3 / 2, birdSize * 3 / 2, null);
    }
}
