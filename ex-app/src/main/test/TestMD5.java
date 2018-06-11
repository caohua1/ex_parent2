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
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        UserAppRegist userAppRegist = new UserAppRegist();
        String date = sf.format(new Date());
        userAppRegist.setRegisttime(sf.parse(date));
        System.out.println(userAppRegist.getRegisttime());
        System.out.println(date);
    }
}
