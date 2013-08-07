package client;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Main {
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		frame.setTitle("Welcome to ePOS");
		frame.setVisible(true);
		frame.setSize(new Dimension(700, 500));
		
		Container c = new Container();
		c.setLayout(new GridLayout(3, 2));
		c.setSize(new Dimension(300, 200));
		frame.add(c);
				
		View v = new ViewMain(frame, c);
		frame.add(v);
		frame.validate();
		
		frame.show();
	}
}
