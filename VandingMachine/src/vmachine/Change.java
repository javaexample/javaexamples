package vmachine;
/**
 * 거스름돈(동전)을 나타내는 클래스입니다.
 * 
 * changes[0] 은  10 원짜리의 개수
 * changes[1] 은  50 원짜리의 개수
 * changes[2] 은 100 원짜리의 개수
 * changes[3] 은 500 원짜리의 개수
 * 
 * 0, 1, 2, 3, 과 같은 숫자를 C10, C50, C100, C500 으로 접근하기 위해서
 * 상수로 만들었습니다.
 * 
 * 거스름돈은 setChange(int, int); 메소드로 설정합니다.
 * 
 * 예를 들어서 거스름돈이 다음과 같이 구성된다면
 *  
 *   10원짜리 4개
 *   50원짜리 1개
 *   500원짜리 1개
 *   
 * 아래와 같이 호출을 해줍니다.
 * 
 * change.setChange(Change.C10, 4); // 10원짜리 4개
 * change.setChange(Change.C50, 1); // 50원짜리 1개
 * change.setChange(Change.C500, 1);// 500원짜리 1개
 * 
 * 1. getChangeAmount()
 * 
 * 그리고 getChangeAmount() 를 호출하면 거스름돈의 전체 금액을 반환합니다.
 * 위처럼 3개의 메소드를 호출했으면 전체 거스름돈 금액은 590원이 나와야합니다.
 * 
 * 2. getCoinCount()
 * 
 * getCointCount() 메소드는 거스름돈을 구성하는 동전의 개수를 반환합니다.
 * 위의 예제에서는 10원짜리 4개, 50원짜리 1개 500원짜리 1개를 거스름돈으로
 * 구성했기 때문에 getCoinCount() 메소드는 6을 반환해야 합니다.
 * 
 * 3. getCointCount(int)
 * 
 * 이 메소드는 getCoinCount 메소드와 이름은 같지만 파라미터로 int 타입의 값을
 * 하나 받습니다. 주어진 int 값은 다음의 4가지 값 중 하나여야 합니다.
 * 
 *     Change.C10
 *     Change.C50
 *     Change.C100
 *     Change.C500
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
	
	public void setChange(int coinType , int counter) {
		changes[coinType] = counter ;
	}
	
	/**
	 * 현재 거스름돈을 구성하는 동전들의 전체 금액을 계산해서 반환해줍니다.
	 * @return 전체 거스름돈 금액
	 */
	public int getChangeAmount() {
		int totalAmount = 0; // 전체 거스름돈을 보관하는 변수
		
		/*
		 * Quiz-1 전체 거스름돈을 반환하는 코드를 완성해야함. 
		 */
		return totalAmount ;
	}
	
	/**
	 * 거스름돈을 구성하는 동전의 전체 개수를 반환합니다.
	 * 
	 * @return
	 */
	public int getCoinCount() {
		int coinCount = 0;
		
		/*
		 * Quiz-2 전체 동전의 개수를 반환하는 메소드 완성해야함.
		 */
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
