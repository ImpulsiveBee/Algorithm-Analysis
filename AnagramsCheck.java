// Name: Patrick O'Connell
// Class: CS 4306/03
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: IntelliJ
/******************************

Algorithm Design Block

Algorithm title: Checking whether two given words are anagrams

Logical steps:

 Step 1: Declare a variable to hold the number of comparisons, 2 char arrays (arr1 and arr2) and 2 Strings (str1 and str2)
 Step 2: Remove all the spaces from the strings and then set all letters to lowercase
 Step 3: Immediately check if the string lengths are equal and if they are not equal. Print false statements and end method
 Step 4: Initialize arr1 and arr1 to be the length of str1
 Step 5: Convert str1 into char array arr1 and str2 into char array arr2
 Step 6: Sort the arrays using the Arrays.Sort() method
 Step 7: if the char at arr1[i] and arr2[i] are equal continue the loop, otherwise if false, print not and anagram and end method
 Step 8: Print out string1, string2, is an anagram, and comparisonCounter.

Algorithm pseudocode syntax:

Algorithm: Find if two strings are anagrams
Input: 2 String variables
Output: Print Statements of string1, string2, anagram statement, and comparisonCounter

Begin check_anagram(string1, string2)
    comparisonCount := 0;
    arr1, arr2 : char[];
    str1, str2 : string;

    str1 := replaceAll(string1, " ", "");
    str1 := toLowerCase(str1);
    str2 := replaceAll(string2, " ", "");
    str2 := toLowerCase(str2);

    if length(str1) ≠ length(str2) then
        comparisonCount := comparisonCount + 1;
        output "String 1:\t\t" + string1;
        output "String 2:\t\t" + string2;
        output "Output:\t\t\tStrings are not anagrams";
        output "Comparisons:\t" + comparisonCount;
        return;
    end if;

    arr1 := new char[length(str1)];
    arr2 := new char[length(str2)];
    for i := 0 to length(arr1) - 1 do
        arr1[i] := charAt(str1, i);
    end for;
    for i := 0 to length(arr2) - 1 do
        arr2[i] := charAt(str2, i);
    end for;

    sort(arr1);
    sort(arr2);

    for i := 0 to length(arr1) - 1 do
        comparisonCount := comparisonCount + 1;
        if arr1[i] ≠ arr2[i] then
            output "String 1:\t\t" + string1;
            output "String 2:\t\t" + string2;
            output "Output:\t\t\tStrings are not anagrams";
            output "Comparisons:\t" + comparisonCount;
            return;
        end if;
    end for;

    output "String 1:\t\t" + string1;
    output "String 2:\t\t" + string2;
    output "Output:\t\t\tStrings are anagrams";
    output "Comparisons:\t" + comparisonCount;
    output;
End;



 ***************************** */
import java.util.Arrays;
import java.util.Scanner;
public class AnagramsCheck {
    public static void check_anagram(String string1, String string2){
        //Counter of # of Comparisons
        int comparisonCount = 0;
        char[] arr1,arr2;
        String str1,str2;
        //first we remove all the spaces from strings and set to lower case
        str1=string1.replaceAll(" ","");
        str1=str1.toLowerCase();
        str2=string2.replaceAll(" ","");
        str2=str2.toLowerCase();

        //immediately checks if the strings are the same size and if not they immediately are not anagrams and the methods is ended
        if(str1.length()!=str2.length()){
            comparisonCount++;
            System.out.println("String 1:\t\t"+ string1);
            System.out.println("String 2:\t\t"+ string2);
            System.out.println("Output:\t\t\tStrings are not anagrams");
            System.out.println("Comparisons:\t"+comparisonCount);
            return;
        }
        //Next we convert into char array
        arr1 = new char[str1.length()];
        arr2 = new char[str2.length()];
        for(int i=0; i<arr1.length; i++){
            arr1[i]= str1.charAt(i);
        }
        for(int i=0; i<arr2.length; i++){
            arr2[i]= str2.charAt(i);
        }
        //Now we will sort the arrays using the Arrays class sort method
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        //finally we will compare them
        for(int i=0; i<arr1.length;i++){
            comparisonCount++;
            if (arr1[i] != arr2[i]){
                System.out.println("String 1:\t\t"+ string1);
                System.out.println("String 2:\t\t"+ string2);
                System.out.println("Output:\t\t\tStrings are not anagrams");
                System.out.println("Comparisons:\t"+comparisonCount);
                return;
            }
        }
        //if the 'if' statement in the previous for loop is never triggered then the following text will occur
        System.out.println("String 1:\t\t"+ string1);
        System.out.println("String 2:\t\t"+ string2);
        System.out.println("Output:\t\t\tStrings are anagrams");
        System.out.println("Comparisons:\t"+comparisonCount);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice=0;
        String str1 = "";
        String str2 = "";
        while(choice!=3) {
            System.out.println();
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read input string1 and string2");
            System.out.println("2. Run algorithm and display output");
            System.out.println("3. Exit program");
            System.out.println();
            System.out.println("Enter option number:");
            choice = scan.nextInt();
            System.out.println();

            switch (choice) {
                case 1 -> {
                    //clears each String so user can do multiple cases in one run of program
                    System.out.println("Enter the first String:");
                    str1 = scan.nextLine();
                    str1 = scan.nextLine();
                    System.out.println("Enter the second String:");
                    str2 = scan.nextLine();


                }
                case 2 -> {
                    check_anagram(str1, str2);
                }
                case 3 -> {

                }
            }
        }
    }

}
