package fi_maven_test;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalCulateTest {

	@Test
	public void laskSummaTest() {
		int sum =0;
		sum = CalCulate.laskeSumma(4, 2);
		assertEquals(6, sum);
	}
	
	@Test
public  void laskMinnusTest() {
	int subt =0;
	subt = CalCulate.laskeMinnus(4, 2);
	assertEquals(2, subt);
	}
	
	
	@Test
public  void laskKertausTest() {
	int mult =0;
	mult = CalCulate.laskeKerta(4, 2);
	assertEquals(8, mult);		
}
	
}
