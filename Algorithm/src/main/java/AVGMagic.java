/**
 * Created by yjw on 18-3-12.
 */

/**
 * 瞎想了两个公式第一个是都是关于平均数的公式：
 * 1. 关于平均数数组的地推公式 : avg(x)=(avg(x-1)*(x-1)+new_num)/x
 * 2. 基于1的公式反推的公式，例如已知的一个avg(x)数组，反推两个数之间加了那个数字： new_num = x*(avg(x)-avg(x-1)) + avg(x-1)
 * 第二个公式在实际中会存在浮点精度问题
 */
public class AVGMagic {
    public static void main(String[] args) {
        double[] avg = new double[100];

        avg[0] = 0;
        int num = 1;
        for (int x = 1; x<100 ; x++) {
            avg[x] = (avg[x-1]*(x-1) + num++) / x;
        }

        for(int i=0;i<100;i++){
            System.out.println(avg[i]);
        }

        for (int x=1; x<100; x++) {
            System.out.println(x*(avg[x] - avg[x-1]) + avg[x-1]);
        }
    }
}
