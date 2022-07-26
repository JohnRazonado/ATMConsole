import java.text.DecimalFormat;

public class Operation {

    public double add(double num1, double num2){
        return num1 + num2;
    }
    public double formatter(double number) { //more like formatter for the two decimal point
		return Double.valueOf(new DecimalFormat("#.##").format(number));
	}
}
