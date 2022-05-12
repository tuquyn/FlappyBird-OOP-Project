package FlappyBird.Control;

import java.awt.*;
import java.util.ArrayList;

public class PipeControl {
    private ArrayList<Pipe> pipes;

    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    public PipeControl(){
        pipes = new ArrayList<>();
        init();
    }
    public void draw(Graphics g){
        for(Pipe pipe : pipes) {
            pipe.update(g);
        }
    }
    public void init(){
        Pipe p = new Pipe(100);
        pipes.add(p);
    }
}
