package roflan.menu;

import roflan.players.Computer;
import roflan.players.User;

import java.util.Scanner;

public class Menu {
    private int digitsInSamePositions;
    private int digitsInDifferentPositions;

    public Menu() {
        System.out.println("Welcome to bulls and cows game!");
        System.out.println("Choose game difficulty:");
        System.out.println("3 - easy");
        System.out.println("4 - medium");
        System.out.println("5 - hard");
        int difficulty;
        boolean isCorrectDifficulty = true;
        Scanner in = new Scanner(System.in);
        difficulty = in.nextInt();
        Computer computer = new Computer();
        try {
            computer.setComputerNumberLength(difficulty);
        } catch (IllegalStateException e) {
            System.out.println("You lose before start OMEGALUL!");
            isCorrectDifficulty = false;
        }
        computer.generateNumber();
        int numberLength = computer.getComputerNumberLength();
        boolean isWin = false;
        if (isCorrectDifficulty){
            User user = new User();
            int numberOfAttempts = 0;
            while (!isWin){
                user.setUserNumberLength(numberLength);
                user.userNumberInput();
                countDigitsInSameAndDifferentPositions(computer, user);
                if (digitsInSamePositions == numberLength){
                    isWin = true;
                    System.out.println("You win!");
                    System.out.print("Secret number: ");
                    computer.printComputerNumber();
                    System.out.println("\nNumber of attempts: " + numberOfAttempts);
                }
                else{
                    numberOfAttempts++;
                    System.out.println("Bulls: " + digitsInSamePositions + " Cows: " + digitsInDifferentPositions);
                    System.out.println("One more try? Yes/No");
                    String oneMoreTryAnswer;
                    do {
                        oneMoreTryAnswer = in.nextLine();
                        oneMoreTryAnswer = oneMoreTryAnswer.toUpperCase();
                    } while (!(oneMoreTryAnswer.equals("YES") || oneMoreTryAnswer.equals("NO")));
                    if (oneMoreTryAnswer.equals("NO")){
                        System.out.println("You lose");
                        System.out.print("Secret number: ");
                        computer.printComputerNumber();
                        System.out.println("\nNumber of attempts: " + numberOfAttempts);
                        break;
                    }
                }
            }
        }

    }

    private void countDigitsInSameAndDifferentPositions(Computer computer, User user){
        int numberLength = computer.getComputerNumberLength();
        int[] computerNumber = computer.getComputerNumber();
        int[] userNumber = user.getUserNumber();
        digitsInSamePositions = 0;
        digitsInDifferentPositions = 0;
        for (int i = 0; i < numberLength; i++) {
            for (int j = 0; j < numberLength; j++) {
                if (computerNumber[i] == userNumber[j]){
                    if (i == j){
                        digitsInSamePositions++;
                    }
                    else {
                        digitsInDifferentPositions++;
                    }
                }
            }
        }
    }

}
