package client;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ViewAdmin extends View {
	private static final long serialVersionUID = 1L;

	public ViewAdmin(final JFrame frame, final Container c)
	{
		this.setLayout(new GridLayout(9, 2));
		this.setSize(new Dimension(700, 500));
		
		c.setLayout(new GridLayout(1,1));
		c.setSize(new Dimension(680, 450));
		
		JButton insertItem, goBack;
		
		JLabel itemCostPrompt, itemNumberPrompt, itemDescriptionPrompt,
			itemTaxPrompt, itemTotalPrompt;
		final JTextArea itemCost;
		final JTextArea itemNumber;
		final JTextArea itemDescription;
		final JTextArea itemTax;
		final JTextArea itemTotal;
		
		JLabel itemCategoryPrompt, itemTypePrompt, itemSizePrompt;
		final JComboBox<String> itemCategory;
		final JComboBox<String> itemType;
		final JComboBox<String> itemSize;
		
		goBack = new JButton("Go Back");
		insertItem = new JButton("Insert Item");

		goBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.removeAll();
				c.setSize(new Dimension(10, 10));
				c.setSize(new Dimension(700, 500));
				View v = new ViewMain(frame, c);
				c.add(v);
				frame.validate();
			}
		});

		itemCostPrompt = new JLabel("Cost: ");
		itemNumberPrompt = new JLabel("Number: ");
		itemDescriptionPrompt = new JLabel("Description: ");
		itemTaxPrompt = new JLabel("Tax: ");
		itemTotalPrompt = new JLabel("Total: ");
		
		itemCost = new JTextArea();
		itemNumber = new JTextArea();
		itemDescription  = new JTextArea();
		itemTax = new JTextArea();
		itemTotal = new JTextArea();
		
		itemCost.setBackground(Color.LIGHT_GRAY);
		itemNumber.setBackground(Color.GRAY);
		itemNumber.setForeground(Color.WHITE);
		itemDescription.setBackground(Color.LIGHT_GRAY);
		itemTax.setBackground(Color.GRAY);
		itemTax.setForeground(Color.WHITE);
		itemTotal.setBackground(Color.LIGHT_GRAY);

		itemCategoryPrompt = new JLabel("Category: ");
		itemCategory = new JComboBox<String>(FItem.categories);
		
		itemTypePrompt = new JLabel("Meat Type: ");
		itemType = new JComboBox<String>(FItem.mtypes);
		
		itemSizePrompt = new JLabel("Size: ");
		itemSize = new JComboBox<String>(FItem.sizes);
		
		this.add(itemCostPrompt);
		this.add(itemCost);

		this.add(itemNumberPrompt);
		this.add(itemNumber);
		
		this.add(itemDescriptionPrompt);
		this.add(itemDescription);
		
		this.add(itemTaxPrompt);
		this.add(itemTax);

		this.add(itemTotalPrompt);
		this.add(itemTotal);

		this.add(itemCategoryPrompt);
		this.add(itemCategory);
		
		this.add(itemTypePrompt);
		this.add(itemType);
		
		this.add(itemSizePrompt);	
		this.add(itemSize);
		


		insertItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cost = itemCost.getText();
				String number = itemNumber.getText();
				String description = itemDescription.getText();
				String tax = itemTax.getText();
				String total = itemTotal.getText();
				
				int category = itemCategory.getSelectedIndex();
				int type = itemType.getSelectedIndex();
				int size = itemSize.getSelectedIndex();
				
				double fcost, ftax, ftotal;
				int fnumber;
				try {
					fcost = Double.parseDouble(cost);
					fnumber = Integer.parseInt(number);
					ftax = Double.parseDouble(tax);
					ftotal = Double.parseDouble(total);
				} catch (Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Incomplete or invalid food entry.");
					return;
				}
				if (description.length() == 0) {
					JOptionPane.showMessageDialog(null, "Incomplete or invalid food entry.");
					return;
				}
				if (FItem.items != null)
				{
					boolean duplicate = false;
					for (int i = 0; i < FItem.items.size(); i++)
					{
						if (FItem.items.get(i).getName().equals(description))
						{
							duplicate = true;
							break;
						}
					}
					if (duplicate)
					{
						JOptionPane.showMessageDialog(null, "Duplicate entry.");
						return;
					}
				}
				
				
				new FItem(fcost, fnumber, category, description, type, size, ftax, ftotal);
			}
		});
	
		this.add(goBack);
		this.add(insertItem);
	}
}
