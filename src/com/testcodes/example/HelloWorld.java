package com.testcodes.example;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y,z;
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter x value:");
		x = scn.nextInt();
		System.out.println("Enter y value:");
		y = scn.nextInt();
		System.out.println("x="+x+" y="+y);
		System.out.println("Hello World");
		z=x;
		x=y;
		y=z;
		System.out.println("x="+x+" y="+y);

	}

}
