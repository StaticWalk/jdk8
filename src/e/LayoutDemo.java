package e;

/**
 * Created by xiongxiaoyu
 * Data:2018/5/18
 * Time:20:14
 */
//LayoutDemo.java  周永
import javax.swing.*;
import java.awt.*;
public class LayoutDemo extends JFrame
{
	JPanel pNorth;
	JLabel lblDrive;
	JComboBox cboDrive;
	JLabel lblSize;
	JTextField txtSize;
	JButton btnStart;
	JButton btnQuit;
	JTextArea areaStatus;
	JProgressBar pBar;
	//构造方法
	public LayoutDemo()
	{
		super("往磁盘写随机文件(务必谨慎使用)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		pNorth=new JPanel();
		getContentPane().add("North",pNorth);
		//添加JComboBox
		lblDrive=new JLabel("选择路径:");
		cboDrive=new JComboBox();
		for(char ch='A';ch<='H';ch++)
			cboDrive.addItem(ch+":");
		cboDrive.setSelectedIndex(2); //默认选中C盘
		//添加标签、文本框、按钮
		lblSize=new JLabel("输入要生成文件的大小:");
		txtSize=new JTextField("100M",6);
		txtSize.setToolTipText("最大可以输入65535G！");
		btnStart=new JButton("开始写操作(W)");
		btnQuit=new JButton("退出程序(Q)");
		//设置快捷键
		btnStart.setMnemonic('W');
		btnQuit.setMnemonic('Q');
		//设置布局方式，添加组件
		pNorth.setLayout(new FlowLayout(FlowLayout.CENTER,3,3));
		pNorth.add(lblDrive);
		pNorth.add(cboDrive);
		pNorth.add(lblSize);
		pNorth.add(txtSize);
		pNorth.add(btnStart);
		pNorth.add(btnQuit);
		//添加屏幕中间的文本区，下方的进度条
		areaStatus=new JTextArea("启动就绪，等待您的操作...\n提示：输入文件大小，可以用字母M或者G结尾！",7,12);
		areaStatus.setEditable(false);
		String sOsName=System.getProperty("[图片]os.name");
		areaStatus.setToolTipText(sOsName+" Version");
		JScrollPane scPane=new JScrollPane(areaStatus);
		getContentPane().add("Center",scPane);
		pBar=new JProgressBar();
		getContentPane().add("South",pBar);
		//设置字体
		Font f=new Font(null,Font.BOLD,18);
		lblDrive.setFont(f);
		cboDrive.setFont(f);
		lblSize.setFont(f);
		txtSize.setFont(f);
		btnStart.setFont(f);
		btnQuit.setFont(f);
		areaStatus.setFont(f);
		pack(); //压缩和整理窗口
		Dimension dScreen=Toolkit.getDefaultToolkit().getScreenSize();
		//屏幕的宽度和高度
		double wS=dScreen.getWidth();
		double hS=dScreen.getHeight();
		//窗口x座标和y座标
		int x=(int)(wS-getWidth())/2;
		int y=(int)(hS-getHeight())/2;
		//位于屏幕中心
		setLocation(x,y);
		setVisible(true);
	}//end of 构造
	//main方法
	public static void main(String args[])
	{
		LayoutDemo objHD=new LayoutDemo();
	}//end of main
}//end of class
