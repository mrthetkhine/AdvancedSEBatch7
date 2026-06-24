package com.turing.advancese7.tdd;

public class BinarySearch {

	public int search(int[] arr,int element) {
		if(arr==null || arr.length==0)
		{
			return -1;
		}
		else
		{
			int start = 0;
			int end = arr.length-1;
			
			while(start<=end)
			{
				int middle = (start+end)/2;
				if(arr[middle] == element)
				{
					return middle;
				}
				else if(arr[middle]< element  )
				{
					start = middle + 1;
				}
				else
				{
					end = middle -1;
				}
			}
			
			return -1;
		}
	}

}
