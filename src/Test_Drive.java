/*
Maya Rozenberg - 313381600
Doron Shpitzer -313262594
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Test_Drive extends myPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 280;
	public static final int FRAME_HEIGHT = 300;

	private T_Vehicle vehicle_tested;

	JLabel title_lbl = new JLabel("Test Driving!");

	private JButton finish_drive_btn = new JButton("Drive");

	private JTextField distance = new JTextField("0");

	public Test_Drive(T_Vehicle vehicle_tested) {
		frame = new JFrame("Test Drive");
		this.vehicle_tested = vehicle_tested;

		setLayout(null);		
		setBackground(Color.red);

		finish_drive_btn.addActionListener(this);

		title_lbl.setBounds(20, 0, 250, 100);
		title_lbl.setFont(new Font("Courier", Font.BOLD,30));
		finish_drive_btn.setBounds(20, 150, 200, 100);
		finish_drive_btn.setFont(new Font("Courier", Font.BOLD,20));
		distance.setBounds(90, 90, 70, 50);
		JComponent[] flag_choose_elements = {title_lbl, finish_drive_btn, distance};
		add_elements(this, flag_choose_elements);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == finish_drive_btn)
		{
			if(isValidField(distance))
			{
				title_lbl.setText("<html>Vehicle Already Driving, Please Wait!</html>");
				title_lbl.setFont(new Font("Courier", Font.BOLD,14));
				new SwingWorker<Void, Void>(){
					@Override
					protected Void doInBackground() throws Exception {
						synchronized (vehicle_tested) {
							title_lbl.setFont(new Font("Courier", Font.BOLD,24));
							title_lbl.setText("Driving...");
							try {
								Thread.sleep(100*Integer.parseInt(distance.getText()));
							} catch (NumberFormatException | InterruptedException e1) {
								e1.printStackTrace();
							}
							exit();
							Info_Win update_db = new Info_Win("Updating database� Please wait");
							update_db.makeFrame(Info_Win.FRAME_WIDTH,Info_Win.FRAME_HEIGHT);
							Random rand = new Random();
							try {
								Thread.sleep(rand.nextInt(5000)+3000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							update_db.exit();
						}
						return null;
					}				
				}.execute();
			}
		}
	}
	public void exit()
	{
		vehicle_tested.Travel_Distance(Integer.parseInt(distance.getText()));
		frame.dispose();
		alive = false;
	}
	public JButton Drive() {
		return finish_drive_btn;
	}
}
