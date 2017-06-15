package Caculator;

public class Computing {
	private double operatingNumber = -0.123456987;
	private double operatedNumber = 0.123456987;
	private char operator = '@';
	private double result = 0;
	
	public void setOperatingNumber(double operatingNumber){
		this.operatingNumber = operatingNumber;
	}
	
	public double getOperatingNumber(){
		return operatingNumber;
	}
	
	public void setOperatedNumber(double operatedNumber){
		this.operatedNumber = operatedNumber;
	}
	
	public void setOperator(char operator){
		this.operator = operator;
	}
	
	public char getOperator(){
		return operator;
	}
	
	public double getResult(){
		return result;
	}

}
