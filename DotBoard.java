package com.company;

import java.util.Random;

class DotBoard {
    public int[][] location1 = new int[3][2];
    public int[][] location2 = new int[3][2];
    public int[][] location3 = new int[3][2];

    String[][] board = {{" ","_"," ","_"," ","_"," ","_"," ","_"," ","_"," ","_"},
            {"|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," "},
            {" ","-"," ","-"," ","-"," ","-"," ","-"," ","-"," ","-"},
            {"|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," "},
            {" ","-"," ","-"," ","-"," ","-"," ","-"," ","-"," ","-"},
            {"|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," "},
            {" ","-"," ","-"," ","-"," ","-"," ","-"," ","-"," ","-"},
            {"|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," "},
            {" ","-"," ","-"," ","-"," ","-"," ","-"," ","-"," ","-"},
            {"|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," "},
            {" ","-"," ","-"," ","-"," ","-"," ","-"," ","-"," ","-"},
            {"|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," "},
            {" ","-"," ","-"," ","-"," ","-"," ","-"," ","-"," ","-"},
            {"|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," ","|"," "},
            {" ","-"," ","-"," ","-"," ","-"," ","-"," ","-"," ","-"}};

    public void reSetBoard(int a, int b){
        int x = (a * 2) + 1;
        int y = (b * 2) + 1;
        board[x][y] = "*";
        for (int row = 0; row < board.length; row++){
            for (int column = 0; column < board[row].length; column++){
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }
    public void setBoard(){
        for (int row = 0; row < board.length; row++){
            for (int column = 0; column < board[row].length; column++){
                System.out.print(board[row][column]);
            }
            System.out.println();
        }
    }
    public void setLocation(){
        Random random = new Random();
        int x1 = random.nextInt(5);
        int y1 = random.nextInt(5);
        int x2 = random.nextInt(5);
        int y2 = random.nextInt(5);
        int x3 = random.nextInt(5);
        int y3 = random.nextInt(5);

        int position1 = random.nextInt(2);
        int position2 = random.nextInt(2);
        int position3 = random.nextInt(2);

        if(position1 == 0){
            this.location1 = new int[][]{{x1, y1}, {x1 + 1, y1}, {x1 + 2, y1}};
        }
        else{
            this.location1 = new int[][]{{x1, y1}, {x1, y1 + 1}, {x1, y1 + 2}};
        }
        if(position2 == 0){
            this.location2 = new int[][]{{x2, y2}, {x2 + 1, y2}, {x2 + 2, y2}};
        }
        else{
            this.location2 = new int[][]{{x2, y2}, {x2, y2 + 1}, {x2, y2 + 2}};
        }
        if(position3 == 0){
            this.location3 = new int[][]{{x3, y3}, {x3 + 1, y3}, {x3 + 2, y3}};
        }
        else{
            this.location3 = new int[][]{{x3, y3}, {x3, y3 + 1}, {x3, y3 + 2}};
        }
    }
    public void checkLocations(){
        for(int i = 0; i < 3; i++){
            for(int x = 0; x < location1.length; x++){
                for(int y = 0; y < location1[x].length - 1; y++){
                    if(i == 0){
                        System.out.print("{"+location1[x][y]+","+location1[x][y+1]+"},");
                    }
                    if(i == 1){
                        System.out.print("{"+location2[x][y]+","+location2[x][y+1]+"},");
                    }
                    if(i == 2){
                        System.out.print("{"+location3[x][y]+","+location3[x][y+1]+"},");
                    }
                }
            }
            System.out.println();
        }
    }
}
