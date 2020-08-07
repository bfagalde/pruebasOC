package proxycomparator.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ComparadorBinario {

	public static void main(String[] args) throws IOException {
		// File f1 = new File("C:\\tmp\\standalone.conf");
		// File f2 = new File("C:\\tmp\\\\standalone.conf.2");
		File f1 = new File("C:\\tmp\\bfagalde-intranet - Copy.cer");
		File f2 = new File("C:\\tmp\\\\bfagalde-intranet.cer");

		boolean result = FileUtils.contentEquals(f1, f2);
		if (!result) {
			System.out.println("Files content are not equal.");
		} else {
			System.out.println("Files content are equal.");
		}

		result = FileUtils.contentEquals(f1, f1);
		if (!result) {
			System.out.println("Files content are not equal.");
		} else {
			System.out.println("Files content are equal.");
		}
	}

	public static boolean comparefiles(String f1Name, String f2Name) throws IOException {
		File f1 = new File(f1Name);
		File f2 = new File(f2Name);

		boolean result = FileUtils.contentEquals(f1, f2);
		/*
		 * if(!result){ System.out.println("Files content are not equal."); }else{
		 * System.out.println("Files content are equal."); }
		 */
		return result;
	}

}
