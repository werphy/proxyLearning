package proxy;

public class RunMallclass {
	
    public static void main(String[] args) throws Exception {
	IMall mall = (IMall) proxyUtil.getProxyInstance(0.8f, IMall.class, Mall.class);
	
	mall.commodityPrice("ţ�п�");
	System.out.println("----------------------------------------------------------------");
	mall.sale();
    }
}
