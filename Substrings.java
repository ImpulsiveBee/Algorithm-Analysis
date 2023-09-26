// Name: Patrick O'Connell
// Class: CS 4306/03
// Term: Fall 2023
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: IntelliJ

import java.util.Scanner;

/******************************

 Algorithm Design Block

 Algorithm title: Counting Substrings Starting with 'A' and Ending with 'B'

 Logical steps:

 Step 1: Declare variables: checkIndex, comparisons, and substringCount, and a character array (characters) for input processing.
 Step 2: Initialize checkIndex, comparisons, and substringCount to 0.
 Step 3: Initialize a character array (characters) to hold the characters of the input string in uppercase.
 Step 4: Loop while checkIndex is less than the length of characters:
 a. Inside the loop, start another loop from checkIndex to the end of characters.
 b. If characters[checkIndex] is 'A', enter the inner loop.
 c. In the inner loop, check for characters[j] being 'B' and increment substringCount and comparisons accordingly.
 d. Increment comparisons for each iteration in the inner loop.
 e. If characters[checkIndex] is not 'A', skip the remaining checks and proceed to the next character.
 f. Increment checkIndex for the outer loop.
 Step 5: Output the input string, the number of substrings found, and the total number of comparisons made.

 Algorithm pseudocode syntax:

 Algorithm: Count Substrings Starting with 'A' and Ending with 'B'
 Input: A string variable (inputString)
 Output: Print the input string, the number of substrings, and the number of comparisons made

 Begin count_substrings(inputString)
 checkIndex := 0;
 comparisons := 0;
 substringCount := 0;
 characters := new char[length(inputString)];

 // Convert inputString to uppercase characters array
 for i := 0 to length(inputString) - 1 do
 characters[i] := toUpperCase(charAt(inputString, i));
 end for;

 while checkIndex < length(characters) do
 for i := checkIndex to length(characters) - 1 do
 if characters[checkIndex] = 'A' then
 for j := checkIndex + 1 to length(characters) - 1 do
 if characters[j] = 'B' then
 substringCount := substringCount + 1;
 end if;
 comparisons := comparisons + 1;
 end for;
 else
 // Skip remaining checks if characters[checkIndex] is not 'A'
 i := length(characters);
 end if;
 checkIndex := checkIndex + 1;
 end for;
 end while;

 output "Input String:\t\t" + inputString;
 output "# of substrings:\t" + substringCount;
 output "# of comparisons:\t" + comparisons;
 End;

 Big-O Analysis:

 | Step | Description                                                       | Time Complexity (Worst Case) | Space Complexity (Worst Case) |
 |------|-------------------------------------------------------------------|------------------------------|-------------------------------|
 | 1    | Initialize variables and input preprocessing                      | O(1)                         | O(1)                          |
 | 2    | Initialize checkIndex, comparisons, and substringCount           | O(1)                         | O(1)                          |
 | 3    | Create a character array (characters) for input processing        | O(n)                         | O(n)                          |
 | 4    | While loop with nested loops for substring counting               | O(n^2)                       | O(1) (char array is reused)   |
 | 5    | Output results                                                    | O(1)                         | O(1)                          |

 Total Time Complexity: O(n^2)
 Total Space Complexity: O(n)

 ***************************** */

public class Substrings {

    public static void checkSubstrings(String input){
        //initial variable that will be used as the check 'A' variable
        int checkIndex=0;
        //checks the total number of comparisons done
        int comparisons=0;
        //only counts the comparisons that begin with 'A' and end with 'B'
        int substringCount=0;
        //Char array to check the values easier than using substring() method
        char[] characters = new char[input.length()];
        for (int i=0; i<input.length();i++){
            characters[i]= input.toUpperCase().charAt(i);
        }
        //The main part of the method that does the comparisons
        while(checkIndex<characters.length){
            //outer for loop that checks that the check index is 'A' character
            for(int i=checkIndex; i<characters.length; i++){
                if(characters[checkIndex]=='A'){
                    //inner loop that is checking for the 'B' character
                    for(int j=checkIndex+1; j<characters.length; j++){
                        if(characters[j]=='B'){
                            substringCount++;
                            comparisons++;
                        }
                        comparisons++;
                    }
                }
                //if 'i' is not 'A' this skips the
                // rest of the checks because it is
                // not worth checking the rest and should just
                // skip to next value in line
                else{
                    i=characters.length;
                    comparisons++;
                }
                checkIndex++;
            }
        }
        //Output Text
        System.out.println();
        System.out.println("Input String:\t\t"+input);
        System.out.println("# of substrings:\t"+substringCount);
        System.out.println("# of comparisons:\t"+comparisons);


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputString = "";
        //variable that while loop and switch statement use for user input
        int loopChoice=0;

        while(loopChoice!=3) {
            //Basic main menu
            System.out.println();
            System.out.println("-----------------MAIN MENU--------------");
            System.out.println("1. Read input string");
            System.out.println("2. Run algorithm (display input, number of substrings, number of comparisons)");
            System.out.println("3. Exit program");
            System.out.println();
            System.out.println("Enter option number:");
            loopChoice = scan.nextInt();
            //switch statement that goes until 3 is chosen and program ends
            switch(loopChoice) {
                case 1 -> {
                    //two scan statements ensure nothing is skipped
                    System.out.println("Enter the input String:");
                    inputString = scan.nextLine();
                    inputString = scan.nextLine();
                }
                case 2 -> checkSubstrings(inputString);

                case 3 -> {
                //is empty so the loop will end.
                }
            }
        }
    }
}
