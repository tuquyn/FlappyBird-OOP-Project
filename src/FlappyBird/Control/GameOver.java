package FlappyBird.Control;

import FlappyBird.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

}
