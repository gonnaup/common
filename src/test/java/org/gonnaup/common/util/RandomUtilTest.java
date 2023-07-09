package org.gonnaup.common.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

/**
 * @author gonnaup
 * @version created at 2023/7/9 下午5:38
 */
class RandomUtilTest {


    @RepeatedTest(5)
    void test() {
        String s = RandomUtil.randomString(94);
        Assertions.assertEquals(94, s.length());


        String prefix = "ABC_";
        String s1 = RandomUtil.randomStringWithPrefix(88, prefix);
        Assertions.assertEquals(88 + prefix.length(), s1.length());
        Assertions.assertTrue(s1.startsWith(prefix));
    }

}