package com.dexesttp.hkxpack.view;

import java.io.IOException;

import com.dexesttp.hkxpack.Main;
import com.dexesttp.hkxpack.resources.ClassFilesUtils;
import com.dexesttp.hkxpack.resources.RandomUtils;

public class ConsoleView {
	private static String version_number = "v0.0.1-alpha";

	public static void main(String[] args) {
		Main main = new Main();
		if(args.length < 0 || args[0] == "-h")
			showHelp();
		String fileName = args[0];
		String outName = RandomUtils.makeFromFileName(fileName);
		try {
			ClassFilesUtils.initFolder();
		} catch (IOException e) {
			System.err.println("Error while reading class list.");
			e.printStackTrace();
			System.exit(1);
		}
		main.exec(fileName, outName);
	}

	private static void showHelp() {
		System.out.println("hkxpack version " + version_number );
		System.out.println("Use : java -jar hkpack.jar <filename>.hkx");
		System.out.println("Report bugs or findings at github.com/dexesttp/hkxpack");
	}
}
