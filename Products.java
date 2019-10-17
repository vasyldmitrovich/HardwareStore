
public class Products {
	private String name;
    private int price;
    private String Manufacturer;
    private int Year;

    public Products(String name, int price, String manufacturer, int year) {
        this.name = name;
        this.price = price;
        Manufacturer = manufacturer;
        Year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
