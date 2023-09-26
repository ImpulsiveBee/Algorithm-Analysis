// Name: Patrick O'Connell
// Class: CS 4306/03
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: IntelliJ
import java.util.Arrays;
import java.util.Scanner;

/******************************

 Algorithm Design Block

 Algorithm title: Partitioning an Array into Two Disjoint Subsets

 Logical steps:

 Step 1: Declare and initialize instance variables: arr, disjoint1, disjoint2, and positiveSum.
 Step 2: Sort the input array (arr) in ascending order.
 Step 3: Calculate the total sum of elements in the array (totalSum).
 Step 4: Check if the totalSum is even. If not, set positiveSum to false and terminate.
 Step 5: Calculate the target sum for each subset (targetSum = totalSum / 2).
 Step 6: Initialize a dynamic programming table (dp) with dimensions (n + 1) x (targetSum + 1).
 Step 7: Initialize the base case in dp: dp[i][0] = true for all i from 0 to n.
 Step 8: Fill the dp table using dynamic programming to determine if there's a subset with a sum equal to targetSum.
 Step 9: If dp[n][targetSum] is true, a valid partition exists. Construct the disjoint subsets disjoint1 and disjoint2.
 Step 10: Output the set size, integer values, and disjoint subsets if a valid partition is found. Otherwise, indicate that no valid partition exists.

 Algorithm pseudocode syntax:

 Algorithm: Partition an Array into Two Disjoint Subsets
 Input: An array of integers (arr)
 Output: Set size, integer values, and disjoint subsets or a message indicating no valid partition

 Begin partition_array(arr)
 arr := arrInput;  // Initialize instance variable
 Sort(arr);        // Sort the input array in ascending order
 totalSum := 0;    // Initialize totalSum
 positiveSum := false; // Default to false

 // Calculate totalSum by summing all elements in arr
 for each num in arr do
 totalSum := totalSum + num;
 end for

 // Check if totalSum is even
 if totalSum % 2 = 0 then
 targetSum := totalSum / 2; // Calculate the target sum for each subset

 n := length(arr); // Get the length of the array
 dp := new boolean[n + 1][targetSum + 1]; // Initialize dp table

 // Initialize base case in dp
 for i := 0 to n do
 dp[i][0] := true;
 end for

 // Fill dp table using dynamic programming
 for i := 1 to n do
 for j := 1 to targetSum do
 if j >= arr[i - 1] then
 dp[i][j] := dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
 else
 dp[i][j] := dp[i - 1][j];
 end if
 end for
 end for

 // If dp[n][targetSum] is true, a valid partition exists
 if dp[n][targetSum] = true then
 disjoint1 := new int[n]; // Initialize the first disjoint subset
 disjoint2 := new int[n]; // Initialize the second disjoint subset
 i := n;
 j := targetSum;
 setIndex := 0;

 // Construct disjoint subsets based on dp table
 while i > 0 and j > 0 do
 if dp[i][j] and not dp[i - 1][j] then
 disjoint1[setIndex] := arr[i - 1];
 j := j - arr[i - 1];
 else
 disjoint2[setIndex] := arr[i - 1];
 end if
 i := i - 1;
 setIndex := setIndex + 1;
 end while

 // Set the remaining elements (if any) to the second subset
 while i > 0 do
 disjoint2[setIndex] := arr[i - 1];
 i := i - 1;
 setIndex := setIndex + 1;
 end while

 positiveSum := true; // Indicate that a valid partition was found
 end if
 end if

 // Output results
 if positiveSum = true then
 Output "Set size:\t\t\t\t\t\t\t" + length(arr) + " integers";
 Output "Integer values:\t\t\t\t\t\t" + arr;
 Output "Disjoint subsets with same sum:\t\t" + disjoint1 + "\n\t\t\t\t\t\t\t\t\t" + disjoint2;
 else
 Output "Set size:\t\t" + length(arr) + " integers";
 Output "Integer values:\t\t" + arr;
 Output "Disjoint subsets with same sum: No valid partition found";
 end if
 End;

 Big-O Analysis

 | Step | Description                                               | Time Complexity (Worst Case) | Space Complexity (Worst Case) |
 |------|-----------------------------------------------------------|------------------------------|-------------------------------|
 | 1    | Initialize instance variables and input preprocessing     | O(1)                         | O(1)                          |
 | 2    | Sorting the input array (using Arrays.sort)               | O(n log n)                   | O(n)                          |
 | 3    | Calculate the total sum of elements in the array         | O(n)                         | O(1)                          |
 | 4    | Check if the totalSum is even                             | O(1)                         | O(1)                          |
 | 5    | Calculate the target sum for each subset                  | O(1)                         | O(1)                          |
 | 6    | Initialize a dynamic programming table (dp)               | O(n * targetSum)             | O(n * targetSum)              |
 | 7    | Initialize the base case in dp                            | O(n)                         | O(targetSum)                  |
 | 8    | Fill the dp table using dynamic programming               | O(n * targetSum)             | O(n * targetSum)              |
 | 9    | Construct disjoint subsets if a valid partition exists   | O(n)                         | O(n)                          |
 | 10   | Output results                                            | O(n)                         | O(n)                          |

 Total Time Complexity: O(n * targetSum) = O(n * totalSum/2) = O(n * totalSum)
 Total Space Complexity: O(n * targetSum) = O(n * totalSum/2) = O(n * totalSum)

 ******************************/
