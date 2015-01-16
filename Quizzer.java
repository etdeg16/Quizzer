import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
/**
 * Outputs questions and checks if user answers are correct. Questions and answers are stored in a text file. Users also have the option to add questions/answers.
 * 
 * @author Ethan De Guzman && Michael Duong
 * @version 01-16-15
 * 
 * We pledge that this program is our own independent work and conforms to Oxford Academy's Academic Honesty Guidelines.
 */
public class Quizzer
{
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private ArrayList<String> removedQue;
    private ArrayList<String> removedAns;
    private int questionNumber;
    private int correctAnswers;
    private int questionsAsked;

    Quizzer()
    {
        correctAnswers = 0;
        questionsAsked = 0;
        questions = new ArrayList<String>();
        answers = new ArrayList<String>();
        removedQue = new ArrayList<String>();
        removedAns = new ArrayList<String>();
        Scanner fileIn;
        try
        {
            fileIn = new Scanner(new FileReader("Problems.txt"));
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
    
    public void startQuiz()
    {
        questionsAsked++;
        questionNumber = (int)(Math.random() * questions.size());
        System.out.println(getQuestion());
    }
    
    public void writeQuestion(String ques, String ans)
    {
        questions.add("Question: " + ques);
        answers.add("Answer: " + ans);
        try{
            File file = new File("Problems.txt");
            
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
        if(answers.get(questionNumber).substring(8).equalsIgnoreCase(ans.trim()))
        {
            System.out.println("Correct!");
            removedQue.add(questions.get(questionNumber));
            removedAns.add(answers.get(questionNumber));
            correctAnswers++;
            questions.remove(questionNumber);
            answers.remove(questionNumber);
            return true;
        }
        System.out.println("Incorrect answer.");
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
    
    public String totalCorrect()
    {
        return correctAnswers + "/" + questionsAsked;
    }
    
    public double percentCorrect()
    {
        return (double) correctAnswers / questionsAsked;
    }
}
