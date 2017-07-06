package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public  class proxyUtil {
	/**
	 * 创建代理对象
	 * @param cut 折扣
	 * @param interfaceClass 
	 * @param implClass 传入需要实例化的对象在invoke方法调用时产生对象 并调用相应方法的invoke
	 * @throws Exception
	 */
	public static Object getProxyInstance(final float cut, final Class<?> interfaceClass,
			final Class<?> implClass)throws Exception {
		return Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class[] { interfaceClass }, new InvocationHandler() {
			/**
			 * 当调用方法时会调用重写的InvocationHandler中的invoke方法，然后可以对方法进行判断拦截。
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {		
				System.out.println("调用的方法为:" + method.getClass().getName());
				System.out.println("调用的方法路径为:" + method);
				System.out.println("调用的方法名为:" + method.getName());
				if(method.getName().equals("commodityPrice")){
				System.out.println("拦截价格查询方法" );
				Float prince = (Float) method.invoke(implClass.newInstance(), args);
				return prince*cut;
				}
				else{
					/*可以根据method名 判断是否需要在方法执行前后进行操作  若不需要这直接调用方法的invoke*/
					System.out.println("不拦截方法:" + method.getName());
					return method.invoke(implClass.newInstance(), args);
				}
			}
		});

	}
}
