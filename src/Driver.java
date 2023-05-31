/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
import java.awt.event.*;

import javax.swing.SwingWorker;

public class Driver {

	public static void main(String[] args) {		

		//Panels
		Vehicle_Adding vehicle_adding = new Vehicle_Adding();
		Main_Menu main_menu = new Main_Menu();
		FlagChange flag_change = new FlagChange();
		Inventory_Report inventory_report = new Inventory_Report(main_menu.getVehicles());

		main_menu.makeFrame(Main_Menu.FRAME_WIDTH, Main_Menu.FRAME_HEIGHT);

		vehicle_adding.GOTO_agency().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SwingWorker<Void, Void>() {
					@Override
					protected Void doInBackground() throws Exception {
						synchronized(main_menu.getVehicles()) {
							vehicle_adding.exit();							
							main_menu.updateDB();
							main_menu.updateVehicles(vehicle_adding.getVehicles());
							main_menu.updateWater_Vehicles(vehicle_adding.getWater_Vehicles());
							main_menu.update_vehicles_imgs();				
							if(inventory_report.isAlive() == true)
							{
								inventory_report.update_vehicles(main_menu.getVehicles());
								inventory_report.update_vehicles_imgs();
								inventory_report.setRebuild(true);
							}
						}
						return null;
					}
				}.execute();
			}
		});
		main_menu.addVehicles().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(vehicle_adding.isAlive() == false)
					vehicle_adding.makeFrame(Vehicle_Adding.FRAME_WIDTH,Vehicle_Adding.FRAME_HEIGHT);
			}
		});
		main_menu.quit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main_menu.exit();
				vehicle_adding.exit();
				if(flag_change.isAlive() == true)
					flag_change.exit();
				if(inventory_report.isAlive() == true)
					inventory_report.exit();				

			}
		});
		main_menu.ChangeFlag().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new SwingWorker<Void, Void>() {

					@Override
					protected Void doInBackground() throws Exception {
						flag_change.updateVehicles(main_menu.getWaterVehicles());
						flag_change.makeFrame(FlagChange.FRAME_WIDTH, FlagChange.FRAME_HEIGHT);
						return null;
					}
				}.execute();
			}
		});
		main_menu.testDrive().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				new SwingWorker<Void, Void>()
				{
					@Override
					protected Void doInBackground() throws Exception {
						if(main_menu.checkIfVehicleCanTestDrive() == true)
						{
							(new Test_Drive(main_menu.getPick())).makeFrame(Test_Drive.FRAME_WIDTH, Test_Drive.FRAME_HEIGHT);
						}
						else
							main_menu.showMSG("Cant test drive, vehicle is in purchase process or Driver not availble.");
						return null;
					}					
				}.execute();
			}
		});
		main_menu.getReport().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(inventory_report.isAlive() == false)
				{
					new SwingWorker<Void, Void>() {

						@Override
						protected Void doInBackground() throws Exception {
							main_menu.setInventory_report(inventory_report);
							inventory_report.update_vehicles(main_menu.getVehicles());
							inventory_report.update_vehicles_imgs();
							inventory_report.makeFrame(Inventory_Report.FRAME_WIDTH, Inventory_Report.FRAME_HEIGHT);							
							return null;
						}
					}.execute();					
				}				
			}
		});
		inventory_report.close().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				inventory_report.exit();
				main_menu.setInventory_report(null);
			}
		});
	}
}