package com.practice.trapeziumpattern;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		int n,i,j,k,a=0,b=0,l=1,count=1;
		System.out.println("Enter the number");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		
		for(i=1;i<=n;i++)
		{
			j=n-i+1;
			while(j!=0)
			{
				count++;
				j--;
			}
		}
		count--;
		for(i=1;i<=n;i++)
		{
			j=n-i+1;
			while(j!=0)
			{
				count++;
				j--;
			}
		}
		System.out.println(count);
		
		
		for(i=1;i<=n;i++)
		{
			k=i;
			while(k!=0)
			{
				System.out.print("-");
				k--;
			}
			
			j=n-i+1;
			while(j!=0)
			{
				System.out.print(l+"*");
				l++;
				j--;
			}
			
			j=n-i+1;
				a=count;
				count-=j;
				b=count+1;
				while(b<=a)
				{
				System.out.print(b+"*");
				b++;
				}
			
			System.out.println();
		}
	}

}
