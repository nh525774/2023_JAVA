import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Week09_01 extends JFrame {
    private JLabel label;
    private Thread t;

    class Counter extends Thread {
        public void run() {
            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
                label.setText(i + "");
            }
        }
    }

    public Week09_01() {
        setTitle("카운트다운");
        setSize(400, 150);
        getContentPane().setLayout(null);
        label = new JLabel("0");
        label.setBounds(0, 0, 384, 111);
        label.setFont(new Font("Serif", Font.BOLD, 100));
        getContentPane().add(label);

        JButton stopButton = new JButton("카운터 중지");
        stopButton.setBounds(247, 25, 125, 23);

        stopButton.addActionListener(e -> t.interrupt());
        getContentPane().add(stopButton);

        JButton restartButton = new JButton("카운트 다시 시작");
        restartButton.setBounds(247, 60, 125, 23);

        restartButton.addActionListener(e -> {
            t = new Counter();
            t.start();
        });
        getContentPane().add(restartButton);

        setVisible(true);
        t = new Counter();
        t.start();
    }

    public static void main(String[] args) {
        Week09_01 t = new Week09_01();
    }
}
