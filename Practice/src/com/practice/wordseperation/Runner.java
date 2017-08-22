package com.practice.wordseperation;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		int i,count=0;
		System.out.println("Enter the sentence");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		for (i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c=='"' && s.charAt(i-1)==' ')
			{
				count++;
				System.out.print(c);
			}
			else if(c==' ' && s.charAt(i-1)=='"' && count==1)
			{
				System.out.println();
				count--;
			}
			else if(c==' ' && count==1 && s.charAt(i-1)!=' ')
			{
				System.out.print(c);
			}
			else if(c==' ' && s.charAt(i-1)!=' ' && count==0)
			{
				System.out.println();
			}
			else if(c!=' ')
			{
				System.out.print(c);
			}
		}
	}

}
