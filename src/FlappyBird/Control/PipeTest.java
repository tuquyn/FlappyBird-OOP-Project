import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PipeTest {
  // Declare the type of variables in private scope
    private Image image;
    private double Xposition;
    private double Yposition;
    private double Xvelocity;
    private double Yvelocity;
    private double width;
    private double height;
  
  
    public PipeTest() {
        this.Xposition = 0;
        this.Yposition = 0;
        this.Xvelocity = 0;
        this.Yvelocity = 0;
    }

    public void setImage(Image image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public void resizeImage(String filepath, int width, int height) {
        Image toReturn = new Image(filepath, width, height, false, false);
        setImage(toReturn);
    }

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

    public void setVelocity(double Xvelocity, double Yvelocity) {
        this.Xvelocity = Xvelocity;
        this.Yvelocity = Yvelocity;
    }

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

    public void render(GraphicsContext gc) {
        gc.drawImage(image, Xposition, Yposition);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(Xposition, Yposition, width, height);
    }

    public boolean intersectsPipeTest(PipeTest s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public void update(double time) {
        Xposition += Xvelocity * time;
        Yposition += Yvelocity * time;
    }
}
