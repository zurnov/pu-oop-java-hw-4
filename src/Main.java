import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 * @author Dimitar Zurnov
 */
public class Main {

    public static void main(String[] args) {

        GameBoard gb = new GameBoard();
        JFrame frame = new JFrame();
        frame.add(gb.getGui());
        frame.setLocationByPlatform(true);
        frame.setMinimumSize(frame.getSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,900));
        frame.setMinimumSize(new Dimension(900,900));
        frame.setLocation(50,50);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }

}