import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a word : ");
        String wordToGuess = scanner.nextLine().toLowerCase();

        for (int i = 0; i < 50; i++) {
            System.out.println();
        }

        boolean [] guessedLetters = new boolean[wordToGuess.length()];

        int remainingGuesses = 6;

        System.out.println("Welcome to the Hangman game!");
        System.out.println("Enter letters to guess the word.");

        while (remainingGuesses > 0) {
            System.out.println();

            for (int i = 0; i < guessedLetters.length; i++) {
                if (guessedLetters[i]) {
                    System.out.print(wordToGuess.charAt(i) + " ");
                }else {
                    System.out.print(" _ ");
                }
            }

            System.out.println(" ");
            System.out.println("You have " + remainingGuesses + " guesses left.");
            System.out.println("Enter letters to guess the word : ");
            char guess = scanner.next().charAt(0);
            boolean isFound = false;

            for (int i = 0; i < guessedLetters.length; i++) {
                if (wordToGuess.charAt(i) == guess) {
                    guessedLetters[i] = true;
                    isFound = true;
                }
            }

            if (isFound){
                System.out.println("You guessed a right letter ! ");
            }else {
                remainingGuesses--;
                System.out.println("Wrong guessed :( You could not found any letter. ");
            }

            boolean isComplete = true;
            for (boolean letter : guessedLetters){
                if (!letter){
                    isComplete = false;
                    break;
                }
            }

            if (isComplete){
                System.out.println("Congratulations you guessed the word correctly !!! " + wordToGuess);
                break;
            }
        }

        if (remainingGuesses == 0) {
            System.out.println("Your guess is over ! GAME OVER .");
            System.out.println("The right word was " + wordToGuess);
        }

    }
}