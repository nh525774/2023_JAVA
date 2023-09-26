import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Week04_02 extends JPanel implements ItemListener {
    JCheckBox[] buttons = new JCheckBox[4];
    String[] items = {"엔진오일 교환", "자동변속기오일교환", "에어컨필터교환", "타이어교환"};
    int[] prices = {45000, 80000, 30000, 100000};
    int money = 0;
    JLabel label;

    public Week04_02() {
        super();

        // JPanel 설정
        setLayout(new GridLayout(5, 1)); // 5개의 행을 가지는 그리드 레이아웃 사용

        // 체크박스와 라벨 추가
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JCheckBox(items[i]);
            buttons[i].addItemListener(this);
            add(buttons[i]);
        }

        label = new JLabel("총 금액: " + money + "원");
        add(label);
    }

    // 체크박스 상태가 변경될 때 호출되는 메서드
    @Override
    public void itemStateChanged(ItemEvent e) {
        money = 0; // 기존 금액 초기화

        // 체크된 항목의 금액을 누적
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isSelected()) {
                money += prices[i];
            }
        }

        // 라벨 업데이트
        label.setText("총 금액: " + money + "원");
    }

    public static void main(String[] args) {
        // JFrame 생성 및 설정
        JFrame frame = new JFrame("수리비 계산기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // JPanel을 JFrame에 추가
        Week04_02 repairPanel = new Week04_02();
        frame.add(repairPanel);

        // 화면에 표시
        frame.setVisible(true);
    }
}
