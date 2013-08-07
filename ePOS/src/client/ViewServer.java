package client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewServer extends View {
	private static final long serialVersionUID = 1L;
	final JLabel itemCostPrompt, itemNumberPrompt, itemDescriptionPrompt, itemTaxPrompt, 
	itemTotalPrompt, itemCategoryPrompt, itemTypePrompt, itemSizePrompt;

	@SuppressWarnings("rawtypes")
	public ViewServer(final JFrame frame, final Container c)
	{
		c.setLayout(new GridLayout(1, 2));
		
		JPanel details = new JPanel(new GridLayout(9, 1));
		JPanel foodPanel = new JPanel(new FlowLayout());
		
		itemCostPrompt = new JLabel("Cost: ");
		itemNumberPrompt = new JLabel("Number: ");
		itemDescriptionPrompt = new JLabel("Description: ");
		itemTaxPrompt = new JLabel("Tax: ");
		itemTotalPrompt = new JLabel("Total: ");
		itemCategoryPrompt = new JLabel("Category: ");
		itemTypePrompt = new JLabel("Meat Type: ");
		itemSizePrompt = new JLabel("Size: ");
		
		details.add(itemCostPrompt);
		details.add(itemNumberPrompt);
		details.add(itemDescriptionPrompt);
		details.add(itemTaxPrompt);
		details.add(itemTotalPrompt);
		details.add(itemCategoryPrompt);
		details.add(itemTypePrompt);
		details.add(itemSizePrompt);
		details.validate();
		c.add(details, BorderLayout.WEST);
		
		ArrayList<String> newItems = new ArrayList<String>();
		if (FItem.items != null)
		{
			for (int i = 0; i < FItem.items.size(); i++)
			{
				newItems.add(FItem.categories[FItem.items.get(i).getCategory()] + " - " + 
						FItem.items.get(i).getName());
			}
		}

		@SuppressWarnings("unchecked")
		final JList<String> foodItems = new JList(newItems.toArray());
		foodItems.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				FItem item = FItem.items.get(foodItems.getSelectedIndex());
				itemCostPrompt.setText("Cost: $" + item.getCost());
				itemNumberPrompt.setText("Number: " + item.getNumber());
				itemDescriptionPrompt.setText("Description: " + item.getName());
				itemTaxPrompt.setText("Tax: $" + item.getTax());
				itemTotalPrompt.setText("Total: $" + item.getTotal());
				itemCategoryPrompt.setText("Category: " + FItem.categories[item.getCategory()]);
				itemTypePrompt.setText("Meat Type: " + FItem.mtypes[item.getType()]);
				itemSizePrompt.setText("Size: " + FItem.sizes[item.getSize()]);
			}
		});
		
		JScrollPane foodItemsScroll = new JScrollPane(foodItems);
	
		foodPanel.add(foodItemsScroll);
		
		foodPanel.validate();
		c.add(foodPanel);
	}
}
