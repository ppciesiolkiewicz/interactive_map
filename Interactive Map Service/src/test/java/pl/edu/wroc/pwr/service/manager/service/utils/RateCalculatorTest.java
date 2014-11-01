package pl.edu.wroc.pwr.service.manager.service.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RateCalculatorTest {

	private RateCalculator calculator;

	@Before
	public void setUp() throws Exception {
		calculator = new RateCalculator();
	}

	@Test
	public void shouldReturnZeroIfNullPassed() throws Exception {
		//when
		double avg = calculator.avg(null);
		//then
		assertEquals(0.0, avg, 0.00001);
	}

	@Test
	public void shouldReturnZeroIfEmptyListPassed() throws Exception {
		//when
		double avg = calculator.avg(new ArrayList<Integer>());
		//then
		assertEquals(0.0, avg, 0.00001);
	}

	@Test
	public void shouldCalculateAverage() throws Exception {
		//given
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(7);
		numbers.add(7);
		//when
		double avg = calculator.avg(numbers);
		//then
		assertEquals(6.3333, avg, 0.001);
	}
}