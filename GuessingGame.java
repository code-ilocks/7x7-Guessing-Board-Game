package com.company;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private static DotBoard board = new DotBoard();
    static char[] alphabet = {'A','B','C','D','E','F','G'};
    static int[] alphaNum = {0,1,2,3,4,5,6};
    Players[] player = new Players[2];

    static boolean loopLocation(int x,int y,int[][] location){

        for(int row = 0; row < location.length; row++){
            for(int column = 0; column < location[0].length - 1; column++){
                if(x == location[row][column] && y == location[row][column + 1]){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean playerHits(Players player,int x,int y) {
        for(int i = 0; i < player.xHits.length; i++){
            if(x == player.xHits[i] && y == player.yHits[i]){
                return true;
            }
            else if(player.xHits[i] == 100 & player.yHits[i] == 100){
                player.xHits[i] = x;
                player.yHits[i] = y;
                return false;
            }
        }
        return false;
    }
    public void checkGuess(Players player,int x, int y){
        player.guessCount++;

        if(!loopLocation(x,y,board.location1) & !loopLocation(x,y,board.location2) & !loopLocation(x,y,board.location3)){
            System.out.println("Missed !");
        }
        else{
            if(loopLocation(x,y,board.location1) & loopLocation(x,y,board.location2) & loopLocation(x,y,board.location3)){
                if(!playerHits(player,x,y)){
                    player.hitCountForLoc3++;
                    player.hitCountForLoc2++;
                    player.hitCountForLoc1++;
                    System.out.println("TRIPLE HIT !");
                }
                else{
                    System.out.println("Already Taken !");
                }
            }
            else if(loopLocation(x,y,board.location1) & loopLocation(x,y,board.location2) & !loopLocation(x,y,board.location3)){
                if(!playerHits(player,x,y)){
                    player.hitCountForLoc2++;
                    player.hitCountForLoc1++;
                    System.out.println("Double Hit !");
                }
                else{
                    System.out.println("Dot already Taken");
                }
            }
            else if(loopLocation(x,y,board.location1) & !loopLocation(x,y,board.location2) & loopLocation(x,y,board.location3)){
                if(!playerHits(player,x,y)){
                    player.hitCountForLoc3++;
                    player.hitCountForLoc1++;
                    System.out.println("Double Hit !");
                }
                else{
                    System.out.println("Dot already Taken");
                }
            }
            else if(loopLocation(x,y,board.location1) & !loopLocation(x,y,board.location2) & !loopLocation(x,y,board.location3)){
                if(!playerHits(player,x,y)){
                    player.hitCountForLoc1++;
                    System.out.println("Hit !");
                }
                else{
                    System.out.println("Dot already Taken");
                }
            }
            else if(!loopLocation(x,y,board.location1) & loopLocation(x,y,board.location2) & loopLocation(x,y,board.location3)){
                if(!playerHits(player,x,y)){
                    player.hitCountForLoc2++;
                    player.hitCountForLoc3++;
                    System.out.println("Double Hit !");
                }
                else{
                    System.out.println("Dot already Taken");
                }
            }
            else if(!loopLocation(x,y,board.location1) & loopLocation(x,y,board.location2) & !loopLocation(x,y,board.location3)){
                if(!playerHits(player,x,y)){
                    player.hitCountForLoc2++;
                    System.out.println("Hit !");
                }
                else{
                    System.out.println("Dot already Taken");
                }
            }
            else if(!loopLocation(x,y,board.location1) & !loopLocation(x,y,board.location2) & loopLocation(x,y,board.location3)){
                if(!playerHits(player,x,y)){
                    player.hitCountForLoc3++;
                    System.out.println("Hit !");
                }
                else{
                    System.out.println("Dot already Taken");
                }
            }
        }
    }

    static int convertX(String str){
        for (int i = 0; i < alphaNum.length; i++){
            if(str.charAt(0) == alphabet[i]){
                return alphaNum[i];
            }
        }
        return 0;
    }

    public void startGame() throws InterruptedException {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        board.setLocation();
        for (int i = 0; i < 2; i++){
            player[i] = new Players();
        }
        System.out.println("Welcome to the Guess the Index Game !");
        System.out.print("Play with a friend(F) or CPU(C) : ");
        char gameType = scan.next().charAt(0);
        switch(gameType){
            case 'F': case 'f':
                System.out.print("Player 1 username : ");
                player[0].setUserName(scan.next());
                System.out.print("Player 2 username : ");
                player[1].setUserName(scan.next());
                break;
            case 'C': case 'c':
                System.out.print("Pick a username : ");
                player[0].setUserName(scan.next());
                player[1].setUserName("CPU");
                break;
        }
        System.out.print("Starting game in ");
        for(int i = 3; i > 0; i--){
            System.out.print(" "+i);
            for(int a = 3; a > 0; a--){
                System.out.print(".");
                Thread.sleep(300);
            }
        }

        System.out.println();
        board.setBoard();
        String winner = "";
        if(player[1].getUserName() == "CPU"){
            while(winner == ""){
                board.checkLocations();
                System.out.println("Rows are A,B,C,D,E,F,G");
                System.out.println("Columns are 0,1,2,3,4,5,6");
                System.out.println("Sample answer : B1 or C2");
                System.out.print(player[0].getUserName()+" Guess : ");
                String guess = scan.next();
                int x = convertX(guess);
                int y = Integer.parseInt(guess.substring(1));
                checkGuess(player[0],x,y);
                board.reSetBoard(x,y);
                player[0].checkWinner();
                System.out.println("CPUs turn to Guess...");
                Thread.sleep(3000);
                x = random.nextInt(7);
                y = random.nextInt(7);
                checkGuess(player[1],x,y);
                board.reSetBoard(x,y);
                player[1].checkWinner();
            }
        }
        else{
            while(winner == ""){
                System.out.println("Rows are A,B,C,D,E,F,G");
                System.out.println("Columns are 0,1,2,3,4,5,6");
                System.out.println("Sample answer : B1 or C2");
                System.out.print(player[0].getUserName()+" Guess : ");
                String guess = scan.next();
                int x = convertX(guess);
                int y = Integer.parseInt(guess.substring(1));
                checkGuess(player[0],x,y);
                board.reSetBoard(x,y);
                player[0].checkWinner();
                System.out.print(player[1].getUserName()+" Guess : ");
                guess = scan.next();
                x = convertX(guess);
                y = Integer.parseInt(guess.substring(1));
                checkGuess(player[1],x,y);
                board.reSetBoard(x,y);
                player[1].checkWinner();
            }
        }
    }
}
