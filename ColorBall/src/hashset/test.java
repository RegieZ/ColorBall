package ColorBall.src.hashset;

import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        //下注
        ticket t = new ticket();
        t.buyTicket();
        doubleBall db = new doubleBall();
        db.randomNum();
        //查看结果
        db.show();
        //开奖
        t.showTicket();
        showResult(db,t);
    }

    //兑奖的过程
    public static void showResult(doubleBall db, ticket t){
        //开奖的红球
        HashSet<Integer> redBalls = db.getRedBalls();

        //下注的红球
        HashSet<Integer> redNums = t.getRedNums();

        //统计红球的中奖个数
        int redCount = 0;
        for(Integer num :redNums){
            boolean flag = redBalls.contains(num);
            if(flag){
                redCount++;
            }
        }

        //统计蓝球的个数
        int blueCount = 0;
        //开奖的蓝球
        Integer blueBall = db.getBlueBall();
        //下注的蓝球
        Integer blueNums = t.getBlueNums();

        if(blueBall==blueNums){
            blueCount=1;
        }

        System.out.println("中奖的红球个数："+redCount);
        System.out.println("中奖的蓝球个数"+blueCount);

        if(redCount==6 && blueCount==1){
            System.out.println("恭喜你，中了一等奖");

        }else if(redCount==6 && blueCount==0){
            System.out.println("恭喜你，中了二等奖");

        }else if(redCount==5 && blueCount==1){
            System.out.println("恭喜你，中了三等奖");

        }else if(redCount==5 ||( redCount==4 && blueCount==1)){
            System.out.println("恭喜你，中了四等奖");

        }else if(redCount==4 ||( redCount==3 && blueCount==1)){
            System.out.println("恭喜你，中了五等奖");

        }else if((redCount==2 && blueCount==1)||(redCount==1 && blueCount==1) || blueCount==1){
            System.out.println("恭喜你，中了六等奖");
        }else{
            System.out.println("感谢您为福利事业做出的贡献");
        }
    }
}
