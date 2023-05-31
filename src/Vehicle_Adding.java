/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Vehicle_Adding extends myPanel implements ActionListener {

	static final private long serialVersionUID = 1L;	
	public static final int FRAME_WIDTH = 820;
	public static final int FRAME_HEIGHT = 600;

	//data structures
	ArrayList<T_Vehicle> vehicles = new ArrayList<T_Vehicle>();		//Agency vehicle Array
	ArrayList<Water_V> w_vehicles = new ArrayList<Water_V>();		//agency ship vehicle Array

	//constant data
	static final int NUMBER_OF_EXISTING_VEHICLES = 7;
	static final int JEEP_FIELDS = 4;
	static final int FRIGATE_FIELDS = 4;
	static final int GLIDER_GAME_FIELDS = 0;
	static final int GLIDER_SPY_FIELDS = 1;
	static final int BICYCLE_FIELDS = 4;
	static final int CRUISE_SHIP_FIELDS = 6;
	static final int AMPHIBIAN_FIELDS = 7;
	static final int HYBRID_AIRCRAFT_FIELDS = 7;
	static final int ELECTRIC_BIKE_FIELDS = 4;
	static final int NUM_OF_IMGS_PER_VEHICLE = 3;


	//string to know which vehicle has been picked
	private String pick = null;

	//Panels
	private JPanel vehicle_pick_menu_panel = new JPanel();
	private JPanel vehicle_add_panel = new JPanel();
	private JPanel vehicle_add_panel_labels = new JPanel();
	private JPanel vehicle_add_panel_textfields = new JPanel();
	private JPanel vehicle_add_panel_images = new JPanel();
	private JPanel buttons_pan = new JPanel();

	//Vehicle Images source array
	private ImageIcon[][] images = {
			{
				new ImageIcon("Images\\Jeep\\j1.jpg"),
				new ImageIcon("Images\\Jeep\\j2.jpg"),
				new ImageIcon("Images\\Jeep\\j3.jpg"),
			},
			{
				new ImageIcon("Images\\Frigate\\f1.jpg"),
				new ImageIcon("Images\\Frigate\\f2.jpg"),
				new ImageIcon("Images\\Frigate\\f3.jpg"),
			},
			{
				new ImageIcon("Images\\GameGlider\\g1.jpg"),
				new ImageIcon("Images\\GameGlider\\g2.jpg"),
				new ImageIcon("Images\\GameGlider\\g3.jpg"),
			},
			{
				new ImageIcon("Images\\SpyGlider\\s1.jpg"),
				new ImageIcon("Images\\SpyGlider\\s2.jpg"),
				new ImageIcon("Images\\SpyGlider\\s3.jpg"),
			},
			{
				new ImageIcon("Images\\Bicycle\\b1.jpg"),
				new ImageIcon("Images\\Bicycle\\b2.jpg"),
				new ImageIcon("Images\\Bicycle\\b3.jpg"),
			},
			{
				new ImageIcon("Images\\Cruise\\c1.jpg"),
				new ImageIcon("Images\\Cruise\\c2.jpg"),
				new ImageIcon("Images\\Cruise\\c3.jpg"),
			},
			{
				new ImageIcon("Images\\Amphibious\\a1.jpg"),
				new ImageIcon("Images\\Amphibious\\a2.jpg"),
				new ImageIcon("Images\\Amphibious\\a3.jpg"),
			},
			{
				new ImageIcon("Images\\HybridAirCraft\\h1.jpg"),
				new ImageIcon("Images\\HybridAirCraft\\h2.jpg"),
				new ImageIcon("Images\\HybridAirCraft\\h3.jpg"),
			},
			{				
				new ImageIcon("Images\\ElectricBike\\eb1.jpg"),
				new ImageIcon("Images\\ElectricBike\\eb2.jpg"),
				new ImageIcon("Images\\ElectricBike\\eb3.jpg"),
			},
	};

	//combo box
	private JComboBox<ImageIcon> vehicle_images_combo = new JComboBox<ImageIcon>();

	//Buttons
	private JButton continue_btn = new JButton("Add Vehicles!");
	private JButton add_vehicle_btn = new JButton("OK");
	private JButton load_img_btn = new JButton("Load Image");
	private JButton back_btn = new JButton("Back");
	private JButton Frigate_btn = new JButton("Frigate");
	private JButton jeep_btn = new JButton("Jeep");
	private JButton glider_game_btn = new JButton("Glider Game");
	private JButton glider_spy_btn = new JButton("Glider Spy");
	private JButton bicycle_btn = new JButton("Bicycle");
	private JButton cruise_ship_btn = new JButton("Cruise Ship");
	private JButton amphibian_btn = new JButton("Amphibian");
	private JButton hybrid_aircraft_btn = new JButton("Hybrid Air Craft");
	private JButton electric_bike_btn = new JButton("Electric Bike");

	private ImageIcon bg_img = new ImageIcon("Images\\bg.jpg");

	//Labels
	private JLabel title_lab = new JLabel("Hey! Please Choose Your Vehicles:");
	private JLabel model_lab = new JLabel("Model:");
	private JLabel max_passengers_lab = new JLabel("Max Passengers:");
	private JLabel max_speed_lab = new JLabel("Max Speed:");
	private JLabel wheels_lab = new JLabel("Wheels Number:");
	private JLabel flag_lab = new JLabel("Flag:");
	private JLabel engine_lab = new JLabel("Engine Life:");
	private JLabel gas_lab = new JLabel("Gas Consumption:");
	private JLabel wind_lab = new JLabel("With Wind:");
	private JLabel power_source_lab = new JLabel("Power Source:");
	private JLabel road_lab = new JLabel("Road:");
	private JLabel menu_img = new JLabel(bg_img);

	//Text Fields
	private JTextField[] vehicle_textfields;

	//file chooser
	private final JFileChooser fc = new JFileChooser();

	public Vehicle_Adding()
	{
		frame = new JFrame("Vehicle Shop");

		//btn action listener adding
		continue_btn.addActionListener(this);
		load_img_btn.addActionListener(this);
		add_vehicle_btn.addActionListener(this);
		back_btn.addActionListener(this);
		Frigate_btn.addActionListener(this);
		jeep_btn.addActionListener(this);
		glider_game_btn.addActionListener(this);
		glider_spy_btn.addActionListener(this);
		bicycle_btn.addActionListener(this);
		cruise_ship_btn.addActionListener(this);
		amphibian_btn.addActionListener(this);
		hybrid_aircraft_btn.addActionListener(this);
		electric_bike_btn.addActionListener(this);

		//panel setup
		setBorder(BorderFactory.createDashedBorder(Color.BLACK));           
		setLayout(new BorderLayout());   
		vehicle_add_panel.setBorder(BorderFactory.createDashedBorder(Color.red));          
		vehicle_add_panel.setLayout(null);
		vehicle_add_panel.setBackground(java.awt.Color.YELLOW);
		vehicle_pick_menu_panel.setBorder(BorderFactory.createDashedBorder(Color.red));          
		vehicle_pick_menu_panel.setLayout(null);
		vehicle_add_panel_images.setLayout(new FlowLayout());
		buttons_pan.setLayout(new FlowLayout());
		vehicle_add_panel_labels.setLayout(new FlowLayout());
		vehicle_add_panel_textfields.setLayout(new FlowLayout());
		vehicle_add_panel_images.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		buttons_pan.setBackground(java.awt.Color.ORANGE);
		vehicle_pick_menu_panel.setBackground(java.awt.Color.ORANGE);
		vehicle_add_panel_labels.setBackground(java.awt.Color.YELLOW);
		vehicle_add_panel_textfields.setBackground(java.awt.Color.YELLOW);
		vehicle_add_panel_labels.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		vehicle_add_panel_textfields.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		//panel componenets setup
		title_lab.setBounds(130,-20,700,100);
		buttons_pan.setBounds(50,70,700,100);
		continue_btn.setBounds(250, 500, 250, 50);
		vehicle_add_panel_images.setBounds(150,300,800,300);
		add_vehicle_btn.setBounds(400, 400, 60, 60);
		menu_img.setBounds(100,50,600,600);
		back_btn.setBounds(450, 400, 300, 100);
		load_img_btn.setBounds(450, 200, 300, 20);
		add_vehicle_btn.setBounds(450, 230, 300, 150);
		add_vehicle_btn.setFont(new Font("Courier", Font.BOLD,34));
		vehicle_add_panel_labels.setBounds(20, 0,200,500);
		vehicle_add_panel_textfields.setBounds(220,0,200,500);
		vehicle_images_combo.setBounds(450,0,320,200);
		title_lab.setFont(new Font("Courier", Font.BOLD,26));
		continue_btn.setFont(new Font("Courier", Font.BOLD,26));

		//adding elements to panels
		JComponent[] buttons_pan_elements = {jeep_btn, Frigate_btn, glider_game_btn, glider_spy_btn, bicycle_btn, cruise_ship_btn, 
				amphibian_btn, hybrid_aircraft_btn, electric_bike_btn};
		add_elements(buttons_pan, buttons_pan_elements);
		JComponent[] vehicle_add_panel_elements = {load_img_btn, back_btn, add_vehicle_btn, vehicle_add_panel_labels, vehicle_add_panel_textfields, vehicle_images_combo};
		add_elements(vehicle_add_panel, vehicle_add_panel_elements);
		JComponent[] vehicle_pick_menu_panel_elements = {title_lab, buttons_pan, continue_btn, menu_img};
		add_elements(vehicle_pick_menu_panel, vehicle_pick_menu_panel_elements);

		//setup start window
		vehicle_add_panel.setVisible(false);
		continue_btn.setEnabled(false);
		add(vehicle_add_panel, BorderLayout.CENTER);
		add(vehicle_pick_menu_panel, BorderLayout.CENTER);
	}

	public void actionPerformed(ActionEvent e) //handle btn clicks
	{   
		if(e.getSource() == load_img_btn)
		{
			fc.showDialog(vehicle_add_panel, "Attach");
			if(fc.getSelectedFile() != null)
			{
				vehicle_images_combo.getModel().setSelectedItem(new ImageIcon(fc.getSelectedFile().toString()));
				repaint();
			}
		}
		if(e.getSource() == add_vehicle_btn)
		{
			if(validInput() == true)
			{
				T_Vehicle v = null;
				if(pick == "jeep")
				{
					v = new Jeep(vehicle_textfields[0].getText(),Integer.parseInt(vehicle_textfields[1].getText())
							, Integer.parseInt(vehicle_textfields[2].getText()), Integer.parseInt(vehicle_textfields[3].getText()));
				}
				if(pick == "frigate")
				{
					v = new Frigate(vehicle_textfields[0].getText(),Integer.parseInt(vehicle_textfields[1].getText())
							, Integer.parseInt(vehicle_textfields[2].getText()), vehicle_textfields[3].getText());
					w_vehicles.add((Water_V) v);
				}
				if(pick == "glider_game")
				{
					v = new Glider_Game();
				}
				if(pick == "glider_spy")
					v = new Glider_Spy(vehicle_textfields[0].getText());
				if(pick == "bicycle")
					v = new Bicycle(vehicle_textfields[0].getText(),Integer.parseInt(vehicle_textfields[1].getText())
							, Integer.parseInt(vehicle_textfields[2].getText()), vehicle_textfields[3].getText());
				if(pick == "cruise_ship")
				{
					v = new Cruise_Ship(vehicle_textfields[0].getText(),Integer.parseInt(vehicle_textfields[1].getText())
							, Integer.parseInt(vehicle_textfields[2].getText()), vehicle_textfields[3].getText()
							,Integer.parseInt(vehicle_textfields[4].getText()), Integer.parseInt(vehicle_textfields[5].getText()));
					w_vehicles.add((Water_V) v);
				}
				if(pick == "amphibian")
				{
					v = new Amphibian(vehicle_textfields[0].getText(),Integer.parseInt(vehicle_textfields[1].getText())
							, Integer.parseInt(vehicle_textfields[2].getText()), Integer.parseInt(vehicle_textfields[3].getText())
							,vehicle_textfields[4].getText(), Integer.parseInt(vehicle_textfields[5].getText())
							,Integer.parseInt(vehicle_textfields[6].getText()));
					w_vehicles.add((Water_V) v);
				}
				if(pick == "hybrid_aircraft")
				{
					v = new HybridAircraft(vehicle_textfields[0].getText(),Integer.parseInt(vehicle_textfields[1].getText())
							, Integer.parseInt(vehicle_textfields[2].getText()), Integer.parseInt(vehicle_textfields[3].getText())
							,vehicle_textfields[4].getText(), Integer.parseInt(vehicle_textfields[5].getText())
							,Integer.parseInt(vehicle_textfields[6].getText()));
					w_vehicles.add((Water_V) v);
				}
				if(pick == "electric_bike")
				{
					v = new Electric_Bicycle(vehicle_textfields[0].getText(),Integer.parseInt(vehicle_textfields[1].getText())
							, Integer.parseInt(vehicle_textfields[2].getText()), vehicle_textfields[3].getText());
				}
				v.setImageSource(vehicle_images_combo.getSelectedItem().toString());
				vehicles.add(v);
				onLeaving_Vehicle_Adding_Menu();
				continue_btn.setEnabled(true);
			}
		}
		if(e.getSource() == jeep_btn)
		{
			pick = "jeep";
			vehicle_textfields = new JTextField[JEEP_FIELDS];
			JLabel[] vehicle_label_fields = {model_lab, gas_lab, max_speed_lab, engine_lab};
			vehicleAdd_menu(vehicle_label_fields);
		}
		if(e.getSource() == Frigate_btn)
		{
			pick = "frigate";
			vehicle_textfields = new JTextField[FRIGATE_FIELDS];
			JLabel[] vehicle_label_fields = {model_lab, max_speed_lab, max_passengers_lab, wind_lab};
			vehicleAdd_menu(vehicle_label_fields);
		}
		if(e.getSource() == glider_game_btn)
		{
			pick = "glider_game";
			vehicle_textfields = new JTextField[GLIDER_GAME_FIELDS];
			JLabel[] vehicle_label_fields = {};
			vehicleAdd_menu(vehicle_label_fields);
		}
		if(e.getSource() == glider_spy_btn)
		{
			pick = "glider_spy";
			vehicle_textfields = new JTextField[GLIDER_SPY_FIELDS];
			JLabel[] vehicle_label_fields = {power_source_lab};
			vehicleAdd_menu(vehicle_label_fields);
		}
		if(e.getSource() == bicycle_btn)
		{
			pick = "bicycle";
			vehicle_textfields = new JTextField[BICYCLE_FIELDS];
			JLabel[] vehicle_label_fields = {model_lab, max_passengers_lab, max_speed_lab, road_lab};
			vehicleAdd_menu(vehicle_label_fields);
		}
		if(e.getSource() == cruise_ship_btn)
		{
			pick = "cruise_ship";
			vehicle_textfields = new JTextField[CRUISE_SHIP_FIELDS];
			JLabel[] vehicle_label_fields = {model_lab, max_passengers_lab, max_speed_lab, flag_lab	,gas_lab, engine_lab};
			vehicleAdd_menu(vehicle_label_fields);
		}
		if(e.getSource() == amphibian_btn)
		{
			pick = "amphibian";
			vehicle_textfields = new JTextField[AMPHIBIAN_FIELDS];
			JLabel[] vehicle_label_fields = {model_lab, max_passengers_lab, max_speed_lab, wheels_lab, flag_lab, engine_lab, gas_lab};
			vehicleAdd_menu(vehicle_label_fields);
		}
		if(e.getSource() == hybrid_aircraft_btn)
		{
			pick = "hybrid_aircraft";
			vehicle_textfields = new JTextField[HYBRID_AIRCRAFT_FIELDS];
			JLabel[] vehicle_label_fields = {model_lab, max_passengers_lab, max_speed_lab, wheels_lab, flag_lab, engine_lab, gas_lab};
			vehicleAdd_menu(vehicle_label_fields);
		}
		if(e.getSource() == electric_bike_btn)
		{
			pick = "electric_bike";
			vehicle_textfields = new JTextField[ELECTRIC_BIKE_FIELDS];
			JLabel[] vehicle_label_fields = {model_lab, max_passengers_lab, max_speed_lab, road_lab};
			vehicleAdd_menu(vehicle_label_fields);
		}
		if(e.getSource() == back_btn)
		{
			onLeaving_Vehicle_Adding_Menu();
		}
	}
	private void onLeaving_Vehicle_Adding_Menu() // make the vehicle add menu not visible and the main vehicle pick menu visible
	{
		vehicle_add_panel_textfields.removeAll();
		vehicle_add_panel_labels.removeAll();
		vehicle_add_panel.setVisible(false);
		vehicle_pick_menu_panel.setVisible(true);
	}
	private void vehicleAdd_menu(JLabel[] vehicle_label_fields)//show and arrange all the labels and text fields for entering vehicle details.
	{
		vehicle_images_combo.removeAllItems();
		if(pick == "jeep")
		{
			setup_specific_vehicle_menu(vehicle_label_fields, JEEP_FIELDS, 0);
		}
		if(pick == "frigate")
		{
			setup_specific_vehicle_menu(vehicle_label_fields,FRIGATE_FIELDS,1);
		}
		if(pick == "glider_game")
		{
			setup_specific_vehicle_menu(vehicle_label_fields,GLIDER_GAME_FIELDS,2);
		}
		if(pick == "glider_spy")
		{
			setup_specific_vehicle_menu(vehicle_label_fields,GLIDER_SPY_FIELDS,3);
		}

		if(pick == "bicycle")
		{
			setup_specific_vehicle_menu(vehicle_label_fields,BICYCLE_FIELDS,4);
		}
		if(pick == "cruise_ship")
		{
			setup_specific_vehicle_menu(vehicle_label_fields,CRUISE_SHIP_FIELDS,5);
		}
		if(pick == "amphibian")
		{
			setup_specific_vehicle_menu(vehicle_label_fields,AMPHIBIAN_FIELDS,6);
		}
		if(pick == "hybrid_aircraft")
		{
			setup_specific_vehicle_menu(vehicle_label_fields,HYBRID_AIRCRAFT_FIELDS,7);
		}
		if(pick == "electric_bike")
		{
			setup_specific_vehicle_menu(vehicle_label_fields,ELECTRIC_BIKE_FIELDS,8);
		}

		vehicle_add_panel.setBounds(0,0,1000,1000);

		vehicle_pick_menu_panel.setVisible(false);
		vehicle_add_panel.setVisible(true);
	}
	private void setup_specific_vehicle_menu(JLabel[] vehicle_label_fields,int length,int img_index)//setup the menu for each specific vehicle type
	{
		for(int i=0;i<length;i++)
		{
			vehicle_textfields[i] = new JTextField("0");
			vehicle_label_fields[i].setPreferredSize(new Dimension(200, 40));
			vehicle_textfields[i].setPreferredSize(new Dimension(160, 40));
			vehicle_label_fields[i].setFont(new Font("Courier", Font.BOLD,20));
			vehicle_add_panel_labels.add(vehicle_label_fields[i]);
			vehicle_add_panel_textfields.add(vehicle_textfields[i]);
		}
		for(int i=0;i<NUM_OF_IMGS_PER_VEHICLE;i++)
			vehicle_images_combo.addItem(images[img_index][i]);
	}
	private boolean validInput()
	{
		for(int i=0; i < vehicle_textfields.length; i ++)
			if(!isValidField(vehicle_textfields[i]))
				return false;
		return true;
	}
	public ArrayList<T_Vehicle> getVehicles()//function to send to main agency menu the vehicles array 
	{
		return vehicles;
	}
	public ArrayList<Water_V> getWater_Vehicles()//function to send to main agency menu the water vehicles array
	{
		return w_vehicles;
	}
	public JButton GOTO_agency()//function to manage window switching with main agency menu
	{
		return continue_btn;
	}

	public void exit()
	{
		frame.dispose();
		alive = false;
	}
}
