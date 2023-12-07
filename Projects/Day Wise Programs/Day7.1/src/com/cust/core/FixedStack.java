package com.cust.core;

public class FixedStack implements Stack {

	Customer[] arr = new Customer[STACK_SIZE1];
	static int count = 0;

	
	
	
	
	
	@Override
	public void push(Customer obj) {
		if (count == STACK_SIZE1) {
			System.out.println("\t\t\t\t Stack Size Full....!");
			return;
		}
		arr[count++] = obj;
		System.out.println("\t\t\t\t Element Pushed....!!!");
	}

	
	
	
	
	public void display() {
		for (Customer customer : arr) {
			if (customer != null) {
				System.out.print("\n\t\t\t\t ");
				System.out.print(customer.getId()+" ");
				System.out.print(customer.getName()+" ");
				System.out.println(customer.getAddress());
			}
		}
	}

	
	
	
	
	
	
	public void top() {
		int pos = count - 1;
		if (arr[pos] != null) {
			System.out.print("\n\t\t\t\t ");
			System.out.print(arr[pos].getId()+" ");
			System.out.print(arr[pos].getName()+" ");
			System.out.println(arr[pos].getAddress());
		}
	}

	
	
	
	
	
	@Override
	public void pop() {
		if (count == 0) {
			System.out.println("\t\t\t\t Stack Empty");
			return;
		}
		top();
		arr[--count] = null;
		count--;
		System.out.println("Element Popped....!!!");
	}
}
