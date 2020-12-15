/*
file : redGreenLight.java
description : This program allows the user to play the game "Red Light Green Light" where they
             can move when the light is green, but if they move when the light is red, they lose.
              If the player reaches the end, they win!
author : Dean Wahle and Josh Prillaman
date : 4/26/20
 */

//import java tools
import java.awt.*;
import java.util.Random;

public class redGreenLight {

    //main method
    public static void main(String[] args) {

        //initializing grid size
        StdDraw.setXscale(0, 120);
        StdDraw.setYscale(0, 120);
        StdDraw.setPenColor(Color.black);

        //intializing numClicks and player location variables
        int numClicks = 1;
        int playerLocation = numClicks * 10;

        //while loop to run game
        while (numClicks < 11) {

            //game instructions
            StdDraw.text(50, 100, "Click when the light is green to move forward.");
            StdDraw.text(40, 95, "If you click when the light is red you lose!");
            StdDraw.text(40, 90, "If you make it to the last space, you win!");

            //Drawing lines
            StdDraw.line(10, 20, 10, 30);
            StdDraw.line(20, 20, 20, 30);
            StdDraw.line(30, 20, 30, 30);
            StdDraw.line(40, 20, 40, 30);
            StdDraw.line(50, 20, 50, 30);
            StdDraw.line(60, 20, 60, 30);
            StdDraw.line(70, 20, 70, 30);
            StdDraw.line(80, 20, 80, 30);
            StdDraw.line(90, 20, 90, 30);
            StdDraw.line(100, 20, 100, 30);
            StdDraw.line(10, 25, 100, 25);
            StdDraw.show();

            //putting stick figure image on the canvas
            StdDraw.picture(playerLocation, 50, "stickFigure.png", 20, 40);

            //creating a random dumber generator to pick the color of the circle at any given time
            Random randGen = new Random();
            int colorPicker = randGen.nextInt(12);

            //if else statments to display color based on the random number generated
            if (colorPicker == 0 || colorPicker == 1) {
                StdDraw.setPenColor(Color.RED);
                StdDraw.filledCircle(100, 80, 15);
                StdDraw.pause(150);
            } else {
                StdDraw.setPenColor(Color.GREEN);
                StdDraw.filledCircle(100, 80, 15);
                StdDraw.pause(150);
            }

            //0 and 1 are the values for red in this random number generator
            //if the mouse is pressed and the light is red, break loop
            if (StdDraw.isMousePressed() == true && colorPicker == 0){
                break;
            }

            //if the mouse is pressed and the light is red, break loop
            else if (StdDraw.isMousePressed() == true && colorPicker == 1) {
                break;
            }

            //if the mouse is pressed and the light is green, increase numClicks and move the stick figure
            else if (StdDraw.isMousePressed() == true) {
                StdDraw.setPenColor(Color.BLACK);
                numClicks = numClicks + 1;
                playerLocation = numClicks * 10;
                StdDraw.picture(playerLocation, 50, "stickFigure.png", 20, 40);
                System.out.println(numClicks);
                if (numClicks > 1) {
                    StdDraw.picture(playerLocation - 10, 50, "White-Square.jpg", 20, 40);
                    StdDraw.pause(100);
                }
            }

            //if the player reaches the end, clear the canvas and break the loop
            if (playerLocation == 100) {
                StdDraw.clear();
                break;
            }
        }

        //if the loop is broken and the player reached the end, display "you win" and crown
        if (playerLocation == 100) {
            StdDraw.clear();
            StdDraw.text(60, 60, "You win!");
            StdDraw.picture(60, 30, "crown.jpg", 40, 40);
        }

        //if the loop was broken and the player did not reach the end, display "you lose" and frowny face
        if (playerLocation != 100) {
            StdDraw.clear();
            StdDraw.text(60, 60, "You lose!");
            StdDraw.picture(60, 30, "download.png", 20, 40);
        }
    }
}