package Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class WordCount 
{
	public static void wordcount() throws Exception
	{
		BufferedReader in = new BufferedReader(new FileReader("sample"));
		ArrayList words_dict = new ArrayList(); 
		String line;
		
		// Read each line, parse it into tokens and add them to list
		while((line = in.readLine()) != null)
		{
			StringTokenizer parser = new StringTokenizer(line);
			while(parser.hasMoreTokens())
			{
				String word = parser.nextToken().toLowerCase().replaceAll("[.,!$@]","");
				words_dict.add(word);
			}
		}
		
		// Sort the list
		Collections.sort(words_dict);
		
		String curr=null, prev = null;
		int value = 1, iter = 0;
		Iterator iterate = words_dict.iterator();
		
		// Iterate through words list and find the frequency
		while(iterate.hasNext())
		{
			curr = (String)iterate.next();
			if(iter == 0)
			{
				prev = curr;
				iter++;
				continue;
			}
			if(prev.equals(curr))
			{
				value++;
			}
			else
			{
				System.out.println(prev+":"+value);	
				value = 1;
			}
			prev = curr;
			iter++;
		}
		System.out.println(prev+":"+value);
	}
	
	public static void main(String[] args) throws Exception
	{		
		wordcount();
	}

}
