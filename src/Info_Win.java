/*
Maya Rozenberg - 313381600
Doron Shpitzer -
 */
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Info_Win extends myPanel {

	private static final long serialVersionUID = 1L;
	public static final int FRAME_WIDTH = 250;
	public static final int FRAME_HEIGHT = 100;

	JLabel lbl;

	public Info_Win(String text) {

		lbl = new JLabel(text);
		lbl.setBounds(20,0,200,80);

		frame = new JFrame("");
		setLayout(null);
		add(lbl);
	}

	public void exit()
	{
		frame.dispose();
	}

}
