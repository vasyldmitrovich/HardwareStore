
public class Informer {
	public void Buy (Users user, Products product) {
		double price = product.GetDiscountPrice(user);
		user.ReduceBalance(price);
		System.out.println(user.getName()+" ����� "+product.getName()+" �� "+price+". ����� ����������� �� �����");
	}//Information what user buy include discount

}
