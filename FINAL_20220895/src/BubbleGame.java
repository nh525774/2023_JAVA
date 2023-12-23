import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BubbleGame extends JFrame{
	public BubbleGame() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton start, end;
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(500,500);	
		setVisible(true);
		
		start = new JButton("시작");
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			new BubbleGame();
			}
		});
		
		end=new JButton("종료");
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			System.exit(1);
			}
		});
		
		
		
		
		
	}
	
	public static void main(String [] args) {
		new BubbleGame();
	}
}

class GamePanel extends JPanel {
	public GamePanel() {
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new BubbleThread(e.getX(), e.getY()).start();
			}
		});
	}
	
	class BubbleThread extends Thread {
		private JLabel bubble;
		
		public BubbleThread(int bubbleX, int bubbleY) {
			
			
			ImageIcon img = new ImageIcon("bubble.jpg");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(),img.getIconWidth());
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble); // GamePanel에 add()
			repaint();
		}
		
		public void run() {
			while(true) {
				int x = bubble.getX() ;
				int y = bubble.getY() - 5;
				if(y < 0) {
					remove(bubble);
					repaint();
					return; // thread ends
				}
				bubble.setLocation(x, y);
				repaint();
				try {
					sleep(200);
				}
				catch(InterruptedException e) {}
			}
		}
	}
}