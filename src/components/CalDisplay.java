package components;

import components.listener.OperationButtonListener;
import utils.ComponentUtil;

import javax.script.ScriptEngineManager;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author: 風楪fy
 * @create: 2022/6/7 13:35
 **/
public class CalDisplay extends JFrame {
    /**
     * 用于存放表达式的 StringBuilder
     */
    public static ThreadLocal<StringBuilder> stringBuilderThreadLocal = new ThreadLocal<>();

    //数字键0-9以及十六进制下的A,B,C,D,E,F
    List<JButton> numBtn = new ArrayList<>();
    JButton btn0 = ComponentUtil.addButton("0", new OperationButtonListener(), this);
    JButton btn1 = ComponentUtil.addButton("1", new OperationButtonListener(), this);
    JButton btn2 = ComponentUtil.addButton("2", new OperationButtonListener(), this);
    JButton btn3 = ComponentUtil.addButton("3", new OperationButtonListener(), this);
    JButton btn4 = ComponentUtil.addButton("4", new OperationButtonListener(), this);
    JButton btn5 = ComponentUtil.addButton("5", new OperationButtonListener(), this);
    JButton btn6 = ComponentUtil.addButton("6", new OperationButtonListener(), this);
    JButton btn7 = ComponentUtil.addButton("7", new OperationButtonListener(), this);
    JButton btn8 = ComponentUtil.addButton("8", new OperationButtonListener(), this);
    JButton btn9 = ComponentUtil.addButton("9", new OperationButtonListener(), this);
    JButton btnA = ComponentUtil.addButton("A", new OperationButtonListener(), this);
    JButton btnB = ComponentUtil.addButton("B", new OperationButtonListener(), this);
    JButton btnC = ComponentUtil.addButton("C", new OperationButtonListener(), this);
    JButton btnD = ComponentUtil.addButton("D", new OperationButtonListener(), this);
    JButton btnE = ComponentUtil.addButton("E", new OperationButtonListener(), this);
    JButton btnF = ComponentUtil.addButton("F", new OperationButtonListener(), this);

    //普通的四则运算按键+ - * /
    JButton btnAdd = ComponentUtil.addButton("+", new OperationButtonListener(), this);       //加法
    JButton btnSub = ComponentUtil.addButton("-", new OperationButtonListener(), this);       //减法
    JButton btnMul = ComponentUtil.addButton("*", new OperationButtonListener(), this);        //乘法
    JButton btnDiv = ComponentUtil.addButton("/", new OperationButtonListener(), this);        //除法

    //左右括号，小数点
    JButton btnLeftPare = ComponentUtil.addButton("(", new OperationButtonListener(), this);     //左括号
    JButton btnRightPare = ComponentUtil.addButton(")", new OperationButtonListener(), this);    //右括号
    JButton btnPoint = ComponentUtil.addButton(".", new OperationButtonListener(), this);         //小数点

    //三种进制
    JButton btnDEC = ComponentUtil.addButton("DEC", null, this);       //十进制
    JButton btnHEX = ComponentUtil.addButton("HEX", null, this);       //十六进制
    JButton btnOCT = ComponentUtil.addButton("OCT", null, this);       //八进制

    //三种按位运算
    JButton btnOR = ComponentUtil.addButton("OR", null, this);         //位与运算
    JButton btnAND = ComponentUtil.addButton("AND", null, this);       //位或运算
    JButton btnXOR = ComponentUtil.addButton("XOR", null, this);       //位非运算

    //三种码制操作
    JButton btnInverse = ComponentUtil.addButton("1'sC", null, this);       //反码
    JButton btnComplement = ComponentUtil.addButton("2'sC", null, this);    //补码
    JButton btnShift = ComponentUtil.addButton("SHF", null, this);          //移码

    //CE键和C键
    JButton btnCE = ComponentUtil.addButton("CE", null, this);          //清除输入
    JButton btnClear = ComponentUtil.addButton("Clear", null, this);        //清除显示器内容

    //等号
    JButton btnEquals = ComponentUtil.addButton("=", null, this);        //等号

    //显示器
    JTextField result_disPlay = ComponentUtil.addTextFiled(null, this);    //显示结果

    //显示进制
    JLabel jLabel1 = ComponentUtil.addLabel("DEC", this);   //十进制
    JLabel jLabel2 = ComponentUtil.addLabel("HEX", this);   //十六进制
    JLabel jLabel3 = ComponentUtil.addLabel("OCT", this);   //八进制

    //数字键对应的二进制数
    JLabel jLabel4 = ComponentUtil.addLabel("0001", this);
    JLabel jLabel5 = ComponentUtil.addLabel("0010", this);
    JLabel jLabel6 = ComponentUtil.addLabel("0011", this);
    JLabel jLabel7 = ComponentUtil.addLabel("0100", this);
    JLabel jLabel8 = ComponentUtil.addLabel("0101", this);
    JLabel jLabel9 = ComponentUtil.addLabel("0110", this);
    JLabel jLabel10 = ComponentUtil.addLabel("0111", this);
    JLabel jLabel11 = ComponentUtil.addLabel("1000", this);
    JLabel jLabel12 = ComponentUtil.addLabel("1001", this);
    JLabel jLabel13 = ComponentUtil.addLabel("1010", this);
    JLabel jLabel14 = ComponentUtil.addLabel("1011", this);
    JLabel jLabel15 = ComponentUtil.addLabel("1100", this);
    JLabel jLabel16 = ComponentUtil.addLabel("1101", this);
    JLabel jLabel17 = ComponentUtil.addLabel("1110", this);
    JLabel jLabel18 = ComponentUtil.addLabel("1111", this);

