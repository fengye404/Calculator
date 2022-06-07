import components.CalDisplay;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author: 風楪fy
 * @create: 2022/6/7 13:36
 **/
public class Main {
    public static void main(String[] args) {
        initGlobalFont(new Font("Microsoft YaHei UI Bold", 0, 15));  //统一设置字体
        try {
            CalDisplay.stringBuilderThreadLocal.set(new StringBuilder());
            CalDisplay display = new CalDisplay();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }
    }

    private static void initGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }
}
