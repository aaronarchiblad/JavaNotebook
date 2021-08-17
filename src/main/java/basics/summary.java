package basics;

public class summary {
    /*
    总结第一个Java程序
    1. Java程序编写, 编译, 运行过程
    编写: 我们将编写的java代码保存在以".java"结尾的源文件中
    编译: 使用javac命令编译java源文件, 格式: javac file.java
    运行: 使用java命令解释运行我们的字节码文件. 格式: java file.class

     2. 在一个java源文件中可以声明多个class, 但是最多有一个类声明为public
     public是封装性的一个关键字. public只能加在和文件名同名的类上.

     3. 程序的入口是main方法. 格式是固定的

     4. 输出语句:
     System.out.println(): 输出后换行
     System.out.print(): 输出后不换行

     5. 每一行执行语句都以";"结束.

     6. 编译的过程: 编译以后会生成一个或者多个字节码文件. 字节码文件的文件名与java源文件
     的类名一样. 每一个类会被编译成一个.class文件, 即使他们是放在一个文件里.

     7. 正确的注释和注释风格:
     <a> 使用文档注释来注释整个类或者整个方法
     <b> 如果注释方法中的某一个步骤, 使用单行或者多行注释

     8. 正确的缩进和空白:
     <a> 使用一次tab操作进行缩进
     <b> 运算符两边习惯性各加一个空格. 比如: 2 + 4 * 6

     9. 块的风格: Java API源代码选择行尾风格, 也可以使用次行风格.

     */

    public static void main(String[] args) {
        System.out.println();
    }
}
