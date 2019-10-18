import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Program {
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	private String creatingDataBase = "CREATE DATABASE IF NOT EXISTS hardwarestore "
			+ "CHARACTER SET utf8 COLLATE utf8_general_ci";
	private String creatingTable = "CREATE TABLE IF NOT EXISTS `hardwarestore`.`products` ("
			+ " `id` INT NOT NULL AUTO_INCREMENT,"
			+ " `name` VARCHAR(45) NOT NULL,"
			+ " `price` VARCHAR(45) NOT NULL,"
			+ " `manufacturer` VARCHAR(45) NOT NULL,"
			+ " `year` VARCHAR(45) NOT NULL,"
			+ " `screendiagonal` VARCHAR(45) NULL,"
			+ " `ram` VARCHAR(45) NULL,"
			+ " `internalmemory` VARCHAR(45) NULL,"
			+ " PRIMARY KEY (`id`));";
	private static String addInTableTelevised1 = "INSERT INTO products "
			+ "(name,price,manufacturer,year,screendiagonal) "
			+ "VALUE ('S43',15300,'Samsung',2017,43);";
	private static String addInTableTelevised2 = "INSERT INTO products "
			+ "(name,price,manufacturer,year,screendiagonal) "
			+ "VALUE ('S32',12000,'Samsung',2012,32);";
	private static String addInTablePhone1 = "INSERT INTO products "
			+ "(name,price,manufacturer,year,screendiagonal,ram,internalmemory) "
			+ "VALUE ('s8',3300,'Apple',2017,6,4,64);";
	private static String addInTablePhone2 = "INSERT INTO products "
			+ "(name,price,manufacturer,year,screendiagonal,ram,internalmemory) "
			+ "VALUE ('s9',7600,'Apple',2019,8,8,128);";
	private static String query = "SELECT * FROM hardwarestore.products where id='1';";
	
        private int price;
        private String Manufacturer;
        private int Year;
	public static void main(String[] args) {
		Program program = new Program(); 
		program.CreatingConnection();
		program.creatingDataBase();
		program.creatingTable();
		//program.creatingProduct(addInTablePhone1);
		//program.creatingProduct(addInTablePhone2);
		
		Users users = new Users("Bob","Men",1,"test1@gmail.com","En",10000,100);
        Users users1 = new Users("Jane","Women",1,"test2@gmail.com","Ua",15000,150);
        Users users2 = new Users("Colin","Men",1,"test2@gmail.com","Ua",25000,50);
        /*Products products = new Televised("S43",15300,"Samsung",2017,43);
        Products products1 = new Televised("S32",12000,"Samsung",2012,32);
        Products products2 = new Phone("s8",3300,"Apple",2017,6,4,64);
        Products products3 = new Phone("s9",7600,"Apple",2019,8,8,128);
        users.infoUsers();
        users1.infoUsers();
        users2.infoUsers();*/
        Products products1 = new Televised();
        products1.infoProducts();
        Products products2 = new Televised();
        products2.infoProducts();
        Products products3 = new Phone();
        products3.infoProducts();
        Products products4 = new Phone();
        products4.infoProducts();
        Products products5 = new Phone();
        products5.infoProducts();
        Products products6 = new Phone();
        products6.infoProducts();
        
        
	}
	
	public void CreatingConnection() {//Перевірка підключення з базою даних
		String url = "jdbc:mysql://localhost:3306/boockstore?characterEncoding=utf8&serverTimezone=UTC";
		String user = "root";
		String password = "512891";
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Ми підключились до бази");
			
			System.out.println("Ми відключаємось від бази");
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void OpenConnection() {//Підключення до бази даних в методі і при необхідності викликаю його
		String url = "jdbc:mysql://localhost:3306/hardwarestore?characterEncoding=utf8&serverTimezone=UTC";
		String user = "root";
		String password = "512891";
		try {
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void creatingDataBase() {//Метод для створення бази даних
		connection = null;
		statement = null;
		try {
		OpenConnection();
		statement.executeUpdate(creatingDataBase);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(statement != null) {
				try {
					statement.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Створили базу даних");
	}
	public void creatingTable() {//Метод для створення таблиці
		connection = null;
		statement = null;
		try {
			OpenConnection();
			statement.executeUpdate(creatingTable);
		}
		catch (SQLException e) {
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
		}
		System.out.println("Створили таблицю");
	}
	public void creatingProduct(String add) {//Метод для додавання в таблицю товарів
		connection = null;
		statement = null;
		try {
			OpenConnection();
			statement.executeUpdate(add);
			connection.close();
		}
		catch (SQLException e) {
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
		}
		System.out.println("Записали в таблицю дані");
	}
	
	
}
