package com.tech.demo.optional;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        Role role3 = new Role();//正常情况自己写这个是知道底的
        //但是以后可能会面临一些未知的情况，比如里面是空的
        Role role1 = null;
        test(role3);
        System.out.println(role3);
    }

    //比如在这种情况下，你的方法不一定能确保role不是空的
    public static void test(Role role){
        /*通常情况下我们会写一些判断来保证这个对象不是空的
        if(role != null){
            Role role2 = role;
            if(role2.getName()!=null){
                System.out.println(role2.getName());
            }
        }
        */

        //上面实在过于繁琐，因此我们可以使用optional
        //Optional<Role> role1 = Optional.of(role);
        //然后这玩意给你抛了个异常
        /*这甚至和
        if(role==null){
            throw new NullPointerException();
        }
        没有区别*/

        //实际我们可能会使用这个
        Optional<Role> role1 = Optional.ofNullable(role);//这样若是空则不报错并且继续运行，role1会标记为Optional.empty，但是如果正常的话可以通过.get来拿到toString后的结果

        //System.out.println(role1);
        if(role1.isPresent()){//所以可以使用这个判断
            System.out.println(role1.get());//当然得不是空才能进行啦
            return;
        }else{
            System.out.println(role1);
            //role = role1.orElse(new Role());//有意思的是，Optional还可以给你创建一个对象，但是必须要写在if里判断，否则不论如何都会执行orElse
            System.out.println(role);
        }
        //也可以使用orElseGet来创建，并且还能使用方法引用和Lambda，并且这个是Role为空时才会进行哦
        role = role1.orElseGet(Role::new);
        System.out.println(role);

        //以及更好玩的，ifPresent方法能执行Lambda，记得把上面注释掉哦
        role1.ifPresent((x)->{
            //其中的x代表的是对象role，不是role1!这个optional对象，而是传进来的那个role
            System.out.println("1");
            x.setName("aa");
        });

        //注意，使用这种方法进行修改时，在main函数中的role3其实也被同步更改了(就是那个不为空的案例)，原因是内存堆栈关系关联

        //亦或者，除了对对象本身进行检查，还需要对部分数值进行校验(是否是空)你可以使用.map方法，他也是通过Lambda驱动
        //role1.map(x -> x.getName() != null && x.getRoleTag() != null);
        Optional<Boolean> aBoolean = role1.map(x -> x.getName() != null && x.getRoleTag() != null);//var补全了一下

        //.filter()是一个过滤方法，也是通过Lambda驱动，根据Lambda的条件来返回布尔值

    }
}
