/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Validate_Purchase_Win extends myPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 200;
	public static final int FRAME_HEIGHT = 200;

	JLabel lbl = new JLabel("Are you Sure?");
	JButton yes_btn = new JButton("Yes");
	JButton no_btn = new JButton("No");

	private boolean purchase = false;
	private boolean recieved_input = false;

	public Validate_Purchase_Win() {
		frame = new JFrame("");
		lbl.setBounds(10,0,100,50);
		yes_btn.setBounds(10, 60, 70, 30);
		no_btn.setBounds(100, 60, 70, 30);

		yes_btn.addActionListener(this);
		no_btn.addActionListener(this);

		setLayout(null);
		JComponent[] elements = {lbl, yes_btn, no_btn};
		add_elements(this, elements);
	}

	public JButton getYesBtn()
	{
		frame.dispose();
		return yes_btn;
	}
	public JButton getNoBtn()
	{
		frame.dispose();
		return no_btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == yes_btn)
		{
			recieved_input = true;
			frame.dispose();
			purchase = true;
		}
		if(e.getSource() == no_btn)
		{
			recieved_input = true;
			frame.dispose();
			purchase = false;
		}
	}

	public boolean isPurchase() {
		return purchase;
	}

	public boolean isRecieved_input() {
		return recieved_input;
	}
}
