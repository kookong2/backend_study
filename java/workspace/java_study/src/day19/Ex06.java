package day19;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class Ex06 extends JFrame implements ActionListener{
	
	public Ex06() {
		super("연습06");
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JMenuBar jmb = new JMenuBar();
		JMenu menu1 = new JMenu("메뉴");
		JMenuItem mlItem = new JMenuItem("파일");
		
		menu1.add(mlItem);
		jmb.add(menu1);
		setJMenuBar(jmb);
		
		mlItem.addActionListener(this);
	}
	
	public static void main(String[] args) {
		
		new Ex06();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JFileChooser file = new JFileChooser();
		file.showOpenDialog(this);
		File fileName = file.getSelectedFile();
		System.out.println(fileName);
		
	}
	
	
}
