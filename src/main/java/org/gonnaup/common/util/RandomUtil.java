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
     * 生成收集数字字符串
     *
     * @param count 长度
     * @return 数字字符串
     */
    public static String randomNumbericString(int count) {
        return randomStringWithPrefixBeginEnd(count, null, 0, 10);
    }

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
        return randomStringWithPrefixBeginEnd(count, prefix, 0, DICT.length);
    }

    /**
     * 生成固定长度并带前缀(不计入长度)的随机字符串，包含a~z,A~Z
     *
     * @param count 字符串长度
     * @return 随机字符串
     */
    public static String randomAlphabet(int count) {
        return randomAlphabetWithPrefix(count, null);
    }

    /**
     * 生成固定长度并带前缀(不计入长度)的随机字符串，包含a~z,A~Z
     *
     * @param count  字符串长度
     * @param prefix 字符串前缀，为null或空时为无前缀模式
     * @return 随机字符串
     */
    public static String randomAlphabetWithPrefix(int count, String prefix) {
        return randomStringWithPrefixBeginEnd(count, prefix, 10, DICT.length);
    }

    /**
     * 生成固定长度并带前缀(不计入长度)的随机字符串
     * <p>
     * 字符串由 {@link RandomUtil#DICT} 在索引 [beginIndex, endIndex) 范围内的字符组成
     *
     * @param count      字符串长度，不包括前缀
     * @param prefix     字符串前缀
     * @param beginIndex DICT开始索引（包括）
     * @param endIndex   DICT结束索引（不包括）
     * @return 随机字符串
     */
    private static String randomStringWithPrefixBeginEnd(int count, String prefix, int beginIndex, int endIndex) {
        if (count <= 0) {
            throw new IllegalArgumentException("字符串长度必须大于0");
        }

        StringBuilder builder;
        if (prefix == null || prefix.isBlank()) {
            builder = new StringBuilder();
        } else {
            builder = new StringBuilder(prefix);
        }

        for (int i = 0; i < count; i++) {
            int randomIndex = RandomHolder.HOLDER.random.nextInt(beginIndex, endIndex);
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
