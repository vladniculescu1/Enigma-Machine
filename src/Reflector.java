public class Reflector extends Rotor
{
	/*
	 * this class represents the reflector of the machine
	 * the reflector represents a final 'rotor'
	 * it changes the letters as a normal rotor would but then it sends the letter back through all the previous rotors
	 */
	public Reflector(String name)
	{
		initialise(name);
	}
	
	//depending on the type of reflector, a different mapping is used
	public void initialise(String name) 
	{
		if(name.equals("ReflectorI"))
		{
			mapping = new int[] { 24, 17, 20, 7, 16, 18, 11, 3, 15, 23, 13, 6, 14, 10, 12, 8, 4, 1, 5, 25, 2, 22, 21, 9, 0, 19 };
		}
		else
		{
			mapping = new int[] { 5, 21, 15, 9, 8, 0, 14, 24, 4, 3, 17, 25, 23, 22, 6, 2, 19, 10, 20, 16, 18, 1, 13, 12, 7, 11 };
		}
	}

	public int substitute(int positionInArray) 
	{
		return mapping[positionInArray];
	}
}