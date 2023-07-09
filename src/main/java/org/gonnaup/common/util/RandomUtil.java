package org.gonnaup.common.util;

import java.util.Random;

/**
 * 随机数据生成工具类
 *
 * @author gonnaup
 * @version created at 2023/7/9 下午1:45
 */
public abstract class RandomUtil {

    private static final char[] DICT = "0123456789qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM".toCharArray();

    /**
     * 生成固定长度的随机字符串，包含0～9,a~z,A~Z
     *
     * @param count 字符串长度
     * @return 随机字符串
     */
    public static String randomString(int count) {
        return randomStringWithPrefix(count, null);
    }

    /**
     * 生成固定长度并带前缀(不计入长度)的随机字符串，包含0～9,a~z,A~Z
     *
     * @param count  字符串长度
     * @param prefix 字符串前缀，为null或空时为无前缀模式
     * @return 随机字符串
     */
    public static String randomStringWithPrefix(int count, String prefix) {
        if (count <= 0) {
            throw new IllegalArgumentException("字符串长度必须大于0");
        }

        StringBuilder builder;
        if (prefix == null || prefix.isBlank()) {
            builder = new StringBuilder();
        } else {
            builder = new StringBuilder(prefix);
        }

        int begin = 0, end = DICT.length;
        for (int i = 0; i < count; i++) {
            int randomIndex = RandomHolder.HOLDER.random.nextInt(begin, end);
            builder.append(DICT[randomIndex]);
        }
        return builder.toString();
    }

    /**
     * 随机类单例
     */
    enum RandomHolder {

        HOLDER;

        final Random random;

        RandomHolder() {
            random = new Random();
        }
    }
}
