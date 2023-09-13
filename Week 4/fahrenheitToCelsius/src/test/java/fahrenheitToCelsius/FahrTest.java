package fahrenheitToCelsius;

import static org.junit.Assert.*;

import org.junit.Test;

public class FahrTest {
	
	@Test
	public void testFarCel () {
		assertEquals(7.22, FahrToCel.fahrCel(), 15.11);
		
	}
	@Test
	public void testSayHi () {
		assertEquals("Hello World", FahrToCel.sayHi());

}
@Test
public void returnFiveTest () {
		assertEquals(5,FahrToCel.returnNumber() );
}
}
