package vmachine;

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
