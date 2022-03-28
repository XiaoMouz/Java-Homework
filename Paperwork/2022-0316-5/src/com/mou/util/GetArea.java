package com.mou.util;

import static com.mou.util.AreaMode.*;

public class GetArea {
    public static double PI = 3.14;

    /**
     * 求正方形、长方形或圆柱体的面积
     * @param a 长/半径
     * @param b 宽/高
     * @param mode 正方形/长方形/圆柱体
     * @return 面积
     */
    public static double getArea(double a, double b, AreaMode mode){
        if(mode == RECTANGLE||mode == SQUARE){
            return a*b;
        }else if(mode == CYLINDER){
            return 2*PI*a*a + 2*PI*a*b;
        }else{
            return 0;
        }
    }

    /**
     * 求梯形面积
     * @param up 上底
     * @param down 下底
     * @param height 高度
     * @return 梯形面积
     */
    public static double getArea(double up,double down,double height){
        return ((up+down)*height)/2;
    }

    /**
     * 求圆面积
     * @param r 半径
     * @return 圆面积
     */
    public static double getArea(double r){
        return PI*r*r;
    }

}
