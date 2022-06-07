package components;

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
    //数字键0-9以及十六进制下的A,B,C,D,E,F
    List<JButton> numBtn = new ArrayList<>();
    JButton btn0 = new JButton("0");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton btnA = new JButton("A");
    JButton btnB = new JButton("B");
    JButton btnC = new JButton("C");
    JButton btnD = new JButton("D");
    JButton btnE = new JButton("E");
    JButton btnF = new JButton("F");

    //普通的四则运算按键+ - * /
    JButton btnAdd = new JButton("＋");       //加法
    JButton btnSub = new JButton("－");       //减法
    JButton btnMul = new JButton("×");        //乘法
    JButton btnDiv = new JButton("÷");        //除法

    //三种进制
    JButton btnDEC = new JButton("DEC");       //十进制
    JButton btnHEX = new JButton("HEX");       //十六进制
    JButton btnOCT = new JButton("OCT");       //八进制

    //三种按位运算
    JButton btnOR = new JButton("OR");         //位与运算
    JButton btnAND = new JButton("AND");       //位或运算
    JButton btnXOR = new JButton("XOR");       //位非运算

    //三种码制操作
    JButton btnInverse = new JButton("1'sC");       //反码
    JButton btnComplement = new JButton("2'sC");    //补码
    JButton btnShift = new JButton("SHF");          //移码

    //CE键和C键
    JButton btnCE = new JButton("CE");          //清除输入
    JButton btnClear = new JButton("C");        //清除显示器内容

    //开关计算器
    JButton btnOFF = new JButton("OFF");       //开机
    JButton btnON = new JButton("ON/C");       //关机

    //左右括号
    JButton btnLeftPare = new JButton("(");     //左括号
    JButton btnRightPare = new JButton(")");    //右括号

    //等号，小数点
    JButton btnEquals = new JButton("=");        //等号
    JButton btnPoint = new JButton(".");         //小数点

    //显示器
    JTextField result_disPlay = new JTextField();    //显示结果
    //字体
    Font font=new Font("Microsoft YaHei UI Bold",Font.BOLD,40);

    //显示进制
    JLabel jLabel1=new JLabel("DEC");   //十进制
    JLabel jLabel2=new JLabel("HEX");   //十六进制
    JLabel jLabel3=new JLabel("OCT");   //八进制

    //数字键对应的二进制数
    JLabel jLabel4=new JLabel("0001");
    JLabel jLabel5=new JLabel("0010");
    JLabel jLabel6=new JLabel("0011");
    JLabel jLabel7=new JLabel("0100");
    JLabel jLabel8=new JLabel("0101");
    JLabel jLabel9=new JLabel("0110");
    JLabel jLabel10=new JLabel("0111");
    JLabel jLabel11=new JLabel("1000");
    JLabel jLabel12=new JLabel("1001");
    JLabel jLabel13=new JLabel("1010");
    JLabel jLabel14=new JLabel("1011");
    JLabel jLabel15=new JLabel("1100");
    JLabel jLabel16=new JLabel("1101");
    JLabel jLabel17=new JLabel("1110");
    JLabel jLabel18=new JLabel("1111");


    //随便写个
    JButton btnMusic=new JButton("Music");

    //美化标签
    JLabel Design=new JLabel("Design by 109");

    public CalDisplay() throws HeadlessException,IOException,FontFormatException {
        //设置面板大小
        setBounds(100, 100, 520, 1000);
        setResizable(false);
        setVisible(true);
        //设置布局方式
        setLayout(null);    //自定义布局

        //将数字键0-9加入列表
        numBtn.add(btn0);
        numBtn.add(btn1);
        numBtn.add(btn2);
        numBtn.add(btn3);
        numBtn.add(btn4);
        numBtn.add(btn5);
        numBtn.add(btn6);
        numBtn.add(btn7);
        numBtn.add(btn8);
        numBtn.add(btn9);
        numBtn.add(btnA);
        numBtn.add(btnB);
        numBtn.add(btnC);
        numBtn.add(btnD);
        numBtn.add(btnE);
        numBtn.add(btnF);

        //设置组件的位置和大小
        //显示器
        result_disPlay.setBounds(20, 20, 460, 150);
        result_disPlay.setFont(font);
        result_disPlay.setHorizontalAlignment(JTextField.RIGHT);

        //装饰
        Design.setFont(new Font("Century Schoolbook",Font.ITALIC+Font.BOLD,20));
        Design.setBounds(80,220,200,50);
        //第一行
        btnOFF.setBounds(302, 300, 84, 40);
        btnON.setBounds(396, 300, 84, 40);
        //第二行
        btnDEC.setBounds(20, 380, 84, 40);
        btnHEX.setBounds(114, 380, 84, 40);
        btnOCT.setBounds(208, 380, 84, 40);
        btnLeftPare.setBounds(302, 380, 84, 40);
        btnRightPare.setBounds(396, 380, 84, 40);
        //第三行
        btnShift.setBounds(20, 460, 84, 40);
        btnD.setBounds(114, 460, 84, 40);
        btnE.setBounds(208, 460, 84, 40);
        btnF.setBounds(302, 460, 84, 40);
        btnMusic.setBounds(396,460,84,40);
        //第四行
        btnInverse.setBounds(20, 540, 84, 40);
        btnA.setBounds(114, 540, 84, 40);
        btnB.setBounds(208, 540, 84, 40);
        btnC.setBounds(302, 540, 84, 40);
        btnDiv.setBounds(396, 540, 84, 40);
        //第五行
        btnOR.setBounds(20, 620, 84, 40);
        btn7.setBounds(114, 620, 84, 40);
        btn8.setBounds(208, 620, 84, 40);
        btn9.setBounds(302, 620, 84, 40);
        btnMul.setBounds(396, 620, 84, 40);
        //第六行
        btnAND.setBounds(20, 700, 84, 40);
        btn4.setBounds(114, 700, 84, 40);
        btn5.setBounds(208, 700, 84, 40);
        btn6.setBounds(302, 700, 84, 40);
        btnSub.setBounds(396, 700, 84, 40);
        //第七行
        btnXOR.setBounds(20, 780, 84, 40);
        btn1.setBounds(114, 780, 84, 40);
        btn2.setBounds(208, 780, 84, 40);
        btn3.setBounds(302, 780, 84, 40);
        btnAdd.setBounds(396, 780, 84, 40);
        //第八行
        btnCE.setBounds(20, 860, 84, 40);
        btn0.setBounds(114, 860, 84, 40);
        btnPoint.setBounds(208, 860, 84, 40);
        btnComplement.setBounds(302, 860, 84, 40);
        btnEquals.setBounds(396, 860, 84, 40);
        //显示进制
        jLabel1.setBounds(200,175,40,20);
        jLabel2.setBounds(260,175,40,20);
        jLabel3.setBounds(320,175,40,20);
        //数字键对应的二进制数
        jLabel4.setBounds(btn1.getX()+28,btn1.getY()-30,40,20);
        jLabel5.setBounds(btn2.getX()+28,btn2.getY()-30,40,20);
        jLabel6.setBounds(btn3.getX()+28,btn3.getY()-30,40,20);
        jLabel7.setBounds(btn4.getX()+28,btn4.getY()-30,40,20);
        jLabel8.setBounds(btn5.getX()+28,btn5.getY()-30,40,20);
        jLabel9.setBounds(btn6.getX()+28,btn6.getY()-30,40,20);
        jLabel10.setBounds(btn7.getX()+28,btn7.getY()-30,40,20);
        jLabel11.setBounds(btn8.getX()+28,btn8.getY()-30,40,20);
        jLabel12.setBounds(btn9.getX()+28,btn9.getY()-30,40,20);
        jLabel13.setBounds(btnA.getX()+28,btnA.getY()-30,40,20);
        jLabel14.setBounds(btnB.getX()+28,btnB.getY()-30,40,20);
        jLabel15.setBounds(btnC.getX()+28,btnC.getY()-30,40,20);
        jLabel16.setBounds(btnD.getX()+28,btnD.getY()-30,40,20);
        jLabel17.setBounds(btnE.getX()+28,btnE.getY()-30,40,20);
        jLabel18.setBounds(btnF.getX()+28,btnF.getY()-30,40,20);
        Container container = new Container();
        add(result_disPlay);
        add(btnDEC);
        add(btnHEX);
        add(btnOCT);
        add(btnOFF);
        add(btnON);
        add(btnLeftPare);
        add(btnRightPare);
        add(btnShift);
        add(btnD);
        add(btnE);
        add(btnF);
        //加一个装饰
        add(btnMusic);
        add(btnInverse);
        add(btnA);
        add(btnB);
        add(btnC);
        add(btnDiv);
        add(btnOR);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btnMul);
        add(btnAND);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btnSub);
        add(btnXOR);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btnAdd);
        add(btnCE);
        add(btn0);
        add(btnPoint);
        add(btnComplement);
        add(btnEquals);
        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(jLabel4);
        add(jLabel5);
        add(jLabel6);
        add(jLabel7);
        add(jLabel8);
        add(jLabel9);
        add(jLabel10);
        add(jLabel11);
        add(jLabel12);
        add(jLabel13);
        add(jLabel14);
        add(jLabel15);
        add(jLabel16);
        add(jLabel17);
        add(jLabel18);
        add(Design);
    }

    //有BUG先废弃
    public Font loadFont() throws IOException,FontFormatException {
        String fontFilename = "Technology-Bold.ttf";
        InputStream is=this.getClass().getResourceAsStream(fontFilename);
        Font actionJson=Font.createFont(Font.TRUETYPE_FONT,is);
        Font actionJsonBase=actionJson.deriveFont(Font.BOLD,40);
        return actionJsonBase;
    }
}