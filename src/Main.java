import java.util.*;

public class Main {

    /* // 列表（Lists）
    List<String> arrayList = new ArrayList<>(); // 动态数组，可变大小；高效得随机访问和快速尾部插入；中间插入和删除相对较慢
    List<Integer> linkedList = new LinkedList<>(); // 双向链表，元素之间通过指针连接；插入和删除元素高效，迭代器性能好；随机访问相对较慢

    // 集合（sets）
    Set<String> hashSet = new HashSet<>();
    Set<Integer> treeSet = new TreeSet<>();
    // HashSet，无序集合，基于HashMap实现；高效地查找和插入操作；但不保证顺序

    // 映射（Maps）
    Map<String, Integer> hashMap = new HashMap<>();
    Map<String, Integer> treeMap = new TreeMap<>();
    // HashMap，基于哈希表实现的键值对存储结构；高效的查找、插入和删除操作；无序，不保证顺序
    // TreeMap，基于红黑树实现的有序键值对存储结构；有序，支持按照键的顺序便利；但插入和删除相对较慢

    // 栈（Stack）
    Stack<Integer> stack = new Stack<>(); // 代表一个栈，通常按照后进先出（LIFO）的顺序操作元素

    // 队列（Queue）
    Queue<String> queue = new LinkedList<>(); // Queue接口：代表一个队列，通常按照先进先出（FIFO）的顺序操作元素；实现类：LinkedList，PriorityQueue，ArrayDeque

    // 堆（Heap）
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collection.reverseOrder()); */


    /* public static void main(String[] args) {
        ArrayList<String> sites = new ArrayList<>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");

        // 获取迭代器
        Iterator<String> it = sites.iterator();

        // 输出集合中的第一个元素
        System.out.println(it.next());

        // 输出集合中的所有元素
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        for (int i = 0; i < sites.size(); i++) {
            System.out.println(sites.get(i));
        }

        // java迭代器是单向遍历机制，不能往回遍历
    } */


    /* // 泛型方法
    public static <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建不同类型的数组：Integer, Double和Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', '0'};

        System.out.println("整形数组元素为：");
        printArray(intArray); // 传递一个整形数组

        System.out.println("\n双精度型数组元素为：");
        printArray(doubleArray); // 传递一个双精度型数组

        System.out.println("\n字符型数组元素为：");
        printArray(charArray); // 传递一个字符型数组
    } */

    /* ******************************************* */

    /* public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x; // 假设x是初始最大值
        if (y.compareTo(max) > 0) {
            max = y; // y更大
        }

        if (z.compareTo(max) > 0) {
            max = z; // 现在z更大
        }

        return max; // 返回最大对象
    }

    public static void main(String[] args) {
        System.out.printf("%d, %d 和 %d 中最大的数为 %d\n\n", 3, 4, 5, maximum(3, 4, 5));

        System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n", 6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

        System.out.printf("%s, %s 和 %s 中最大的数为 %s\n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));

    } */
    
    /* ******************************************* */


    /* // 泛型类
    public static class Box<T> {
        private T t;
        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(10);
        stringBox.add("cnjc");

        System.out.printf("整型值为：%d\n\n", integerBox.get());
        System.out.printf("字符串为：%s\n\n", stringBox.get());
    } */


    // 类型通配符
    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        ArrayList<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

        //getUperNumber(name); // 上界是Number，所以方法中的参数限定了参数泛型上限为Number，只接受Number及其子类
        getUperNumber(age);
        getUperNumber(number);
        
    }

    public static void getData(List<?> data) {
        System.out.println("data:" + data.get(0));
    }

    public static void getUperNumber(List<? extends Number> data) {
        System.out.println("data:" + data.get(0));
    }
}