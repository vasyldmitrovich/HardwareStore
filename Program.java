import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
	

	public static void main(String[] args) {
		//			Test DB
		/*Program program = new Program(); 
		program.CreatingConnection();
		program.creatingDataBase();
		program.creatingTable();
		program.creatingProduct(addInTablePhone1);
		program.creatingProduct(addInTablePhone2);*/
		
		
		Users user = new Users("Volodya","Men",1,"test1@gmail.com","En",50000,0);
        Users user1 = new Users("Olya","Women",1,"test2@gmail.com","Ua",150000,150);
        Users user2 = new Users("Colin","Men",1,"test2@gmail.com","Ua",25000,50);
        
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
        
        Products [] products = new Products[6];
        products[0] = products1;
        products[1] = products2;
        products[2] = products3;
        products[3] = products4;
        products[4] = products5;
        products[5] = products6;
        
        Informer informer = new Informer();
        
        while (true) {
        	System.out.println("Добрий день: "+user.getName()+" Ваш баланс: "+user.getBalance()+
        			" Ви потратили: "+user.getSpend()+"\nЯкщо ви потратили до 3000 ви платите повну ціну. "+
        			"Якщо до 10000 то 90%, Якщо більше то 80%");
        	for (int i = 0; i < products.length;i++) {
        		System.out.println("Товар: "+i+" "+products[i].getName()+" За ціною: "+products[i].getPrice());
        	}
        	System.out.println("Виберіть товар і натисніть ентер ");
        	int productNumber = inputNumber();
        	if (productNumber >=0 && productNumber < products.length) { 
        		if (products[productNumber].getPrice() < user.getBalance()) {
        			informer.Buy(user, products[productNumber]);
        		}
        		else {
        			System.out.println("У вас не достатньо коштів");
        		}
        	}
        	else {
        		System.out.println("Такого товару не існує");
        	}
        	
        }
        
	}
	
	public void CreatingConnection() {
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
	}//Перевірка підключення з базою даних
	
	public void OpenConnection() {
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
	}//Підключення до бази даних в методі і при необхідності викликаю його
	
	public void creatingDataBase() {
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
	}//Метод для створення бази даних
	
	public void creatingTable() {
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
	}//Метод для створення таблиці
	
	public void creatingProduct(String add) {
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
	}//Метод для додавання в таблицю товарів
	
	public static int inputNumber(){
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        return result;
    }
	
}
