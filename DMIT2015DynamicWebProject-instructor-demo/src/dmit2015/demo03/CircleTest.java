package dmit2015.demo03;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircleTest {

	@Test
	public void testArea() {
		Circle circle1 = new Circle(25);
		// The area should be 1963.5
		assertEquals(1963.5, circle1.area(), 0.1);		
	}

	@Test
	public void testCircumference() {
		Circle circle1 = new Circle(25);
		// The circumference should be 
		assertEquals(157.1, circle1.circumference(), 0.1);
	}
	
	@Test(expected=Exception.class)
	public void shouldThrowException() throws Exception {
		Circle circle1 = new Circle();
		circle1.setRadius(-125);
	}
	
	@Test(expected=ArithmeticException.class)
	public void shouldThrowDivisionByZeroException() {
		assertEquals(0, 3 / 0);
	}
	
	

}
