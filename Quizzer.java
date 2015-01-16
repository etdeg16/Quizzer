import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
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
    private ArrayList<String> removedQue;
    private ArrayList<String> removedAns;
    private int questionNumber;
    private int numQuestions;

    Quizzer()
    {
        questions = new ArrayList<String>();
        answers = new ArrayList<String>();
        removedQue = new ArrayList<String>();
        removedAns = new ArrayList<String>();
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
            fileIn.close();
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
        removedQue = new ArrayList<String>();
        removedAns = new ArrayList<String>();
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
    
    public void writeQuestion(String ques, String ans)
    {
        questions.add("Question: " + ques);
        answers.add("Answer: " + ans);
        try{
            File file = new File("PhysicsProblems.txt");
            
            PrintStream fileStream = new PrintStream(file);
            // Writes the content to the file
            for(int r = 0; r < removedQue.size();  r++)
            {
                fileStream.println(removedQue.get(r));
                fileStream.println(removedAns.get(r));
                fileStream.println();
            }
            for(int i = 0; i < questions.size();  i++)
            {
                fileStream.println(questions.get(i));
                fileStream.println(answers.get(i));
                fileStream.println();
            }
            fileStream.close();
        }
        catch(IOException e)
        {
            System.err.println(e);
            System.err.println("Oh nooo. Writing the file didn't work.");
        }
    }

    public boolean checkAnswer(String ans)
    {
        if(answers.get(questionNumber).substring(8).equals(ans.trim()))
        {
            System.out.println("Correct!");
            removedQue.add(questions.get(questionNumber));
            removedAns.add(answers.get(questionNumber));
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
        removedQue.add(questions.get(questionNumber));
        removedAns.add(answers.get(questionNumber));
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
