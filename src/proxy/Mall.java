package proxy;

public class Mall implements IMall{

	@Override
	public Float commodityPrice(String commodity) {
		Float Price=20.0f;
		System.out.println("��Ʒ"+commodity+"�۸�Ϊ:"+Price);
		return Price;

	}

	@Override
	public boolean sale() {
		System.out.println("������Ʒ");
		return false;
	}


}
