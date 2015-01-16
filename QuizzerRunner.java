import java.util.Scanner;
/**
 * Write a description of class QuizzerRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuizzerRunner
{
    public static void main(String[] args)
    {
        Scanner keyIn = new Scanner(System.in);
        System.out.println("Hello! Welcome to the quizzer!");
        System.out.println("Reminder: Make sure to put the correct units in your answers!");
        Quizzer qz = new Quizzer();
        boolean cont = true;
        while (cont)
        {
            qz.startQuiz();
            boolean incorrect = true;
            while (incorrect)
            {
                if (!qz.checkAnswer(keyIn.nextLine()))
                {
                    System.out.println("Do you want to remove the question? (y/n)");
                    if (keyIn.nextLine().equalsIgnoreCase("y"))
                    {
                        qz.removeQuestion();
                        incorrect = false;
                    }
                    else
                    {
                        System.out.println("Do you want to redo the question? (y/n)");
                        if (keyIn.nextLine().equalsIgnoreCase("y"))
                            System.out.println(qz.getQuestion());
                        else
                        {
                            System.out.println(qz.getAnswer());
                            qz.removeQuestion();
                            incorrect = false;
                        }
                    }
                }
                else
                    incorrect = false;
            }
            if (qz.hasQuestions())
            {
                System.out.println("Do you want another question? (y/n)");
                if (keyIn.nextLine().equalsIgnoreCase("y"))
                    cont = true;
                else
                    cont = false;
            }
            else
            {
                System.out.println("Sorry! Out of questions!");
                cont = false;
            }
        }
        System.out.println("You got " + qz.totalCorrect() + " correct!");
        if (qz.percentCorrect() >= 0.9)
            System.out.println("Outstanding job! You are definitely ready for the test!");
        else if (qz.percentCorrect() >= 0.8 && qz.percentCorrect() < 0.9)
            System.out.println("Good job! With maybe just a little bit of studying, you will be ready!");
        else if (qz.percentCorrect() >= 0.7 && qz.percentCorrect() < 0.8)
            System.out.println("Not bad. You may probably need some more study time, but you are on the right track!");
        else
            System.out.println("Ouch! Better luck next time!");
        System.out.println("Thanks for completing in the quizzer! Goodbye!"); 
    }
}
