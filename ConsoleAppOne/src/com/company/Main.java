package com.company;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	String personName = "Joro";
	int personAge = 25;
	double personHeight = 1.73;

	System.out.println(personName + " is " + personAge + " years old and is " + personHeight + " meters tall.");

	double firstValue = 21034.4;
	double secondValue = 21034.6;

	double result = firstValue + secondValue;

	System.out.println("The result is " + result);
	System.out.println();

	//Problem 9 below

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	System.out.println("The date is: " + dtf.format(now));

	LocalDateTime afterHours = now.plusHours(20);
	System.out.println("The date after 20 hours will be: " + dtf.format(afterHours));
	System.out.println();

	double firstNumber = 34.4;
	double secondNumber = 34.6;
	double sum = firstNumber + secondNumber;
	System.out.println("The first double variable is: " + firstNumber + "\nThe second double variable is: " + secondNumber + "\nCombined they make: " + sum);
	System.out.println();

	Scanner in = new Scanner(System.in);
	System.out.print("Hello, what is the number that you wish to add 10 to? ");
	double userInputNumber = in.nextDouble();
	System.out.println("Your number plus 10 is: " + (userInputNumber + 10));
	System.out.println();

	System.out.print("Hello, please provide a valid integer: ");
	int firstIntegerInput = in.nextInt();
	System.out.println("Thank you. Now please provide a second valid integer: ");
	int secondIntegerInput = in.nextInt();
	int productInteger = firstIntegerInput * secondIntegerInput;
	System.out.println("The product of the integers provided by you is: " + productInteger);
	System.out.println();

	for (int x = 1; x<=1000; x = x+1 )
    {
        System.out.print(x + " ");

    }
    }
}
