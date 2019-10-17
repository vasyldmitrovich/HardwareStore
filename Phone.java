
public class Phone extends Products {
    private int ScreenDiagonal;
    private int Ram;
    private int InternalMemory;

    public Phone(String name, int price, String manufacturer, int year, int screenDiagonal, int ram, int internalMemory) {
        super(name, price, manufacturer, year);
        ScreenDiagonal = screenDiagonal;
        Ram = ram;
        InternalMemory = internalMemory;
    }

    public int getScreenDiagonal() {
        return ScreenDiagonal;
    }

    public void setScreenDiagonal(int screenDiagonal) {
        ScreenDiagonal = screenDiagonal;
    }

    public int getRam() {
        return Ram;
    }

    public void setRam(int ram) {
        Ram = ram;
    }

    public int getInternalMemory() {
        return InternalMemory;
    }

    public void setInternalMemory(int internalMemory) {
        InternalMemory = internalMemory;
    }
}