package ColorBall.src.hashset;

/*
 * 模拟进行投注(即买票)的操作
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ticket {
    //投注时的红球
    private HashSet<Integer> redNums = new HashSet<>();

    //投注时篮球
    private Integer blueNums;

    public HashSet<Integer> getRedNums() {
        return redNums;
    }

    public Integer getBlueNums() {
        return blueNums;
    }

    //实现用户下注的方法
    public void buyTicket() {
        //控制台录入数据
        //获取键盘输入
        Scanner sc = new Scanner(System.in);
        int i = 1;
        //选号  红球
        while (true) {
            System.out.println("请输入第" + i + "个红球号码:");
            int redNum = sc.nextInt();
            if (redNum >= 1 && redNum <= 33) {
                //放到集合里面
                boolean flag = redNums.add(redNum);
                if (flag) {
                    //添加成功
                    i++;
                    if (i == 7) {
                        break;
                    }
                } else {
                    System.out.println("你输入的号码重复了，请重新输入");
                }
            } else {
                System.out.println("输入的号码无效，请重新输入");
            }
        }

        //选号 蓝球
        while (true) {
            System.out.println("请输入蓝球号码:");
            int num = sc.nextInt();
            if (num >= 1 && num <= 16) {
                blueNums = num;
                break;
            } else {
                System.out.println("输入的号码无效，请重新输入");
            }
        }
    }

    //显示用户下注号码的方法
    public void showTicket() {
        Integer[] arr = new Integer[6];
        redNums.toArray(arr);
        Arrays.sort(arr);
        String s = Arrays.toString(arr);
        System.out.println("下注的红球号码是：" + s);
        System.out.println("下注的蓝球号码是：" + blueNums);
    }

}
