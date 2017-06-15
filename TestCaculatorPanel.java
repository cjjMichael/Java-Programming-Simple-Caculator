package Caculator;
import java.awt.Color;

import javax.swing.*;

public class TestCaculatorPanel {

	public static void main(String[] args){
		CaculatorFrame caculator = new CaculatorFrame();
		caculator.setSize(320, 420);
		caculator.pack();
		caculator.setTitle("CACULATOR");
		caculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		caculator.setLocationRelativeTo(null);
		caculator.setVisible(true);
		
	}
}
