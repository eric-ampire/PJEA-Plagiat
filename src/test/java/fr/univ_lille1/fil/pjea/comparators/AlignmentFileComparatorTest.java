package fr.univ_lille1.fil.pjea.comparators;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.univ_lille1.fil.pjea.PlagiatVEMPTest;
import fr.univ_lille1.fil.pjea.data.ComparisonResult;
import fr.univ_lille1.fil.pjea.data.Java8File;

public class AlignmentFileComparatorTest {
	
	@SuppressWarnings("static-method")
	@Test
	public void testComputeDifference() throws Exception {
		ComparisonResult res = new AlignmentFileComparator(
				new Java8File(PlagiatVEMPTest.TEST_PACK_1[0]), // file1.java
				new Java8File(PlagiatVEMPTest.TEST_PACK_1[1])) // file1copy.java
				.computeDifference();
		assertEquals(1, res.similarityRate, 0.01);
	}
	
	@SuppressWarnings("static-method")
	@Test
	public void testComputeDifference2() throws Exception {
		ComparisonResult res = new AlignmentFileComparator(
				new Java8File(PlagiatVEMPTest.TEST_PACK_1[0]), // file1.java
				new Java8File(PlagiatVEMPTest.TEST_FILE_NB_TOKEN_12))
				.computeDifference();
		assertEquals(0, res.similarityRate, 0.01);
	}
	
}
