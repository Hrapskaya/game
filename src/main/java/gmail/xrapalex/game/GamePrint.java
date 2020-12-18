package gmail.xrapalex.game;

public class GamePrint {

    public static void printAvailableMoves(String[] args) {
        System.out.println("Available moves:");
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + 1 + "-" + args[i]);
        }
        System.out.println("0 - exit");
        System.out.print("Enter your move: ");
    }

    public static void printMoves(String gamerMoves, String computerMoves) {
        System.out.println("Your move: " + gamerMoves);
        System.out.println("Computer move:" + computerMoves);
    }

    public static void printResult(Win win) {
        System.out.println(win);
    }

    public static void printHex(String hex){
        System.out.println("HMAC: " + hex);
    }

    public static void printKey(String secretKey){
        System.out.println("HMAC key: " + secretKey);
    }
}
