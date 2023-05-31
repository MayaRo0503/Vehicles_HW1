/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Info_Win_With_Btn extends Info_Win implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	public static final int FRAME_WIDTH = 300;
	public static final int FRAME_HEIGHT = 150;
	
	JButton ok_btn = new JButton("OK");
	
	public Info_Win_With_Btn(String text) {
		super(text);
		ok_btn.addActionListener(this);
		ok_btn.setBounds(60, 50, 100, 50);
		lbl.setBounds(20,-20,200,80);
		
		add(ok_btn);	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ok_btn)
			frame.dispose();
	}

}
