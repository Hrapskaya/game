package gmail.xrapalex.game;

import gmail.xrapalex.game.exception.GameException;
import gmail.xrapalex.game.exception.ValidateException;

public class Main {

    public static void main(String[] args) {
        try {
            ArgumentsValidator.getInstance().isValid(args);
            Game game = new Game(args);
            game.play();
        } catch ( ValidateException e) {
            System.out.println(e.getMessage());
        }
        catch (GameException ignored){
        }
    }
}
