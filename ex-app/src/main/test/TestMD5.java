import com.ex.util.CustomMD5;

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
    public static void main(String[] args) {
        System.out.println(CustomMD5.passwordAndSalt("123456","123"));

        Random a=new Random();
        Integer ran = a.nextInt(1000000);
        System.out.println(a.nextInt(ran));
    }
}