    //美化标签
    JLabel Design = ComponentUtil.addLabel("Design by 109", this);

    public CalDisplay() throws HeadlessException, IOException, FontFormatException {
        //设置面板大小
        setBounds(100, 100, 520, 900);
        setResizable(false);
        setVisible(true);
        //设置布局方式
        setLayout(null);    //自定义布局

        //设置组件的位置和大小
        //显示器
        result_disPlay.setBounds(20, 20, 460, 150);
        result_disPlay.setFont(new Font("Microsoft YaHei UI Bold", Font.BOLD, 40));
        result_disPlay.setHorizontalAlignment(JTextField.RIGHT);

        //装饰
        Design.setFont(new Font("Century Schoolbook", Font.ITALIC + Font.BOLD, 20));
        Design.setBounds(80, 220, 200, 50);
        //第二行
        btnDEC.setBounds(20, 380 - 100, 84, 40);
        btnHEX.setBounds(114, 380 - 100, 84, 40);
        btnOCT.setBounds(208, 380 - 100, 84, 40);
        btnLeftPare.setBounds(302, 380 - 100, 84, 40);
        btnRightPare.setBounds(396, 380 - 100, 84, 40);
        //第三行
        btnShift.setBounds(20, 460 - 100, 84, 40);
        btnD.setBounds(114, 460 - 100, 84, 40);
        btnE.setBounds(208, 460 - 100, 84, 40);
        btnF.setBounds(302, 460 - 100, 84, 40);
        btnClear.setBounds(396, 460 - 100, 84, 40);
        //第四行
        btnInverse.setBounds(20, 540 - 100, 84, 40);
        btnA.setBounds(114, 540 - 100, 84, 40);
        btnB.setBounds(208, 540 - 100, 84, 40);
        btnC.setBounds(302, 540 - 100, 84, 40);
        btnDiv.setBounds(396, 540 - 100, 84, 40);
        //第五行
        btnOR.setBounds(20, 620 - 100, 84, 40);
        btn7.setBounds(114, 620 - 100, 84, 40);
        btn8.setBounds(208, 620 - 100, 84, 40);
        btn9.setBounds(302, 620 - 100, 84, 40);
        btnMul.setBounds(396, 620 - 100, 84, 40);
        //第六行
        btnAND.setBounds(20, 700 - 100, 84, 40);
        btn4.setBounds(114, 700 - 100, 84, 40);
        btn5.setBounds(208, 700 - 100, 84, 40);
        btn6.setBounds(302, 700 - 100, 84, 40);
        btnSub.setBounds(396, 700 - 100, 84, 40);
        //第七行
        btnXOR.setBounds(20, 780 - 100, 84, 40);
        btn1.setBounds(114, 780 - 100, 84, 40);
        btn2.setBounds(208, 780 - 100, 84, 40);
        btn3.setBounds(302, 780 - 100, 84, 40);
        btnAdd.setBounds(396, 780 - 100, 84, 40);
        //第八行
        btnCE.setBounds(20, 860 - 100, 84, 40);
        btn0.setBounds(114, 860 - 100, 84, 40);
        btnPoint.setBounds(208, 860 - 100, 84, 40);
        btnComplement.setBounds(302, 860 - 100, 84, 40);
        btnEquals.setBounds(396, 860 - 100, 84, 40);
        //显示进制
        jLabel1.setBounds(200, 175, 40, 20);
        jLabel2.setBounds(260, 175, 40, 20);
        jLabel3.setBounds(320, 175, 40, 20);
        //数字键对应的二进制数
        jLabel4.setBounds(btn1.getX() + 28, btn1.getY() - 22, 40, 20);
        jLabel5.setBounds(btn2.getX() + 28, btn2.getY() - 22, 40, 20);
        jLabel6.setBounds(btn3.getX() + 28, btn3.getY() - 22, 40, 20);
        jLabel7.setBounds(btn4.getX() + 28, btn4.getY() - 22, 40, 20);
        jLabel8.setBounds(btn5.getX() + 28, btn5.getY() - 22, 40, 20);
        jLabel9.setBounds(btn6.getX() + 28, btn6.getY() - 22, 40, 20);
        jLabel10.setBounds(btn7.getX() + 28, btn7.getY() - 22, 40, 20);
        jLabel11.setBounds(btn8.getX() + 28, btn8.getY() - 22, 40, 20);
        jLabel12.setBounds(btn9.getX() + 28, btn9.getY() - 22, 40, 20);
        jLabel13.setBounds(btnA.getX() + 28, btnA.getY() - 22, 40, 20);
        jLabel14.setBounds(btnB.getX() + 28, btnB.getY() - 22, 40, 20);
        jLabel15.setBounds(btnC.getX() + 28, btnC.getY() - 22, 40, 20);
        jLabel16.setBounds(btnD.getX() + 28, btnD.getY() - 22, 40, 20);
        jLabel17.setBounds(btnE.getX() + 28, btnE.getY() - 22, 40, 20);
        jLabel18.setBounds(btnF.getX() + 28, btnF.getY() - 22, 40, 20);
    }
}