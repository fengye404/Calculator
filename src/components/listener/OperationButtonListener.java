package components.listener;

import components.CalDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: 風楪fy
 * @create: 2022/6/7 20:21
 * 表达式按钮
 **/
public class OperationButtonListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        StringBuilder stringBuilder = CalDisplay.stringBuilderThreadLocal.get();
        stringBuilder.append(buttonText);
    }
}
