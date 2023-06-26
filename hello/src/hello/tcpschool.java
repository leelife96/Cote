package hello;
import java.util.*;

class Car implements Comparable<Car> {
	private String modelName;
	private int modelYear;
	private String color;
	
	Car(String mn, int my, String c){
		this.modelName = mn;
		this.modelYear = my;
		this.color = c;
	}
	
	public String getModel() {
		return this.modelYear + "식" + this.modelName + " " + this.color;
	}
	
	 public int compareTo(Car obj) {

	        if (this.modelYear == obj.modelYear) {

	            return 0;

	        } else if(this.modelYear < obj.modelYear) {

	            return -1;

	        } else {

	            return 1;

	        }

	    }
}

public class tcpschool {
	public static void main(String[] args) {
		
	Car car01 = new Car("아반떼", 2016, "노란색");
	Car car02 = new Car("소나타", 2010, "흰색");
	
	System.out.println(car01.compareTo(car02));
	}
  }



