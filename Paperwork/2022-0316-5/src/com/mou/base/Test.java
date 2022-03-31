package com.mou.base;

public class Test {

        static int x=10;

        int y=99;

        {

            y=y+10;

        }

        static {

            x=x+5;

        }

        {

            y=y+10;

        }

        static {

            x=x+5;

        }

        public Test() {//构造方法

            x=x+5;

        }

        {

            System.out.println(x*y);

        }

    }

