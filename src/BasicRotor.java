public class BasicRotor extends Rotor 
{
	/*
	 * this class represents the basic rotor
	 * a rotor changes a letter that goes in through it's mapping
	 * eventually, it will change the letter again through an inverse mapping
	 */
	private int[] inverseMapping = new int[26];
	
	public BasicRotor(String typeToSet)
	{
		name = typeToSet;
		initialise(name);
	}

	//depending on the type of rotor, a different mapping is used
	public void initialise(String name) 
	{
		if(name.equals("I"))
		{
			 mapping = new int[] { 4, 10, 12, 5, 11, 6, 3, 16, 21, 25, 13, 19, 14, 22, 24, 7, 23, 20, 18, 15, 0, 8, 1, 17, 2, 9 };
		}
		else if(name.equals("II"))
		{
			mapping = new int[] { 0, 9, 3, 10, 18, 8, 17, 20, 23, 1, 11, 7, 22, 19, 12, 2, 16, 6, 25, 13, 15, 24, 5, 21, 14, 4 };
		}
		else if(name.equals("III"))
		{
			mapping = new int[] { 1, 3, 5, 7, 9, 11, 2, 15, 17, 19, 23, 21, 25, 13, 24, 4, 8, 22, 6, 0, 10, 12, 20, 18, 16, 14 };	
		}
		else if(name.equals("IV"))
		{
			mapping = new int[] {4, 18, 14, 21, 15, 25, 9, 0, 24, 16, 20, 8, 17, 7, 23, 11, 13, 5, 19, 6, 10, 3, 2, 12, 22, 1 };	
		}
		else
		{
			mapping = new int[] { 21, 25, 1, 17, 6, 8, 19, 24, 20, 15, 18, 3, 13, 7, 11, 23, 0, 22, 12, 9, 16, 14, 5, 4, 2, 10 };
		}
	}
	
	//this is the method that changes the letter using the mapping of the rotor
	public int substitute(int positionInArray) 
	{
		int positionToReturn = positionInArray - position;
		
		//depending on the rotor's innitial position, a different mapping has to be used
		//in order for the mapping to not go out of bounds, we need to make the 'circular'
		if(positionToReturn < 0)
		{
			positionToReturn += ROTORSIZE; 
		}
		
		positionToReturn = mapping[positionToReturn] + position;
		positionToReturn= positionToReturn % ROTORSIZE;
		return positionToReturn;
	}
	
	//this method works in the same way as the substitute method, the only difference being the mapping of the rotor which is inverse
	public int substituteBack(int positionInArray)
	{
		for(int n : mapping)
		{
			inverseMapping[mapping[n]] = n;
		}
		
		int positionToReturn = positionInArray - position;
		
		if(positionToReturn < 0)
		{
			positionToReturn += ROTORSIZE; 
		}
		
		positionToReturn = inverseMapping[positionToReturn] + position;
		positionToReturn= positionToReturn % ROTORSIZE;
		return positionToReturn;
	}
	
	/*
	 * this method 'rotates' the rotor
	 * this means that each time the rotor is rotated (after every use), the position is incremented by one
	 */
	public void rotate()
	{
		position++;
		if(position == ROTORSIZE)
		{
			position = 0;
		}
	}
}
