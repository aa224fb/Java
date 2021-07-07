package aa224fb_assign2;

import static org.junit.Assert.*;

import org.junit.Test;

public class calculatorTest {

	@Test
	public void test() {
		Calculator calculator = new Calculator();
	    int sum = calculator.evaluate("1+2+3");
	    assertEquals(6, sum);
	}

}
