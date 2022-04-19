package FlappyBird.Control;

import java.awt.*;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class Cloud {
    private int x;
    private int y;
    private BufferedImage img;
    public Cloud(int x, int y, BufferedImage img){
        this.x = x;
        this.y = y;
        this.img = img;
    }
    public void draw(Graphics g){
        this.x -= SPEED*3/2;
        g.drawImage(img, x, y, frameWidth / 10, frameHeight / 10, null);
        if(this.x <= -1 * img.getWidth())
            this.x = frameWidth;
    }
}
