import java.sql.ResultSet;
import java.sql.SQLException;

public class Phone extends Products {
    private int ScreenDiagonal;
    private int Ram;//���������� ������
    private int InternalMemory;//�������� ������
    
    public Phone() {
    	
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
			this.Ram = resultset.getInt("ram");
			this.InternalMemory = resultset.getInt("internalmemory");
			
    	}
    	
    }
    @Override
    public void infoProducts() {
    	System.out.println("��� ������: "+getName()+" ֳ��: "+getPrice()+
    			" Գ���: "+getManufacturer()+" г�: "+getYear()+
    			" ĳ������� ������: "+getScreenDiagonal()+
    			" ���������� ������: "+getRam()+" �������� ������: "+
    			getInternalMemory()+" �������� ���� � "+(getId()-1));  
    }

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