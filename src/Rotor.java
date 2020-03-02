public abstract class Rotor
{
	/*
	 * this abstract class represents the rotor
	 * it's subclasses are the BasicRotor, TurnoverRotor and Reflector
	 * each of those classes have the following methods and variables
	 */
	public String name;
	public int position;
	public int[] mapping;
	public final int ROTORSIZE = 26;
	
	public void setPosition(int positionToSet)
	{
		position = positionToSet;
	}
	
	public int getPosition()
	{
		return position;
	}
	
	public abstract void initialise(String type);
	
	public abstract int substitute(int x);

}
