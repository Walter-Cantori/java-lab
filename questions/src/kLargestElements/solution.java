package kLargestElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *       
Given an array of N positive integers, print k largest elements from the array.  The output elements should be printed in decreasing order.

Input:
The first line of input contains an integer T denoting the number of test cases. The first line of each test case is N and k, N is the size of array and K is the largest elements to be returned. The second line of each test case contains N input C[i].

Output:
Print the k largest element in descending order.
 */

public class solution {
	
	public static void kLargest(List<Integer> inputArray, int k) {
		Collections.sort(inputArray);
		
		List<Integer> solution = new ArrayList<Integer>();
		int count = 1;
		
		while (solution.size() < k) {
			solution.add(inputArray.get(inputArray.size() - count));
			count++;
		}
		System.out.println(solution);
		
	}
	
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>(
			Arrays.asList(2,5,8,91,22,5,7)
		);
		int k = 3;
		kLargest(arr, k);
	}

}
