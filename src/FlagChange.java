/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class FlagChange extends myPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 820;
	public static final int FRAME_HEIGHT = 600;

	private String flag = null;

	//data structures
	private ArrayList<Water_V> w_vehicles = null;		//agency ship vehicle Array

	static final int NUM_OF_FLAGS = 7;

	private JComboBox<ImageIcon> flags = new JComboBox<ImageIcon>();

	//flag image array
	private ImageIcon[] flag_images = new ImageIcon[NUM_OF_FLAGS];

	private JLabel choose_flag_lbl = new JLabel("Choose Desired Flag!");

	private JButton flag_choose_btn = new JButton("Choose");
	private JButton back_btn = new JButton("Back");

	public FlagChange()
	{		
		frame = new JFrame("Change Flag");

		flag_choose_btn.addActionListener(this);
		back_btn.addActionListener(this);

		//setting up flag images sources
		for(int i=1;i<NUM_OF_FLAGS + 1;i++)
			flag_images[i-1] = new ImageIcon("Images\\Flags\\f" + i + ".jpg");

		setLayout(null);		
		setBackground(Color.CYAN);

		for(int i=0;i<NUM_OF_FLAGS;i++)
			flags.addItem(flag_images[i]);	

		back_btn.setBounds(600, 200, 100, 220);
		flag_choose_btn.setBounds(450, 200, 100, 220);
		flags.setBounds(100,200,300,220);
		choose_flag_lbl.setBounds(180, -50, 600, 200);
		choose_flag_lbl.setFont(new Font("Courier", Font.BOLD,36));
		JComponent[] flag_choose_elements = {flag_choose_btn, flags, back_btn, choose_flag_lbl};
		add_elements(this, flag_choose_elements);
	}

	public void exit()
	{
		frame.dispose();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == flag_choose_btn)
		{
			exit();
			if(flags.getSelectedItem().toString().contains("f1"))
				flag = "Israel";
			else if(flags.getSelectedItem().toString().contains("f2"))
				flag = "Germany";
			else if(flags.getSelectedItem().toString().contains("f3"))
				flag = "USA";
			else if(flags.getSelectedItem().toString().contains("f4"))
				flag = "Italy";
			else if(flags.getSelectedItem().toString().contains("f5"))
				flag = "Greece";
			else if(flags.getSelectedItem().toString().contains("f6"))
				flag = "PIRATE";
			else
				flag = "Sumalia";
			new SwingWorker<Void, Void>() {

				@Override
				protected Void doInBackground() throws Exception {
					Info_Win update_db = new Info_Win("Updating database� Please wait");
					update_db.makeFrame(250, 100);
					Random rand = new Random();
					Thread.sleep(rand.nextInt(5000)+3000);
					update_db.exit();
					for(int i=0;i<w_vehicles.size();i++)
						w_vehicles.get(i).setFlag(flag);
					alive = false;
					return null;
				}
			}.execute();
		}
		if(e.getSource() == back_btn)
		{
			alive = false;
			frame.dispose();
		}
	}
	public void updateVehicles(ArrayList<Water_V> w_vehicles)
	{
		this.w_vehicles = w_vehicles;
	}
}
