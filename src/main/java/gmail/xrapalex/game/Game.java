package gmail.xrapalex.game;

import gmail.xrapalex.game.exception.GameException;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final static Random random = new Random();
    private final static Scanner scanner = new Scanner(System.in);

    private final String[] allMoves;
    private MovesCode codeComputerMoves;

    public Game(String[] allMoves) {
        this.allMoves = allMoves;
    }

    public void play() throws GameException {
        int computerMoves = computerMove();
        int gamerMoves = scanGamerMoves();
        if(gamerMoves == -1){
            throw new GameException();
        }
        sumUp(gamerMoves, computerMoves);
    }

    private int computerMove() {
        int movesIndex = random.nextInt(allMoves.length);
        codeComputerMoves = new MovesCode(allMoves[movesIndex]);
        GamePrint.printHex(codeComputerMoves.getCodeHex());
        return movesIndex;
    }

    private int scanGamerMoves() {
        while (true) {
            GamePrint.printAvailableMoves(allMoves);
            int moves = scanner.nextInt();
            if (moves >= 0 && moves <= allMoves.length) {
                return moves - 1;
            }
        }
    }

    private void sumUp(int gamerMoves, int computerMoves) {
        Win win = findWinner(gamerMoves, computerMoves, allMoves.length);
        GamePrint.printResult(win);
        GamePrint.printMoves(allMoves[gamerMoves], allMoves[computerMoves]);
        GamePrint.printKey(codeComputerMoves.getSecretKey());
    }

    private static Win findWinner(int gamerMoves, int computerMoves, int length) {
        int count = length / 2;
        int temp = gamerMoves - computerMoves;
        Win win = Win.DRAW;
        if (temp > 0) {
            win = temp <= count ? Win.GAMER : Win.COMPUTER;
        }
        if (temp < 0) {
            win = -temp <= count ? Win.COMPUTER : Win.GAMER;
        }
        return win;
    }
}
