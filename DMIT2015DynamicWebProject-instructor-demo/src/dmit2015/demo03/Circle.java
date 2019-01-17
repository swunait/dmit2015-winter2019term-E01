package dmit2015.demo03;

public class Circle {
	
	/** The radius of this circle */
	private double radius = 1;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) throws Exception {
		if (radius > 0) {
			this.radius = radius;
		} else {
			throw new Exception("Radius value must be > 0");
		}
	}
	
//	public void setRadius(double radius) {
//		if (radius > 0) {
//			this.radius = radius;
//		} else {
//			throw new RuntimeException("Radius value must be > 0");
//		}
//	}

	public Circle() {
//		radius = 1;
	}

	public Circle(double newRadius) {
		radius = newRadius;
	}
	
	public double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public double circumference() {
		return 2 * Math.PI * radius;
	}

}
