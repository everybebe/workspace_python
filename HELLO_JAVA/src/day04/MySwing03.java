package day04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MySwing03 extends JFrame {

	
	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing03 frame = new MySwing03();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MySwing03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf1 = new JTextField();
		tf1.setBounds(12, 57, 116, 21);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lbl = new JLabel("+");
		lbl.setBounds(163, 60, 25, 15);
		contentPane.add(lbl);
		
		tf2 = new JTextField();
		tf2.setBounds(209, 57, 116, 21);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JButton btn = new JButton("=");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				
//				int num1 = Integer.parseInt(tf1.getText());
//				int num2 = Integer.parseInt(tf2.getText());
//				
//				int result = (num1+num2);
//				
//				tf3.setText(Integer.toString(result));
				
				myclick();

			}

		
		});
		btn.setBounds(337, 56, 97, 23);
		contentPane.add(btn);
		
		tf3 = new JTextField();
		tf3.setBounds(446, 57, 116, 21);
		contentPane.add(tf3);
		tf3.setColumns(10);
	}
	private void myclick() {
		String a = tf1.getText();
		String b = tf2.getText();
		
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		int sum = aa+bb;
		
		tf3.setText(sum+"");
		
	}
}
