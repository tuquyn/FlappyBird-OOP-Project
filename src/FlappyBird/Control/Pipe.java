public class Pipe {
    private PipeTest pipe;
    private double Xlocation;
    private double Ylocation;
    private double height;
    private double width;

    public Pipe(boolean isFaceUp, int height) {
        this.pipe = new PipeTest();
        this.pipe.resizeImage(isFaceUp ? "/resources/wood.png" : "/resources/wood.png", 70, height);
        this.width = 80;
        this.height = height;
        this.Xlocation = 500;
        this.Ylocation = isFaceUp? 600 - height : 0;
        this.pipe.setXYPosition(Xlocation, Ylocation);
    }

    public PipeTest getPipe() {
        return pipe;
    }
}
