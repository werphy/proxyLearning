package proxy;

public class Mall implements IMall{

	@Override
	public Float commodityPrice(String commodity) {
		Float Price=20.0f;
		System.out.println("商品"+commodity+"价格为:"+Price);
		return Price;

	}

	@Override
	public boolean sale() {
		System.out.println("出售商品");
		return false;
	}


}
