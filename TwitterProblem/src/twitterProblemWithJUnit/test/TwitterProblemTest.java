package twitterProblemWithJUnit.test;

import org.junit.Test;
import junit.framework.TestCase;
import twitterProblemWithJUnit.main.TwitterProblem;

public class TwitterProblemTest extends TestCase{

	@Test
	public void testSetValuesOfArray(){
		int[] inputArray = {2, 5, 1, 2, 3, 4, 7, 7, 6};
		TwitterProblem.setValuesOfArray(inputArray);
		assertEquals(inputArray,TwitterProblem.getArray());
	}
	@Test
	public void testSearchAbsoluteMax(){
		int absoluteMax = TwitterProblem.searchAbsoluteMax(TwitterProblem.getArray());
		assertEquals("the answer should be 7",7,absoluteMax);
	}
	@Test
	public void testGettingOfAbsoluteMax(){
		int absoluteMax = TwitterProblem.getAbsoluteMax();
		assertEquals("the answer should be 7",7,absoluteMax);
	}
	@Test
	public void testCalculateVolume(){
		int volume = TwitterProblem.calculateVolume();
		assertEquals("the answer should be 10",10,volume);
	}
}
