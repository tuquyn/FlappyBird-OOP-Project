package FlappyBird.Control;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.PortUnreachableException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static FlappyBird.Util.Constant.*;


public class Score {
    public int score;
    public List<String> scoreBoard;
    private  String pathScoreBoard = "scoreboard.txt";
    public Score()
    {
        scoreBoard = new ArrayList<>();
        //SaveScoreBoard();
        score=0;
        LoadScoreBoard();

    }
    public  void drawScoreBoard(Graphics g)
    {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        int y = 100;
        for(int i = 0; i < scoreBoard.size(); i++)
        {
            g.drawString((i+1)+". "+ scoreBoard.get(i),frameWidth/2 , y);
            y+=22;
        }
    }
    public void drawScore(Graphics g){
        try{
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/Mas Bro Demo.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(48f);
            g.setFont(font);
            g.drawString("Score: "+score, frameWidth/2 , 80);
        }catch (Exception e) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g.drawString("Score: " + score, frameWidth / 2, 80);
        }
    }
    public void NewScore(String playerName)
    {
        for(int i = 0; i< scoreBoard.size();i++)
        {
            String[] data = scoreBoard.get(i).split(":");
            String pName = data[0];
            int pScore = Integer.parseInt(data[1]);
            if(pScore <= score || true) // update later
            {
                scoreBoard.add(i,playerName+":"+score);
                break;
            }
        }
        while (scoreBoard.size() > 10)
        {
            scoreBoard.remove(scoreBoard.size()-1);
        }
        SaveScoreBoard();
    }
    public void SaveScoreBoard() {
        try{
            File file = new File(pathScoreBoard);
            if(!file.exists())
            {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(pathScoreBoard);

            fw.write((String.join("-",scoreBoard)));
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public  void LoadScoreBoard()
    {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(pathScoreBoard));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] data = new String(encoded, Charset.defaultCharset()).split("-");
        for(int i = 0; i< data.length;i++)
        {
            scoreBoard.add(data[i]);
        }


    }


}
