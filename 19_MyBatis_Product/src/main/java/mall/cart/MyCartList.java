package mall.cart;

import java.util.HashMap;
import java.util.Map;

public class MyCartList { // 장바구니(상품번호, 주문수량)
	private Map<Integer, Integer> orderlists = null;
	
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}
	
	public void addOrder(int pnum, int oqty) { // 상품번호, 주문수량
		if(!orderlists.containsKey(pnum)) { // 기존에 없으면 새로 넣기
			orderlists.put(pnum, oqty);
		} else { // 기존에 있으면 누적하기
			orderlists.put(pnum, orderlists.get(pnum)+oqty);
		}
		for ( int x : orderlists.keySet() ) {
		    System.out.println("pnum:"+x + "oqty:"+orderlists.get(x));
		}
	}
	
	public Map<Integer, Integer> getAllOrderList() {
		return orderlists;
	}
}

// 3가지 컬렉션: List, Set, Map => 중요하니 잘 구분해두기