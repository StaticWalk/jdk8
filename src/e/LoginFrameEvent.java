package e;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/18
 * Time:20:16
 */
//LoginFrameEvent.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
public  class  LoginFrameEvent   extends   JFrame
{
	JPanel  p;
	GridLayout   gLayout;
	JLabel  lblUser,lblPass;
	JTextField  txtUser;
	JPasswordField  txtPass;
	JButton  btnOK,btnCancel;
	//内部类：MyFocusListener
	//###########################################
	class  MyFocusListener implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
			JTextField  obj=(JTextField)e.getSource();
			obj.setBackground(Color.yellow);
			obj.selectAll();
		}
		public void focusLost(FocusEvent e)
		{
			JTextField  obj=(JTextField)e.getSource();
			obj.setBackground(Color.white);
		}
	}
	//###########################################
	public LoginFrameEvent()
	{
		super("用户登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p=new  JPanel();
		getContentPane().add(p);
		gLayout=new  GridLayout (3,2);
		p.setLayout(gLayout);
		lblUser=new  JLabel("用户名：");
		lblPass=new  JLabel("密码：");
		txtUser=new  JTextField("admin",10);
		txtPass=new  JPasswordField();
		btnOK=new  JButton("确定");
		btnCancel=new  JButton("取消");
		//注册事件监听
		MyFocusListener  lis=new MyFocusListener();
		txtUser.addFocusListener(lis);
		txtPass.addFocusListener(lis);
		p.add(lblUser);p.add(txtUser);
		p.add(lblPass);p.add(txtPass);
		p.add(btnOK);p.add(btnCancel);
		setSize(480,240);
		setVisible(true);
		setLayout(new FlowLayout());
		add(btnOK);
		btnOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,"欢迎登录");


			}
		});

	}
	public static  void  main(String args[])
	{
		LoginFrameEvent   obj=new  LoginFrameEvent();
	}//end of main
}//end of class
