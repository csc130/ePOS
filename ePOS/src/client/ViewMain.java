package client;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ViewMain extends View {
	private static final long serialVersionUID = 1L;
	JTextField usernameArea;
	JPasswordField passwordArea;
	
	public ViewMain(final JFrame frame, final Container c)
	{
		JButton loginButton = new JButton("Login");
		
		JLabel logo = new JLabel("        Property of David Magnotti (ePOS)");
		logo.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 12));

		JLabel usernamePrompt = new JLabel("Username: ");
		JLabel passwordPrompt = new JLabel("Password: ");
		
		usernameArea = new JTextField("", 12);
		passwordArea = new JPasswordField("", 12);

		usernamePrompt.setFont(new Font("Serif", Font.PLAIN, 22));
		passwordPrompt.setFont(new Font("Serif", Font.PLAIN, 22));
		
		usernameArea.setFont(new Font("Serif", Font.PLAIN, 22));
		passwordArea.setFont(new Font("Serif", Font.PLAIN, 22));
		
		loginButton.setFont(new Font("Serif", Font.PLAIN, 36));


		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (usernameArea.getText().equalsIgnoreCase("admin") && 
						passwordArea.getText().equals("apass"))
				{
					c.removeAll();
					View v = new ViewAdmin(frame, c);
					c.add(v);
					frame.validate();				
				}
				else if (usernameArea.getText().equalsIgnoreCase("server") && 
						passwordArea.getText().equals("spass"))
				{
					if (FItem.items == null)
					{
						JOptionPane.showMessageDialog(null, "ERROR: No food entered; try adding some in admin first.");
						return;
					}
					c.removeAll();
					View v = new ViewServer(frame, c);
					c.add(v);
					frame.validate();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Invalid username or password.");
				}
			}
		});

		c.setLayout(new GridLayout(4, 2));
		c.add(usernamePrompt);
		c.add(usernameArea);
		c.add(passwordPrompt);
		c.add(passwordArea);
		c.add(loginButton);
		c.add(logo);
	}
}
