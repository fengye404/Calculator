package test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigInteger;
import java.util.regex.Pattern;

/**
 * @author: 風楪fy
 * @create: 2022/6/7 20:04
 **/
public class Test {
    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(10));
//        System.out.println(Integer.toBinaryString(~10));
//        System.out.println(Integer.parseInt("2147483648"));
        if (Pattern.matches("[^0-9A-F0X]", "1")) {
            System.out.println(1);
        }
    }
}
