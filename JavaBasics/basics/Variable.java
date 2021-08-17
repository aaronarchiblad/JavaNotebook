package basics;

public class Variable {
    public static void main(String[] args) {
        /*
        primitive类型char, byte, short, long, int, float, double 可以自动在运算的时候可以自动转换类型.
        两个不同的类型相加会转换成兼容性更大的. 如: double与int相加会自动转换成double, byte与int相加会自动转换成int.
        因为byte的容量是8个bit, 只能包括-128-128之间的整数(2^8). 而int是4*8个bit, 能覆盖-2147483648-2147483648
        之间的整数(2^32).
         */
        byte a1 = 127;
        int b1 = 2;
        int c1 = a1 + b1;
        System.out.println(c1);

        /*
        特殊情况:
        当char, byte, short做运算时, 最后的运算结果只能是int, 原因不明, 就当是一个默认的规则.
        注:
        1. char与其他做运算时, 是把char编程ASCII码后做运算.
        2. 即使是同类型相加, 如: short + short 最终也是要存成int型
         */

        char a2 = '1';
        int b2 = 2;
        System.out.println(a2+b2);

        byte a3 = 1;
        short b3 = 2;
//        short c1 = a3 + a4; // 编译失败, 因为运算后是int
        System.out.println(a3+b3);

        /*
        强制类型转换: 有时候我们需要把一个范围大的变量转换成一个范围小的变量上去, 有可能是需要控制内容的使用
        这时候我们就要用到强制类型转换.
         */

        double a4 = 1.1;
        int b4 = (int) a4;
        System.out.println(b4); // 强转有可能会造成精度损失.
        long c4 = 123;
        short d4 = (short) c4;
        System.out.println(d4); // 如果强转后的值仍在强转类型范围内就不会造成精度损失.
        int e4 = 128;
        byte f4 = (byte) e4;
        /*
        精度损失的一种情况就是内存溢出. 因为byte的范围是-128-127, 而我们把128强转成了byte型
        因此造成了内存溢出的情况.
         */
        System.out.println(f4);

        /*
        当你定义一个long型, 如果赋的值是在int范围之内, 那么后面没有L, java会把他自动转换
        成int型, 但是如果超过了int的范围, 则会报错
         */
        long a5 = 100;
        System.out.println(a5); // 编译运行都没问题
//        long b5 = 1000000000000000000; // 会报超过范围， 必须要在后面加L作为标识
        long c5 = 1000000000000000000L;
        System.out.println(c5);

        /*
        对于常量来讲, 整型默认是int型. 浮点常量, 默认类型为double型
         */
        byte a6 = 12;
//        byte b6 = a6 + 1; // 报错, 类型不匹配.
        System.out.println(a6);

        /*
        1. String不是一个primitive的数据类型. String是一个引用数据类型.
        2. 定义String的时候用双引号, 定义char是用单引号.
        3. 与char不同, String内可以包含0到N个ch字符. 而char有且只有一个字符.
        4. String可以与所有的primitive类型做运算, 包括Boolean. 用"+"号, 表示连接
        5. String不能转回primitive类型, 但是可以通过Integer去转
        注: 判断到底是加法还是拼接, 就看前后是不是有String参与. 有String参与输出都是String.
         */

        String a7 = "Number";
        int b7 = 1234;
        boolean c7 = true;
        char d7 = 'a';
        System.out.println(a7+b7+c7+d7);
        System.out.println(b7+d7+a7+c7); //因为'a'是97, 这里b7是一个int, 因此是1234+97=1331, 后面才是拼接.

        String e7 = "123";
//        int f7 = (int) e7; // 编译不通过, 不能把string强转成int.

    }
}
