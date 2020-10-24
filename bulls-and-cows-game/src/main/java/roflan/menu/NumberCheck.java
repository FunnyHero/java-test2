package roflan.menu;

public class NumberCheck {
    public boolean isDifferentDigits(int[] number){
        boolean isDifferentDigits = true;
        for (int i = 0; i < number.length && isDifferentDigits; i++) {
            for (int j = 0; j < number.length && isDifferentDigits; j++) {
                if (i != j){
                    isDifferentDigits = number[i] != number[j];
                }
            }
        }
        return isDifferentDigits;
    }

}
