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
                        System.out.println(qz.getAnswer());
                        qz.removeQuestion();
                        incorrect = false;
                    }
                    else
                    {
                        System.out.println("Do you want to redo the question? (y/n)");
                        if (keyIn.nextLine().equalsIgnoreCase("y"))
                            System.out.println(qz.getQuestion());
                        else
                            incorrect = false;
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

        System.out.println("Would you like to add questions and answeres to the quizzer for next time? (y/n)");
        if (keyIn.nextLine().equalsIgnoreCase("y"))
        {
            cont = true;
            while (cont)
            {
                System.out.print("Question: ");
                String question = keyIn.nextLine();
                System.out.print("Answer: ");
                String answer = keyIn.nextLine();
                qz.writeQuestion(question, answer);
                
                System.out.println("Do you want to add another question? (y/n)");
                if (keyIn.nextLine().equalsIgnoreCase("y"))
                    cont = true;
                else
                    cont = false;
            }
        }
        System.out.println("Thanks for participating in the quizzer! Goodbye!");
    }
}
