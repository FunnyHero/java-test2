package roflan.players;

import roflan.menu.NumberCheck;

import java.util.Scanner;

public class User {
    private int[] userNumber;
    private int userNumberLength;

    public void userNumberInput() {
        Scanner in = new Scanner(System.in);
        int[] userNumber = new int[userNumberLength];
        System.out.println("Enter " + userNumberLength + " different digits");
        boolean isDifferentDigits = false;
        NumberCheck numberCheck = new NumberCheck();
        while (!isDifferentDigits){
            for (int i = 0; i < userNumberLength; i++) {
                do {
                    userNumber[i] = in.nextInt();
                    if (userNumber[i] < 0 || userNumber[i] > 9){
                        System.out.println("You must enter the number one digit at a time");
                    }
                } while (userNumber[i] < 0 || userNumber[i] > 9);
            }
            isDifferentDigits = numberCheck.isDifferentDigits(userNumber);
            if (!isDifferentDigits){
                System.out.println("Number contains the same digits");
                System.out.println("Enter number again");
            }
        }
        setUserNumber(userNumber);
    }
    private void setUserNumber(int[] userNumber) {
        this.userNumber = userNumber;
    }

    public int[] getUserNumber() {
        return userNumber;
    }
    public void setUserNumberLength(int userNumberLength) {
        this.userNumberLength = userNumberLength;
    }

}
