package FlappyBird.Control;

import FlappyBird.Game;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Random;

import static FlappyBird.Util.Constant.*;

public class GameOver extends JFrame implements ActionListener {
    TextField tf;
    Button bthSave;


    public GameOver() {
//        JLabel label1 = new JLabel("Test");
//        label1.setLocation(50, 50);
//        add(label1);
//        add(new JLabel("Hello World"), BorderLayout.CENTER);
        tf = new TextField();
        tf.setBounds(100, 50, 150, 20);
        bthSave = new Button("Save");
        bthSave.setBounds(50, 200, 50, 50);
        bthSave.addActionListener(this);
        add(bthSave);
        add(tf);
        setSize(300, 300);
        setLocation(frameX + frameWidth / 2 - 150, frameY + frameHeight / 2 - 50);

        setIconImage(img.getImage());
        setLayout(null);
        setResizable(false);
        setVisible(false);


        setUndecorated(true);
        getContentPane().setBackground(Color.CYAN);
        getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
        MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void Show(boolean isVisible) {
        setVisible(isVisible);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bthSave) {
            Game.score.NewScore(tf.getText());
            show(false);
        }
    }

    private boolean i = true;
    private int x = frameWidth;

    public void draw(Graphics g) {
        Random rand = new Random();
        float red = rand.nextFloat();
        float green = rand.nextFloat();
        float blue = rand.nextFloat();
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);

        try {
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/DJB Ransom Note.ttf");
            Font font;
            if (i) {
                font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(98f);
            } else {
                font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(100f);
            }
            g.setFont(font);
            g.drawString("Game Over", frameWidth / 3 - font.getSize(), font.getSize() * 2);
        } catch (Exception e) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 100));
            g.drawString("Game Over", frameWidth / 2, 100);
        }


        try {
            String str = "PRESS space TO play AGAIN";
            g.setColor(Color.WHITE);
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/UchronyCube-Bold-FFP.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(30f);
            g.setFont(font);
            g.drawString(str, frameWidth / 4 - font.getSize() * 2, frameHeight - font.getSize() * 2);
        } catch (Exception e) {
        }

        try {
            String str = "We showed up!";
            g.setColor(Color.black);
            InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("resources/Wall Notes.otf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(30f);
            g.setFont(font);
            g.drawString(str, x, 55);
            x -= SPEED;
            if (x < -SPEED * 2) x = frameWidth + SPEED;
        } catch (Exception e) {
        }
        i = !i;
    }

    class MyDefaultMetalTheme extends DefaultMetalTheme {
        public ColorUIResource getWindowTitleInactiveBackground() {
            return new ColorUIResource(java.awt.Color.orange);
        }

        public ColorUIResource getWindowTitleBackground() {
            return new ColorUIResource(java.awt.Color.orange);
        }

        public ColorUIResource getPrimaryControlHighlight() {
            return new ColorUIResource(java.awt.Color.orange);
        }

        public ColorUIResource getPrimaryControlDarkShadow() {
            return new ColorUIResource(Color.CYAN);
        }

        public ColorUIResource getPrimaryControl() {
            return new ColorUIResource(Color.orange);
        }

        public ColorUIResource getControlHighlight() {
            return new ColorUIResource(Color.orange);
        }

        public ColorUIResource getControlDarkShadow() {
            return new ColorUIResource(Color.orange);
        }

        public ColorUIResource getControl() {
            return new ColorUIResource(Color.orange);
        }
    }
//    http://www.java2s.com/Tutorials/Java/Swing_How_to/JFrame/Change_the_color_of_titlebar_in_JFrame.htm
}