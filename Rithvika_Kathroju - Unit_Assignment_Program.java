/*
Rithvika Kathroju 
10/18/2021
ICS 3U1-01

Unit 4 Assignment - Snakes and Ladders Simulator
Description: 
    Create a snakes and ladders game. Player starts at square #1 and rolls two dice. They will then move that 
    many spots to the next space. They get to move up the ladder to the space where the ladder ends. If the player
    lands on a snake’s head, then they have to move down the snake to where the tail sends to their new spot. The 
    player continuously rolls the two dice until they reach or exceed 100.


FEATURES 
    - As the game progresses, everytime you land on an even number the user will win a ticket, everytime a user lands on a snake
        they have the option to spend two tickets to escape the snake and stay at their current spot instead of having to go down
    - Asks the user if they would like to play again or exit the game
    - Included visuals such as emojis and borders to ensure that code is organized and visually appealing
    - Prompts the user to press enter after each turn/time the dice are rolled
    - Used procedures and functions as well as arrays and global variables to make code efficent, code within the main metheod is short
*/

//import the Scanner class in the util package within java in order to allow user input 
import java.util.Scanner;

public class MyProgram {
    // initializing a global scanner class object to scan user input, in order to allow user input across all methods
    static Scanner s = new Scanner(System.in);
    // declaring and initializing a global variable that stores and counts tickets won so that it can be used in other methods
    static int ticketsWon;
    // declaring and initializing a global variable that stores the player's position throughout the game, it can be used in other methods
    static int playerPosition;
    
