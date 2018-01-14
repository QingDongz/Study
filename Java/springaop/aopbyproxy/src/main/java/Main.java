public class Main {
    public static void main(String[] args) {

        Calculate target = new CalculateImpl();

        Calculate proxy = new CalculateLogProxy(target).getLogProxy();

        int result = proxy.add(1, 2);
        System.out.println("结果为"+result);

    }
}
