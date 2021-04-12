package com.atguigu.spring.cloud.test;

public  class demoimpl2 extends demoImpl {
    @Override
    public void say() {
        System.out.println("demo2");
    }


    public static void main(String[] args) {
        demo demo1 = new demoimpl2();
        demo1.say();
        demoImpl demo =  new demoimpl2();
        demo.say();
        demo.test();
    }


    @Override
    public void test() {

    }
}
