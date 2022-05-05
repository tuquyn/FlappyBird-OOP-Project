package FlappyBird.Control;

import FlappyBird.Util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.Rectangle2D;

import static FlappyBird.Util.Constant.*;

public class PipeTest {
  // Declare the type of variables in private scope
    private BufferedImage image;
    private double Xposition;
    private double Yposition;
    private double Xvelocity;
    private double Yvelocity;
    private double width;
    private double height;
  
  // Initialize PipeTest constructor with no arguments
    public PipeTest() {
        this.Xposition = 0;
        this.Yposition = 0;
        this.Xvelocity = 0;
        this.Yvelocity = 0;
    }
  
  // Initialize a void data type setImage function with the input parameter image, width, height type int
    public void setImage(BufferedImage image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public void resizeImage(String filepath, int width, int height) {
        BufferedImage toReturn = new BufferedImage(filepath, width, height, false, false);
        setImage(toReturn);
    }
  
  // Set position of X and Y 
    public void setXYPosition(double Xposition, double Yposition) {
        this.Xposition = Xposition;
        this.Yposition = Yposition;
    }

    public double getXPosition() {
        return Xposition;
    }

    public double getYPosition() {
        return Yposition;
    }
  
  // Set velocity into function
    public void setVelocity(double Xvelocity, double Yvelocity) {
        this.Xvelocity = Xvelocity;
        this.Yvelocity = Yvelocity;
    }
  
  // Add velocity 
    public void addVelocity(double x, double y) {
        this.Xvelocity += x;
        this.Yvelocity += y;
    }

    public double getXVelocity() {
        return Xvelocity;
    }

    public double getYVelocity() {
        return Yvelocity;
    }

    public double getWidth() {
        return width;
    }
  
    public void render(Graphics g) {
        g.drawImage(image, Xposition, Yposition);
    }
  
  // Make boundary
    public Rectangle2D getBoundary() {
        return new Rectangle2D(Xposition, Yposition, width, height);
    }

    public boolean intersectsPipeTest(PipeTest s) {
        return s.getBoundary().intersects(this.getBoundary());
    }
  
  // Update position by formula: velocity * time 
    public void update(double time) {
        Xposition += Xvelocity * time;
        Yposition += Yvelocity * time;
    }
}
