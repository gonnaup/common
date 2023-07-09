package org.gonnaup.common.util;

import java.util.Objects;

/**
 * 字符串工具类
 *
 * @author gonnaup
 * @version created at 2023/7/9 下午5:21
 */
public abstract class StringUtil {

    /**
     * 字符串不为null,且不是空串
     *
     * @param s
     * @return
     */
    public static boolean isNotBlank(String s) {
        return Objects.nonNull(s) && !s.isBlank();
    }

    /**
     * 字符串是null或空串
     *
     * @param s
     * @return
     */
    public static boolean isNullOrBlank(String s) {
        return Objects.isNull(s) || s.isBlank();
    }

    /**
     * 将字符串用指定字符从开头填充到指定长度
     *
     * @param string
     * @param minLength 填充长度
     * @param padChar   填充字符
     * @return
     */
    public static String padStart(String string, int minLength, char padChar) {
        Objects.requireNonNull(string);
        if (string.length() >= minLength) {
            return string;
        } else {
            StringBuilder sb = new StringBuilder(minLength);
            sb.append(String.valueOf(padChar).repeat(minLength - string.length()));
            sb.append(string);
            return sb.toString();
        }
    }

    /**
     * 将字符串用指定字符从结尾填充到指定长度
     *
     * @param string
     * @param minLength 填充长度
     * @param padChar   填充字符
     * @return
     */
    public static String padEnd(String string, int minLength, char padChar) {
        Objects.requireNonNull(string);
        if (string.length() >= minLength) {
            return string;
        } else {
            StringBuilder sb = new StringBuilder(minLength);
            sb.append(string);
            sb.append(String.valueOf(padChar).repeat(minLength - string.length()));
            return sb.toString();
        }
    }

}
