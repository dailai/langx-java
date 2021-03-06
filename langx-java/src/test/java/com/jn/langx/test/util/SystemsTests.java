package com.jn.langx.test.util;

import com.jn.langx.text.StringTemplates;
import com.jn.langx.util.Strings;
import com.jn.langx.util.SystemPropertys;
import com.jn.langx.util.collection.Collects;
import com.jn.langx.util.comparator.Comparators;
import com.jn.langx.util.function.Consumer2;
import org.junit.Test;

import java.util.Map;

public class SystemsTests {
    @Test
    public void testSystemProperties() {
        System.out.println("====================System Properties===========");
        Map<String, String> map = Collects.propertiesToStringMap(System.getProperties(), true);
        Collects.forEach(map, new Consumer2<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(StringTemplates.formatWithPlaceholder("{} = {}", key, value));
            }
        });
    }

    @Test
    public void testEnvironmentVariables() {
        System.out.println("====================Environment Variables===========");
        Collects.forEach(Collects.sort(System.getenv(), Comparators.STRING_COMPARATOR_IGNORE_CASE), new Consumer2<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(StringTemplates.formatWithPlaceholder("{} = {}", key, value));
            }
        });
    }

    @Test
    public void javaClassPathTests() {
        System.out.println("====================Java Class Path ===========");
        System.out.println(SystemPropertys.getJavaClassPathString());
        System.out.println(Strings.join("\n", SystemPropertys.getJavaClassPath()));
    }

}
