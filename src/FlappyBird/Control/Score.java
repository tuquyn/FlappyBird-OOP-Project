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
    public int noScore;
    public int score;
    public List<String> scoreBoard;
    private  String pathScoreBoard = "scoreboard.txt";
    public Score() {
        noScore = 0;
        scoreBoard = new ArrayList<>();
        //SaveScoreBoard();
        score = 0;
        LoadScoreBoard();

    }
    public  void drawScoreBoard(Graphics g)
    {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        try{
            g.setColor(Color.blue);
            g.fillRect(630,330, buttonSize - 23, buttonSize - 35);
            g.setColor(Color.yellow);
            String str = scoreBoard.get(noScore);
            String point = str.substring(str.indexOf(":")+1, str.length());
            String name = (str.length() - point.length()  > 7 ? str.substring(0,7) + "..." : str.substring(0,str.indexOf(":")));
            g.drawString("No "+(noScore+1)+".",630,350);
            g.drawString(name,630,370);
            g.drawString(point,630,390);
        }catch(Exception ex){

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
        if( playerName.equals("")) playerName = "Playername";
        for(int i = 0; i<= scoreBoard.size();i++)
            if(i != scoreBoard.size())
        {
            String[] data = scoreBoard.get(i).split(":");
            String pName = data[0];
            int pScore = Integer.parseInt(data[1]);
            if(pScore <= score)
            {
                scoreBoard.add(i,playerName+":"+score);
                break;
            }
        }{
        if(scoreBoard.size() < 5){
            scoreBoard.add(scoreBoard.size(),playerName+":"+score);
        }
    }
        while (scoreBoard.size() > 5)
        {
            scoreBoard.remove(scoreBoard.size()-1);
        }
        SaveScoreBoard();
    }

    public int getBest(){
        String[] data = scoreBoard.get(0).split(":");
        int pScore = Integer.parseInt(data[1]);
        return pScore;
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
