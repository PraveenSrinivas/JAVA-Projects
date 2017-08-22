package com.practice.evenskippattern;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		int i,j,k=1,n;
		System.out.println("Enter the number");
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		for(i=1;i<=n;i++)
		{
			if(i%2!=0)
			{
			for(j=1;j<=n;j++)
			{
				if(k==n*i)
					System.out.print(k);
				else
					System.out.print(k+"*");
				k++;
			}
			System.out.println();
			}
			else
				k+=n;
		}
		k=1;
		for(i=1;i<=n;i++)
		{
			if(i%2==0)
			{
			for(j=1;j<=n;j++)
			{
				if(k==n*i)
					System.out.print(k);
				else
					System.out.print(k+"*");
				k++;
			}
			System.out.println();
			}
			else
				k+=n;
		}
	}

}
