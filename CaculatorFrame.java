package Caculator;


import java.awt.*;    
import java.awt.event.*;
import java.awt.Image; 

import javax.swing.*;
import javax.swing.JOptionPane;


public class CaculatorFrame extends JFrame{
	
	private JLabel showLabel;
	private JLabel resultLabel;
	private JTextField showTextField;
	private JTextField resultTextField;
	private JPanel showPanel;
	private JPanel resultPanel;
	private JPanel sRPanel;
	private JPanel numberPanel;
	private JPanel signPanel1;
	private JPanel signPanel2;
	private JPanel clearPanel;
	private JPanel s2CPanel;
	private JPanel bottomPanel;
	private JButton zeroButton;
	private JButton oneButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton sixButton;
	private JButton sevenButton;
	private JButton eightButton;
    private JButton nineButton;
    private JButton pointButton;
    private JButton addButton;
    private JButton minusButton;
    private JButton multiButton;
    private JButton dividButton;
    private JButton remaindButton;
    private JButton revNumberButton;
    private JButton opoNumberButton;
    private JButton resultButton;
    private JButton backButton;
    private JButton clearButton;
    private JButton pasteButton;
    private Computing computing;
  
    public CaculatorFrame(){
    	
    	designForPanel();
    	setWindowIcon();
    	addNumberButtonActionListener();
    	addSignButtonActionListener();
    	addChangeButtonActionListener();
    	addResultActionListener();
    	addClearButtonActionListener();
    	addPasteButtonActionListener();
    }
    
