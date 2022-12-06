package day19;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class Ex04 extends JFrame{
	
	public Ex04() {
		super("예제04");
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		String[] hobbies = {"수영", "야구", "축구", "테니스", "피아노"};
		
		/*
		JCheckBox[] checkBoxes = new JCheckBox[hobbies.length];
		
		for(int i = 0; i < hobbies.length; i++) {
			checkBoxes[i] = new JCheckBox(hobbies[i]);
			add(checkBoxes[i]);
		}
		
		*/
		
		/*
		ButtonGroup bg = new ButtonGroup();
		
		JRadioButton[] buttons = new JRadioButton[hobbies.length];
		for(int i = 0; i < hobbies.length; i++) {
			boolean selected = i == 0 ? true : false;
			buttons[i] = new JRadioButton(hobbies[i], selected);
			bg.add(buttons[i]);
			add(buttons[i]);
		}
		*/
		
		/*
		JComboBox<String> box = new JComboBox<String>(hobbies);
		add(box);
		*/
	}
	
	public static void main(String[] args) {
		new Ex04();
	}
}
