package com.epam.lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FilesUtil {
	/**
	 * 
	 * @param path
	 */
	public static void delete(String path) {
		File index = new File(path);
		if(!index.exists()) {
			return;
		}
		String[] entries = index.list();
		for (String s : entries) {
			File currentFile = new File(index.getPath(), s);
			if (currentFile.isDirectory()) {
				delete(currentFile.toString());
				currentFile.delete();
			} else {
				currentFile.delete();
			}
		}
		try {
			Files.delete(index.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param source
	 * @param destination
	 * @throws IOException
	 */
	public static void copy(String source, String destination) throws IOException {
		File sourceFile = new File(source);
		File destinationFile = new File(destination);
		if (!destinationFile.exists()) {
			destinationFile.mkdir();
		}

		String[] entries = sourceFile.list();
		for (String s : entries) {
			File currentFile = new File(sourceFile.getPath(), s);
			File currentDestFile = new File(destinationFile.getPath(), s);
			if (currentFile.isDirectory()) {

				Files.copy(currentFile.toPath(), currentDestFile.toPath());

				copy(currentFile.toString(), currentDestFile.toString());
			} else {

				Files.copy(currentFile.toPath(), currentDestFile.toPath());

			}
		}

	}
}