    class NumberButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		if(e.getSource() == zeroButton){
    			showTextField.setText(showTextField.getText() + "0");
    		}else if(e.getSource() == oneButton){
    			showTextField.setText(showTextField.getText() + "1");
    		}else if(e.getSource() == twoButton){
    			showTextField.setText(showTextField.getText() + "2");
    		}else if(e.getSource() == threeButton){
    			showTextField.setText(showTextField.getText() + "3");
    		}else if(e.getSource() == fourButton){
    			showTextField.setText(showTextField.getText() + "4");
    		}else if(e.getSource() == fiveButton){
    			showTextField.setText(showTextField.getText() + "5");
    		}else if(e.getSource() == sixButton){
    			showTextField.setText(showTextField.getText() + "6");
    		}else if(e.getSource() == sevenButton){
    			showTextField.setText(showTextField.getText() + "7");
    		}else if(e.getSource() == eightButton){
    			showTextField.setText(showTextField.getText() + "8");
    		}else if(e.getSource() == nineButton){
    			showTextField.setText(showTextField.getText() + "9");
    		}else if(e.getSource() == pointButton){
    			showTextField.setText(showTextField.getText() + ".");
    		}
    	}
    }
    
    class SignButtonListener implements ActionListener{

    	public void actionPerformed(ActionEvent e){
    		computing = new Computing();
    		e.getActionCommand();
    			try{
    				
    		if(showTextField.getText() == null)
    		    throw new NumberFormatException("Syntax Error");
    	
    			
    		if((e.getSource() == addButton)){
    			computing.setOperatingNumber(Double.parseDouble(showTextField.getText()));
    			computing.setOperator('+');
    			showTextField.setText(null);
    		}else 	if((e.getSource() == minusButton)){
    			computing.setOperatingNumber(Double.parseDouble(showTextField.getText()));
    			computing.setOperator('-');
    			showTextField.setText(null);
    		}else   if((e.getSource() == multiButton)){
    			computing.setOperatingNumber(Double.parseDouble(showTextField.getText()));
    			computing.setOperator('*');
    			showTextField.setText(null);
    		}else 	if((e.getSource() == dividButton)){
    			computing.setOperatingNumber(Double.parseDouble(showTextField.getText()));
    			computing.setOperator('/');
    			showTextField.setText(null);
    		}else 	if((e.getSource() == remaindButton)){
    			computing.setOperatingNumber(Double.parseDouble(showTextField.getText()));
    			computing.setOperator('%');
    			showTextField.setText(null);
    		}
    	}
    		catch (NumberFormatException ex){
    			JOptionPane.showMessageDialog(null, "Syntax error !","TIPS",JOptionPane.INFORMATION_MESSAGE);
    		}
    	}
    	
    }
    
    class ChangeButtonListener implements ActionListener{
    	public void actionPerformed(ActionEvent e){
    		double t;
    		try{
    			if(showTextField.getText() == null)
    				throw new NumberFormatException("There is not operated number in the show text field .");
    		if( e.getSource() == opoNumberButton){
    			t = 1 / Double.parseDouble(showTextField.getText());
    			resultTextField.setText("" + t);
    		}else if(e.getSource() == revNumberButton){
    			t = -Double.parseDouble(showTextField.getText());
    			resultTextField.setText("" + t);
    		}
    		   }
    		catch(NumberFormatException ex) {
    			JOptionPane.showMessageDialog(null, "Syntax error!","TIPS",JOptionPane.INFORMATION_MESSAGE);
    		}
    	}
    }
    
    class resultButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e){
    		double t;  
    		try{ 
    			if(showTextField.getText() == null || computing.getOperatingNumber() == -0.123456987)
    			{
    				throw new NullPointerException("Second operated number dose not have value");
    			}
    		if(computing.getOperator() == '+'){
    			t = computing.getOperatingNumber() + Double.parseDouble(showTextField.getText());
    			resultTextField.setText(t + "");
    		}else if(computing.getOperator() == '-'){
    			t = computing.getOperatingNumber() - Double.parseDouble(showTextField.getText());
    			resultTextField.setText(t + "");
    		}else if( computing.getOperator() == '*'){
    			t = computing.getOperatingNumber() * Double.parseDouble(showTextField.getText());
    			resultTextField.setText(t + "");
    		}else if(computing.getOperator() == '/'){
    			t = computing.getOperatingNumber() / Double.parseDouble(showTextField.getText()) * 1.0;
    			resultTextField.setText(t + "");
    		}else if(computing.getOperator() == '%'){
    			t = computing.getOperatingNumber() % Double.parseDouble(showTextField.getText());
    			resultTextField.setText(t + "");
    		}
 
    		}
    		catch (NumberFormatException ex){
    			JOptionPane.showMessageDialog(null, "Syntax error !","TIPS",JOptionPane.INFORMATION_MESSAGE);
    		}
    		catch(NullPointerException ex){
    			JOptionPane.showMessageDialog(null, "Syntax error !","TIPS",JOptionPane.INFORMATION_MESSAGE);
    		}
    	}

	
    }
    
    class ClearButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e){
    		
    		try{
    			if(showTextField.getText() == null)
    				throw new StringIndexOutOfBoundsException("The show text field has been aready empty .");
    		if(e.getSource() == backButton){
    			showTextField.setText(showTextField.getText().substring(0, showTextField.getText().length() - 1));
    		}else if(e.getSource() == clearButton){
    			showTextField.setText("");
    	   		resultTextField.setText("");
    		}
    		   }
    		catch(StringIndexOutOfBoundsException ex) {
    			JOptionPane.showMessageDialog(null, "Syntax error !","TIPS",JOptionPane.INFORMATION_MESSAGE);
    		}
    	}
    
    }
    
    class PasteButtonListener implements ActionListener{
    	
    	public void actionPerformed(ActionEvent e){
    		showTextField.setText(resultTextField.getText());

    	}
    }
    
    public void designForPanel(){
    	
    	Font font = new Font("SansSerif",Font.BOLD,20);
    	Font font1 = new Font("SansSerif",Font.BOLD,16);
    	showLabel = new JLabel("PROCESS :");
        showLabel.setSize(80, 60);
        showLabel.setForeground(Color.BLUE);
        showLabel.setFont(font1);
    	showTextField = new JTextField();
    	showTextField.setEditable(false);
    	showTextField.setBackground(Color.LIGHT_GRAY);
    	showTextField.setForeground(Color.BLACK);
    	showTextField.setFont(font);
    	showTextField.setSize(240, 60);
    	showPanel = new JPanel();
    	showPanel.setLayout(new GridLayout(1,2));
    	showPanel.setSize(320, 60);
    	showPanel.setBackground(Color.BLACK);
    	showPanel.add(showLabel);
    	showPanel.add(showTextField);
    	
    	resultTextField = new JTextField();
    	resultTextField.setEditable(false);
    	resultTextField.setBackground(Color.LIGHT_GRAY);
    	resultTextField.setForeground(Color.BLACK);
    	resultTextField.setFont(font);
    	resultTextField.setSize(240, 60);
    	resultLabel = new JLabel("RESULT :");
        resultLabel.setSize(80, 60);
        resultLabel.setForeground(Color.BLUE);
        resultLabel.setFont(font1);
    	resultPanel = new JPanel();
    	resultPanel.setLayout(new GridLayout(1,2));
    	resultPanel.setSize(320, 60);
    	resultPanel.setBackground(Color.BLACK);
    	resultPanel.add(resultLabel);
    	resultPanel.add(resultTextField);
    	
    	sRPanel = new JPanel();
    	sRPanel.setSize(320, 120);
    	sRPanel.setLayout(new GridLayout(2,1));
    	sRPanel.add(showPanel);
    	sRPanel.add(resultPanel);
    	
    	numberPanel = new JPanel();
    	numberPanel.setSize(240, 180);
    	numberPanel.setLayout(new GridLayout(3,3));
    	numberPanel.add(oneButton = new JButton("1"));
    	oneButton.setBackground(Color.ORANGE);
    	oneButton.setFont(font1);
    	numberPanel.add(twoButton = new JButton("2"));
    	twoButton.setBackground(Color.ORANGE);
    	twoButton.setFont(font1);
    	numberPanel.add(threeButton = new JButton("3"));
    	threeButton.setBackground(Color.ORANGE);
    	threeButton.setFont(font1);
    	numberPanel.add(fourButton = new JButton("4"));
    	fourButton.setBackground(Color.ORANGE);
    	fourButton.setFont(font1);
    	numberPanel.add(fiveButton = new JButton("5"));
    	fiveButton.setBackground(Color.ORANGE);
    	fiveButton.setFont(font1);
    	numberPanel.add(sixButton = new JButton("6"));
    	sixButton.setBackground(Color.ORANGE);
    	sixButton.setFont(font1);
    	numberPanel.add(sevenButton = new JButton("7"));
    	sevenButton.setBackground(Color.ORANGE);
    	sevenButton.setFont(font1);
    	sixButton.setFont(font1);
    	numberPanel.add(eightButton = new JButton("8"));
    	eightButton.setBackground(Color.ORANGE);
    	eightButton.setFont(font1);
    	numberPanel.add(nineButton = new JButton("9"));
    	nineButton.setBackground(Color.ORANGE);
    	nineButton.setFont(font1);
    	
    	signPanel1 = new JPanel();
    	signPanel1.setSize(240, 120);
    	signPanel1.setLayout(new GridLayout(2,2));
    	signPanel1.add(zeroButton = new JButton("0"));
    	zeroButton.setBackground(Color.GRAY);
    	zeroButton.setFont(font1);
    	signPanel1.add(pointButton = new JButton("."));
    	pointButton.setBackground(Color.GRAY);
    	pointButton.setFont(font);
    	signPanel1.add(addButton = new JButton("+"));
    	addButton.setBackground(Color.GRAY);
    	addButton.setFont(font1);
    	signPanel1.add(opoNumberButton = new JButton("1/X"));
    	opoNumberButton.setBackground(Color.GRAY);
    	opoNumberButton.setFont(font1);
    	opoNumberButton.setToolTipText("Get reciprocal .");
    	signPanel1.add(minusButton = new JButton("-"));
    	minusButton.setBackground(Color.GRAY);
    	minusButton.setFont(font);
    	signPanel1.add(multiButton = new JButton("*"));
    	multiButton.setBackground(Color.GRAY);
    	multiButton.setFont(font);
    	signPanel1.add(dividButton = new JButton("/"));
    	dividButton.setBackground(Color.GRAY);
    	dividButton.setFont(font);
    	signPanel1.add(remaindButton = new JButton("%"));
    	remaindButton.setBackground(Color.GRAY);
    	remaindButton.setFont(font1);
    	
    	s2CPanel = new JPanel();
    	s2CPanel.setSize(80, 180);
    	s2CPanel.setLayout(new GridLayout(5,1));
    	s2CPanel.add(clearButton = new JButton("AC"));
    	clearButton.setBackground(Color.GRAY);
    	clearButton.setForeground(Color.CYAN);
    	clearButton.setFont(font1);
    	clearButton.setToolTipText("Clear all data from process and result text field .");
    	s2CPanel.add(backButton = new JButton("C"));
    	backButton.setBackground(Color.GRAY);
    	backButton.setForeground(Color.CYAN);
    	backButton.setFont(font1);
    	backButton.setToolTipText("Reback last data of entering .");
    	s2CPanel.add(pasteButton = new JButton("PASTE"));
    	pasteButton.setBackground(Color.GRAY);
    	pasteButton.setForeground(Color.CYAN);
    	pasteButton.setFont(font1);
    	pasteButton.setToolTipText("Past result text to Process field .");
    	s2CPanel.add(resultButton = new JButton("="));
    	resultButton.setBackground(Color.GRAY);
    	resultButton.setFont(font1);
    	s2CPanel.add(revNumberButton = new JButton("=/-"));
    	revNumberButton.setBackground(Color.GRAY);
    	revNumberButton.setFont(font1);
    	revNumberButton.setToolTipText("Invert the sign .");
    	
    	
    	bottomPanel = new JPanel();
    	bottomPanel.setLayout(new BorderLayout());
    	bottomPanel.add(numberPanel,BorderLayout.CENTER);
    	bottomPanel.add(signPanel1, BorderLayout.SOUTH);
    	bottomPanel.add(s2CPanel, BorderLayout.EAST);
    	
    	this.setLayout(new BorderLayout());
    	this.add(sRPanel,BorderLayout.CENTER);
    	this.add(bottomPanel,BorderLayout.SOUTH);
    }
    
    public void setWindowIcon(){
    	
    	ImageIcon imageIcon = new ImageIcon("ooopic_1497321706.png");
    	this.setIconImage(imageIcon.getImage());
    }
    
    public void addNumberButtonActionListener(){
    	
    	zeroButton.addActionListener(new NumberButtonListener());
    	oneButton.addActionListener(new NumberButtonListener());
    	twoButton.addActionListener(new NumberButtonListener());
    	threeButton.addActionListener(new NumberButtonListener());
    	fourButton.addActionListener(new NumberButtonListener());
    	fiveButton.addActionListener(new NumberButtonListener());
    	sixButton.addActionListener(new NumberButtonListener());
    	sevenButton.addActionListener(new NumberButtonListener());
    	eightButton.addActionListener(new NumberButtonListener());
    	nineButton.addActionListener(new NumberButtonListener());
    	pointButton.addActionListener(new NumberButtonListener());
    	
    }
    
    public void addSignButtonActionListener(){
    	
    	addButton.addActionListener(new SignButtonListener());
    	minusButton.addActionListener(new SignButtonListener());
    	multiButton.addActionListener(new SignButtonListener());
    	dividButton.addActionListener(new SignButtonListener());
    	remaindButton.addActionListener(new SignButtonListener());
    	
    }
    
    public void addChangeButtonActionListener(){
    	
    	revNumberButton.addActionListener(new ChangeButtonListener());
    	opoNumberButton.addActionListener(new ChangeButtonListener());
    }
    
    public void addResultActionListener(){
    	
    	resultButton.addActionListener(new resultButtonListener());
    }
    
    public void addClearButtonActionListener(){
    	
    	backButton.addActionListener(new ClearButtonListener());
    	clearButton.addActionListener(new ClearButtonListener());
    }
    
    public void addPasteButtonActionListener(){
    	pasteButton.addActionListener(new PasteButtonListener());
    }
}
