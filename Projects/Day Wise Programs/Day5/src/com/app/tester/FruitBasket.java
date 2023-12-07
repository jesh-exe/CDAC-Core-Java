package com.app.tester;

import java.util.Scanner;

import com.app.fruits.*;

public class FruitBasket {

	public static boolean check(int count, int size)
	{
		return count > size ? false : true;
	}

	public static void main(String[] args)
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Size of Basket: ");
		final Fruit[] basket = new Fruit[sc.nextInt()];
		boolean exit = true;
		int count = 0;
		int size = basket.length - 1;

		while (exit)
		{

			System.out.print("\n\t\t\tFruit Basket" + "\n1.Add Mango" + "\n2.Add Orange" + "\n3.Add Apple"
					+ "\n4.Display Name of all Fruits" + "\n5.Display All Properties of Fresh Fruits"
					+ "\n6.Mark a Fruit as Stale" + "\n7.Mark all Sour Fruits Stale"
					+ "\n8.Invoke Fruit Special Functionality" + "\n9.Exit\nCHOICE: ");

			switch (sc.nextInt())
			{

			case 1: // Mango
				if (check(count, size))
				{
					System.out.println("\nEnter Mango Details(Color, Weight, Name)");
					basket[count++] = new Mango(sc.next(), sc.nextDouble(), sc.next());

				}
				else
				{
					System.out.println("\nBasket is Full!....");
				}
				break;

			case 2: // Orange
				if (check(count, size))
				{
					System.out.println("\nEnter Orange Details(Color, Weight, Name)");
					basket[count++] = new Orange(sc.next(), sc.nextDouble(), sc.next());
				}
				else
				{
					System.out.println("\nBasket is Full!....");
				}
				break;

			case 3: // Apple
				if (check(count, size))
				{
					System.out.println("\nEnter Apple Details(Color, Weight, Name)");
					basket[count++] = new Apple(sc.next(), sc.nextDouble(), sc.next());
				}
				else
				{
					System.out.println("\nBasket is Full!....");
				}
				break;

			case 4:
				System.out.println("\nNames of All Fruit in Basket");
				System.out.println("+---------------------------------------------------------------+");
				for (Fruit fruit : basket)
				{
					if (fruit != null) System.out.println(fruit.getName());
				}
				System.out.println("+---------------------------------------------------------------+");
				break;

			case 5:
				System.out.println("\n\nProperties of all FRESH Fruit in Basket\n");
				for (Fruit fruit : basket)
				{
					if (fruit != null)
					{

						System.out.println("+---------------------------------------------------------------+");
						System.out.println("Name: " + fruit.getName());
						System.out.println("Color: " + fruit.getColor());
						System.out.println("Weight: " + fruit.getWeight());
						if (fruit.getFresh() == true)
						{
							System.out.println("Taste: " + fruit.taste());
						}
						else if (fruit.getFresh() == false)
						{
							System.out.println("Taste: NOT FRESH");
						}
					}
				}
				System.out.println("+---------------------------------------------------------------+");
				break;

			case 6:
				System.out.print("\nEnter Index to mark fruit Stale: ");
				int index = sc.nextInt();
				--index;
				if (check(index, size))
				{
					if (basket[index] == null)
					{
						System.out.println("\nNo Fruit at this Index...!");
					}
					else
					{
						basket[index].setFresh(false);
						System.out.println("\nFruit Marked as Stale....!");
					}
				}
				else
				{
					System.out.println("\nInvalid Index...Try Again...!!");

				}
				break;

			case 7:
				int index1 = 0;
				for (Fruit temp : basket)
				{
					if (temp != null)
					{
						if (index1 <= count)
						{
							temp.equals(basket[index1]);
							index1++;
						}
					}
				}
				System.out.println("\nAll Sour Fruits Marked Stale!");

				break;

			case 8:

				System.out.print("\nEnter Index to Extract (Pulp/Juice/Jam): ");
				int index2 = sc.nextInt();
				--index2;

				if (check(index2, size))
				{

					if (basket[index2] == null)
					{
						System.out.println("\nNo Fruit Found at this Index...!");
					}
					else
					{
						if (basket[index2] instanceof Mango) ((Mango) basket[index2]).pulp();

						else if (basket[index2] instanceof Orange) ((Orange) basket[index2]).juice();

						else((Apple) basket[index2]).jam();
					}

				}
				else
				{

					System.out.println("\nIndex out of Range!....");
				}

				break;

			case 9:
				exit = false;
				break;

			default:
				System.out.println("\nInvalid Input...Check Again!");
				break;
			}

		}
		sc.close();
	}

}
