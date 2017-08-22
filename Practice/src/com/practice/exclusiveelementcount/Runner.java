package com.practice.exclusiveelementcount;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		int i,l1,l2,n=0,count=0,t=0; 
		System.out.println("Enter the size of the array 1");
		Scanner sc = new Scanner(System.in);
		l1=sc.nextInt();
		int[] arr1 = new int[l1];
		System.out.println("Enter the array");
		for(i=0;i<l1;i++)
			arr1[i]=sc.nextInt();
		System.out.println("Enter the size of the array 2");
		l2=sc.nextInt();
		int[] arr2 = new int[l2];
		System.out.println("Enter the array");
		for(i=0;i<l2;i++)
			arr2[i]=sc.nextInt();
		int[] arr3 = new int[l1+l2];

		for(i=0;i<l1;i++)
		{
			t=0;
			while(arr1[i]!=arr2[t])
			{
				t++;
				if(t==l2) break;
			}
			if(t==l2)
			{
				arr3[n++]=arr1[i];
				count++;
			}
		}
		
		for(i=0;i<l2;i++)
		{
			t=0;
			while(arr2[i]!=arr1[t])
			{
				t++;
				if(t==l1)break;
			}
			if(t==l1)
			{
				arr3[n++]=arr2[i];
				count++;
			}
		}
		
		System.out.println("Exclusive element count: "+count);
	}

}
