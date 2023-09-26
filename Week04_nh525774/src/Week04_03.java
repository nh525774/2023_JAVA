import java.awt.*;
import javax.swing.*;

class MyFrame extends JFrame {
    public MyFrame() {
        // 전체 패널 설정
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 정보 패널 (이름, 대학교, 전공)
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("김나현");
        
        JLabel universityLabel = new JLabel("덕성여자대학교");
        
        JLabel majorLabel = new JLabel("사이버보안학과");
        

        infoPanel.add(nameLabel);
        
        infoPanel.add(universityLabel);
        
        infoPanel.add(majorLabel);
        

        // 이미지 패널
        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel(new ImageIcon("C:/Users/김나현/.eclipse/prof.png"));
        imagePanel.add(imageLabel);

        // 정보 패널과 이미지 패널을 전체 패널에 추가
        mainPanel.add(infoPanel, BorderLayout.CENTER);
        mainPanel.add(imagePanel, BorderLayout.WEST);

        // 전체 패널을 프레임에 추가
        add(mainPanel);
    }
}

public class Week04_03 {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setTitle("명함 만들기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}