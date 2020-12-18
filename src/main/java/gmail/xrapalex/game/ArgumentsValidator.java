package gmail.xrapalex.game;

import gmail.xrapalex.game.exception.ValidateException;

import java.util.HashSet;
import java.util.Set;

public class ArgumentsValidator {

    private final static ArgumentsValidator instance = new ArgumentsValidator();

    private ArgumentsValidator() {
    }

    public static ArgumentsValidator getInstance() {
        return instance;
    }

    public void isValid(String[] arguments) throws ValidateException {
        isValidNumber(arguments);
        isOddNumber(arguments);
        isRepeat(arguments);
    }

    private void isOddNumber(String[] arguments) throws ValidateException {
        if (arguments.length % 2 == 0){
            throw new ValidateException("The number of arguments must be odd!"
                    + '\n' + "For example: rock paper scissors.");
        }
    }

    private void isValidNumber(String[] arguments) throws ValidateException {
        int length = arguments.length;
        if (length < 3) {
            throw new ValidateException("Number of arguments must be 3 or more!"
                    + '\n' + "For example: rock paper scissors.");
        }
    }

    private void isRepeat(String[] arguments) throws ValidateException {
        Set<String> checkRepeat = new HashSet<>();
        for (String s : arguments) {
            checkRepeat.add(s.toLowerCase());
        }
        if (checkRepeat.size() < arguments.length) {
            throw new ValidateException("Arguments must not be repeated!"
                    + '\n' + "For example: rock paper scissors.");
        }
    }
}
