package com.maruti.files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilesOperations {
public static void main(String[] args) {
	readTxtFile();
}


//How to read a file in Java 8
private static void readTxtFile() {
	///Java 8 Interview QA/src/com/maruti/resource/Intro.txt
	try {
		Files.lines(Paths.get("C:\\Users\\ADMIN\\eclipse-workspace\\Java 8 Interview QA\\src\\com\\maruti\\resource\\Intro.txt"), StandardCharsets.UTF_8).forEach(System.out::println);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}
}
