import com.ex.entity.Orders;
import com.ex.entity.UserAppRegist;
import com.ex.util.CustomMD5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @ProjectName ex_parent
 * @ClassName TestMD5
 * @Description TODO
 * @Author sanmu
 * @Date 2018/6/4 11:16
 * @Version 1.0
 **/
public class TestMD5 {

    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
//        Calendar c = Calendar.getInstance();
//        System.out.println(sf.format(c.getTime()));
//        System.out.println(sf.format(new Date()));
//        // 生成5分钟后的时间
//        c.add(Calendar.MINUTE, 5);
//        String currentTime = sf.format(c.getTime());
//        System.out.println(currentTime);
//
//        UserAppRegist user = new UserAppRegist();
//        System.out.println(user.getRegisttime());
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        UserAppRegist userAppRegist = new UserAppRegist();
//        String date = sf.format(new Date());
//        userAppRegist.setRegisttime(sf.parse(date));
//        System.out.println(userAppRegist.getRegisttime());
//        System.out.println(date);


//        Calendar now = Calendar.getInstance();
//        now.setTime(new Date());
//        System.out.println(now.getTime());////////--------------
//        now.set(Calendar.DATE, now.get(Calendar.DATE) + 10);
//        System.out.println(now.getTime());//////////////------------
//
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.MINUTE, 14400);
//        String currentTime = sf.format(c.getTime());
//        System.out.println(currentTime);////////////////--------------
//        Orders o = new Orders();
//        o.setFinishTime(sf.parse(currentTime));
//        System.out.println(o.getFinishTime());////////////////------------
//        20180727162745
//

        if (sf.format(sf.parse("2018-07-27 09:35:33")).compareTo(sf.format(null)) > 0) {
            System.out.println("交易完成");
        }else{
            System.out.println("交易进行中");
        }

    }
}
