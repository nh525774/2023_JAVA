import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class MyFrame extends JFrame implements ActionListener
{
       private JButton  button1;
       private JLabel label;
       private JTextField field1;
       private JTextField field2;
      
       public MyFrame(){
             setSize(400, 400);
             setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             setTitle("마일을 킬로미터로 변환");
             label = new JLabel("거리를 마일 단위로 입력하시오.");
             field1 = new JTextField(30);
             field2 = new JTextField(30);
             button1 = new JButton("변환");
             button1.addActionListener(this);
             JPanel panel = new JPanel();
            
             panel.add(label);
             panel.add(field1);
             panel.add(button1);
             panel.add(field2);
            
             add(panel);
            
             setVisible(true);
       }
      
       public void actionPerformed(ActionEvent g) {
             // TODO Auto-generated method stub
             if(g.getSource() == button1)
             {
                    field2.setText(field1.getText() + " 마일은" + Double.parseDouble(field1.getText())*1.6 + "킬로미터");
             }
       }
}
public class Week03_02 {

	public static void main(String[] args) {
		MyFrame f=new MyFrame();

	}

}
