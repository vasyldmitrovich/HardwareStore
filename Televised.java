
public class Televised extends Products {
    private int ScreenDiagonal;

    public Televised(String name, int price, String manufacturer, int year, int screenDiagonal) {
        super(name, price, manufacturer, year);
        ScreenDiagonal = screenDiagonal;

    }

    public int getScreenDiagonal() {
        return ScreenDiagonal;
    }

    public void setScreenDiagonal(int screenDiagonal) {
        ScreenDiagonal = screenDiagonal;
    }

}
