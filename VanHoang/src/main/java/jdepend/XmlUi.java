package jdepend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import jdepend.xmlui.*;

public class XmlUi {
	public static void main(String[] args) throws IOException {
		runXmlUi("T:\\VanHoang\\Library-Assistant",  //directory project
				"T:\\VanHoang\\src\\main\\resources\\report.xml", //directory export xml
				"T:\\jdepend-ui", //directory jdepend ui
				"be"); //directory package
	}	

	public static void runXmlUi(String project, String reportXml, String directoryJdependUi, String classPrefix)
			throws IOException {
		JDepend jdpXml = new JDepend(new PrintWriter("T:\\VanHoang\\src\\main\\resources\\report.xml"));
		jdpXml.addDirectory("T:\\VanHoang\\Library-Assistant");
		jdpXml.analyze();
		System.out.println("DONE directory report.xml saved: ");
		System.out.print(reportXml);
		ProcessBuilder processBuilder = new ProcessBuilder();

		processBuilder.command("cmd.exe", "/c", "cd " 
		+ directoryJdependUi 
		+ "&& npm run jdepend-ui " 
		+ reportXml 
		+ " "
		+ classPrefix 
		+ " && index.html");

		
		//handle cmd.exe
		try {

			Process process = processBuilder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			int exitCode = process.waitFor();
			System.out.println("\nExited with error code : " + exitCode);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
