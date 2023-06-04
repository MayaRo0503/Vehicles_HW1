/*
Maya Rozenberg - 313381600
Doron Shpitzer -313262594
 */
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class myPanel extends JPanel{
	private static final long serialVersionUID = 1L;

	protected boolean alive = false;
	protected JFrame frame;

	public myPanel()
	{

	}	
	protected void makeFrame(int width, int height)
	{
		alive = true;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(this);
	}
	protected void add_elements(JPanel panel, JComponent[] cmps)//add array of elements to panel 
	{
		for(int i=0;i<cmps.length;i++)
			panel.add(cmps[i]);
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	protected boolean isValidField(JTextField f)
	{
		if(f.getText().equals(""))
			return false;
		return true;
	}
}
