package dmit2015.demo03;

public class TestCircle {

	public static void main(String[] args) {
		// Create a circle with radius 1
		Circle circle1 = new Circle();
		System.out.println("The area of the circle with radius "
				+ circle1.getRadius()
				+ " is " 
				+ circle1.area());
		
		// Create a circle with radius 25
		Circle circle2 = new Circle(25);
		System.out.println("The area of the circle with radius "
				+ circle2.getRadius()
				+ " is " 
				+ circle2.area());
		
		// Change the radius of circle2 to 125
		try {
			circle2.setRadius(-125);
			System.out.println("The area of the circle with radius "
					+ circle2.getRadius()
					+ " is " 
					+ circle2.area());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
