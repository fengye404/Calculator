package utils;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.http.HttpResponse;

/**
 * @author: 風楪fy
 * @create: 2022/6/7 20:17
 **/
public class ComponentUtil {
    public static JButton addButton(String text, ActionListener listener, JFrame jFrame) {
        JButton jButton = new JButton(text);
        if (listener != null) {
            jButton.addActionListener(listener);
        }
        jFrame.add(jButton);
        return jButton;
    }

    public static JLabel addLabel(String text, JFrame jFrame) {
        JLabel jLabel = new JLabel(text);
        jFrame.add(jLabel);
        return jLabel;
    }

    public static JTextField addTextFiled(String text, JFrame jFrame) {
        JTextField jTextField = new JTextField(text);
        jFrame.add(jTextField);
        return jTextField;
    }

    public static JTextArea addTextArea(String text, JFrame jFrame) {
        JTextArea jTextArea = new JTextArea(text);
        jFrame.add(jTextArea);
        return jTextArea;
    }
}
