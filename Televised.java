import java.sql.ResultSet;
import java.sql.SQLException;

public class Televised extends Products {
    private int ScreenDiagonal;

    public Televised() {
    	
    }
        
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
    
    @Override
    public void setFromDb(ResultSet resultset) throws SQLException {
    	while (resultset.next()) {
    		setName(resultset.getString("name"));
			
			setPrice(resultset.getInt("price"));
			setManufacturer(resultset.getString("manufacturer"));
			setYear(resultset.getInt("year"));
			setId(getId()+1);
			this.ScreenDiagonal = resultset.getInt("screendiagonal");
    	}
    	
    }
    
    @Override
    public void infoProducts() {
    	System.out.println("Імя товару: "+getName()+" Ціна: "+getPrice()+
    			" Фірма: "+getManufacturer()+" Рік: "+getYear()+
    			" Діагональ екрану: "+getScreenDiagonal()+
    			" Створили обєкт № "+(getId()-1));  
    }
}
