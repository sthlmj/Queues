/* 
 * Queue
 * L2 U6
 * 
 * FIFO skrivar aktivitet
 *  
 */

import java.util.Arrays;



public class Queue 
{
	private String[] queueArray;
	private int queueSize;
	private int front, rear, numberOfItems = 0;
	
	Queue(int size) 
	{
		queueSize = size;
		queueArray = new String[size];
		Arrays.fill(queueArray, "-1");
	}
	
	/**
	 * Insert to the queue
	 */
	public void insert(String input) 
	{
		if(numberOfItems + 1 <= queueSize) 
		{
			queueArray[rear] = input;	//put in rear since it's a queue
			rear++;
			numberOfItems++;
			
			System.out.println(input + " Was Added to the printer queue\n");
		}
		else 
		{
			System.out.println("Sorry But the Queue is Full");
		}
	}
	
	/**
	 * Remove item from queue
	 */
	public void remove() 
	{
		if(numberOfItems > 0) 
		{
			System.out.println("REMOVE " + queueArray[front] + " Was Removed");
			queueArray[front] = "-1";
			front++;
			numberOfItems--;
		}
		else 
		{
			System.out.println("Sorry But the Queue is Empty");
		}
	}
	
	/**
	 * Peek first item in queue
	 */
	public void peek() 
	{
		System.out.println("The first document in printer Queue is " + queueArray[front]);	//display front
	}
	
	/**
	 * Display the queue by front first
	 */
	public void displayTheQueue() 
	{
		for(int n = 0; n < 61; n++)System.out.print("-");
		System.out.println();
		for(int n = 0; n < queueSize; n++) 
		{
			System.out.format("| %2s "+ " ", n);
		}
			System.out.println("|");
			for(int n = 0; n < 61; n++)System.out.print("-");
			System.out.println();
			for(int n = 0; n < queueSize; n++) 
			{
				if(queueArray[n].equals("-1")) System.out.print("|     ");
				else System.out.print(String.format("| %2s "+ " ", queueArray[n]));
			}
			System.out.println("|");
			for(int n = 0; n < 61; n++)System.out.print("-");
			System.out.println();
			int spacesBeforeFront = 3*(2*(front+1)-1);
			for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");
			System.out.print("F");
			int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
			for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");
			System.out.print("R");
			System.out.println("\n");
		
	}
	
	/**
	 * Main
	 */
	public static void main(String[] args) 
	{
		Queue theQueue = new Queue(10);
		
		/**
		 * Controller
		 */
		
		theQueue.insert("D1");
		theQueue.insert("D2");
		theQueue.insert("D3");
		
		
		theQueue.peek();
		theQueue.displayTheQueue();
		theQueue.remove();
		theQueue.peek();
		theQueue.displayTheQueue();
	}
}