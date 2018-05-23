package e;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/18
 * Time:20:15
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ShowDIalog extends JFrame{
	JButton button=new JButton("显示");
	public ShowDIalog(){
		setLayout(new FlowLayout());
		add(button);
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,"Wath a fucking day!");
			}
		});
		setVisible(true);
		setSize(100,100);
	}
	public static void main(String[] args){
		ShowDIalog s=new ShowDIalog();
	}
}
