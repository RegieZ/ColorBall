package ColorBall.src.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //红球下注
        int[] buyRedBalls = buyRedBalls();
        //蓝球下注
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入下注的蓝球号码(1-16)：");
        int buyBlue = sc.nextInt();

        //红球开奖号码
        int[] redBalls = getRedBalls();
        //蓝球开奖号码
        Random r = new Random();
        int blue = r.nextInt(16) + 1;

        //显示下注号码
        System.out.println("您下注的红球号码为：" + Arrays.toString(buyRedBalls));
        System.out.println("您下注的蓝球号码为：" + buyBlue);
        //显示开奖号码：
        System.out.println("开奖的红球号码为：" + Arrays.toString(redBalls));
        System.out.println("开奖的蓝球号码为：" + blue);

        //统计红球中奖个数
        int redCount = checkBalls(redBalls, buyRedBalls);
        System.out.println("中奖的红球个数：" + redCount);
        //统计蓝球中奖个数
        int blueCount = buyBlue == blue ? 1 : 0;
        System.out.println("中奖的蓝球个数：" + blueCount);

        //统计中奖结果
        /*
        一等奖（6+1）：红球33选6，蓝球16选1；
        二等奖（6+0）：红球33选6；
        三等奖（5+1）：红球33选5，蓝球16选1；
        四等奖（5+0、4+1）：红球33选5 或者 红球33选4，蓝球16选1；
        五等奖（4+0、3+1）：红球33选4 或者 红球33选3，蓝球16选1；
        六等奖（2+1、1+1、0+1）：红球33选2，蓝球16选1 或者 红球33选1，蓝球16选1 或者蓝球16选1；
         */
        if (redCount == 6 && blueCount == 1) {
            System.out.println("恭喜你中了一等奖");
        } else if (redCount == 6) {
            System.out.println("恭喜你中了二等奖");
        } else if (redCount == 5 && blueCount == 1) {
            System.out.println("恭喜你中了三等奖");
        } else if (redCount == 5 || (redCount == 4 && blueCount == 1)) {
            System.out.println("恭喜你中了四等奖");
        } else if (redCount == 4 || (redCount == 3 && blueCount == 1)) {
            System.out.println("恭喜你中了五等奖");
        } else if ((redCount == 2 && blueCount == 1) || (redCount == 1 && blueCount == 1) || blueCount == 1) {
            System.out.println("恭喜你中了六等奖");
        } else {
            System.out.println("感谢您为福利事业做出的贡献！");
        }
    }

    //统计红球中奖个数
    public static int checkBalls(int[] redBalls, int[] buyBalls) {
        int count = 0;
        for (int i = 0; i < buyBalls.length; i++) {
            for (int j = 0; j < redBalls.length; j++) {
                if (buyBalls[i] == redBalls[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    //模拟用户下注红球的过程
    public static int[] buyRedBalls() {
        int[] arr = new int[6];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个红球(1-33)：");
            arr[i] = sc.nextInt();
        }
        //排序（方便查看）
        Arrays.sort(arr);
        return arr;
    }

    //随机生成1-33之间的不重复的6个整数（红球的开奖号码）
    public static int[] getRedBalls() {
        int[] arr = new int[6];
        Random r = new Random();
        int index = 0;
        //为第一个元素赋值
        arr[index] = r.nextInt(33) + 1;
        wc:
        while (true) {
            //生成随机数
            int num = r.nextInt(33) + 1;
            //判断num是否重复
            for (int i = 0; i <= index; i++) {
                if (num == arr[i]) {
                    continue wc;
                }
            }
            //如果执行到这里，说明不重复，存到数组中
            arr[++index] = num;
            //如果index为5，说明6个元素全部存满
            if (index == 5) {
                break wc;
            }
        }
        //排序（方便查看）
        Arrays.sort(arr);
        //返回数组
        return arr;
    }
}