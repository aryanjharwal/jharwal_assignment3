package jharwal_problem1;

import java.security.SecureRandom;

import java.util.Scanner;

public class CAI5 {

public static void main(String[] args) {

Scanner sc = new Scanner(System.in);

String flag;

do {

//calling quiz

quiz(sc);

//getting user input about next round

System.out.print("\nDo you want another round?(yes/no): ");

flag = sc.next();

System.out.println();

}while(flag.equalsIgnoreCase("yes"));

sc.close();

}

public static void quiz(Scanner sc) {

SecureRandom rand = new SecureRandom();

int countCorrect = 0;

int x,i,correctAns=0;

int max = readDifficulty(sc);

int problemtype = readProblemType(sc);

for ( i = 1; i <= 10; i++) {

int first = rand.nextInt(max);

int second = rand.nextInt(max);

switch(problemtype){

case 1:

correctAns = call_method(first, second, i,1);

break;

case 2:

correctAns = call_method(first, second, i,2);

break;

case 3:

correctAns = call_method(first, second, i,3);

break;

case 4:

correctAns = call_method(first, second, i,4);

break;

case 5:

x = rand.nextInt(4)+1; // rand between 1-4

correctAns = call_method(first, second, i,x);

break;

default:

System.out.println("Wrong choice!!");

break;

}

int response = readResponse(sc);

if (isAnswerCorrect(correctAns, response)) {

displayCorrectResponse(rand);

countCorrect++;

} else

displayIncorrectResponse(rand);

}

displayCompletionMessage(countCorrect);

}

private static void displayCompletionMessage(int countCorrect) {

double percent = ((double) countCorrect / 10.0) * 100.0;

System.out.println("\nYou Scored: " + percent + "%");

if (percent < 75)

System.out.println("Please ask your teacher for extra help.");

else

System.out.println("Congratulations, you are ready to go to next level!");

}

private static void displayIncorrectResponse(SecureRandom rand) {

String incorrect[] = { "No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying." };

// generating random index

int index = rand.nextInt(incorrect.length);

System.out.println(incorrect[index]);

}

private static void displayCorrectResponse(SecureRandom rand) {

String appreciate[] = { "Very good!", "Excellent", "Nice work!", "Keep up the good work!" };

// generating random index

int index = rand.nextInt(appreciate.length);

System.out.println(appreciate[index]);

}

private static boolean isAnswerCorrect(int correctAns, int response) {

return correctAns == response;

}

private static int readResponse(Scanner sc) {

System.out.print("Ans. ");

int response = sc.nextInt();

return response;

}

private static int readDifficulty(Scanner sc){

System.out.println("Choose the difficulty level");

System.out.print("Difficulty(1-4)? ");

int response = sc.nextInt();

switch (response){

case 1:

response = 10;

break;

case 2:

response = 100;

break;

case 3:

response = 1000;

break;

case 4:

response = 10000;

break;

default:

System.out.println("Wrong choice!!");

break;

}

return response;

}

private static int readProblemType(Scanner sc){

System.out.println("Choose the problem type");

System.out.print("Problem Type(1-5)? ");

int response = sc.nextInt();

return response;

}

private static int multiply(int first, int second, int i) {

System.out.println("Q."+i+" how much is " + first + " X " + second + "?");

int correctAns = first * second;

return correctAns;

}

private static int add(int first, int second, int i) {

System.out.println("Q."+i+" how much is " + first + " + " + second + "?");

int correctAns = first + second;

return correctAns;

}

private static int subtract(int first, int second, int i) {

System.out.println("Q."+i+" how much is " + first + " - " + second + "?");

int correctAns = first - second;

return correctAns;

}

private static int division(int first, int second, int i) {

System.out.println("Q."+i+" how much is " + first + " / " + second + "?");

int correctAns = first / second;

return correctAns;

}

private static int call_method(int first,int second,int i, int choice){

int ans=0;

switch (choice){

case 1:

ans = add(first,second,i);

break;

case 2:

ans = subtract(first,second,i);

break;

case 3:

ans = multiply(first,second,i);

break;

case 4:

ans = division(first,second,i);

break;

}

return ans;

}
private static int generateQuestionArgument(SecureRandom rand, int difficulty) {
int argument = 0;
  
if (difficulty == 1)
argument = rand.nextInt(10);
else if (difficulty == 2)
argument = rand.nextInt(100);
else if (difficulty == 3)
argument = rand.nextInt(1000);
else
argument = rand.nextInt(10000);
  
return argument;
}

}