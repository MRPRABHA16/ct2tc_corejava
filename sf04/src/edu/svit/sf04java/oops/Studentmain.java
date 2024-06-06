package edu.svit.sf04java.oops;

public class Studentmain
{
	public static void main(String[] args)
	{
		student studentone = new student();
		System.out.println(studentone);
		
		student studenttwo = new student(101,"uday","ISE","Banglore");
		System.out.println(studenttwo);
	}

}
