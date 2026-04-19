package com.sps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    public static void main(String[] args) {
        AbstractApplicationContext con = new AnnotationConfigApplicationContext(AppConfig.class);
        Student st = con.getBean("student", Student.class);
        st.study();
        con.close();
    }
}
