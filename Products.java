import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Products {
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	private String Name;
    private int Price;
    private String Manufacturer;
    private int Year;
    public static int Id=1;//Designed for testing
    
    public Products() {
    	connectionDB();
    }//If I create new product, information give from DB
    
    public Products(String name, int price, String manufacturer, int year) {
        this.Name = name;
        this.Price = price;
        Manufacturer = manufacturer;
        Year = year;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.Manufacturer = manufacturer;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    public void infoProducts() {
    	System.out.println("Імя товару: "+getName()+" Ціна: "+getPrice()+" Фірма: "+getManufacturer()+" Рік: "+getYear()+" Створили обєкт № "+(getId()-1));
    }
    
    public void connectionDB () {
    	connection = null;
		statement = null;
		resultset = null;
    	String url = "jdbc:mysql://localhost:3306/hardwarestore?characterEncoding=utf8&serverTimezone=UTC";
		String user = "root";
		String password = "512891";
		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			String query = "SELECT * FROM hardwarestore.products where id='"+getId()+"';";
			
			resultset = statement.executeQuery(query);
			setFromDb(resultset);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(statement !=null) {
				try {
				statement.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			}
			if(connection !=null) {
				try {
				connection.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(resultset !=null) {
				try {
				resultset.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Вибрали з бд дані про товар");
    	
    }//Method connected from DB and select from table information by id
    
    public void setFromDb(ResultSet resultset) throws SQLException {
		while (resultset.next()) {
			this.Name = resultset.getString("name");
			this.Price = resultset.getInt("price");
			this.Manufacturer = resultset.getString("manufacturer");
			this.Year = resultset.getInt("year");
			this.Id++;
		}
	}//Write information from DB in object 
    
    public double GetDiscountPrice (Users user) {
    	if (user.getSpend() < 3000){
            return Price;
        }
        if (user.getSpend() < 10000){
            return Price*0.9;
        }
        return Price*0.8;
    }//If person spend a certain amount of accrued discount
}
