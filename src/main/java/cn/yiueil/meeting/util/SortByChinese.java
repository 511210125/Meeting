package cn.yiueil.meeting.util;
 
import java.util.*;
import java.text.*;
 
public class SortByChinese {
//测试
    public static void main(String[] args) {
 
        String[] a = { "阿里","张三", "李四", "刘翔", "刘六","郭晶晶","姚明"};
        getSortOfChinese(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
 
    }
/**
 * 
 * @param a String[]
 * @return String[]
 */
    public static String[] getSortOfChinese(String[] a) {
        // Collator 类是用来执行区分语言环境这里使用CHINA
        Comparator<Object> cmp = Collator.getInstance(java.util.Locale.CHINA);
 
        // JDKz自带对数组进行排序。
        Arrays.sort(a, cmp);

        return a;
    }
}