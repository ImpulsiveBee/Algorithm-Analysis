// Name: Patrick O'Connell
// Class: CS 4306/03
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: IntelliJ
/******************************

Algorithm Design Block

Algorithm title:

Logical steps:

Step 1: Declare a variable to hold the number of comparisons
Step 2: Initialize two pointers 'i' and 'j' to keep track of the current position in each list
Step 3: Create an empty ArrayList 'commonList' to store the common elements
Step 4: Repeat the following steps until either 'i' reaches the end of list1 or 'j' reaches the end of list2:
Step 5: If the elements pointed by 'i' and j' are equal, add the element to the 'commonList' and move both 'i' and j' to the next elements.
Step 6: If the element pointed by 'i' is smaller than the element pointed by 'j', move 'i' to the next element
Step 7: If the element pointed by j is smaller than the element pointed by 'i', move 'j' to the next element
Step 8: Print out list1, list2, commonList, and comparisonCounter.

Algorithm pseudocode syntax:

Algorithm: Find all the common elements in two sorted lists of numbers.
Input: 2 Non-empty List (list1, list2) of Integers.
Output: Print statements of list1, list2, commonList, and comparisonCounter.

Begin common_entries(list1,list2)
    comparisonCount = 0;
    i=0;
    j=0;
    commonList = null;
    while i < list1.size() and j < list2.size()
        if (list1.get(i) == list2.get(i))
            commonList.add(list1[i]);
            i++;
            j++;
            comparisonCounter++;
        else if (list1.get(i) < list2.get(j))
            i++;
            comparisonCounter++;
        else
            j++;
            comparisonCounter++;
        End If
    End While
    Print out list1;
    Print out list2;
    Print out commonList;
    Print out comparisonCount;
 End;

******************************/
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class CommonElements {
    public static void common_entries(ArrayList<Integer> list1, ArrayList<Integer> list2){
       //Counter of # of Comparisons
        int comparisonCount = 0;
        int i=0;
        int j=0;
        ArrayList<Integer> commonList = new ArrayList<>();
        while(i<list1.size()&&j<list2.size()){
            if(Objects.equals(list1.get(i), list2.get(j))){
                commonList.add(list1.get(i));
                i++;
                j++;
                comparisonCount++;
            }
            else if (list1.get(i) < list2.get(j)){
                i+=1;
                comparisonCount++;
            }
            else{
                j+=1;
                comparisonCount++;
            }
        }
        System.out.println("List 1:\t\t\t"+ list1);
        System.out.println("List 2:\t\t\t"+ list2);
        if(commonList.isEmpty()){
            System.out.println("Common Values:\tNo common Values");
        }
        else {
            System.out.println("Common Values:\t" + commonList);
        }
        System.out.println("Comparisons:\t"+comparisonCount);
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        ArrayList<Integer> list1= new ArrayList<>();
        ArrayList<Integer> list2= new ArrayList<>();
        while(choice!=3){
            System.out.println();
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read input lists (integer values)");
            System.out.println("2. Run algorithm and display output");
            System.out.println("3. Exit program");
            System.out.println();
            System.out.println("Enter option number:");
            choice = scan.nextInt();
            System.out.println();
            switch(choice){
                case 1 -> {
                    //clears each list so user can do multiple cases in one run of program
                    list1.clear();
                    list2.clear();
                    //while loop to allow users to add values to each list until they type a negative number
                    System.out.println("Enter the values for the first list: ");
                    System.out.println("Enter a negative number to finish");
                    while (scan.hasNextInt()) {
                        int num = scan.nextInt();
                        if (num > 0)
                            list1.add(num);
                        else
                            break;
                    }
                    System.out.println("Enter the values for the second list: ");
                    System.out.println("Enter a negative number to finish");
                    while (scan.hasNextInt()) {
                        int num = scan.nextInt();
                        if (num > 0)
                            list2.add(num);
                        else
                            break;
                    }
                }
                case 2 -> {
                    common_entries(list1, list2);
                }
                case 3 -> {

                }
            }
        }
    }
}
