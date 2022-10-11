package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
        //Print Board
        System.out.println("---------");
        for (String[] strings : board) {
            System.out.print("| ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        String winner = "";
        int playerTurn = 1;
        do {
            //Fill board with user input
            System.out.println("Make your move!");
            String xInput = sc.next();
            String yInput = sc.next();
            do {
                int x;
                int y;
                try {
                    x = Integer.parseInt(xInput);
                    y = Integer.parseInt(yInput);
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                    System.out.println("Make your move!");
                    xInput = sc.next();
                    yInput = sc.next();
                    continue;
                }
                if (x > 3 || y > 3 || x < 1 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.println("Make your move!");
                    xInput = sc.next();
                    yInput = sc.next();
                } else if (!board[x - 1][y - 1].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Make your move!");
                    xInput = sc.next();
                    yInput = sc.next();
                } else {
                    if (playerTurn == 1) {
                        board[x - 1][y - 1] = "X";
                    } else {
                        board[x - 1][y - 1] = "O";
                    }
                    break;
                }
            } while (true);
            System.out.println("---------");
            for (String[] strings : board) {
                System.out.print("| ");
                for (int j = 0; j < board.length; j++) {
                    System.out.print(strings[j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");

            int xCount = 0;
            int oCount = 0;
            int blank = 0;

//            Check if board is impossible
            for (String[] row : board) {
                for (String mark : row) {
                    if (mark.equals("X")) {
                        xCount++;
                    } else if (mark.equals("O")) {
                        oCount++;
                    } else {
                        blank++;
                    }
                }
            }
            if ((xCount - oCount) > 1 || (oCount - xCount) > 1 && blank > 0) {
                winner = "Draw";
            }
            //Check is someone won
            if (!winner.equals("Draw")) {
                for (int i = 0; i < board.length; i++) {
                    if (playerTurn == 1) {
                        if (board[i][0].equals("X") && board[i][1].equals("X") && board[i][2].equals("X")) {
                            winner = "X";
                            break;
                        } else if (board[0][i].equals("X") && board[1][i].equals("X") && board[2][i].equals("X")) {
                            winner = "X";
                            break;
                        } else if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")) {
                            winner = "X";
                            break;
                        } else if (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")) {
                            winner = "X";
                            break;
                        }
                    } else {
                        if (board[i][0].equals("O") && board[i][1].equals("O") && board[i][2].equals("O")) {
                            winner = "O";
                            break;
                        } else if (board[0][i].equals("O") && board[1][i].equals("O") && board[2][i].equals("O")) {
                            winner = "O";
                            break;
                        } else if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")) {
                            winner = "O";
                            break;
                        } else if (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")) {
                            winner = "O";
                            break;
                        }
                    }
                }
                if (playerTurn == 1) {
                    playerTurn = 2;
                } else {
                    playerTurn = 1;
                }
            }
        } while (!winner.equals("X") && !winner.equals("O") && !winner.equals("Draw"));
        if (!winner.equals("Draw")) {
            System.out.println(winner + " wins");
        } else {
            System.out.println("Draw");
        }
    }
}
