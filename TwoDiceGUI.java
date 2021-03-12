// this app needs the Class Die.Java in the root directory

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TwoDiceGUI extends JFrame implements ActionListener
{

	Font mainFont = new Font("Impact", Font.PLAIN, 26);
	JLabel title = new JLabel("Two Dice Game");
	JLabel playerLabel = new JLabel("The player's roll is: ");
	JLabel comLabel = new JLabel("The computer's roll is: ");
	JLabel result = new JLabel("");
	JTextField pRoll = new JTextField(4);
	JTextField cRoll = new JTextField(4);
	JButton button = new JButton("Click to Play");

	// custom constructor for this class
	public TwoDiceGUI()
	{
		super("Two Dice Game");
		setBounds(450, 450, 300, 240);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout());
		setResizable(false);

		title.setFont(mainFont);
		result.setFont(mainFont);
		button.setBackground(Color.BLACK);
		button.setBackground(Color.WHITE);

		add(title);
		add(playerLabel);
		add(pRoll);
		add(comLabel);
		add(cRoll);
		add(button);
		add(result);

		button.addActionListener(this);
	}
	// event handling method
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// create two objects from the Die class
		Die playerDie = new Die();
		Die computerDie = new Die();
		String outcome;

		// decide what the outcome of the game should be based on the values of the two Die objects
		if(playerDie.getDieValue() > computerDie.getDieValue())
		{
			outcome = "The player wins!";
			result.setForeground(Color.GREEN);
		}
		else if(playerDie.getDieValue() < computerDie.getDieValue())
		{
			outcome = "The computer wins!";
			result.setForeground(Color.RED);
		}
		else
		{
			outcome = "we have a tie.";
			result.setForeground(Color.BLUE);
		}	

	// output to the GUI
	pRoll.setText("" + playerDie.getDieValue());
	cRoll.setText("" + computerDie.getDieValue());
	result.setText(outcome);
	button.setText("Play Again?");
	}

	public static void main(String[] args) 
	{
		TwoDiceGUI frame = new TwoDiceGUI();
	}
}