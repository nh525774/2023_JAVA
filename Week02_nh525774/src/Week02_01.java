class Circle {
	protected int radius;
	public Circle(int r) {radius=r;}
}

class Pizza extends Circle {
	String name;
	public Pizza(String name, int r) {
		super (r);
		this.name=name;}

	public void print() {
		System.out.println(name+" 피자- "+"둘레: "+radius);
		
	}
}
public class Week02_01 {

	public static void main(String[] args) {
		Pizza obj=new Pizza("Pepperoni", 20);
		obj.print();
	}

}
