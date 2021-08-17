package basics;

public class comment {

    /**
     * 这是一个文档注释：
     * 注释内容可以被jdk提供的工具javadoc所解析，生成一套以网页
     * 文件形式体现的该程序的说明文档. 是Java特有的注解方式.
     * 操作方法：
     * javadoc -d dirname -author -version file.java
     */

    public void print(){
        System.out.println("This is a print");
    }
    // 这是一个单行注释:
    public static void main(String[] args) {
        /*
         * 这是一个多行注释, 注释有以下好处
         * 1. 对所写的程序进行解释说明, 增强可读性.
         * 2. 调试所写代码, 可以注释掉一部分代码, 然后再运行, 进行debug.
         * 注: 多行注释是不可以嵌套使用的.
         */
        System.out.println("Comment explanation");
    }
}
