import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class TicTacToe implements ActionListener
{
    JFrame frame = new JFrame();
    JPanel textPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    int chance_flag = 0;
    Random random = new Random();
    boolean playerMove;

    // Creating class constructor for creating grid
    TicTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(224, 247, 250));
        frame.setTitle("TIC TAC TOE GAME");
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(0,121,107));
        textfield.setForeground(Color.white);
        textfield.setFont(new Font("Arial", Font.BOLD, 50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic Tac Toe Game in Swing");
        textfield.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.setPreferredSize(new Dimension(500,100));
        textPanel.setBackground(new Color(33,150,243));

        buttonPanel.setLayout(new GridLayout(3, 3,5,5));
        buttonPanel.setBackground(new Color(255, 255, 255));

        for (int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 60));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(new Color(224,224,224));
            buttons[i].setMargin(new Insets(0,0,0,0));
        }

        textPanel.add(textfield);
        frame.add(textPanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        startGame();
    }

    // Creating method to start the game and decide the chance
    public void startGame()
    {
        try
        {
            textfield.setText("Loading....");
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        int chance=random.nextInt(100);

        if (chance%2 == 0)
        {
            playerMove = true;
            textfield.setText("Player X turn");
            textfield.setBackground(new Color(0,121,107));
        }
        else
        {
            playerMove = false;
            textfield.setText("Player O turn");
            textfield.setBackground(new Color(211,47,47));
        }
    }

    public void gameOver(String s)
    {
        chance_flag = 0;
        Object[] option={"Restart","Exit"};
        int n=JOptionPane.showOptionDialog(frame, "Game Over\n"+s,"Game Over", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
        frame.dispose();
        if(n==0)
        {
            new TicTacToe();
        }

    }

    // Creating method for checking winning conditions
    public void matchCheck()
    {
        if ((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X")))
        {
            xWins(0, 1, 2);
        }
        else if ((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X")))
        {
            xWins(0, 4, 8);
        }
        else if ((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X")))
        {
            xWins(0, 3, 6);
        }
        else if ((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X")))
        {
            xWins(1, 4, 7);
        }
        else if ((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X")))
        {
            xWins(2, 4, 6);
        }
        else if ((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X")))
        {
            xWins(2, 5, 8);
        }
        else if ((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X")))
        {
            xWins(3, 4, 5);
        }
        else if ((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X")))
        {
            xWins(6, 7, 8);
        }

        else if ((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O")))
        {
            oWins(0, 1, 2);
        }
        else if ((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O")))
        {
            oWins(0, 3, 6);
        }
        else if ((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O")))
        {
            oWins(0, 4, 8);
        }
        else if ((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O")))
        {
            oWins(1, 4, 7);
        }
        else if ((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O")))
        {
            oWins(2, 4, 6);
        }
        else if ((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O")))
        {
            oWins(2, 5, 8);
        }
        else if ((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O")))
        {
            oWins(3, 4, 5);
        } else if ((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O")))
        {
            oWins(6, 7, 8);
        }
        else if(chance_flag==9)
        {
            textfield.setText("Game Draw!!");
            textfield.setBackground(new Color(158,158,158));
            gameOver("Game Draw!!");
        }
    }

    // Method to print that Player X wins
    public void xWins(int x1, int x2, int x3)
    {
        buttons[x1].setBackground(Color.YELLOW);
        buttons[x2].setBackground(Color.YELLOW);
        buttons[x3].setBackground(Color.YELLOW);

        for (int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player X wins");
        gameOver("Player X Wins");
    }

    // Method to print that Player O wins
    public void oWins(int x1, int x2, int x3)
    {
        buttons[x1].setBackground(Color.YELLOW);
        buttons[x2].setBackground(Color.YELLOW);
        buttons[x3].setBackground(Color.YELLOW);

        for (int i = 0; i < 9; i++)
        {
            buttons[i].setEnabled(false);
        }
        textfield.setText("Player O Wins");
        gameOver("Player O Wins");
    }

    // Method for performing action after every turn
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i = 0; i < 9; i++)
        {
            if (e.getSource() == buttons[i])
            {
                if (playerMove)
                {
                    if (buttons[i].getText().isEmpty())
                    {
                        buttons[i].setForeground(new Color(0, 188, 255));
                        buttons[i].setText("X");
                        playerMove = false;
                        textfield.setText("O turn");
                        textfield.setBackground(new Color(211,47,47));
                        chance_flag++;
                        matchCheck();
                    }
                }
                else
                {
                    if (buttons[i].getText().isEmpty())
                    {
                        buttons[i].setForeground(new Color(255, 87, 34));
                        buttons[i].setText("O");
                        playerMove = true;
                        textfield.setText("X turn");
                        textfield.setBackground(new Color(0,121,107));
                        chance_flag++;
                        matchCheck();
                    }
                }
            }
        }
    }
}

// Driver code
public class Main
{
    public static void main(String[] args)
    {
        new TicTacToe();
    }
}