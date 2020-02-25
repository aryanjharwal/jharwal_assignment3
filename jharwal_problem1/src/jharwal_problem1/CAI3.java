package jharwal_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
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

       int countCorrect = 0;//for count correct answer

       for (int i = 1; i <= 10; i++) {
          
           int first = rand.nextInt(10);
           int second = rand.nextInt(10);
           int correctAns = first * second;//correct ans

           askquestion(first, second, i);

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
       String incorrect[] = { "No. Please try again", "Wrong. Try once more", "Don't give up!", "No. Keep trying" };

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

   private static void askquestion(int first, int second, int i) {
       System.out.println("Q."+i+" how much is " + first + " times " + second + "?");
   }
}