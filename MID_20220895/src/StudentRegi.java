import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentRegi extends JFrame {
    private ArrayList<String> Stu;
    private Map<Integer, String> phoneBookWithID;
    private int idCounter;

    private JTextField nameField;
    private JTextField numberField;
    private JTextField gradeField;
    
    private JTextArea displayArea;

    public StudentRegi() {
        Stu = new ArrayList<>();
        phoneBookWithID = new HashMap<>();
        idCounter = 1;

        JLabel nameLabel = new JLabel("이름:");
        nameField = new JTextField(20);

        JLabel numberLabel = new JLabel("학번:");
        numberField = new JTextField(20);

        JLabel gradeLabel = new JLabel("성적:");
        gradeField = new JTextField(20);

        

        displayArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JButton addButton = new JButton("추가");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String number = numberField.getText();
                String grade = gradeField.getText();
                String entry = "이름: " + name + ", 전화번호: " + number + ", 이메일: " + grade;
                Stu.add(entry);
                phoneBookWithID.put(idCounter, entry);
                idCounter++;
                displayStu();
            }
        });

        

        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(numberLabel);
        panel.add(numberField);
        panel.add(gradeLabel);
        panel.add(gradeField);
        panel.add(addButton);
        

        this.add(panel);
        this.add(scrollPane);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    private void displayStu() {
        displayArea.setText("");
        for (String entry : Stu) {
            displayArea.append(entry + "\n");
        }
    }

    public static void main(String[] args) {
        new StudentRegi();
    }
}
