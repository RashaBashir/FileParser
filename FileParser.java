/*
 * Assignment#4 Comp_249 winter 21....
 * @author Rasha Bashir ID(40153688)..
 * @author Hrithika Adla ID(40054701)..
 * PART NO<1>....
 */
 
import java.util.ArrayList;

import java.util.Scanner; 
import java.io.PrintWriter; 
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.File;

public class FileParser {
	/*
	 * removeDuplicates method accepts:
	 * @param ArrayList and check every element of the array to find the duplicate and remove it.
	 * @return array without duplicates..
	 */
	public static <A> ArrayList<A> removeDuplicates(ArrayList<A> originallist)
	{
		// Create a new ArrayList
		ArrayList<A> finalList = new ArrayList<A>();
		// loop through the first list
		for (A element : originallist) {
			// check if the array list has the same values.
			if (!finalList.contains(element)) {
				finalList.add(element);
			}
		}
		// return the new list
		return finalList;
	}
	public static void main(String[] args) throws FileNotFoundException {
		//ask the user to input the file name to process....
		System.out.println("Please enter the name of the file :");
		Scanner sc = new Scanner(System.in);
		String filename = sc.nextLine();
		//creating the arrays and opening the files .....
		ArrayList<String> listOfWords = new ArrayList<>();
		File vowel = new File("vowel_verbiage.txt");
		PrintWriter vpw= new PrintWriter(vowel);
		File obs =new File("obsessive_o.txt");
		PrintWriter opw= new PrintWriter(obs);
		File dist =new File ("distinct_data.txt");
		PrintWriter dpw= new PrintWriter(dist);
		ArrayList <String>vowelList = new ArrayList<>();
		ArrayList <String>oList = new ArrayList<>();
		ArrayList <String>dList = new ArrayList<>();
		ArrayList <String> nList = new ArrayList<>();
		int wcount = 0; 
		try {
			//read the files word by word and store them in an array...
			File file = new File(filename);
			Scanner inputFile = new Scanner(file);
			String line = null ;
			while(inputFile.hasNext()) {

				line=inputFile.next().replaceAll("[^a-zA-Z0-9]","");
				if (line.equals("")|| line==null) {
					listOfWords.remove(line);
				}else {
					listOfWords.add(line);
				}
			
				//if(listOfWords)
			}
			//listOfWords.removeAll(Arrays.asList("",null));
			int wordscount=0;
			for(int i =0 ; i<listOfWords.size();i++) {
				char ch = listOfWords.get(i).charAt(0);
				if(ch=='o'|ch=='O') {
					oList.add(listOfWords.get(i));
					wordscount++;  
				}
				else {
					continue;
				}
			}
			opw.print("words count: " + wordscount + "\n") ;
			for (int i=0;i<oList.size();i++) {
				opw.write(oList.get(i)+"\n");
			}
			opw.close();
			//search if the words that has more than three vowels...
			for(int i =0 ;i<listOfWords.size(); i++) {
				int Vowelcount=0;
				for(int j=0;j<listOfWords.get(i).length() ;j++)
				{
					char ch=listOfWords.get(i).charAt(j);   //Read the word char by char
					if(ch == 'a' || ch == 'e' || ch == 'i' ||ch == 'o' || ch == 'u'|| ch == 'A' || ch == 'E' || ch == 'I' ||ch == 'O' || ch == 'U')   //Checking for vowels
					{
						Vowelcount++;
					}
				}
				if(Vowelcount>3) {
					vowelList.add(listOfWords.get(i));
					wcount++;
				}
				else {
					continue;
				}
			}
			vpw.print("words count: " + wcount + "\n") ;
			for (int i=0;i<vowelList.size();i++) {
				vpw.write(vowelList.get(i)+"\n");
			}
			vpw.close();
			//finding the duplicate words,print them out into dList and the write them out to the text flie"distanct file" ...

			dList= removeDuplicates(listOfWords);
			dpw.write("Words count :" +dList.size()+"\n" );
			for (int i=0;i<dList.size();i++) {
				dpw.write(dList.get(i)+"\n");				
			}
			dpw.close();
			inputFile.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
//C:\Users\rasha\eclipse-workspace\Assi#4\history_of_java.txt