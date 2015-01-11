import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Write a description of class Quizzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quizzer
{
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private int questionNumber;

    Quizzer()
    {
        questions = new ArrayList<String>();
        answers = new ArrayList<String>();
        Scanner fileIn;
        try
        {
            fileIn = new Scanner(new FileReader("PhysicsProblems.txt"));
            while (fileIn.hasNext())
            {
                String check = fileIn.nextLine();
                if (check.startsWith("Question"))
                    questions.add(check);
                if (check.startsWith("Answer"))
                    answers.add(check);
            }

        }
        catch (IOException errMessage)
        {
            System.err.println(errMessage);
        }
    }

    public void startQuiz()
    {
        questionNumber = (int)(Math.random() * questions.size());
        System.out.println(questions.get(questionNumber));
    }

    public boolean checkAnswer(String ans)
    {
        if(answers.get(questionNumber).endsWith(ans.trim()))
        {
            questions.remove(questionNumber);
            answers.remove(questionNumber);
            return true;
        }
        return false;
    }

    public void removeQuestion()
    {
        questions.remove(questionNumber);
        answers.remove(questionNumber);
    }
}
