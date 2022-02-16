import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.ArrayList;
import java.awt.Point;
/**
 * Creates a 5x5 grid of lights that starts with a random amount of moves made. The user
 * then must click different squares until all lights on the grid are turned off.
 *
 * @author Michael Scanlon, Dawson Bridger
 * @version Spring 2020
 */
public class LightsOut extends JFrame implements Runnable,ActionListener
{
    int totalClicks = 0;
    private JLabel clicks = new JLabel();
    private JLabel cheatList = new JLabel();
    private JButton[][] squares;
    private ArrayList<Point> cheats = new ArrayList<Point>();
    Random rand = new Random();
    /**
    The run method to set up the graphical user interface
     */
    @Override
    public void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Lights Out");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel gameWindow = new JPanel(new BorderLayout());
        JPanel game = new JPanel(new GridLayout(5,5));
        JPanel topSpace = new JPanel(new BorderLayout());
        gameWindow.add(game,BorderLayout.CENTER);
        gameWindow.add(topSpace,BorderLayout.NORTH);

        JButton reset = new JButton("Reset");
        reset.setName("Reset");
        reset.addActionListener(this);
        JButton cheat = new JButton("Cheats");
        cheat.setName("Cheats");
        cheat.addActionListener(this);
        squares = new JButton[5][5];
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                JButton currButton = new JButton();
                squares[i][j] = currButton;
                currButton.setBackground(Color.BLACK);
                currButton.setName("" + i + j);
                currButton.addActionListener(this);
                game.add(currButton);
            }
        }

        topSpace.add(reset,BorderLayout.EAST);
        topSpace.add(cheat, BorderLayout.WEST);
        topSpace.add(clicks, BorderLayout.SOUTH);
        topSpace.add(cheatList, BorderLayout.CENTER);
        clicks.setText("Clicks: " + totalClicks);

        frame.add(gameWindow);
        frame.setPreferredSize(new Dimension(500,500));
        frame.pack();
        frame.setVisible(true);

        makeMoves();
    }

    /**
     * Method that takes in a mouse click as a parameter and does an action
     * based on where the mouse was clicked.
     * 
     * @param e The position on the board where the mouse was clicked.
     */
    public void actionPerformed(ActionEvent e)
    {
        JButton current = (JButton)e.getSource();
        String name = current.getName();
        char columnChar = name.charAt(0);
        char rowChar = name.charAt(1);
        int column = Character.getNumericValue(columnChar);
        int row = Character.getNumericValue(rowChar);

        JButton chosen = new JButton();
        JButton up = new JButton();
        JButton right = new JButton();
        JButton left = new JButton();
        JButton down = new JButton();

        if(name.equals("Reset"))
        {
            cheats.clear();
            makeMoves();
            return;
        }
        if(name.equals("Cheats"))
        {
            cheatList.setText("Moves to win: " + cheats);
            return;
        }

        chosen = squares[column][row];
        changeColor(chosen);
        totalClicks++;
        clicks.setText("Clicks: " + totalClicks);
        try{
            up = squares[column-1][row];
            changeColor(up);
        }
        catch(ArrayIndexOutOfBoundsException i){
        }
        try{
            down = squares[column+1][row];
            changeColor(down);
        }
        catch(ArrayIndexOutOfBoundsException i){
        }
        try{
            left = squares[column][row-1];
            changeColor(left);
        }
        catch(ArrayIndexOutOfBoundsException i){
        }
        try{
            right = squares[column][row+1];
            changeColor(right);
        }
        catch(ArrayIndexOutOfBoundsException i){
        }
        gameOver();
    }
    
    /**
     * Method that simulates between 12 and 25 moves so that the player can access a list of moves to cheat.
     */
    public void makeMoves()
    {
        JButton chosen = new JButton();
        JButton up = new JButton();
        JButton right = new JButton();
        JButton left = new JButton();
        JButton down = new JButton();
        int howManyLoops = rand.nextInt(12) + 14;
        for(int j = 0; j < howManyLoops; j++)
        {
            int randColumn = rand.nextInt(5);
            int randRow = rand.nextInt(5);
            try{
                chosen = squares[randColumn][randRow];
                changeColor(chosen);
                cheats.add(new Point(randColumn,randRow));
            }
            catch(ArrayIndexOutOfBoundsException i){
            }
            try{
                up = squares[randColumn-1][randRow];
                changeColor(up);
            }
            catch(ArrayIndexOutOfBoundsException i){
            }
            try{
                down = squares[randColumn+1][randRow];
                changeColor(down);
            }
            catch(ArrayIndexOutOfBoundsException i){
            }
            try{
                left = squares[randColumn][randRow-1];
                changeColor(left);
            }
            catch(ArrayIndexOutOfBoundsException i){
            }
            try{
                right = squares[randColumn][randRow+1];
                changeColor(right);
            }
            catch(ArrayIndexOutOfBoundsException i){
            }
        }
        totalClicks = 0;
        clicks.setText("Clicks: " + totalClicks);
    }

    /**
     * Method that takes a JButton as input and if its black, turns it yellow and if its yellow,
     * turns it black.
     * @param a A button on the gameboard
     */
    public void changeColor(JButton a)
    {
        if(a.getBackground() == Color.BLACK)
        {
            a.setBackground(Color.YELLOW);
        }
        else
        {
            a.setBackground(Color.BLACK);
        }
    }

    /**
     * Method that checks if all the lights are out on the game board, meaning a win.
     */
    private void gameOver()
    {
        int numYellow = 0;
        for(int i = 0; i < squares.length; i++)
        {
            for(int j = 0; j < squares.length; j++)
            {
                if(squares[i][j].getBackground() == Color.YELLOW)
                {
                    numYellow++;
                }
            }
        }
        
        if(numYellow == 0)
        {
            JOptionPane.showMessageDialog(this, "You have won the game!  Turns to Win: " + totalClicks);
            makeMoves();
            cheats.clear();
        }
    }

    /**
     * Main method.
     */
    public static void main(String args[]){
        // The main method is responsible for creating a thread (more
        // about those later) that will construct and show the graphical
        // user interface.
        javax.swing.SwingUtilities.invokeLater(new LightsOut());
    }
}

