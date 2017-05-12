package splits;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the score line: ");
        String scoreLine = scan.nextLine();

        System.out.println("Total: " + main.scoreCalculator(scoreLine));
    }

    private int scoreConversion(int x, String[] newInput){
        try{
            String scoreInput = newInput[x];
            if(scoreInput.equals("X")) {
                return 10;
            }
            else if (scoreInput.equals("/")){
                return (10 - Integer.parseInt(newInput[x - 1]));
            }
            else{
                return Integer.parseInt(scoreInput);
            }
        }
        catch (StringIndexOutOfBoundsException e){
            return 0;
        }
    }

    private int scoreCalculator(String inputScore){
        String[] newInput = inputScore.replace("-", "0").trim().split("");

        int totalScore = 0;
        double frame = 1.0;


        for (int i = 0; i < newInput.length; i++) {
            totalScore = totalScore + this.scoreConversion(i, newInput); //

            if(i < newInput.length && frame < 10){
                if(newInput[i].equals("X")){
                    totalScore = totalScore + (this.scoreConversion(i + 1, newInput) + this.scoreConversion(i + 2,  newInput));
                    frame = frame + 1;
                }
                else if (newInput[i].equals("/")){
                    totalScore = totalScore + this.scoreConversion(i + 1, newInput);
                    frame = frame + .5;
                }
                else {
                    frame = frame + .5;
                }
            }

        }
        return totalScore;
    }

}