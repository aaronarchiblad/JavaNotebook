package basics;

public class Operation {
    public static void main(String[] args) {
        /*
        i++ 和 ++i 的区别: i++ 是先进行运算(如: 赋值运算)再自增, 而 ++i是先进行自增再进行赋值运算
        */
        int a1 = 1;
        int b1 = a1 ++;
        System.out.println(a1); // 因为无论如何这里a1都会自增1, 因此a1结果是2
        System.out.println(b1); // 因为是先做赋值运算, 后做自增, 因此这里b1的结果是1;

        int c1 = 1;
        int d1 = ++c1;
        System.out.println(c1); // 因为无论如何这里c1都会自增1, 因此c1结果是2
        System.out.println(d1); // 因为是先自增, 后做赋值运算, 因此这里d1的结果是2;

        /*
        给一个变量自增1的方法有两种
        <1> int a2 = 1; a2 = a2 + 1;
        <2> int b2 = 1; b2++;
        但是这两种方法有不同, <2>不会改变赋值后的结果, 而<1>会先把a2转成int型然后再和后面int型的常量1相加
        注: 当你要自增的时候推荐<2>, 因为效率更高, 用<1>有时候需要强转, 系统先把变量转成正确的型, 再
            运算, 运算完了之后再强转回去. 而<2>不需要类型转换, 但是要注意取值范围.
         */

        byte a2 = 127;
        System.out.println(a2 + 1); // 系统会先把a2转化成int型, 然后和后面的int型常量1相加,
        a2 = (byte) (a2 + 1); // 如果这里没有强转, 编译会失败, 因为a2 + 1 是int型, 没有强转, 会把int赋值给byte变量
        System.out.println(a2);

        byte b2 = 127;
        b2++;
        System.out.println(b2); // 因为不改变byte类型, 因此内存溢出了.

        /*
        赋值运算:
         */

        // 方法1:
        int a3 = 1;
        int b3 = 1;

        // 方法2:
        int c3, d3;
        c3 = d3 = 1;

        // 方法3:
        int e3 = 1, f3 = 1;

        /*
        其他赋值运算 +=, -=, *=等
         */

        int g3 = 1;
        g3 += 1;
        System.out.println(g3);

        int h3 = 1;
        h3 -= 1;
        System.out.println(h3);

        /*
        <1> g3 += 1 与 <2> g3 = g3 + 1的区别是<1>本身不会改变数据类型
        注: 在+1的情况下, <1> 与 g3++ 是一样的效果, 但是g3++代码量更小, 因此更推荐.
         */
        short i3 = 10;
//        i3 = i3 + 1; // 编译不通过, 因为类型不匹配
        i3 += 1;
        System.out.println(i3);

        // 习题1:
        int i = 1;
        i *= 0.1;
        System.out.println(i); // 编译能过, 但是因为 *= 赋值不会改变类型, 因此还是整型. i = 0
        i++;
        System.out.println(i);

        // 习题2:
        int m = 2;
        int n = 3;
        n *= m++; // m++ m无论如何都要加1, 因此m为3, 因为是先做 *= 运算后++, 因此是n = 3 * 2 = 6
        System.out.println("m=" + m);
        System.out.println("n=" + n);

        //习题3:
        int x = 10;
        /*
        从左往右看, x++, 因此x在第一次赋值运算后已经是11, 因此第一次赋值运算时10 + 10 = 20
        第二次运算时先++, 因此x变成了11 + 1 = 12, 然后再赋值. 20 + 12 = 32
         */
        x += (x++) + (++x);
        System.out.println(x);

        int y = 10;
        /*
        这个写法的逻辑和上面是一样的, 除了部分细节.
        这里先做y + (y++) 运算. y一开始是10, 先加y, 结果是20, 后++, 结果y=11
        然后先++, y=11+1=12, 再相加20+12=32, 最后再赋值给y, 结果是32.
         */
        y = y + (y++) + (++y);
        System.out.println(y);

    }


}
