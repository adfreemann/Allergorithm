import javax.swing.JOptionPane;
public class welcome{
	public static void main(String[] args) 
	{
		int x;
		Circle c = new Circle(-10);
		System.out.println(c.radius);
	}
}

class Circle
{
	Circle() {
		radius = 5;
	}
	Circle(double r) {
		init(r);
	}

	private double radius;

	public double area(){
		return radius * radius * 3.14159;
};