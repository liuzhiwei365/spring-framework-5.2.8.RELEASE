package org.lzw.base.test;


import org.springframework.util.PropertyPlaceholderHelper;

import java.util.Properties;

public class TestPropertyPlaceholderHelper {

    private final static  PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper("${", "}");

    public static void main(String[] args) {

        testWithProperties();
    }

    public static void testWithProperties() {
        String text = "name=${foo}";
        Properties props = new Properties();
        props.setProperty("foo", "bar");

        String s = helper.replacePlaceholders(text, props);

        System.out.println(s);
    }
}
