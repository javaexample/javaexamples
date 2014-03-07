package vmachine;

/**
 * ���Ǳ⿡ ��ϵ� Ŀ�� ��ǰ�� ��Ÿ���� Ŭ���� 
 *
 */
public class Coffee {

	/**
	 * Ư�� ��ǰ�� ��Ÿ���� id��
	 */
	private String id ;
	
	/**
	 * ��ǰ��
	 */
	private String name;
	
	/**
	 * ����
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
