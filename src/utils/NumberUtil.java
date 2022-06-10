package utils;

/**
 * @author: 風楪fy
 * @create: 2022/6/8 15:02
 **/
public class NumberUtil {

    /**
     * 有符号二进制转十进制
     *
     * @param binaryStr
     * @param includeSymbol
     * @return
     */
    public static Integer binaryToDec(String binaryStr, boolean includeSymbol) {
        Integer result;
        //有符号且符号为1，负数时特殊处理
        if (includeSymbol && binaryStr.charAt(0) == '1') {
            result = -Integer.parseInt(binaryStr.substring(1), 2);
        } else {
            result = Integer.parseInt(binaryStr, 2);
        }
        return result;
    }

    /**
     * 获取10进制数的反码
     *
     * @param i
     * @return
     */
    public static Integer getDecInverse(Integer i) {
        if (i >= 0) {
            return i;
        } else {
            String binaryString = getBinaryString(i);
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            for (int j = 1; j < binaryString.length(); j++) {
                sb.append(binaryString.charAt(j) == '0' ? '1' : '0');
            }
            return binaryToDec(sb.toString(), true);
        }
    }
    /**
     * 获取10进制数的补码     *
     * @param i
     * @return
     */
    public static Integer getDecComplement(Integer i) {
        if (i >= 0) {
            return i;
        } else {
            String binaryString = getBinaryString(i);
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            for (int j = 1; j < binaryString.length(); j++) {
                sb.append(binaryString.charAt(j) == '0' ? '1' : '0');
            }
            for (int j = sb.length()-1; j >=0; j--) {
                if(sb.charAt(j)=='0'){
                    sb.setCharAt(j,'1');
                    break;
                }else if(sb.charAt(j)=='1'){
                    sb.setCharAt(j,'0');
                }
            }
            return binaryToDec(sb.toString(), true);
        }
    }

    /**
     * 获取10进制数的二进制字符串（补前导0）
     *
     * @param i
     * @return
     */
    public static String getBinaryString(Integer i) {
        String s = Integer.toBinaryString(-1*i);
        StringBuilder sb = new StringBuilder();
        for (int j = s.length(); j < 32; j++) {
            sb.append(0);
        }
        return sb.append(s).toString();
    }

}
