public class EnigmaMachine 
{	
	//this class represents the actual enigma machine and all its components
	public Plugboard enigmaPlugboard;
	public BasicRotor rotors[];
	public Reflector enigmaReflector;

	//the constructor adds the plugboard and the array of rotros
	public EnigmaMachine()
	{
		enigmaPlugboard = new Plugboard();
		rotors = new BasicRotor[3];
	}
	
	public void addPlug(char end1, char end2)
	{
		enigmaPlugboard.addPlug(end1, end2);
	}
	
	public void clearPlugboard()
	{
		enigmaPlugboard.clear();
	}
	
	private void addRotor(BasicRotor rotor, int slot)
	{
		rotors[slot] = rotor;
	}
	
	private BasicRotor getRotor(int slot)
	{
		return rotors[slot];
	}
	
	private void addReflector(Reflector reflector)
	{
		enigmaReflector = reflector;
	}
	
	private Reflector getReflector()
	{
		return enigmaReflector;
	}
	
	public void setPosition(int slot, int position)
	{
		rotors[slot].position = position;
	}
	
	//this method is used to encode each letter using all the rotors and the reflector
	public char encodeLetter(char letter)
	{
		int number;
		//first, the letter goes through the plugboard
		letter = this.enigmaPlugboard.substitute(letter);
		//the letter is then converted to a numeric value for ease of use
		number = (int)(letter - 'A');
		
		//the letter is encoded through all the rotors
		for(int i = 0; i <=2 ; i++)
		{
			number = rotors[i].substitute(number);
		}
		
		//the letter is encoded through the reflector
		number = enigmaReflector.substitute(number);
		//the letter is encoded back through all the rotors
		for(int i = 2; i >= 0; i--)
		{
			number = rotors[i].substituteBack(number);
		}
		
		//the letter is turned back into the char type
		letter = (char)(number + 'A');
		//the letter goes again through the plugboard
		letter = this.enigmaPlugboard.substitute(letter);
		
		rotors[0].rotate();
		return letter;
	}
	
	/*
	 * this method is used to run the different tests of the coursework
	 * Instructions are detailed in the 'enigma.txt' file
	 * each test or challenge tunes the enigma machine to the required settings
	 */
	public void start()
	{
		//TEST 1
//	/*
		this.enigmaPlugboard.addPlug('A', 'M');
		this.enigmaPlugboard.addPlug('G', 'L');
		this.enigmaPlugboard.addPlug('E', 'T');
		
		BasicRotor rotor0 = new BasicRotor("I");
		BasicRotor rotor1 = new BasicRotor("II");
		BasicRotor rotor2 = new BasicRotor("III");
		Reflector reflector = new Reflector("ReflectorI");
		
		rotor0.setPosition(6);
		rotor1.setPosition(12);
		rotor2.setPosition(5);
		
		this.addRotor(rotor0, 0);
		this.addRotor(rotor1, 1);
		this.addRotor(rotor2, 2);
		this.addReflector(reflector);
//	*/
		//TEST 2
	/*	
		this.enigmaPlugboard.addPlug('B', 'C');
		this.enigmaPlugboard.addPlug('R', 'I');
		this.enigmaPlugboard.addPlug('S', 'M');
		this.enigmaPlugboard.addPlug('A', 'F');
		
		BasicRotor rotor0 = new BasicRotor("IV");
		BasicRotor rotor1 = new BasicRotor("V");
		BasicRotor rotor2 = new BasicRotor("II");
		Reflector reflector = new Reflector("ReflectorII");
		
		rotor0.setPosition(23);
		rotor1.setPosition(4);
		rotor2.setPosition(9);
		
		this.addRotor(rotor0, 0);
		this.addRotor(rotor1, 1);
		this.addRotor(rotor2, 2);
		this.addReflector(reflector);
	*/
		//TEST 3
	/*	
		this.enigmaPlugboard.addPlug('Q','F');
		
		TurnoverRotor rotor0 = new TurnoverRotor("I");
		TurnoverRotor rotor1 = new TurnoverRotor("II");
		TurnoverRotor rotor2 = new TurnoverRotor("III");
		Reflector reflector = new Reflector("ReflectorI");
		
		rotor0.setNextRotor(rotor1);
		rotor1.setNextRotor(rotor2);
		
		rotor0.setPosition(23);
		rotor1.setPosition(11);
		rotor2.setPosition(7);
		
		this.addRotor(rotor0, 0);
		this.addRotor(rotor1, 1);
		this.addRotor(rotor2, 2);
		this.addReflector(reflector);
	*/	
		//CHALLENGE 1
	/*
		BasicRotor rotor0 = new BasicRotor("IV");
		BasicRotor rotor1 = new BasicRotor("III");
		BasicRotor rotor2 = new BasicRotor("II");
		Reflector reflector = new Reflector("ReflectorI");
		
		rotor0.setPosition(8);
		rotor1.setPosition(4);
		rotor2.setPosition(21);
		
		this.addRotor(rotor0, 0);
		this.addRotor(rotor1, 1);
		this.addRotor(rotor2, 2);
		this.addReflector(reflector);
	*/	
		//CHALLENGE 2
	/*	
		this.enigmaPlugboard.addPlug('H', 'L');
		this.enigmaPlugboard.addPlug('G', 'P');
		
		BasicRotor rotor0 = new BasicRotor("V");
		BasicRotor rotor1 = new BasicRotor("III");
		BasicRotor rotor2 = new BasicRotor("II");
		Reflector reflector = new Reflector("ReflectorI");
		
		this.addRotor(rotor0, 0);
		this.addRotor(rotor1, 1);
		this.addRotor(rotor2, 2);
		this.addReflector(reflector);
	*/
		//CHALLENGE 3
	/*	
		this.enigmaPlugboard.addPlug('M','F');
		this.enigmaPlugboard.addPlug('O','I');
		
		//the positions are initially set to random values in order for the constructor to work
		BasicRotor rotor0 = new BasicRotor("V");
		BasicRotor rotor1 = new BasicRotor("III");
		BasicRotor rotor2 = new BasicRotor("II");
		Reflector reflector = new Reflector("ReflectorI");
		
		rotor0.setPosition(22);
		rotor1.setPosition(24);
		rotor2.setPosition(23);
		
		this.addRotor(rotor0, 0);
		this.addRotor(rotor1, 1);
		this.addRotor(rotor2, 2);
		this.addReflector(reflector);
	*/
	}
}
