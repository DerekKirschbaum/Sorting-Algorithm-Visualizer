import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class VisualizerPanel extends javax.swing.JPanel implements Runnable{
	
	public static ArrayList<Integer> indexes = new ArrayList<>();
	public ArrayList<Integer> heights = new ArrayList<>();
	public ArrayList<Integer> Rs = new ArrayList<>();
	public ArrayList<Integer> Gs = new ArrayList<>();
	public ArrayList<Integer> Bs = new ArrayList<>();
	
	public boolean canClick = true;
	public int swapSpeed = 12;
	public String algorithm = "";
	
	public FlowLayout layout;
	public JButton shuffle;
	public JButton sortSpeed;
	public JButton bubbleSort;
	public JButton insertionSort;
	
	
	
	public VisualizerPanel() {
		layout = new FlowLayout();
		shuffle = new JButton("Shuffle");
		sortSpeed = new JButton("Sort Speed (>)");
		bubbleSort = new JButton("Bubble Sort");
		insertionSort = new JButton("Insertion Sort");
		
		setLayout(layout);
		add(shuffle);
		add(sortSpeed);
		add(bubbleSort);
		add(insertionSort);
		
		for(int i=0; i<50; i++) {
			indexes.add(i);
			heights.add((i+1)*10);
			Bs.add(255);
		}
		int x = 255;
		for(int i=0;i<indexes.size(); i++) {
			Gs.add((i+1)*5);
			x-=5;
			Rs.add(x);	
		}
		
	}
	
	public void shuffle() {
		Collections.shuffle(indexes);
		repaint();
	}
	
	public static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void swap (int index1, int index2) {
		int temp = indexes.get(index1);
		indexes.set(index1, indexes.get(index2));
		indexes.set(index2, temp);
		sleep(swapSpeed);
		repaint();

	}

	public void bubbleSort() {
		int firstIndex = 0;
		int secondIndex = 1;
		boolean notSorted = true;
		while(notSorted) {
			//System.out.println(indexes);
			firstIndex = 0;
			secondIndex = 1;
			notSorted = false;
			for(int i=0; i<indexes.size()-1; i++) {
				if (indexes.get(firstIndex) > indexes.get(secondIndex)) {
					swap(firstIndex, secondIndex);
					notSorted = true;
				}
				firstIndex++;
				secondIndex++;
			}
		}
	}
	
	public void insertionSort() {
		
	}

	public void run() {
		System.out.println("thread run");
		canClick = false;
		
		if (algorithm.equals("Bubble Sort")) {
			bubbleSort();
		} else if (algorithm.equals("Insertion Sort")) {
			insertionSort();
		}
		
		canClick = true;
	}
	
	public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
        
        int x = 50;
       
        graphics.setColor(Color.BLUE);
        for (int i = 0; i < indexes.size(); i++) {
            graphics.setColor(new Color(Rs.get(indexes.get(i)), Gs.get(indexes.get(i)), Bs.get(indexes.get(i))));
            graphics.fillRect(x, 550 - heights.get(indexes.get(i)), 10, heights.get(indexes.get(i)));
            x+=10;
        }
    }
}

