package Java8.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Tester1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n是一个参数传递到Predicate接口的test方法
        // n如果存在则test方法返回true

        System.out.println("输出所有数据：");

        // 传递参数n
        eval(list, n -> true);

        // Predicate<Integer> predicate1 = n -> n % 2 == 0
        // n是一个参数传递到Predicate接口的test方法
        // 如果n % 2为0则test方法返回true

        System.out.println("输出所有偶数：");
        eval(list, n -> n % 2 == 0);

        // Predicate<Integer> predicate2 = n -> n > 3
        // n是一个参数传递到Predicate接口的test方法
        // 如果n大于3则test方法返回true
        eval(list, n -> n > 3);

    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for (Integer n : list) {
            System.out.println(n + " ");
        }
    }
}
