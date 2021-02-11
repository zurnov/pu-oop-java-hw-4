import javafx.scene.layout.GridPane;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameBoard {

    private final Square[][] c1squares = new Square[8][8];
    private JPanel board;

    GameBoard() {
        initializeGui();
    }

    /**
     * Placing the Green/Blue/Yellow boxes.
     */
    public final void initializeGui() {
        Random random = new Random();
        int greenBoxCounter = 1;
        int blueBoxCounter = 1;
        int randomNumber;

        for (int i = 0; i < c1squares.length; i++) {
            for (int j = 0; j < c1squares[i].length; j++) {

                Square square = new Square();

                randomNumber = random.nextInt(100);
                if (randomNumber < 30 && greenBoxCounter <= 8) {
                    greenBoxCounter++;
                    square.setBackground(Color.green);
                } else if (randomNumber < 50 && blueBoxCounter <= 5) {
                    blueBoxCounter++;
                    square.setBackground(Color.blue);
                } else {
                    square.setBackground(Color.red);
                }


                c1squares[i][j] = square;
            }
        }
        yellowSquareGenerator();
        board = new BoardPanel(c1squares);
        board.setBorder(new EmptyBorder(5, 5, 5, 5));

    }

    public final JComponent getGui() {
        return board;
    }

    /**
     * Generating the position of the Yellow square.
     */
    void yellowSquareGenerator() {
        int randomNumber;
        Random random = new Random();
        randomNumber = random.nextInt(4);
        switch (randomNumber) {
            case 0:
                c1squares[0][0] = new Square();
                c1squares[0][0].setBackground(Color.yellow);
                break;
            case 1:
                c1squares[0][7] = new Square();
                c1squares[0][7].setBackground(Color.yellow);
                break;
            case 2:
                c1squares[7][0] = new Square();
                c1squares[7][0].setBackground(Color.yellow);
                break;
            case 3:
                c1squares[7][7] = new Square();
                c1squares[7][7].setBackground(Color.yellow);
                break;
        }
    }

    private class BoardPanel extends JPanel {

        Square[][] squares;

        public BoardPanel(final Square[][] squares) {

            this.squares = squares;

        }

        /**
         * Method that paints the components of the board
         *
         * @param g Object of graphics
         */
        @Override
        public void paintComponent(final Graphics g) {

            super.paintComponent(g);

            int width = getWidth();
            int height = getHeight();

            for (int i = 0; i < squares.length; i++) {
                for (int j = 0; j < squares[i].length; j++) {

                    Square currentSquare = squares[i][j];

                    System.out.println("Managing square " + i + "  " + j);

                    g.setColor(currentSquare.getBackground());
                    g.fillRect(i * width / squares.length, j * height / squares.length, width / squares.length,
                            height / squares.length);

                }
            }


        }


    }

    private class Square {

        
        Color background;



        public Color getBackground() {
            return background;
        }

        public void setBackground(final Color background) {
            this.background = background;
        }

    }


}