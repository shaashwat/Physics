import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PhysicsCalculator extends JFrame
{
	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
	
	private JLabel velocityInitialL, deltaTimeL, accelerationL, velocityL;
	private JTextField velocityInitialT, deltaTimeT, accelerationT, velocityT;
	private JButton calculateB, exitB;
	
	private CalculateButtonHandler cbHandler;
	private ExitButtonHandler ebHandler;
	
	public PhysicsCalculator()
	{
		velocityInitialL = new JLabel("Enter the initial velocity: ", SwingConstants.RIGHT);
		deltaTimeL = new JLabel("Enter the time: ", SwingConstants.RIGHT);
		accelerationL = new JLabel("Enter the acceleration: ", SwingConstants.RIGHT);
		velocityL = new JLabel("The velocity is: ", SwingConstants.RIGHT);
		velocityInitialT = new JTextField(10);
		deltaTimeT = new JTextField(10);
		accelerationT = new JTextField(10);
		velocityT = new JTextField(10);
		calculateB = new JButton("Calculate");
		cbHandler = new CalculateButtonHandler();
		calculateB.addActionListener(cbHandler);
		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);
		
		setTitle("Physics Calculator");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(5, 2));
		
		//left to right, top to bottom on grid
		pane.add(velocityInitialL);
		pane.add(velocityInitialT);
		pane.add(deltaTimeL);
		pane.add(deltaTimeT);
		pane.add(accelerationL);
		pane.add(accelerationT);
		pane.add(velocityL);
		pane.add(velocityT);
		pane.add(calculateB);
		pane.add(exitB);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class CalculateButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double initialvelocity, time, acceleration, velocity;
			
			initialvelocity = Double.parseDouble(velocityInitialT.getText());
			time = Double.parseDouble(deltaTimeT.getText());
			acceleration = Double.parseDouble(accelerationT.getText());
			velocity = initialvelocity+(time * acceleration);
			
			velocityT.setText("" + velocity);
		}
	}
	
	public class ExitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		PhysicsCalculator physcalc = new PhysicsCalculator();
	}
	
}