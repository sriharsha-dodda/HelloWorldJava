package com.testcodes.example;

import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("--:Shortest Job First - preemptive:--");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of processes");
		int numProcess = sc.nextInt();
		int pid[] 			 = new int[numProcess];
		int arrivalTime[]	 =new int[numProcess];
		int burstTime[]		 = new int[numProcess];
		int exitTime[] 		 = new int[numProcess];
		int turnAroundTime[] = new int[numProcess];
		int waitingTime[]	 =new int[numProcess];
		int f[]				 =new int[numProcess];//array of flag to check whether process is completed or not
        int bt1[] 			 = new int[numProcess];//2nd array for storing burst times
		//int temp;
		int i;
		float averageWaitingTime=0, averageTurnAroundTime=0;
                         
		System.out.print("\nEnter arrival time: burst time  \n");
		for(i=0;i<numProcess;i++)
		{		
		    arrivalTime[i] = sc.nextInt();
		    burstTime[i]   = sc.nextInt();
		    
		    pid[i] = i+1;
		    bt1[i] = burstTime[i];
            f[i]   = 0;
		}
		sc.close();
		int st=0, tot=0;
		while(true)
		{
			
			int min=99,c=numProcess;
		    if (tot==numProcess)
		    	break;
		    for ( i=0;i<numProcess;i++)
		    {
		       	if ((arrivalTime[i]<=st) && (f[i]==0) && (burstTime[i]<min))
		    	{	
		    		min=burstTime[i];
		    		c=i;
		    	}
		    }
		    	
		    if (c==numProcess)
		    	st++;
		    else
		    {
		    	burstTime[c]--;
		    	st++;
		    	if (burstTime[c]==0)
		    	{
		    		exitTime[c]= st;
		    		f[c]=1;
		    		tot++;
		    	}
		    }
		 }
		
		 for(i=0;i<numProcess;i++)
		 {
			 turnAroundTime[i] 	  = exitTime[i] - arrivalTime[i];
		  	 waitingTime[i] 		  = turnAroundTime[i] - bt1[i];
		  	 averageWaitingTime	 += waitingTime[i];
		  	 averageTurnAroundTime += turnAroundTime[i];
		 }
		 System.out.println("pid  arrival  burst  complete turn waiting");
		 for(i=0;i<numProcess;i++)
		 {
		 	System.out.println(pid[i] +"\t"+ arrivalTime[i]+"\t"+bt1[i] +"\t"+ exitTime[i] +"\t"+ turnAroundTime[i] +"\t"+ waitingTime[i]);
		 } 
		    
		 System.out.println("\nAverage Turn Around Time is " + (float) (averageTurnAroundTime / numProcess));
		 System.out.println("Average Waiting Time is "       + (float) (averageWaitingTime    / numProcess));
		    			
	}
}