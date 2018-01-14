import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculateLogProxy {

    //要代理的接口
    private Calculate target;

    public CalculateLogProxy(Calculate target) {
        this.target = target;
    }

    public Calculate getLogProxy() {
        Calculate proxy;
        // 创建代理对象时使用的第一个参数：由哪个类记载器加载
        ClassLoader loader = target.getClass().getClassLoader();
        // 创建代理对象时使用的第二个参数：代理对象的类型，也就是代理对象有哪些方法
        Class[] interfaces = new Class[]{Calculate.class};
        // 第三个参数：调用代理对象的方法时，执行的代码：
        InvocationHandler h = new InvocationHandler() {
            /**
             * Object proxy 正在返回的代理对象
             * Method method 正在被调用的方法
             * args 调用方法时，传入的参数
             * */
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                String methodName = method.getName();
                // 写一句，模拟日志，
                System.out.println("准备执行" + methodName + "方法，参数为" + Arrays.asList(args));
                Object result=null;

                try {
                    // 在本行的位置写语句的话，相当于SpringAOP的前置通知
                    // 然后真正执行方法
                    result = method.invoke(target, args);
                    // 在本行的位置，相当于返回通知，可以访问到上一行方法的返回值
                } catch (Exception e) {
                    e.printStackTrace();
                    // 在本行的位置，相当于异常通知，可以访问到异常
                }
                // 在本行的位置，相当于后置通知，因为可能出现异常，所以无法访问返回值

                // 写一句，模拟日志
                System.out.println("执行完毕" + methodName + "方法，结果为" + result);
                return result;
            }
        };

        proxy =(Calculate) Proxy.newProxyInstance(loader,interfaces,h);
        return proxy;
    }
}
