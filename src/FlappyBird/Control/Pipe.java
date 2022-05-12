package FlappyBird.Control;

import java.awt.*;

import static FlappyBird.Util.Constant.*;

public class Pipe {
    private PipeTest pipeUp;
    private PipeTest pipeDown;
    private Coin coin;
    private int Xlocation;
    private int Ylocation;

    public Pipe(int height) {
        this.Xlocation = frameWidth;
        this.Ylocation = height;
        this.pipeUp = new PipeTest(Xlocation, Ylocation - heightPipe);
        this.pipeDown = new PipeTest(Xlocation, Ylocation + 3 * birdSize);
        this.coin = new Coin(Xlocation + birdSize, Ylocation + birdSize);
    }

    public void update(Graphics g){
        if(Xlocation == 0 )Xlocation = frameWidth;
        Xlocation -= SPEED;
        pipeUp.setXYlocation(Xlocation, Ylocation - heightPipe);
        pipeDown.setXYlocation(Xlocation, Ylocation + 3 * birdSize);
        pipeUp.draw(g);
        pipeDown.draw(g);

        coin.setX(Xlocation + birdSize / 2);
        coin.draw(g);
    }

    public Coin getCoin() {
        return coin;
    }
}
