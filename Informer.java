
public class Informer {
	public void Buy (Users user, Products product) {
		double price = product.GetDiscountPrice(user);
		user.ReduceBalance(price);
		System.out.println(user.getName()+" Купив "+product.getName()+" За "+price+". Заказ відправлений на склад");
	}//Information what user buy include discount

}
