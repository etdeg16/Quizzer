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
}
