/*
* Emmanuel Onwuka
* September, 29 2016
* CS 201
* Programming Project 1
*
* This class is created to read  a file into the Tree.
*  and write the data in the tree into a text file
*/

import java.io.*;
import java.util.Scanner;
public  class readFile {
	static private Scanner x;
	
	/*
	 * Method to open the file provided by the user
	 */
	public static  void openFile(String name){
		try{
			 x = new Scanner(new File(name));
		}
		catch(Exception e){
			System.out.println("No Dictionary Found!!!");
		}
	}
	/* Method to read the opened file
	 * storing 2 lines, First as the term and next as the meaning
	 * then storing it in the binary tree
	 */
	public static BinarySearchTree<String> ReadFile(BinarySearchTree<String> T){
		while(x.hasNext()){
			String a = x.nextLine();
		
			String b = x.nextLine();
			T.insert(a, b);	
		}
		return T;
	}
	// Close the opened file
	public void closeFile(){
		x.close();
	}
	/*
	 * I know, weird name!!!!!
	 * This method writes the data in the tree to a new text file
	 */
	public void Opener(String myFile,BinarySearchTree<String> t){
		try{		
			PrintWriter  o = new PrintWriter(new FileWriter(myFile));
			BufferedWriter bw = new BufferedWriter(o);
			while( o.checkError());
			{
			bw.write(t.printTree());
			}
			bw.close();
		}catch(Exception e){
			System.out.println("An error has been found, Please read instruction carefully.");
		}
	}
	
	

}
