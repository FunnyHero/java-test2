package roflan.players;

import roflan.menu.NumberCheck;

import java.util.Random;

public class Computer {
    private int[] computerNumber;
    private int computerNumberLength;

    public void generateNumber(){
        Random random = new Random();
        int[] computerNumber = new int[computerNumberLength];
        for (int i = 0; i < computerNumberLength; i++) {
            computerNumber[i] = random.nextInt(10);
        }
        boolean isDifferentDigits = false;
        NumberCheck numberCheck = new NumberCheck();
        while (!isDifferentDigits){
            for (int i = 0; i < computerNumber.length; i++) {
                for (int j = 0; j < computerNumber.length; j++) {
                    if (computerNumber[i] == computerNumber[j]){
                        computerNumber[j] = random.nextInt(10);
                    }
                }
            }
            isDifferentDigits = numberCheck.isDifferentDigits(computerNumber);
        }
        setComputerNumber(computerNumber);
    }

    public void setComputerNumberLength(int gameDifficulty) throws IllegalStateException {
        switch (gameDifficulty){
            case 3:
                computerNumberLength = 3;
                break;
            case 4:
                computerNumberLength = 6;
                break;
            case 5:
                computerNumberLength = 9;
                break;
            default:
                throw new IllegalStateException("Unexpected difficulty: " + gameDifficulty);
        }
    }

    public int getComputerNumberLength() {
        return computerNumberLength;
    }

    public int[] getComputerNumber() {
        return computerNumber;
    }

    private void setComputerNumber(int[] computerNumber) {
        this.computerNumber = computerNumber;
    }

    public void printComputerNumber(){
        for (int i = 0; i < computerNumberLength; i++) {
            System.out.print(computerNumber[i]);
        }
    }

}
