package io.github.picoledelimao.animationduplicator;
import java.lang.reflect.InvocationTargetException;

import io.github.picoledelimao.mdl.MDLModel;
public class AnimationDuplicator {

	public static void readFile(String input, String output) {
		try {
			System.out.println("Reading file " + input + "...");
			MDLModel model = MDLModel.readFromFile(input);
			System.out.println("Saving to file " + output + "...");
			model.writeToFile(output);
			System.out.println("Done!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		readFile("C:\\Users\\Abner Matheus\\Desktop\\Juugo.mdl", "C:\\Users\\Abner Matheus\\Desktop\\Tenso.mdl");
		//System.out.println("FInished reading");
		/*Scanner sc = new Scanner(System.in);
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
		
		sc.close();*/
	}

} 
