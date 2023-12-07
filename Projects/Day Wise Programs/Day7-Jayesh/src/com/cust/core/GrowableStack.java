package com.cust.core;

public class GrowableStack implements Stack {

	Customer[] arr = new Customer[STACK_SIZE2];
	static int count = 0;

	@Override
	public void push(Customer obj)
	{
		arr[count++] = obj;
		System.out.println("--------------Element Pushed-------------");
	}

	public void display()
	{
		for (Customer customer : arr)
		{
			if (customer != null)
			{
				System.out.println(customer.toString());
			}
		}
	}

	public void top()
	{
		int pos = count - 1;
		if (arr[pos] != null)
		{
			System.out.println(arr[pos].toString());
		}
	}

	@Override
	public void pop()
	{
		if (count == 0)
		{
			System.out.println("---------------Stack Empty---------------");
			return;
		}
		top();
		arr[--count] = null;
		count--;
		System.out.println("--------------Element Popped---------------");
	}

}
