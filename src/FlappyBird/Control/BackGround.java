package FlappyBird.Control;

import FlappyBird.Util.*;

import java.awt.*;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class BackGround {
    private static final BufferedImage backGroundImg;
    private final int speed = SPEED;
    private int layerX;
    static {
        backGroundImg = Util.loadBufferedImage(BG_PATH);
        assert backGroundImg != null;
    }
    public BackGround(){
        this.layerX = 0;
    }
    public void draw(Graphics g){
        int width = backGroundImg.getWidth();

        int count = 2;
        // we need at least 2 pics bg to make it like moving

        for(int i = 0; i < count; i++){
            g.drawImage(backGroundImg, width * i - layerX, 0, null);
        }
        move();
    }
    private void move(){
        layerX += this.speed;
        if(layerX > backGroundImg.getWidth())
            layerX = 0;
    }

}
