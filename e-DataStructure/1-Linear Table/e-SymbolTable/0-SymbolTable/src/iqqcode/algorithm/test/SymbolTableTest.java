package iqqcode.algorithm.test;

import iqqcode.algorithm.array.SymbolTableArray;
import iqqcode.algorithm.link.SymbolTable;
import org.junit.Test;

/**
 * @Author: Mr.Q
 * @Date: 2020-05-14 10:09
 * @Description:符号表测试
 */
public class SymbolTableTest {
    @Test
    public void test() {
        SymbolTable<Integer,String> symbol = new SymbolTable<>();

        // 测试put
        symbol.put(1 , "Java");
        symbol.put(2 , "Python");
        symbol.put(3 , "C++");
        symbol.put(4 , "GoLang");
        System.out.println("插入完毕后，元素个数为： " + symbol.size());

        symbol.put(1 , "JavaScript");

        //测试get
        System.out.println(symbol.get(1));

        //测试删除
        symbol.delete(1);
        System.out.println(symbol.get(1));
        System.out.println("删除后，元素个数为： " + symbol.size());
    }

    @Test
    public void testArray() {
        SymbolTableArray<Integer,String> symbol = new SymbolTableArray<>(10);

        // 测试put
        symbol.put(1 , "Java");
        symbol.put(2 , "Python");
        symbol.put(3 , "C++");
        symbol.put(4 , "GoLang");
        System.out.println("插入完毕后，元素个数为： " + symbol.size());

        symbol.put(1 , "JavaScript");

        //测试get
        System.out.println(symbol.get(1));

        //测试删除
        symbol.delete(1);
        System.out.println(symbol.get(1));
        System.out.println("删除后，元素个数为： " + symbol.size());
    }
}
