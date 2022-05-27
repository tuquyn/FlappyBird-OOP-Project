package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

import static FlappyBird.Util.Constant.*;

public class PipeTest {
  // Declare the type of variables in private scope
    private BufferedImage image;
    private int Xlocation;
    private int Ylocation;

  // Initialize PipeTest constructor

    public PipeTest(int xlocation, int ylocation) {
        this.image = Util.loadBufferedImage(PIPE_PATH);
        Xlocation = xlocation;
        Ylocation = ylocation;
    }


//    // Initialize a void data type setImage function with the input parameter image, width, height type int
//    public void setImage(BufferedImage image) {
//        this.image = image;
//        this.width = image.getWidth();
//        this.height = image.getHeight();
//    }

//  // Add velocity
//    public void addVelocity(double x, double y) {
//        this.Xvelocity += x;
//        this.Yvelocity += y;
//    }
    public  int getWidth()
    {
        return   65;
    }
    public  int getHeigth()
    {
        return   heightPipe - 3;
    }
public int getX() {
    return Xlocation + 18;
}

    public int getY() {
        return Ylocation;
    }



    public void draw(Graphics g) {
        g.drawImage(image, Xlocation, Ylocation, widthPipe, heightPipe, null);
//        g.drawRect(getX(),getY(),getWidth(),getHeigth());
    }

    public void setXYlocation(int xlocation,int ylocation) {
        Xlocation = xlocation;
        Ylocation = ylocation;
    }

    //  // Make boundary
//    public Rectangle2D getBoundary() {
//        return new Rectangle2D(X1, Y1, X2, Y2);
//    }
//
//    public boolean intersectsPipeTest(PipeTest s) {
//        return s.getBoundary().intersects(this.getBoundary());
//    }
//
//  // Update position by formula: velocity * time
//    public void update(double time) {
//        Xposition += Xvelocity * time;
//        Yposition += Yvelocity * time;
//    }
}
