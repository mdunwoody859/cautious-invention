package com.company;

import sun.util.resources.cldr.yo.CurrencyNames_yo;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {

		int choice = GetProduct();
		if (choice == 0) {
			while (choice == 0) {
				System.out.println("Error. Please try again and input 1, 2 or 3\n");
				choice = GetProduct();
			}
		}
		String order = "";
		switch (choice) {

			case 1:
				order = "Tractor";
			case 2:
				order = "Handbag";
			case 3:
				order = "Shed";
			default:
				break;
		}
		int no = GetAddressNo(order);
		if (no == 0) {
			while (no == 0) {
				System.out.println("Error. Please try again and input 1, 2 or 3\n");
				no = GetAddressNo(order);
			}
		}
		String[] addresses = PopulateAddresses(no);
		System.out.println("thank you for your order of our famous "+order + " product");
		System.out.println("they will be delivered to the following addresses:");
		for (String item: addresses
			 ) {
			System.out.println("\t" + item);
		}
	}

	public static int GetProduct() {

		String welcomeMessage = "Hello and welcome to my online shop. Here you can order one of 3 amazing products we have in stock." +
				"\nPress the corresponding number to order:\n\t1.A tractor\n\t2.A handbag\n\t3.A shed";
		System.out.println(welcomeMessage);
		Scanner myScanner = new Scanner(System.in);
		//Implement error handling to deal with non numeric data
		if (!isInteger(myScanner.next())) {
			return 0;
		}
		int selection = myScanner.nextInt();
		if (selection == 1 || selection == 2 || selection == 3) {
			return selection;
		} else {
			return 0;
		}
	}

	public static int GetAddressNo(String order) {

		String message = String.format("How many addresses will you need a " + order + " delivered to?");
		System.out.println(message);
		Scanner myScanner = new Scanner(System.in);
		//Implement error handling to deal with non numeric data
		if (!isInteger(myScanner.next())) {
			return 0;
		} else {
			return myScanner.nextInt();
		}
	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}


	public static String[] PopulateAddresses(int no) {
    	String[] addresses = new String[no];
    	Scanner myScanner = new Scanner(System.in);
		for (int i = 0; i < no; i++) {
			System.out.println("Please type in address number "+i+1);
			String address = myScanner.next();
			addresses[i] = address;
		}
		return addresses;
	}

}

