Java 8 API 添加了一个新的抽象称为流 Stream ，可以让你以一种声明的方式处理数据
Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象
Stream API 可以极大提高 Java 程序员的生产力，让程序员写出高效率、干净、简洁的代码
这种风格将要处理的元素集合看作一种流，流在管道中传输，并且可以在管道的节点上进行处理，比如筛选，排序，聚合等
元素流在管道中经过中间操作 (intermediate operation) 的处理，最后由最终操作 (terminal operation) 得到前面处理的结果
+--------------------+       +------+   +------+   +---+   +-------+
| stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
+--------------------+       +------+   +------+   +---+   +-------+
以上的流程转换为 Java 代码为：
```
List<Integer> transactionsIds = 
widgets.stream()
             .filter(b -> b.getColor() == RED)
             .sorted((x,y) -> x.getWeight() - y.getWeight())
             .mapToInt(Widget::getWeight)
             .sum();
```

# 什么是 Stream ？
Stream (流) 是一个来自数据源的元素队列并支持聚合操作
- 元素是特定类型的对象，形成一个队列。 Java 中的 Stream 并不会存储元素，而是按需计算
- 数据源：流的来源。可以是集合，数组，I/O channel，产生器 generator 等
- 聚合操作：类似 SQL 语句一样的操作，比如 filter, map, reduce, find, match, sorted 等。和以前的 Collection 操作不同， Stream 操作还有两个基础的特征：
  - Pipelining：中间操作都会返回流对象本身。这样多个操作可以串联成一个管道，如同流式风格 (fluent style) 。这样做可以对操作进行优化，比如延迟执行 (laziness) 和短路 (short-circuiting)。
  - 内部迭代：以前对集合遍历都是通过 Iterator 或者 For-Each 的方式，显式的在集合外部进行迭代，这叫做外部迭代。 Stream 提供了内部迭代的方式，通过访问者模式 (Visitor) 实现。

# 生成流
在 Java 8 中，集合接口有两个方法来生成流：
- stream() - 为集合创建串行流
- parallelStream() - 为集合创建并行流
``` 
List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
```