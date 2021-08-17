package basics;

public class LogicTest {
    public static void main(String[] args) {
        /*
        与 与 短路与 &&, &
        他们的运算结果是相同的, 但是当用短路与的时候, 第一个值是false, 那么后面的就不会执行,
        因为无论如何都是false, 但是用普通与是会执行的. 同理可得短路或 || 开发中推荐使用短路.
         */
        boolean a1 = true;
        int b1 = 10;
        if (a1 & (b1 ++ > 0)) {
            System.out.println("Hello");
        } else {
            System.out.println("Hi");
        }
        System.out.println(b1);

        boolean a2 = false;
        int b2 = 10;
        if (a2 && (b2 ++ > 0)) {
            System.out.println("Hello");
        } else {
            System.out.println("Hi");
        }
        System.out.println(b2);

        boolean a3 = true;
        int b3 = 10;
        if (a3 & (b3 ++ > 0)) {
            System.out.println("Hello");
        } else {
            System.out.println("Hi");
        }
        System.out.println(b3);

        boolean a4 = true;
        int b4 = 10;
        if (a4 && (b4 ++ > 0)) {
            System.out.println("Hello");
        } else {
            System.out.println("Hi");
        }
        System.out.println(b4);

        // 练习
        int x1 = 1;
        int y1 = 1;
        if (x1++ == 2 & ++y1 == 2) {
            x1 = 7;
        }
        System.out.println("x1=" + x1 + "y1=" + y1); // x1=2, y1=2

        int x2 = 1, y2=1;
        if (x2++ == 2 && ++y2 == 2) {
            x2 = 7;
        }
        System.out.println("x2=" + x2 + "y2=" + y2); // x=2, y2=1

        int x3 = 1, y3 = 1;
        if (x3++ == 1 | ++y3 == 1) {
            x3 = 7;
        }
        System.out.println("x3=" + x3 + "y3=" + y3); // x3 = 7, y3=2

        int x4 = 1, y4 = 1;
        if (x4++ == 1 || ++y4 == 1) {
            x4 = 7;
        }
        System.out.println("x4=" + x4 + "y4=" + y4); // x4 = 7, y4=1

        // 面试题
        boolean x5 = true, y5 = false;
        short z5 = 42;
        if ((z5++ == 42) && (y5 = true)) z5++; // 后++, 因此z5==42=>true, 且z5=43, 然后把true赋值给y再&&, =>true, z5=44
        if ((x5 = false) || (++z5==45)) z5++; // 把false赋值给x5=>false, || 需要看后面, 因此z5先++得45, 45==45=>ture z5++=46
        System.out.println(z5);

        boolean x6 = true, y6 = false;
        short z6 = 42;
        if ((z6++ == 42) && (y6 == true)) z6++; // 后++, z6==42=>true => z6=43, y6==true => false, 不执行后面的z6++
        if ((x6 = false) || (++z6==45)) z6++; // 把false赋值给x6, 执行||, z6++ = 44, 44==45 => false, 不执行后面的z6++
        System.out.println(z6);


    }
}
