/*
* Emmanuel Onwuka
* September, 29 2016
* CS 201
* Programming Project 1
*
* This File contains the methods to create the binarySearch Tree for the dictionary, 
* Method for inserting new Terms, method for removing an already Existing Term, Method for
* Printing the Tree.
* .
*/
//import java.util.*;
//import java.io.*;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> 
{
	String Tree; // Used in writing to a new file
	/* Nested class for a node in the tree */
	private static class BinaryNode<AnyType>
	{
		//String Tree;
		String def; // Term Definition
		AnyType data;
		BinaryNode<AnyType> left;
		BinaryNode<AnyType> right;
		/*
		 * 
		 * @OverRide for the toStrings method to include the term definition
		 */
		@Override public String toString(){
			return  "" + data.toString() + "\n" + def;
		}
		
		//BinaryNode(AnyType item, String meaning)
		//{
			//this(item, null, null, "");
		//}
		
		BinaryNode(AnyType item, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt, String meaning)
		{
			data = item;
			left = lt;
			right = rt;
			def = meaning;
		}
	}
	
	/* Root of the tree */
	private BinaryNode<AnyType> root;
	
	/* Constructor */
	public BinarySearchTree()
	{
		root = null;
	}
	
	/* Clear the tree */
	public void makeEmpty()
	{
		root = null;
	}
	
	/* Check if the tree is empty */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	/* Check if an item is in the tree */
	public boolean contains(AnyType x)
	{
		return contains(x, root);
	}
	
	/* Internal method to find an item */
	private boolean contains(AnyType x, BinaryNode<AnyType> t)
	{
		if (t == null)
			return false;
		
		int result = x.compareTo(t.data);
		
		if (result < 0)
			return contains(x, t.left);
		else if (result > 0)
			return contains(x, t.right);
		else
			System.out.println(t.def);
			return true;
	}
	
	
	
	/* Find the minimum item in the tree */
	public AnyType findMin()
	{
		
		if (isEmpty())
			throw new NullPointerException();
		
		return findMin(root).data;
	}
	
	/* Internal method to find the smallest item.
	 * This is a recursive approach. 
	 */
	private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t)
	{
		if (t == null)
			return null;
		else if (t.left == null)
			return t;
		return findMin(t.left);
	}
	
	/* Find the maximum item in the tree */
	public AnyType findMax()
	{
		if (isEmpty())
			throw new NullPointerException();
		
		return findMax(root).data;
	}
	
	/* Internal method to find the largest item. 
	 * This is a non-recursive approach. 
	 */
	private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t)
	{
		if (t != null)
		{
			while (t.right != null)
				t = t.right;
		}
		
		return t;
	}
	
	/* Insert a node in the tree */
	public void insert(AnyType x, String meaning)
	{
		root = insert(x, root, meaning);
	}
	
	/* Internal method to insert a node(term) and its meaning.
	 * t is the root of the subtree.
	 * return the new root of the subtree
	 */
	private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t, String meaning)
	{
		if (t == null)
			return new BinaryNode<>(x, null, null, meaning);
			
		int result = x.compareTo(t.data);
		
		if (result < 0)
			t.left = insert(x, t.left, meaning);
		else if (result > 0)
			t.right = insert(x, t.right, meaning);
		else
			; // Duplicate; do nothing
		return t;
	}
	
	/* Remove a node */
	public void remove(AnyType x)
	{
		root = remove(x, root);
	}
	
	/* Internal method to remove from a subtree.
	 * word (x) and meaning is the item to remove.
	 * t is the root of the subtree.
	 * Returns the new root of the subtree.
	 */
	private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t)
	{
		if (t == null)
			return t;
		
		int result = x.compareTo(t.data);
		
		if (result < 0)
			t.left = remove(x, t.left);
		else if (result > 0)
			t.right = remove(x, t.right);
		else if (t.left != null && t.right != null) // Two children
		{
			t.data = findMin(t.right).data;
			t.right = remove(t.data, t.right);
		}
		else
			t = (t.left != null) ? t.left : t.right;
		
		return t;
	}
	
	/* Print the contents of the tree */
	public String printTree()
	{
		Tree = "";
		if (isEmpty())
			System.out.println("Empty tree");
		else
			printTree(root);
		
		System.out.println();
		return Tree;
	}
	
	/* Internal method to print a subtree in sorted order */
	private void printTree(BinaryNode<AnyType> t)
	{
		if (t != null)
		{
			
			printTree(t.left);
			System.out.println(t.data + " \n" + t.def);
			Tree +=t.data + " \n" + t.def + "\n";
			printTree(t.right);
			
		
			
		}
	}
	
	
	
	public BinaryNode<AnyType> find(AnyType key){
		root = find(key,root);
		return root ;
		
	}
	public BinaryNode<AnyType> find(AnyType key,BinaryNode<AnyType> current){
		 current = root;
	while (key.toString().compareTo(current.data.toString()) == 0){
			if(key.toString().compareTo(current.data.toString()) > 0){
				current = current.left;
			
			}else 
				current = current.right;
	}
		//return current;
	return current;
		
	}
	/*
	 *printTreeStrig uses the Users input to compare with Terms in the dictionary
	 * and return terms that are similar.
	 *
	 */
	
	public void printTreeString(AnyType x)
	{
		 printTreeString(x, root);
		
		
	}
	 private void printTreeString(AnyType x, BinaryNode<AnyType> t ){
		if (t !=null){
			//while (x.toString().compareTo(t.data.toString()) == 0){
			
			if (t.toString().contains(x.toString())){
				

					BinaryNode<AnyType> a = find(x);
					 
					System.out.println(a.data + "\n" + a.def);
					
				}else 
				System.out.println("Error! word not found ");
			System.out.println(t.toString());
			System.out.println(x.toString());
			
			
		 //return t;
		}
		}
	// public int getLeafCount(BinaryNode<AnyType> node){  
		//	 int i = 0;
		  // if(node == null)     
		   //  return 0;  
		   //if(node.left ==null && node.right==null)    
		    // return 1;     
		   //else
		  // i = getLeafCount(node.left)+ getLeafCount(node.right);  
		  // return i;
		// }
	 
	 public void disp(AnyType x)
		{
			root = disp(x, root);
			
		}
		
		/* Internal method to remove from a subtree.
		 * word (x) and meaning is the item to remove.
		 * t is the root of the subtree.
		 * Returns the new root of the subtree.
		 */
		private BinaryNode<AnyType> disp(AnyType x, BinaryNode<AnyType> t)
		{
			if (t == null)
				return t;
			
			int result = x.compareTo(t.data);
			
			if (result < 0)
				t.left = disp(x, t.left); //System.out.println(t.data + "\n" + t.def);
			     
			else if (result > 0)
				t.right = disp(x, t.right);
			else if (t.left != null && t.right != null) // Two children
			{
				t.data = findMin(t.right).data;
				t.right = disp(t.data, t.right);
			}
			else
				t = (t.left != null) ? t.left : t.right;
			
			return t;
		}

}
	 