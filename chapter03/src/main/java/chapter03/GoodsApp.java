package chapter03;

/*
쇼핑몰에서 상품을 관리하기 위해 상품관리 프로그램을 만들려고 합니다.
프로그램을 만들기 전에 업무(비즈니스) 분석을 통해 상품 객체를 분석하고
다음과 같은 Goods 클래스를 정의 하였습니다. 

Goods 클래스를 정의하고 GoodsApp 클래스에서  Goods 클래스를 테스트 하세요.
[1] Goods 객체를 하나 생성하고 이 객체에 대한 레퍼런스 변수를 camera 로 합니다.
[2] 이 객체의 데이터인 각 각의 인스턴스 변수는 다음과 같은 값을 가지도록 합니다.
    상품이름 : "nikon", 가격: 400,000, 재고개수: 30, 팔린 개수: 50
[3] 값을 세팅 한 후,  객체의 데이터를 출력해 보세요.
*/

public class GoodsApp {
	public static void main(String[] args) {
		Goods camera = new Goods();
		camera.setName("nikon");
		camera.setPrice(400000);
		camera.setCountSold(50);
		camera.setCountStock(30);

		camera.showInfo();

		// Information Hiding (Data Protection)
		camera.setPrice(-400000);

		// Static Variance(Class Variance)
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		System.out.println(Goods.countOfGoods);
	}
}
