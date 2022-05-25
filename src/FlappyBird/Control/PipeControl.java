package FlappyBird.Control;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static FlappyBird.Util.Constant.*;

public class PipeControl {
    private ArrayList<Pipe> pipes;

    private int x, y , n;
    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    public PipeControl(){
        pipes = new ArrayList<>();
        init();
        Random rand = new Random();
        x = rand.nextInt(0, pipes.get(0).getYlocation() / FPS);
        y = rand.nextInt(0, (400 - pipes.get(0).getYlocation()) * 2 / 15);
        n = x + y + 3;
    }
    public void draw(Graphics g){
        for(int i = 0; i < pipes.size();) {
            Pipe pipe;
            try{
                pipe = pipes.get(i);
            }catch(Exception ex){
                init();
                return;
            }
            pipe.update(g);
            if(pipe.getXlocation() < -widthPipe) {
                pipes.remove(i);
            }else i++;
        }
        if(n-- == 0 && playGameState != gameOverState){
            int h = pipes.get(pipes.size() - 1).getYlocation();
            int h_new = h - FPS * x + 2 * FPS * y / 15;
            if(h_new <= birdSize * 2 || h_new >= frameHeight - birdSize * 5 / 2) pipes.add(new Pipe(200));
                else
            pipes.add(new Pipe(h_new));
            Random rand = new Random();
            try {
                x = rand.nextInt(1, pipes.get(pipes.size() - 1).getYlocation() / FPS);
                y = rand.nextInt(widthPipe * 15 / 2 / FPS * 2, (400 - pipes.get(pipes.size() - 1).getYlocation()) * 2 / 15);
                n = x + y + 3;
            }catch(Exception e){
                x = 2; y = 10;
                n = widthPipe / SPEED * 2;
            }
        }
    }
    public void init(){
        pipes.clear();
        Pipe p = new Pipe(100);
        pipes.add(p);
    }
}
