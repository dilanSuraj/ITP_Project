package inv_dis_mgmtsys.model;

public class DataPoint {
	
    private int x = 0;
    private int y=0;
    
    private int year;
    
    public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
		
	}

	private double income = 0,expense = 0,profit = 0;
 
	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income += income;
		
	}

	public double getExpense() {
		return expense;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setExpense(double expense) {
		this.expense += expense;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public void setX(int x){
		System.out.println("Inside x");
		this.x = this.year;
		
	}
	
	public void setY(int y){
		this.y=this.year;
	}
	
	

}
