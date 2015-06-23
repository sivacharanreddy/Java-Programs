package miscellaneous;

import java.util.Arrays;
import java.util.Scanner;

public class Hackerrank_substr 
{

	public static void substrcount(String input)
	{
		// sort the string
		char input_chars[] = input.toCharArray();
		Arrays.sort(input_chars);
		String sorted_input = new String(input_chars); 
		System.out.println(sorted_input);
		
		// find the number of desired substrings
		int char_count = 1;
		int substr_count = 0;
		int i;
		
		for(i=0; i<sorted_input.length()-1; i++)
		{
			if(sorted_input.charAt(i) == sorted_input.charAt(i+1))
			{
				char_count++;
			}	
			else
			{
				System.out.println(sorted_input.charAt(i)+":"+char_count);
				substr_count = substrcounthelper(char_count, substr_count);
				char_count = 1;
			}
		} // n-1 iterations
		
		System.out.println(sorted_input.charAt(i)+":"+char_count);
		substr_count = substrcounthelper(char_count, substr_count);
		System.out.println("Total number of desired substrings:" +substr_count);
	}
	
	public static int substrcounthelper(int char_count, int substr_count)
	{
		if(char_count==1)
			substr_count = substr_count+1;
		else
			substr_count = substr_count + char_count + ((char_count)*(char_count-1))/2;
		
		return substr_count;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Enter the string");
		Scanner s = new Scanner(System.in);
		String input = s.next();
		substrcount(input);
	}

}
