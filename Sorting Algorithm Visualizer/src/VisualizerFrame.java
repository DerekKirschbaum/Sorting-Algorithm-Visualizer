import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class VisualizerFrame extends JFrame implements ActionListener {

	public VisualizerPanel p;

	public VisualizerFrame() {
		p = new VisualizerPanel();
		setContentPane(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		setResizable(false);
		setVisible(true);
		p.shuffle.addActionListener(this);
		p.sortSpeed.addActionListener(this);
		p.bubbleSort.addActionListener(this);
		p.insertionSort.addActionListener(this);
	}
	
	public void run() {
		//System.out.println("run");
	}
	
	
	public static void main(String[] args) {
		VisualizerFrame visualizerFrame = new VisualizerFrame();
		visualizerFrame.run();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == p.shuffle && p.canClick) {
			p.shuffle();
			//System.out.println("shuffle");
		} else if(e.getSource() == p.sortSpeed) {
			if(p.swapSpeed == 12) {
				p.sortSpeed.setText("Sort Speed (>>)");
				p.swapSpeed = 6;
			} else if(p.swapSpeed == 6) {
				p.sortSpeed.setText("Sort Speed (>>>>)");
				p.swapSpeed = 3;
			} else if(p.swapSpeed == 3) {
				p.sortSpeed.setText("Sort Speed (>)");
				p.swapSpeed = 12;
			}
		} else if(e.getSource() == p.bubbleSort && p.canClick) {
			//System.out.println("bubble sort");
			p.algorithm = "Bubble Sort";
			Thread t = new Thread(p);
			t.start();
		} else if(e.getSource() == p.insertionSort && p.canClick) {
			//System.out.println("insertion sort");
			p.algorithm = "Insertion Sort";
			Thread t = new Thread(p);
			t.start();
		}
	}

}
