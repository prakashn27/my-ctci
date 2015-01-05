/* 
author: Prakash N
mail: mail@prakashn.com

Write a method to decide if two strings are anagrams or not.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* 
@param: two strings which needed to be compared 
@return: true if they are anagrams false otherwise
*/
class Question1_4
{
	boolean isAnagram(String str1, String str2) {
		char[] char1 = str1.replaceAll("[\\s]","").toCharArray();
		char[] char2 = str2.replaceAll("[\\s]","").toCharArray();
		Arrays.sort(char1);
		Arrays.sort(char2);
		return Arrays.equals(char1,char2);
		
	}
	boolean isAnagram2(String str1, String str2) {
		char[] charArr1 = str1.replaceAll("[\\s]","").toCharArray();
		char[] charArr2 = str2.replaceAll("[\\s]","").toCharArray();
		int char_count = 0;	//to store the count of the characters counted
		int unique_cnt = 0, completed_unique = 0;
		int[] letters = new int[256];
		//for first array
		for(char ch : charArr1) { //O[length]
			int index = ch;
			if(letters[index] == 0) ++unique_cnt;
			++letters[index];
		}
		//for second array
		for(char ch : charArr2) {
			char_count++;	
			int index = ch;
			if(letters[index] == 0) return false;	//element not present in array1
			--letters[index];
			if(letters[index] == 0) {
				++completed_unique;
				if(completed_unique == unique_cnt) {
					return char_count == charArr2.length;
				}
			}
		}
		return false;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Question1_4 pgm = new Question1_4();
		String str1 = ":asa,fd ";
		String str2 = "faad       s,:";
		System.out.println("1. "+pgm.isAnagram(str1,str2));
		System.out.println("1. "+pgm.isAnagram2(str1,str2));
		
	}
}