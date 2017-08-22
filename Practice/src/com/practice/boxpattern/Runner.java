/*
n=4              n=3

4 4 4 4			3 3 3
4 1 1 4			3 1 3
4 2 2 4			3 2 3
4 3 3 4			3 3 3
4 4 4 4 
*/
package com.practice.boxpattern;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		int i,j,k=0,n;
		System.out.println("Enter the number");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		for(i=1;i<n+2;i++)
		{
			for(j=1;j<=n;j++)
			{
				if(j>1 && j<n && i>1 && i<n+1)
					System.out.print(k+" ");
				else
				System.out.print(n+" ");
			}
			k++;
			System.out.println();
		}
	}

}