    // main method
    public static void main(String[] args) {
        
        // invoke the procedure printIntroduction() to print out a game introduction and the rules
        printIntroduction();
        /*
        In this while loop the userWantsToPlay() procedure will be invoked to check if the user wants to play the game. The procedure returns 
        a boolean value, if true the loop will invoke and execute the playGame() method which encompasses the main game
        */
        while (userWantsToPlay()){
            playGame();
        }
    }
    
    
    /*
    This is the printIntroduction() procedure that outputs the title of the game as well as the game rules in addition to subheading borders for visual appeal
    */
    static void printIntroduction() {
        // outputs a subheading border line
        System.out.println("---------------------------------------------------------------------");
        System.out.println("🏆  🎲  👣  ♟️  🐍  🏆  🎲  👣  ♟️  🐍  🏆  🎲  👣  ♟️  🐍  🏆  🎲  👣  ♟️  🐍  🏆  🎲  👣 \n");
        // outputs a title for the game
        System.out.println("                    SNAKES AND LADDERS SIMULATOR");
        // outputs a subheading border line
        System.out.println("\n🏆  🎲  👣  ♟️  🐍  🏆  🎲  👣  ♟️  🐍  🏆  🎲  👣  ♟️  🐍  🏆  🎲  👣  ♟️  🐍  🏆  🎲  👣 ");
        System.out.println("---------------------------------------------------------------------\n");
        // outputs the game rules for the game so that the user can understand how the game works
        System.out.println("GAME RULES:\n");
        System.out.println("Player starts at square #1 and rolls two dice.");
        System.out.println("They will then move that many spots to the next space.");
        System.out.println("Everytime the user lands on an even number they will win");
        System.out.println("a ticket, which can be used to fight snakes. If they land"); 
        System.out.println("on a ladder they get to move up to the space where the");
        System.out.println("ladder ends. If the player lands on a snake’s head, they");
        System.out.println("can pay 2 tickets to remain in their current spot, otherwise");
        System.out.println("then they have to move down the snake to where the tail");
        System.out.println("ends. The player continuously rolls the two dice until \nthey reach or exceed 100.");
    }
    
    
    /*
    This is the playGame() procedure that encompasses the main game and funtionality of the program. 
    
    Within the method two variables are initialized, tickets won set to equal 0 and the player position equal to 1 since the player starts at 1 in 
    the game. An infinite while loop will then be executed to run the game, and will only break if the player wins. After prompting the user to 
    press enter for the their turn, the printPosition() is invoked in order to print out the current position of the player on the game board. 
    A variable is then declared and intialized to store the rolled dice value (rolls two dice, and outputs sum) generated by invoking the 
    rollDice() function. After the players position is recalculated using the movePlayerPosition(totalDiceValue) procedure by passing in the rolled
    dice value as an arugment, it will then check if the user is at a snake or ladder using the checkForSnakesAndLadders() procedure, and then 
    check to see if the player won a ticket to escape snakes using the checkIfWonTicket() procedure -- both using the player position. Lastly, it 
    will check if the player won using the playerWon() function, if the player did win it will break out of the loop 
    */
    static void playGame(){
        // initializing the tickets won counter variable to 0, starting off with 0 tickets in the game
        ticketsWon = 0;
        // initializing the player position variable to 1, starts the game at game board position 1
        playerPosition = 1;
        
        /*
        This is an infinite while loop that executes to run the main game and only breaks when the user wins
        
        First the user is prompted to press enter for the their turn, and then the printPosition() is invoked in order to print out the current 
        position of the player on the game board. A variable is then created to store the rolled dice value (rolls two dice, and outputs sum) generated by invoking the 
        rollDice() function. Next, the players position is recalculated using the movePlayerPosition(totalDiceValue) procedure by passing in the rolled
        dice value as an arugment. After that It will then check if the user is at a snake or ladder using the invoked checkForSnakesAndLadders() procedure, it will also
        check to see if the player won a ticket to escape snakes using the checkIfWonTicket() procedure -- both methods mainly focus on the player position. Lastly, it 
        will check if the player won using the playerWon() function, if the player did win it will output a message and break out of the loop 
        */
        while (true) {
            // outputs a subheading border line
            System.out.println("\n---------------------------------------------------------------------\n");
            // prompts the user to press enter in order to continue with the loop 
            System.out.print("Press enter to continue"); // prompts the user
            s.nextLine(); // accepts the input and does not store it in a variable as its not necessary 
            
            // invokes the printPosition() method which prints out the current position of the player
            printPosition();
            
            // declares and intializes a variable to store the rolled dice value (rolls two dice, and outputs sum) generated by invoking the rollDice() function.
            int totalDiceValue = rollDice();
            // invokes the movePlayerPosition() method and passes in the rolled dice value as a parameter in order to move the player
            movePlayerPosition(totalDiceValue);
            
            // invokes the checkForSnakesAndLadders() to check if there is a snake or ladder in the current position of the player
            checkForSnakesAndLadders();
            // invokes the checkIfWonTicket() to check if the user won a ticket based on current position, helps player escape from snakes
            checkIfWonTicket();
            
            /*
            This if statement checks if the user won the game
            
            if the user won, checked by invoking the playerWon() function then it will output a winning message and then break out of the loop
            */
            if (playerWon()) {
                // outputs a subheading border line
                System.out.println("\n---------------------------------------------------------------------\n");
                // outputs a winning message for the user
                System.out.println("🏆  You reached or exceeded 100! You Win!!");
                // breaks out of the loop since user won and game is finished
                break;
            }
        }
    }
    
    
    /*
    This is the printPosition() procedure that prints out the current position of the player by stating what square it is at
    */
    static void printPosition() {
        // outputs the square position of the player 
        System.out.println("\n♟️  You are at square " + playerPosition);
    }
    
    
    /*
    This is the rollDice() function which will generate two random number both between 1 and 6 to represent dice, 
    the sum of both dice will be calculated and then returned by the function as in int value
    */
    static int rollDice(){
        // declare and initialize a min variable to store the minimum of the range of numbers that can be generated
        int min = 1; 
        // declare and initialize a max variable to store the maximum of the range of numbers that can be generated
        int max = 6;
        
        // declare and initialize a variable to store the first randomly generated number between 1 and 6
        int rollDie1 = (int)(Math.random()*(max - min + 1) + min);
        // declare and initialize another variable to store the second randomly generated number between 1 and 6
        int rollDie2 = (int)(Math.random()*(max - min + 1) + min);
        
        // declare and initialize a total dice variable to store the sum of both randomly generated numbers 
        int totalRolledDice = rollDie1 + rollDie2;
        
        // outputs the total value of the rolled dice as a message
        System.out.println("🎲  You rolled a dice total of " + totalRolledDice + "!");
        
        // returns the total rolled dice value as an integer
        return totalRolledDice;
    }
    
    
    /*
    This is the movePlayerPosition() procedure which will take in a parameter, the rolled dice value, 
    and then calculate/move the player to its new position. It will then output the square number position it is at 
    */
    static void movePlayerPosition(int totalDiceValue) {
        // re-initializes the value of player position to store the orginal value of the position plus the rolled dice value, which is the new position of the player
        // this is possible because it is a global variable -- greater scope
        playerPosition += totalDiceValue;
        // outputs the users new position after moving
        System.out.println("♟️  You moved to square " + playerPosition);
    }
    
    
    /*
    This is the checkIfSnakeOrLadder() procedure that takes in the player's position as a parameter. The function uses arrays 
    to check whether the player landed on the start of a ladder or face of snake, it will then move the player accordingly by matching
    the index number of both arrays for one action (ex. ladder). In the case of a snake, if the user has enough tickets 
    saved up they are allowed to spend 2 tickets to fight the snake and stay at their current spot as opposed to having to go down. 
    It will then update the position accordingly
    */
    static void checkForSnakesAndLadders() {
        // ADDED 2 EXTRA LADDERS (4-->15) and (32-->51)
        // declare and initialize an array to store the starting positions of each of the ladders 
        int[] ladderStart = {4, 9, 32, 40, 67};
        // declare and initialize an array to store the ending positions of each of the ladders
        // elements correspond to previous array based on index location within array, ex.  ladderStart[0] and ladderEnd[0]
        int[] ladderEnd = {15, 34, 51, 64, 86};
        
        // ADDED 1 EXTRA SNAKE (87-->65)
        // declare and initialize an array to store the starting positions of each of the snakes 
        int[] snakeStart = {54, 87, 90, 99};
        // declare and initialize an array to store the ending positions of each of the ladders
        // elements correspond to previous array based on index location within array, ex.  snakeStart[0] and snakeEnd[0]
        int[] snakeEnd = {19, 65, 48, 77};
        
        /*
        This for loop runs while i is less than the length of the ladderStart array and increments by 1 each time after starting at 0. 
        This provides index positions of the arrays. If the current positition of the player is equal to an element in the ladderStart 
        array that means that they user must be at the start of a ladder, in which they will go up. It will output a message and the 
        position will be redefined
        */
        for (int i = 0; i < ladderStart.length; i++) {
            // if the position is equal to an element in the startLadder program then they must be at a ladder
            if (playerPosition == ladderStart[i]) {
                // outputs a message informing they are going up a ladder
                System.out.println("👣  Ladder up to " + ladderEnd[i] + "!");
                // outputs the new position
                System.out.println("♟️  You moved to square " + ladderEnd[i]);
                // position variable is now updated to the location of where the ladder ended
                playerPosition = ladderEnd[i];
            }
        }
        /*
        This for loop runs while i is less than the length of the snakeStart array and increments by 1 each time after starting at 0. 
        This provides index positions of the arrays. If the current positition of the player is equal to an element in the snakeStart 
        array that means that they user must be at a snake. If the player has enough tickets they can spend them and escape the snake, 
        otherwise they would have to go down. It will output messages along the way and the position will be redefined
        */
        for (int i = 0; i < snakeStart.length; i++) {
            /*
            if the position is equal to an element in the startSnake program then they must be at a snake, if they have enough tickets, 
            the user can escape the snake and stay at its current position, otherwise the user can choose to OR must go down according 
            to the situation
            */
            if (playerPosition == snakeStart[i]) {
                // outputs a message warning snake
                System.out.println("🐍  A SNAKE!!");
                
                /*
                if the user has more than or equal to 2 tickets, they will be asked if they want to spend it. 
                if they choose to, the total tickets count will decrease by 2, and the user will remain in their current spot
                otherwise, if the user decides not to spend their tickets, they will have to go down the snake to a new position
                */
                if (ticketsWon >= 2) {
                    // prompts the user if they would like to spend 2 tickets to fight the snake
                    System.out.print("Would you like to use 2 tickets to fight the snake and stay at your current spot? (\'y\' or \'n\') : "); // prompt
                    String spendTickets = s.nextLine(); // accepts user input and stores it in a variabl
                    
                    /*
                    This if statement checks if the user inputted 'y' or 'n' to wanting to use their tickets to fight the snake
                    
                    if the player said 'y' then the tickets won counter will be decremented by 2 since it takes 2 tickets to fight a snake.
                    It will then output a message telling the user they used 2 tickets, and inform them how many are remaining
                    It will then tell them the square position on the board that they remain it
                    
                    otherwise, if the user did not say 'y', then it means they do not want to use their tickets, in which 
                    the player will go down the snake to a new position. It will then output the new position of the player
                    */
                    if (spendTickets.equalsIgnoreCase("y")) {
                        // decrement the tickets won counter by 2, since it takes 2 tickets to fight a snake
                        ticketsWon -= 2;
                        // outputs a message saying they used 2 tickets, tells them how many tickets remain
                        System.out.println("You used 2 tickets. You have " + ticketsWon + " remaining!");
                        // outputs the position the player remains at
                        System.out.println("♟️  You remain at square " + playerPosition);
                    }
                    else {
                        // outputs a message saying the player went down the snake. 
                        // It went to the corresponding end position based on the start position of the snake
                        System.out.println("🐍  Snake!! Back down to " + snakeEnd[i] + "!");
                        // outputs the new position of the player
                        System.out.println("♟️  You are at square " + snakeEnd[i]);
                        // re-intializes the player position to the the corresponding end position of the snake based on its start position 
                        playerPosition = snakeEnd[i];
                    }
                }
                else {
                    // outputs a message saying the player went down the snake. 
                    // It went to the corresponding end position based on the start position of the snake
                    System.out.println("🐍  Snake!! You only have " + ticketsWon + " ticket(s). Back down to " + snakeEnd[i] + "!");
                    // outputs the new position of the player
                    System.out.println("♟️  You are at square " + snakeEnd[i]);
                    // re-intializes the player position to the the corresponding end position of the snake based on its start position 
                    playerPosition = snakeEnd[i];
                }
            }
        }
    }
    
    
    /*
    This is the checkIfWonTicket() procedure that checks if the player won a ticket - can be used to fight snakes
    
    if the player is positioned at an even number then the player will win a ticket. It will output a message, 
    and increment the counter by 1
    */
    static void checkIfWonTicket() {
        // if the player position is an even number then the player will win a ticket. Outputs a message, and increments counter
        if (playerPosition % 2 == 0) {
            // outputs a message saying the player won a ticket
            System.out.println("You just won a ticket because you landed on a multiple of 2!");
            // increments the tickets won counter by 1
            ticketsWon++;
        }
    }
    
    
    /*
    This is the playerWon() function that checks to see if the player has won the game, returns a boolean value
    */
    static boolean playerWon(){
        /*
        returns true or false based on whether the player has won, if the player position is greater than or equal
        to 100 it will return true. Otherwise, it will return false 
        */
        return playerPosition >= 100;
    }
    
    
    /*
    This is the userWantsToPlay() function that checks if the user wants to play the game, and returns a boolean value
    
    if they want to play, the function will return the boolean value as true because they want to play
    otherwise, if they do not want to play, it will output a goodbye message and thenreturn the boolean value as false 
    */
    static boolean userWantsToPlay() {
        // outputs a subheading border line
        System.out.println("\n---------------------------------------------------------------------\n");
        // prompts the user asking them if they would like to play the game
        System.out.print("Would you like to play? (\'y\' or \'n\'): "); // prompts the user
        String userPlayAgain = s.nextLine(); // accepts the user input and stores it in a variable
        
        /*
        if they want to play, the function will return the boolean value as true because they want to play
        otherwise, if they do not want to play, it will output a goodbye message and thenreturn the boolean value as false 
        */
        if (userPlayAgain.equalsIgnoreCase("y")) {
            // returns true because the user wants to play
            return true;
        }
        else {
            // outputs a subheading border line
            System.out.println("\n---------------------------------------------------------------------\n");
            // output message telling the user goodbye and thanks for visiting the game
            System.out.println("👋  Okay, thank you for visiting! Goodbye!");
            // returns true because the user wants to play
            return false;
        }
    }
}//end - total of 354 lines