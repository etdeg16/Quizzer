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
    private int numQuestions;

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
    
    Quizzer(int numQ)
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
        System.out.println(getQuestion());
    }
    

    public boolean checkAnswer(String ans)
    {
        if(answers.get(questionNumber).substring(8).equals(ans.trim()))
        {
            System.out.println("Correct!");
            questions.remove(questionNumber);
            answers.remove(questionNumber);
            return true;
        }
        System.out.println("Incorrect answer.");
        //System.out.println(answers.get(questionNumber));
        return false;
    }

    public void removeQuestion()
    {
        questions.remove(questionNumber);
        answers.remove(questionNumber);
    }
    
    public String getQuestion()
    {
        return questions.get(questionNumber);
    }
    public String getAnswer()
    {
        return answers.get(questionNumber);
    }
    
    public boolean hasQuestions()
    {
        return questions.size() > 0;
    }
}
