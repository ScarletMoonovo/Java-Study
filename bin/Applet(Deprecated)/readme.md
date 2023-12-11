# Java Applet 基础
Applet是一种Java程序。它一般运行在支持Java的web浏览器内。因为它有完整的Java API支持，所以Applet是一个全功能的Java应用程序
如下所示是独立的Java应用程序和applet程序之间重要的不同：
- Java中Applet类继承来java.applet.Applet类
- Applet类没有定义main()，所以一个Applet程序不会调用main()方法
- Applet被设计为嵌入在一个HTML页面
- 当用户浏览包含Applet的HTML页面，Applet的代码就被下载到用户的机器上
- 要查看一个Applet需要JVM。JVM可以是web浏览器的一个插件，或者一个独立的运行时环境
- 用户机器上的JVM创建一个Applet类的实例，并调用Applet生命周期过程中的各种方法
- Applet有web浏览器强制执行的严格的安全规则，Applet的安全机制被称为沙箱安全
- Applet需要的其他类可以用Java归档(JAR)文件的形式下载下来

# Applet的生命周期
Applet类中的四个方法为我们提供类一个框架，你可以在该框架上开发小程序：
- init：该方法的目的是为你的Applet提供所需的任何初始化。在Applet标记内的param标签被处理后调用该方法
- start：浏览器调用init方法后，该方法被自动调用。每当用户充其他页面返回到包含Applet的页面时，则调用该方法
- stop：当用户从包含Applet的页面移除的时候，该方法自动被调用。因此，可以在相同的Applet中反复调用该方法
- destroy：此方法仅当浏览器正常关闭时调用。因为Applet只有在HTML网页上有效，所以你不应该在用户离开包含Applet的页面后遗漏任何资源
- paint：该方法在start()方法之后立即被调用，或者在Applet需要重绘在浏览器时用。paint()方法实际上继承于java.awt