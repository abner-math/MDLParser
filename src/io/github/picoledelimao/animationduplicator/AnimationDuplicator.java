package io.github.picoledelimao.animationduplicator;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

import io.github.picoledelimao.mdl.core.MDLNotFoundException;
import io.github.picoledelimao.mdl.core.MDLObject;
import io.github.picoledelimao.mdl.core.MDLParserErrorException;
public class AnimationDuplicator {

	public static void readFile(String input, String output) {
		/*try {
			 FileReader inputFile = new FileReader(input);
			 BufferedReader bufferReader = new BufferedReader(inputFile);
			 StringBuilder sb = new StringBuilder();
			 String line;
			 while ((line = bufferReader.readLine()) != null) {
				 sb.append(line + "\n");
			 }
			 bufferReader.close();
			 MDLFile file = new MDLFile();
			 file.parse(sb.toString());
			 FileWriter outputFile = new FileWriter(output);
			 outputFile.write(file.toMDL());
			 outputFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//readFile("C:\\Users\\Abner Matheus\\Desktop\\JuugoNew7.mdl", "C:\\Users\\Abner Matheus\\Desktop\\Tenso.mdl");
		//System.out.println("FInished reading");
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (sc.hasNextLine()) {
			sb.append(sc.nextLine()).append("\n");
		} 
		String contents = sb.toString();
		MDLObject obj = null;// new MDLObject("Version");
		try {
			obj.parse(contents);
		} catch (MDLParserErrorException | MDLNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(obj);
		
		sc.close();
	}

} 
