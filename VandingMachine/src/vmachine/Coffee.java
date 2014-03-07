package vmachine;

/**
 * 자판기에 등록된 커피 제품을 나타내는 클래스 
 *
 */
public class Coffee {

	/**
	 * 특정 상품을 나타내는 id값
	 */
	private String id ;
	
	/**
	 * 상품명
	 */
	private String name;
	
	/**
	 * 가격
	 */
	private int price;
	
	public Coffee(String id, String coffeeName, int coffeePrice) {
		this.id = id;
		name = coffeeName;
		price = coffeePrice;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getID() {
		return this.id;
	}
	
	
	
	
}
