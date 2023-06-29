package org.gonnaup.common.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author gonnaup
 * @version created at 2023/5/31 下午6:03
 */
public class ResultTest {

    record Person(String name, int age) {
    }

    @Test
    void resultOkTest() {
        Person mike = new Person("mike", 20);
        Result<Person> ok = Result.ok(mike);
        Assertions.assertSame(ok.data(), mike);
        System.out.println(ok);
    }

    @Test
    void resultFailTest() {
        String reason = "error.account.notexist";
        Result<String> fail = Result.fail(reason);
        Assertions.assertEquals(fail.message(), reason);
        System.out.println(fail);
    }

}
