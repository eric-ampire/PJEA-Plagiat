package fr.univ_lille1.fil.pjea;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UncheckedIOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class PlagiatVEMPTest {
	
	public static final String TEST_FILE_DIR = "src/test/resources/";

	public static final String TEST_FILE_NB_TOKEN_12 = TEST_FILE_DIR + "fileNbT12.java";
	public static final String TEST_FILE_NB_TOKEN_8  = TEST_FILE_DIR + "fileNbT8.java";

	public static final String[] TEST_PACK_1 = new String[] {
			TEST_FILE_DIR + "test_pack_1/file1.java",
			TEST_FILE_DIR + "test_pack_1/file1copy.java",
			TEST_FILE_DIR + "test_pack_1/file1modif.java",
			TEST_FILE_DIR + "test_pack_1/file1rearanged.java"
	};
	
	public static final String[] TEST_PACK_2 = new String[] {
			TEST_FILE_DIR + "test_pack_2/BigFile1.java",
			TEST_FILE_DIR + "test_pack_2/BigFile2.java"
	};
	
	// IMPORTANT : ne pas mettre de jeu de test trop lourd. On réserve ça pour des
	// tests manuels
	
	// TODO ajouter d'autres jeu de test (et créer une méthode de test associé, ci-dessous)
	
	
	
	
	
	// DONT TOUCH
	private static final PrintStream STDOUT = System.out;

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.setOut(STDOUT); // restaure stdout in System.out;
	}
	// ----------
	
	
	ByteArrayOutputStream outputContent;

	@Before
	public void setUp() throws Exception {
		outputContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputContent, true));
	}

	@After
	public void tearDown() throws Exception {
		outputContent = null;
	}
	

	
	
	@Test
	public void testOutputResult() {
		PlagiatVEMP.outputResult("F1F1", "F2F2", 0.42);
		assertEquals("F1F1 and F2F2: 42%"+System.lineSeparator(), outputContent.toString());
		outputContent.reset();
		
		PlagiatVEMP.outputResult("toto", "titi", 0);
		assertEquals("toto and titi: 0%"+System.lineSeparator(), outputContent.toString());
		outputContent.reset();
		
		PlagiatVEMP.outputResult("toto", "titi", 1);
		assertEquals("toto and titi: 100%"+System.lineSeparator(), outputContent.toString());
		outputContent.reset();
		
		PlagiatVEMP.outputResult("toto", "titi", 1.2);
		assertEquals("toto and titi: 100%"+System.lineSeparator(), outputContent.toString());
		outputContent.reset();
		
		PlagiatVEMP.outputResult("toto", "titi", -0.3);
		assertEquals("toto and titi: 0%"+System.lineSeparator(), outputContent.toString());
		outputContent.reset();
	}
	

	@SuppressWarnings("static-method")
	@Test
	public void testPlagiatVEMP() {
		assertNotNull(new PlagiatVEMP()); // inutile, mais c'est juste pour la couverture de code
	}
	
	

	/*
	 * 
	 * Les méthodes de tests pour main().
	 * Chacun exécute une seule fois la fonction main.
	 * et le contenu de la sortie standard est récupérable
	 * via outputContent.toString();
	 */
	
	@Test
	public void testMainNoFile() {
		PlagiatVEMP.main(new String[0]);
		assertEquals("", outputContent.toString());
	}

	@Test
	public void testMainOneFile() {
		PlagiatVEMP.main(new String[] {TEST_PACK_1[0]});
		assertEquals("", outputContent.toString());
	}

	@Test
	public void testMainPack1() {
		PlagiatVEMP.main(TEST_PACK_1);
		String output = outputContent.toString();
		assertNotSame("", output);
		fail("Vérifier la sortie (nombre de ligne, ...)");
	}

	@Test
	public void testMainPack2() {
		PlagiatVEMP.main(TEST_PACK_2);
		String output = outputContent.toString();
		assertNotSame("", output);
		fail("Vérifier la sortie (nombre de ligne, ...)");
	}

	@SuppressWarnings("static-method")
	@Test(expected=UncheckedIOException.class)
	public void testMainFileNotExist() {
		PlagiatVEMP.main(new String[] {"target/.unexistant_file"});
	}
	

}
