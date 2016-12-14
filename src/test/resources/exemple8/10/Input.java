package util;

import java.io.IOException;
import java.util.Scanner;

/**
 * A tool class, to read String and int from standard input
 *
  */
public class Input {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * read a String from standard input
	 * 
	 * @return the read string
	 */
	public static String readString() {
			return Input.scanner.next();
	}

	/**
     * read an int from standard input
     * 
	 * @return the read int
	 * @exception java.io.IOException if input does not correspond to an int
	 */
	public static int readInt() throws java.io.IOException {
		try {
			return Input.scanner.nextInt();
		} catch (Exception e) {
			Input.scanner.skip(".*");
			throw new java.io.IOException();
		}
	}
	
	// to test Input
	public static void main(String[] args) {
		
		System.out.print(" chaine : ? ");
		String chaineLue = Input.readString();
		System.out.println("lue  => " + chaineLue);
		int intLu;
		try {
			System.out.print(" int : ? ");
			intLu = Input.readInt();
			System.out.println("lu  => " + intLu);
		} catch (java.io.IOException e) {
		    //"exception... : la saisie n'est pas un entier";
		    // on peut par exemple ici fournir une valeur par défaut : 
		    intLu = 0;
			System.out.println("corrigé  => " + intLu);
		}
   	 }
}// Input