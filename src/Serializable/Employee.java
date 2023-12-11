package Serializable;

public class Employee implements java.io.Serializable {
    public String name;
    public String address;
    public transient int SSN; // transient关键字表明不被序列化，在反序列化后，这些字段会被初始化为默认值
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
    // 注意，一个类的对象想要序列化成功，必须满足两个条件：
    // 该类必须实现java.io.Serializable接口；
    // 该类的所有属性必须是可序列化的，如果有一个属性是不可序列化的，则该属性必须注明是短暂的

    // 注意：当序列化一个对象到文件时，按照java的标准约定是给文件一个.ser扩展名。
    
}