public class Partition {

    private int[] arr;
    private int[] disjoint1;
    private int[] disjoint2;
    private boolean positiveSum=false;

    public Partition(int[] arrInput){
        arr = arrInput;
        Arrays.sort(arr);
    }

    public void partitionArray() {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Check if the total sum is even (necessary condition for a valid partition)
        if (totalSum % 2 == 0) {
            int targetSum = totalSum / 2;

            int n = arr.length;
            boolean[][] dp = new boolean[n + 1][targetSum + 1];

            // Initialize the dynamic programming table "dp"
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }

            // Fill the table using dynamic programming
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= targetSum; j++) {
                    if (j >= arr[i - 1]) {
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            // If dp[n][targetSum] is true, a valid partition exists
            if (dp[n][targetSum]) {
                // Construct the disjoint subsets
                disjoint1 = new int[n];
                disjoint2 = new int[n];
                int i = n;
                int j = targetSum;
                int setIndex = 0;

                while (i > 0 && j > 0) {
                    if (dp[i][j] && !dp[i - 1][j]) {
                        disjoint1[setIndex] = arr[i - 1];
                        j -= arr[i - 1];
                    } else {
                        disjoint2[setIndex] = arr[i - 1];
                    }
                    i--;
                    setIndex++;
                }

                // Set the remaining elements (if any) to the second subset
                while (i > 0) {
                    disjoint2[setIndex] = arr[i - 1];
                    i--;
                    setIndex++;
                }

                positiveSum = true;
            } else {
                positiveSum = false;
            }
        } else {
            positiveSum = false;
        }
    }

    public int[] getArr(){
        return arr;
    }

    public int[] getDisjoint1(){
        return disjoint1;
    }

    public int[] getDisjoint2(){
        return disjoint2;
    }
    public boolean getPositiveSum(){
        return positiveSum;
    }

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int setSize=0;
    int[] values = new int[0];
    int choice = 0;
    int arrValue = 0;



    while(choice!=4) {
        System.out.println("");
        System.out.println("-----------------MAIN MENU--------------");
        System.out.println("1. Read set size (number of integers)");
        System.out.println("2. Read set elements (integer values)");
        System.out.println("3. Run algorithm (display set size, set values, disjoint subsets)");
        System.out.println("4. Exit program");
        System.out.println();
        System.out.println("Enter option number:");
        choice = scan.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.println("Enter the set size: (must be positive)");
                setSize= scan.nextInt();
                values = new int[setSize];
            }
            case 2 -> {
                System.out.println("Enter the set elements: (must be positive)");
                for(int i=0; i<setSize; i++){
                    arrValue = scan.nextInt();
                    values[i]=arrValue;
                }
            }
            case 3 -> {
                Partition p1 = new Partition(values);
                p1.partitionArray();

                //Output Text
                if(p1.getPositiveSum()==true) {
                    System.out.println("Set size:\t\t\t\t\t\t\t" + setSize + " integers");
                    System.out.println("Integer values:\t\t\t\t\t\t" + Arrays.toString(p1.getArr()));
                    System.out.println("Disjoint subsets with same sum:\t\t" + Arrays.toString(p1.getDisjoint1()) + "\n\t\t\t\t\t\t\t\t\t" + Arrays.toString(p1.getDisjoint2()));
                }
                else{
                    System.out.println("Set size:\t\t" + setSize + " integers");
                    System.out.println("Integer values:\t\t" + Arrays.toString(p1.getArr()));
                    System.out.println("Disjoint subsets with same sum: No disjoint subsets with the same sum of their elements found");
                }
            }
            case 4 -> {

            }
        }


    }
    }
}
