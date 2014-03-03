package vmachine;
/**
 * 이번에는 거스름돈 인스턴스를 초기화하는 메소드를 완성합니다.
 * 
 * initChange(int money) 메소드를 호출하면 changes 배열이 금액에 맞게 설정되어야 합니다.
 * 
 * money 가 980이면
 * 
 * 500원 1개, 100원 4개, 50원 1개 10원 4개
 * 
 * 로 changes 배열이 초기화되어야 합니다.
 * 
 * 
 * 
 * 
 * 
 *
 */
public class Change {
	final public static int C10  = 0;
	final public static int C50  = 1;
	final public static int C100 = 2;
	final public static int C500 = 3;
	
	private int [] changes = new int [4];
	
	public Change(int money) {
		initChange( money ) ;
	}
	
	/**
	 * 주어진 거스름돈을 구성하는 동전의 개수를 changes 배열에 반영하는 코드입니다.
	 * 
	 * @param money
	 */
	private void initChange(int money ) {
		// 아래의 작업을 하도록 이 메소드를 완성해야 합니다.
		// 500원짜리 개수 설정
		// 100원짜리 개수 설정
		//  50원짜리 개수 설정
		//  10원짜리 개수 설정
	}
	
	public void setChange(int coinType , int counter) {
		changes[coinType] = counter ;
	}
	
	/**
	 * 현재 거스름돈을 구성하는 동전들의 전체 금액을 계산해서 반환해줍니다.
	 * @return 전체 거스름돈 금액
	 */
	public int getChangeAmount() {
		int totalAmount = 0; // 전체 거스름돈을 보관하는 변수
		
		totalAmount += changes[C10]*10;
		totalAmount += changes[C50]*50;
		totalAmount += changes[C100]*100;
		totalAmount += changes[C500]*500;
		
		return totalAmount ;
	}
	
	/**
	 * 거스름돈을 구성하는 동전의 전체 개수를 반환합니다.
	 * 
	 * @return
	 */
	public int getCoinCount() {
		int coinCount = 0;
		
		for (int i = 0; i < changes.length; i++) {
			coinCount += changes[i];
		}
		
		return coinCount;
	}

	/**
	 * 주어진 타입의 동전 개수를 반환합니다.
	 * coinType은 아래의 4개이 값 중 하나여야 합니다.
	 * 
	 *    Change.C10 - 10원짜리를 의미
	 *    Change.C50 - 50원짜리를 의미
	 *    Change.C100 - 100원짜리를 의미
	 *    Change.C500 - 500원짜리를 의미
	 *    
	 * @param coinType
	 * @return 주어진 타입의 동전 개수
	 */
	public int getCoinCount(int coinType) {
		return changes[coinType];
	}
	
	
}
