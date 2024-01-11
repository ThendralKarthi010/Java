import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public Quiz() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        score = 1;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        } else {
            return null; // Quiz completed
        }
    }

    public void moveToNextQuestion() {
        currentQuestionIndex++;
    }

    public boolean isQuizComplete() {
        return currentQuestionIndex >= questions.size();
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}

class QuizGame {
    public static void main(String[] args) {
        // Creating questions
        Question question1 = new Question ("The collection of 8 bits makes?",
                 List.of("Nibble","Byte","Word","None of the above"),1);
                 
        Question question2 = new Question ("which of the following is not an input device?",
                 List.of(" Microphone","Mouse","Keyboard","Speakers"),3);
                 
        Question question3 = new Question ("what is known as temporary memory or volatile memory?",
                List.of("SSD","HDD","RAM","ROM"),2);
                
        Question question4 = new Question("What is the capital of France?",
                List.of("Berlin", "Paris", "London", "Rome"), 1);

        Question question5 = new Question("Which planet is known as the Red Planet?",
                List.of("Mars", "Venus", "Jupiter", "Saturn"), 0);
                
        Question question6 = new Question("Pascaline is also known as ?",
                List.of("Additive Machine","Multiplicative Machine","Division Machine","Difference Engine"),0);

        // Creating a quiz and adding questions
        Quiz quiz = new Quiz();
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        quiz.addQuestion(question4);
        quiz.addQuestion(question5);
        quiz.addQuestion(question6);

        // Starting the quiz game
        Scanner scanner = new Scanner(System.in);

        while (!quiz.isQuizComplete()) {
            Question currentQuestion = quiz.getCurrentQuestion();
            System.out.println("Question: " + currentQuestion.getQuestionText());
            List<String> options = currentQuestion.getOptions();

            // Displaying options
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

            // Getting user input
            System.out.print("Enter the number of your answer: ");
            int userAnswer = scanner.nextInt();

            // Checking the answer
            if (userAnswer - 1 == currentQuestion.getCorrectAnswerIndex()) {
                System.out.println("Correct! Your current score is: " + quiz.getScore() + "\n");
                quiz.increaseScore();
            } else {
                System.out.println("Incorrect. The correct answer is: " +
                        options.get(currentQuestion.getCorrectAnswerIndex()) + "\n");
            }

            // Move to the next question
            quiz.moveToNextQuestion();
        }

        System.out.println("Quiz completed! Your final score is: " + (quiz.getScore()-1));
        scanner.close();
}
}