/*
Maya Rozenberg - 313381600
Doron Shpitzer -313262594
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.*;

public class Main_Menu extends myPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 820;
	public static final int FRAME_HEIGHT = 600;

	private Inventory_Report inventory_report = null;

	//Locks for test drive
	private ReentrantLock airLock = new ReentrantLock();
	private ReentrantLock landLock = new ReentrantLock();
	private ReentrantLock waterLock = new ReentrantLock();

	//data structures
	private ArrayList<T_Vehicle> vehicles = new ArrayList<T_Vehicle>();		//Agency vehicle Array
	private ArrayList<Water_V> w_vehicles = new ArrayList<Water_V>();		//agency ship vehicle Array
	private ArrayList<T_Vehicle> tmp_vehicles = new ArrayList<>();					//temporary vehicle array to hold needed objects

	//Panels
	private JPanel main_menu_panel = new JPanel();
	private JPanel vehicles_panel = new JPanel();
	private JPanel scroll_pane_container = new JPanel();	

	private JScrollPane scroll_pane;

	//labels
	private JLabel title_lbl = new JLabel("Welcome To the Best Vehicle Agency Ever!");
	private JLabel choose_vehicle_lbl = new JLabel("These Are Our Vehicles:");
	private JLabel vehicle_info = new JLabel();
	private JLabel pick_title_lbl = new JLabel("<html>"+ "Chosen Vehicle:" +"</html>");
	private JLabel pick_lbl = new JLabel();
	private JLabel[] vehicle_lbls = null;

	//JScrollPane vehicle_scroll_pane = new JScrollPane();

	//buttons
	private JButton add_vehicles_btn = new JButton("<html>"+ "Add Vehicles" +"</html>");
	private JButton buy_btn = new JButton("<html>"+ "Buy Vehicle" +"</html>");
	private JButton test_drive_btn = new JButton("<html>"+ "Test Drive" +"</html>");
	private JButton reset_distance_btn = new JButton("<html>"+ "Reset Distances" +"</html>");
	private JButton flag_change_btn = new JButton("<html>"+ "Change Flags" +"</html>");
	private JButton exit_btn = new JButton("Exit");
	private JButton get_report = new JButton("Get Full Report");

	//user vehicle pick indicator
	private int pick;

	//mouse listener for vehicles
	private MouseListener mouse_listener;

	public Main_Menu()
	{		
		frame = new JFrame("Vehicle Agency");
		//adding action listeners to btns
		add_vehicles_btn.addActionListener(this);
		buy_btn.addActionListener(this);
		reset_distance_btn.addActionListener(this);
		test_drive_btn.addActionListener(this);
		flag_change_btn.addActionListener(this);
		get_report.addActionListener(this);

		//setting up the mouse listener
		mouse_listener = new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				for(int i=0;i<vehicles.size();i++)
				{
					if(e.getSource() == vehicle_lbls[i])
					{
						vehicle_info.setText(null);
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				for(int i=0;i<vehicles.size();i++)
				{
					if(e.getSource() == vehicle_lbls[i])
					{
						vehicle_info.setText("<html>"+ vehicles.get(i).toString() +"</html>");
					}
				}

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				for(int i=0;i<vehicles.size();i++)
				{
					if(e.getSource() == vehicle_lbls[i])
					{
						buy_btn.setEnabled(true);
						test_drive_btn.setEnabled(true);
						pick = i;
						pick_lbl.setIcon(vehicle_lbls[i].getIcon());
					}
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}
		};

		//setting up panels
		main_menu_panel.setLayout(null);
		main_menu_panel.setBackground(Color.YELLOW);

		vehicles_panel.setLayout(new FlowLayout());
		vehicles_panel.setBackground(Color.YELLOW);

		scroll_pane_container.setLayout(new FlowLayout());

		//setting up class details
		setSize(1280,980);
		setBorder(BorderFactory.createDashedBorder(Color.BLACK));           
		setLayout(new BorderLayout());

		//----------------setting up panel components------------------------------------------------------------------------
		title_lbl.setFont(new Font("Courier", Font.BOLD,24));
		title_lbl.setBounds(10,-80,1000,200);

		choose_vehicle_lbl.setFont(new Font("Courier", Font.BOLD,20));
		choose_vehicle_lbl.setBounds(10,-40,1000,200);

		vehicle_info.setBorder(BorderFactory.createLineBorder(Color.BLACK));  
		vehicle_info.setFont(new Font("Courier", Font.BOLD,16));
		vehicle_info.setBounds(4,340,800,80);

		pick_title_lbl.setBounds(10,420, 50,50);
		pick_lbl.setBounds(73, 430, 80, 80);

		buy_btn.setBounds(180,430,120,40);
		test_drive_btn.setBounds(180,470,120,40);
		reset_distance_btn.setBounds(310,430,130,80);
		flag_change_btn.setBounds(450,430,130,80);
		add_vehicles_btn.setBounds(590,430,130,80);
		exit_btn.setBounds(700, 0, 100, 50);
		get_report.setBounds(180, 515, 540, 40);
		buy_btn.setFont(new Font("Courier", Font.BOLD,14));
		test_drive_btn.setFont(new Font("Courier", Font.BOLD,14));
		reset_distance_btn.setFont(new Font("Courier", Font.BOLD,18));
		flag_change_btn.setFont(new Font("Courier", Font.BOLD,18));
		add_vehicles_btn.setFont(new Font("Courier", Font.BOLD,18));

		buy_btn.setEnabled(false);
		test_drive_btn.setEnabled(false);

		//		vehicle_scroll_pane.setBounds(0, 80, 800, 240);
		//		vehicle_scroll_pane.setBackground(Color.cyan);

		scroll_pane = new JScrollPane(vehicles_panel);

		vehicles_panel.setPreferredSize(new Dimension(720, (vehicles.size() * 120)/9));

		scroll_pane.setPreferredSize(new Dimension(800, 240));

		scroll_pane_container.add(scroll_pane);
		scroll_pane_container.setBounds(0,80,800,240);

		JComponent[] main_menu_elements = {choose_vehicle_lbl, vehicle_info, title_lbl, buy_btn, test_drive_btn, reset_distance_btn
				, flag_change_btn,add_vehicles_btn, exit_btn, pick_lbl,pick_title_lbl, get_report,scroll_pane_container};
		add_elements(main_menu_panel, main_menu_elements);
		//----------------------------------------------------------------------------------------------------------------

		//adding panels to class
		add(main_menu_panel, BorderLayout.CENTER);

		update_vehicles_imgs();
	}
	public void update_vehicles_imgs()//update the vehicle imgs every time a new vehicle is added via the vehicle adding panel
	{
		if(vehicle_lbls != null)
			for(int i=0;i<vehicle_lbls.length;i++)
			{
				vehicles_panel.remove(vehicle_lbls[i]);
			}
		vehicle_lbls = new JLabel[vehicles.size()];
		for(int i=0;i<vehicle_lbls.length;i++)
		{
			ImageIcon img = new ImageIcon(vehicles.get(i).getImageSource());
			Image newimg = img.getImage();
			newimg = newimg.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			img = new ImageIcon(newimg);			
			vehicle_lbls[i] = new JLabel(img);
			vehicle_lbls[i].addMouseListener(mouse_listener);
			vehicle_lbls[i].setBorder(BorderFactory.createDashedBorder(Color.BLACK));         
			vehicles_panel.add(vehicle_lbls[i]);
		}
		vehicle_info.setText(null);
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent e)//handle btn clicks
	{
		if(e.getSource() == buy_btn)
		{
			tmp_vehicles.add(getPick());
			new SwingWorker<Void, Void>() {

				@Override
				protected Void doInBackground() throws Exception {

					synchronized (vehicles.get(pick)) {
						Info_Win delay = new Info_Win("Please wait...");
						delay.makeFrame(200, 150);
						Random rand = new Random();
						Thread.sleep(rand.nextInt(5000)+5000);
						delay.exit();
						Validate_Purchase_Win check_pur = new Validate_Purchase_Win();
						check_pur.makeFrame(Validate_Purchase_Win.FRAME_WIDTH, Validate_Purchase_Win.FRAME_HEIGHT);
						while(check_pur.isRecieved_input() == false)
						{
							Thread.sleep(100);
						}
						if(check_pur.isPurchase() == true)
						{
							vehicles.remove(tmp_vehicles.get(0));
							main_menu_panel.remove(vehicle_lbls[pick]);
							tmp_vehicles.remove(0);
							updateDB();
							for(int i=0;i<vehicle_lbls.length;i++)
								main_menu_panel.remove(vehicle_lbls[i]);
							update_vehicles_imgs();
							buy_btn.setEnabled(false);
							test_drive_btn.setEnabled(false);
							vehicle_info.setText(null);
							(new Info_Win_With_Btn("Congratz on your new Vehicle!")).makeFrame(Info_Win.FRAME_WIDTH, Info_Win_With_Btn.FRAME_HEIGHT);
							pick_lbl.setIcon(null);
							repaint();
							if(inventory_report != null)
							{
								inventory_report.update_vehicles(vehicles);
								inventory_report.update_vehicles_imgs();
							}
						}
					}					
					return null;
				}
			}.execute();
		}
		if(e.getSource() == reset_distance_btn)
		{
			new SwingWorker<Void, Void>() {

				@Override
				protected Void doInBackground() throws Exception {
					updateDB();
					for(int i = 0; i < vehicles.size();i++)
						vehicles.get(i).resetDistanceTraveled();
					vehicle_info.setText(null);
					(new Info_Win_With_Btn("Distance Reset!")).makeFrame(Info_Win_With_Btn.FRAME_WIDTH, Info_Win_With_Btn.FRAME_HEIGHT);
					return null;
				}
			}.execute();;

		}
	}

	public JButton addVehicles()//call the vehicle adding panel
	{
		return add_vehicles_btn;
	}
	public void updateVehicles(ArrayList<T_Vehicle> vehicle_arr)//get the vehicles from the vehicle adding panel
	{
		vehicles = vehicle_arr;
	}
	public void updateWater_Vehicles(ArrayList<Water_V> w_vehicle_arr)//get the water vehicles from the vehicle adding panel
	{
		w_vehicles = w_vehicle_arr;
	}

	public ArrayList<T_Vehicle> getVehicles()
	{
		return vehicles;
	}
	public ArrayList<Water_V> getWaterVehicles()
	{
		return w_vehicles;
	}
	public JButton quit()
	{
		return exit_btn;
	}
	public JButton getReport()
	{
		return get_report;
	}
	public void showMSG(String msg)
	{
		vehicle_info.setText(msg);
	}
	public JButton ChangeFlag()
	{
		return flag_change_btn;
	}
	public boolean checkIfVehicleCanTestDrive()
	{
		//		if(getPick() instanceof Water_V_Class || getPick() instanceof Water_V)
		//		{
		//			if(waterLock.isLocked() == false && !tmp_vehicles.contains(getPick()))
		//			{			
		//				waterLock.lock();
		//				return true;
		//			}
		//			else
		//				return false;
		//		}
		//		if(getPick() instanceof Land_V_Class || getPick() instanceof Land_V)
		//		{
		//			if(landLock.isLocked() == false && !tmp_vehicles.contains(getPick()))
		//			{
		//				landLock.lock();
		//				return true;
		//			}
		//			else 
		//				return false;
		//		}
		//		if(getPick() instanceof Air_V_Class || getPick() instanceof Air_V)
		//		{
		//			if(airLock.isLocked() == false && !tmp_vehicles.contains(getPick()))
		//			{
		//				airLock.lock();
		//				return true;
		//			}
		//			else
		//				return false;
		//		}
		//
		//		return false;

		if(tmp_vehicles.contains(getPick()))
			return false;
		return true;
	}
	public JButton testDrive()
	{
		return test_drive_btn;
	}
	public T_Vehicle getPick()
	{
		return vehicles.get(pick);
	}
	public void exit()
	{
		frame.dispose();
		alive = false;
	}
	public Inventory_Report getInventory_report() {
		return inventory_report;
	}
	public void setInventory_report(Inventory_Report inventory_report) {
		this.inventory_report = inventory_report;
	}
	/**
	 * @return the airLock
	 */
	public ReentrantLock getAirLock() {
		return airLock;
	}
	/**
	 * @param airLock the airLock to set
	 */
	public void setAirLock(ReentrantLock airLock) {
		this.airLock = airLock;
	}
	/**
	 * @return the landLock
	 */
	public ReentrantLock getLandLock() {
		return landLock;
	}
	/**
	 * @param landLock the landLock to set
	 */
	public void setLandLock(ReentrantLock landLock) {
		this.landLock = landLock;
	}
	/**
	 * @return the waterLock
	 */
	public ReentrantLock getWaterLock() {
		return waterLock;
	}
	/**
	 * @param waterLock the waterLock to set
	 */
	public void setWaterLock(ReentrantLock waterLock) {
		this.waterLock = waterLock;
	}
	/**
	 * @return the tmp_vehicles
	 */
	public ArrayList<T_Vehicle> getTmp_vehicles() {
		return tmp_vehicles;
	}
	/**
	 * @param tmp_vehicles the tmp_vehicles to set
	 */
	public void setTmp_vehicles(ArrayList<T_Vehicle> tmp_vehicles) {
		this.tmp_vehicles = tmp_vehicles;
	}
	public void updateDB()
	{
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		exit_btn.setEnabled(false);
		Info_Win update_db = new Info_Win("Updating database� Please wait");
		update_db.makeFrame(Info_Win.FRAME_WIDTH,Info_Win.FRAME_HEIGHT);
		Random rand = new Random();
		try {
			Thread.sleep(rand.nextInt(5000)+3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		update_db.exit();
		exit_btn.setEnabled(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
