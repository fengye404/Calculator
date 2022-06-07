package test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigInteger;

/**
 * @author: 風楪fy
 * @create: 2022/6/7 20:04
 **/
public class Test {
    public static void main(String[] args) {
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine se = manager.getEngineByName("js");
//        Double result = null;
//        String exp = "(1+1)*2/3";
//        try {
//            result = Double.valueOf(se.eval(exp).toString());
//            System.out.println(result);
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        }

        Float f=0.15490197f;
        System.out.println(Integer.toHexString(Float.floatToIntBits(f)));
    }
}
