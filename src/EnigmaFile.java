import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
public class EnigmaFile
{
	//this class is used for reading and writing files
	/*
	 * this method creates a reader and a buffer and prints out the output
	 * although an output file is created, the output is actually displayed on the console
	 * this was a design choice for easier debugging
	 */

	public void print(EnigmaMachine myMachine)
	{
		//the reader and writer objects are set up
		BufferedReader reader = null;
		FileOutputStream fileOut = null;
		try
		{
			fileOut = new FileOutputStream("Output.txt");
		}
		catch(IOException e)
		{
			System.out.println("File not found");
		}
		PrintStream writer = new PrintStream(fileOut);
		
		String sentence;
		try
		{
			reader = new BufferedReader(new FileReader("Input.txt"));
			while(reader.ready())
			{
				String line = reader.readLine();
				
				//Beginning of extension
				//method learned from stackoverflow.com
				line = line.replaceAll("[^a-zA-Z]", "");
				line = line.toUpperCase();
				line = line.replaceAll("\\s+","");
				//end of extension
				
				//the line from the file read is converted into a string builder so each charactre can be individually encoded
				StringBuilder sb = new StringBuilder();
				char[] charArray = line.toCharArray();
				for(char character: charArray)
				{
					sb.append(myMachine.encodeLetter(character));
				}
				sentence = sb.toString();
				
				System.out.println(sentence);
			
			 /*
				if(sentence.contains("ANSWER"))
				{
					System.out.print("The plugs that were used are: ");
					for(Plug n: myMachine.enigmaPlugboard.plugboard)
					{
						System.out.print(n.getEnd1() + "-" + n.getEnd2() + " ");
					}
					System.out.println();
					System.out.println(sentence);
					System.out.println();
				}
			 */
			/*
				if(sentence.contains("ELECTRIC"))
				{
					System.out.println("The first rotor's positions is " + myMachine.rotors[0].getPosition());
					System.out.println("The second rotor's positions is " + myMachine.rotors[1].getPosition());
					System.out.println("The third rotor's positions is " + myMachine.rotors[2].getPosition());
					System.out.println();
					System.out.println(sentence);
					System.out.println();
				}
			*/
			/*
				if(sentence.contains("JAVA"))
				{
					System.out.println("The first rotor is type " + myMachine.rotors[0].name);
					System.out.println("The second rotor is type " + myMachine.rotors[1].name);
					System.out.println("The third rotor is type " + myMachine.rotors[2].name);
					System.out.println();
					System.out.println(sentence);
					System.out.println();
				}
			*/
			}
			reader.close();
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println("File not found");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
