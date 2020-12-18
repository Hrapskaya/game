package gmail.xrapalex.game;

public enum Win {

    COMPUTER ("Computer win!"),
    GAMER ("You win!"),
    DRAW ("Draw!");

    String currency;

    Win(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return currency;
    }
}
