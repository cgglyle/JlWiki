package pers.cgglyle.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author cgglyle
 * @date 2022-01-07 17:06
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    public static String underline(String str){
        // 匹配单个字符
        String regExp="([A-Z]{1})";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            // 把大写的 改成 _小写的内容。匹配大写后改成小写的，前面加一个下划线
            matcher.appendReplacement(sb, "_"+matcher.group().toLowerCase());
        }
        matcher.appendTail(sb);
        System.out.println("changeUpperLetter: "+sb.toString());
        return sb.toString();
    }
}
