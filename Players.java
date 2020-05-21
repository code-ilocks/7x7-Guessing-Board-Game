package com.company;

class Players extends GuessingGame{
    private String userName = "";
    int guessCount = 0;
    int hitCountForLoc1 = 0;
    int hitCountForLoc2 = 0;
    int hitCountForLoc3 = 0;
    int[] xHits = {100,100,100,100,100,100,100,100,100};
    int[] yHits = {100,100,100,100,100,100,100,100,100};

    void setUserName(String userName){
        this.userName = userName;
    }
    String getUserName(){
        return userName;
    }

    void checkWinner(){
        if(hitCountForLoc1 == 3 && hitCountForLoc2 == 3 && hitCountForLoc3 == 3){
            System.out.println("CONGRATULATIONS ! "+userName+" WON !");
            System.out.println("Number of Guesses: " + guessCount);
            System.exit(0);
        }
    }
}
