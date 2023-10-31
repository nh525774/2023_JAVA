import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

interface ArrayProcessing {
	double apply (double[] memberList);
}
public class GradeBookTest extends JFrame {
    private JTextField nameField;
    private JTextField numField;
    
    private JTextField gradeField;
   
    private JTextArea displayArea;
    private ArrayList<String> memberList;

    public GradeBookTest() {
        memberList = new ArrayList<>();

        JLabel nameLabel = new JLabel("이름:");
        nameField = new JTextField(20);

        JLabel numLabel = new JLabel("학번:");
        numField = new JTextField(20);


        JLabel gradeLabel = new JLabel("점수:");
        gradeField = new JTextField(20);

        

        JButton submitButton = new JButton("제출");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberInfo = "이름: " + nameField.getText() + ", 학번: " + numField.getText() +
                         ", 점수: " + gradeField.getText() 
                        ;
                memberList.add(memberInfo);
                displayArea.append(memberInfo + "\n");
            }
        });

        JButton resetButton = new JButton("초기화");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                numField.setText("");
                
                gradeField.setText("");
                
            }
        });

        JButton searchButton = new JButton("검색");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTerm = numField.getText();
                for (String memberInfo : memberList) {
                    if (memberInfo.contains(searchTerm)) {
                        displayArea.setText(memberInfo);
                        return;
                    }
                }
                displayArea.setText("일치하는 회원을 찾을 수 없습니다.");
            }
        });

        JLabel displayLabel = new JLabel("작성한 내용:");
        displayArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(numLabel);
        panel.add(numField);
        
        panel.add(gradeLabel);
        panel.add(gradeField);
        
        panel.add(new JLabel());
        panel.add(submitButton);
        panel.add(resetButton);
        panel.add(searchButton);

        JPanel displayPanel = new JPanel();
        displayPanel.add(displayLabel);
        displayPanel.add(scrollPane);

        this.add(panel, BorderLayout.NORTH);
        this.add(displayPanel, BorderLayout.CENTER);
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    

    public static void main(String[] args) {
        new GradeBookTest();
        
        
	
	
}}
