package FlappyBird.Control;

import javazoom.jl.player.Player;

import java.io.FileInputStream;

public class Sound extends Thread{
    private String fileLocation;
    private boolean loop;
    private Player prehravac;

    public Sound(String fileLocation, boolean loop) {
        this.fileLocation = fileLocation;
        this.loop = loop;
    }
    public void initialize(Sound p){
        this.fileLocation = p.fileLocation;
        this.loop = p.loop;
        this.prehravac = p.prehravac;
    }

    public void run() {

        try {
            do {
                FileInputStream buff = new FileInputStream(fileLocation);
                prehravac = new Player(buff);
                prehravac.play();
            } while (loop);
        } catch (Exception ioe) {
            System.out.println(ioe);
        }
        close();
    }

    public void close(){
        loop = false;
        prehravac.close();
        this.interrupt();
    }
}