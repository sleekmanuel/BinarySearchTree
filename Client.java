/*
* Data Structures
*
* This method grants the user access to use the dictionary. it includes a menu and methods
*  for loading adding, displaying specific strings or the whole Tree and saving 
*  the Dictionary to a Text file
*/

import java.util.*;

public class BinarySearchTreeClient {
 static Scanner console = new Scanner(System.in);

static BinarySearchTree<String> T = new BinarySearchTree<>();
	
	// Main class  accesses the Display menu
	public  static void main(String[] args)
	{
		int n = -1;
		while (n != 0)
		{
			System.out.println();
		 n = DisplayMenu();	
			if (n == 1){
				OpenFile();
		}else if(n == 2){
				AddTerm();
		}else if(n == 3){
				LookUp();
		}else if(n ==4){
			RemoveTerm();
		}else if(n == 5){
			Display();
		}else if(n == 6){
			DispSpec();
		}else if(n==7){
			Save();
		}
				
		}
	}
	
	public static  int DisplayMenu(){ // Displays a menu for the user to choose from
		System.out.println("To Load file to Dictionary ENTER 1");
		System.out.println("To Add Term to dictionary ENTER 2 ");
		System.out.println("To Lookup Term in Dictionary ENTER 3");
		System.out.println("To Remove Term from Dictionary ENTER 4 ");
		System.out.println("To Display Entire Dictionary ENTER 5");
		System.out.println("To Display all terms starting with a Specific String ENTER 6");
		System.out.println("To Save Dictionay to File ENTER 7");
		System.out.println("To Quit ENTER 0");
		
		System.out.print(" Pick an option from the menu: ");
		int n = console.nextInt();
		
		return n;
		
		
	}
	/*
	 * Asks the user for the file to open and calls the readFile class
	 * opens, reads and closes the file
	 */
	public static  void OpenFile(){
		System.out.print("Provide the name of the file (with .txt extension) : ");
		console.nextLine();
		String name = console.nextLine();
				readFile r = new readFile();
				readFile.openFile(name);
			     readFile.ReadFile(T);
				r.closeFile();	
	}
	/*
	 * To insert terms in node/ Dictionary
	 * Asks for Word and meaning
	 */
	public  static void AddTerm(){
		System.out.println("Enter Word: ");
		String word = console.next();
		System.out.println("Enter Meaning: ");
		console.nextLine();
		String meaning = console.nextLine();

		T.insert(word, meaning);
	}
	/*
	 * Asks user for word to look up
	 * If word not available, a message will be returned to the user
	 * If available, function calls contains function
	 */
	
	// revisit look up.... somehow this bitchy method cant search more than one word
	public static void LookUp(){
		System.out.print("Enter word to lookup: ");
		String w = console.next();
		if(!T.contains(w)){
			System.out.println("Word not Found!");
	}	
 }
	/*
	 * Asks user for word
	 * If word isn't in dictionary, a message will be returned to the user
	 * also returns the definition of the word to show exact... 
	 * word that was deleted
	 */
	public static  void RemoveTerm(){
		System.out.println("Enter Term to be removed: ");
		String remove = console.next();
		//System.out.println("Enter Meaning to be removed");
		//String Mean = console.next(); 
		if(!T.contains(remove)){
			System.out.println("Term and Meaning not Found! ");
			
		}else 
			System.out.println("Word and Meaning above has been removed!");
			T.remove(remove);
	}
	// Recursive Method to display the dictionary
	public static  void Display(){
		T.printTree();
	}
	/// this fucking method is not even working at all... revisit that shit
	public static void DispSpec(){
		System.out.println("Enter word to be searched: ");
		String Word = console.next();
		T.disp(Word);
		
	}
	// Method to save Tree to a new Text file with name created by the user
	public static  void Save(){
		System.out.print("Provide the name of the file (with .txt extension) : ");
		console.nextLine();
		String myFile = console.nextLine();
		readFile r = new readFile();
		r.Opener(myFile,T);
	}
	}
