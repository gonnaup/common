package org.gonnaup.common.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author gonnaup
 * @version created at 2023/7/9 下午5:43
 */
class StringUtilTest {


    @Test
    void test() {
        assertTrue(StringUtil.isNullOrBlank(null));
        assertTrue(StringUtil.isNullOrBlank("  "));
        assertFalse(StringUtil.isNullOrBlank("A"));

        assertTrue(StringUtil.isNotBlank("B"));
        assertFalse(StringUtil.isNotBlank(null));
        assertFalse(StringUtil.isNotBlank("    "));

        String s = "AAAAA";
        int len = s.length();
        int padLength = 10;
        String padStart = StringUtil.padStart(s, padLength, '0');
        assertTrue(padStart.startsWith("0".repeat(padLength - len)));
        assertEquals(padLength, padStart.length());

        String padEnd = StringUtil.padEnd(s, padLength, '0');
        assertTrue(padEnd.endsWith("0".repeat(padLength - len)));
        assertEquals(padLength, padEnd.length());
    }
}