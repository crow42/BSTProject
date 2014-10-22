import java.io.*;
import java.util.*;


public class TestBST {
	public static void main(String[] args)
	{
		//myList to store all the string in the textfile
		ArrayList<String> myList = new ArrayList<>();
		//read the file
		myList = readFile("testList.txt");
		System.out.println("My list is valid: " + checkBST(myList));
		BST<String> newTree = new BST<String>();
		for(String val: myList)
		{
			newTree.insert(val);
		}
		System.out.println("My tree");
		newTree.inorder();
		System.out.println();
		newTree.postorder();
	}
	
	public static ArrayList<String> readFile(String fileName)
	{
		ArrayList<String> myList = new ArrayList<>();
		try(
		    	//read the file
		    	BufferedReader br = new BufferedReader(new FileReader(fileName))) 
		    	{
		        //read each line of the file
		        String line = br.readLine();
		        //loop to read all the line in file
		        while (line != null) {
		        	//split the string into an array list
		        	String[] arrList = line.trim().split(" ");
		            //append the line into content
		        	myList.addAll(Arrays.asList(arrList));
		        	//read the next line
		            line = br.readLine();
		        }

		        //display the output
		        System.out.println(myList);
		        return myList;
		        
		    } catch (FileNotFoundException e) {
		    	System.out.println("File not found");
		    	return myList;
			} catch (IOException e) {
				System.out.println("IOException");
				return myList;
			}
	}
	//check if the arraylist is valid or not
	public static boolean checkBST(ArrayList<String> list)
	{
		//sort an arrayList
		Collections.sort(list);
		//compare to see if there is any duplicate element
		for(int i=0;i<list.size();i++)
		{
			if(i == 0)
			{
				if(list.get(i).equals(list.get(i+1)))
				{
					return false;
				}
			}
			else if(i == (list.size()-1))
			{
				if(list.get(i).equals(list.get(i-1)))
				{
					return false;
				}
			}
			else
			{
				if(list.get(i).equals(list.get(i-1))||list.get(i).equals(list.get(i+1)))
				{
					return false;
				}
			}
		}
		//check if the 
		return true;
	}

}
