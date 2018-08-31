package inv_dis_mgmtsys.model;

public class DataPoint {
	
    private int x,y;
    
    private int year;
    
    public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	private double income,expense,profit;
 
	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income += income;
	}

	public double getExpense() {
		return expense;
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
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	

}
