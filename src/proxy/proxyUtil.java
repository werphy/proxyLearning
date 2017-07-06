package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public  class proxyUtil {
	/**
	 * �����������
	 * @param cut �ۿ�
	 * @param interfaceClass 
	 * @param implClass ������Ҫʵ�����Ķ�����invoke��������ʱ�������� ��������Ӧ������invoke
	 * @throws Exception
	 */
	public static Object getProxyInstance(final float cut, final Class<?> interfaceClass,
			final Class<?> implClass)throws Exception {
		return Proxy.newProxyInstance(interfaceClass.getClassLoader(),new Class[] { interfaceClass }, new InvocationHandler() {
			/**
			 * �����÷���ʱ�������д��InvocationHandler�е�invoke������Ȼ����ԶԷ��������ж����ء�
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {		
				System.out.println("���õķ���Ϊ:" + method.getClass().getName());
				System.out.println("���õķ���·��Ϊ:" + method);
				System.out.println("���õķ�����Ϊ:" + method.getName());
				if(method.getName().equals("commodityPrice")){
				System.out.println("���ؼ۸��ѯ����" );
				Float prince = (Float) method.invoke(implClass.newInstance(), args);
				return prince*cut;
				}
				else{
					/*���Ը���method�� �ж��Ƿ���Ҫ�ڷ���ִ��ǰ����в���  ������Ҫ��ֱ�ӵ��÷�����invoke*/
					System.out.println("�����ط���:" + method.getName());
					return method.invoke(implClass.newInstance(), args);
				}
			}
		});

	}
}
