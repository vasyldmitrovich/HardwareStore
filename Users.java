
public class Users {
    private String Name;
    private String Gender;//Стать
    private int Pass;
    private String Mail;
    private int MemberID;
    private String Address;
    private double Balance;
    private double Spend;
    public static int Id = 0;
    //private String myOrders;This is things what I buy, that must be object

    public Users(String name, String gender, int pass, String mail, String address, double balance, double spend) {
        Name = name;
        Gender = gender;
        Pass = pass;
        Mail = mail;
        Id++;
        MemberID = Id;
        Address = address;
        Balance = balance;
        Spend = spend;
    }
    
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getPass() {
        return Pass;
    }

    public void setPass(int pass) {
        Pass = pass;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public int getMemberID() {
        return MemberID;
    }

    public void setMemberID(int memberID) {
        MemberID = memberID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public double getSpend() {
        return Spend;
    }

    public void setSpend(double spend) {
        Spend = spend;
    }
    
    public void infoUsers(){
        System.out.println("Name= "+Name+" Gender= "+Gender+" Pass= "+Pass+" Mail= "+Mail
                +" MemberID="+MemberID+" Address="+Address+" Balance= "+Balance+" Spend= "+Spend);
    }//Information about user
    
    public void ReduceBalance (double price) {
    	this.Balance -= price;
    	this.Spend += price;
    }//When buy product: Balance minus price and Spend plus 
}
