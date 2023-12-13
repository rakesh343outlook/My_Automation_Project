package junit;


	import org.junit.jupiter.api.Assertions;
	import org.junit.jupiter.api.Test;

	public class CalculatorTest {
		
		@Test
		public void AddtitionTest1() {
			
			Calculator cal = new Calculator();
			int actResult = cal.Add(5, 6);
			int expResult = 11;
			
			Assertions.assertEquals(expResult, actResult);
			
		}
		
		@Test
		public void SubTest1() {
			
			Calculator cal = new Calculator();
			
			int actResult = cal.Sub(11, 6);
			int expResult = 5;
			
			Assertions.assertEquals(expResult, actResult);

			
		}


}
