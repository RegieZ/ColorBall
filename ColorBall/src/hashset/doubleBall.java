package ColorBall.src.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/*
 * 代表双色球开奖的操作
 */
public class doubleBall {
    //红球
    private HashSet<Integer> redBalls = new HashSet<>();

    //篮球
    private Integer blueBall;

    public HashSet<Integer> getRedBalls() {
        return redBalls;
    }

    public Integer getBlueBall() {
        return blueBall;
    }

    //随机产生6个红球和1个蓝球的方法,模拟开奖
    public void randomNum() {
        Random r = new Random();
        //随机产生6个红球 (1-33)之间的6个随机数
        while (true) {
            int num = r.nextInt(33) + 1; //[1-33]
            redBalls.add(num);

            if (redBalls.size() == 6) {
                break;
            }
        }

        //生成1-16之间的数字，蓝球的号码
        blueBall = r.nextInt(16) + 1;
    }

    //显示开奖的号码
    public void show() {
        Integer[] arr = new Integer[6];

        redBalls.toArray(arr);

        //对开奖号码排序
        Arrays.sort(arr);

        String s = Arrays.toString(arr); //Ctrl + 1
        System.out.println("开奖的红球号码是：" + s);
        System.out.println("开奖的蓝球号码是：" + blueBall);
    }
}
