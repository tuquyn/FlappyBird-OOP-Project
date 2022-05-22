package FlappyBird.Control;

import FlappyBird.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;

import static FlappyBird.Util.Constant.frameWidth;

public class GameOver extends Frame implements ActionListener {
    TextField tf;
    Button bthSave;


    public GameOver()
    {
        tf = new TextField();
        tf.setBounds(50, 50, 150, 20);
        bthSave = new Button("Save");
        bthSave.setBounds(50, 200, 50, 50);
        bthSave.addActionListener(this);
        add(bthSave);
        add(tf);
        setSize(300, 300);
        setLayout(null);
        setVisible(false);
    }
    public void Show(boolean isVisible)
    {
        setVisible(isVisible);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bthSave)
        {
            Game.score.NewScore(tf.getText());
            show(false);
        }
    }
    public void draw(Graphics g){
        try{
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/DJB Ransom Note.ttf");

            Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(13);
            g.setFont(font);
            g.drawString("Game Over", frameWidth / 2 , 100);
        }catch (Exception e) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.drawString("Game Over", frameWidth / 2, 100);
        }
    }
}
