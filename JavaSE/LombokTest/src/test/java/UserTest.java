import com.iqqcode.lombok.User;
import lombok.Cleanup;
import org.junit.Test;

import java.io.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * @Author: Mr.Q
 * @Date: 2020-03-21 08:45
 * @Description:
 */
public class UserTest {

    @Test
    public void test() throws IOException {
        User user = User.builder().id(1).username("Mr.Q").password("123").age(18).build();
        //打印类的日志信息
        //user.fun("test");

        @Cleanup InputStream in = new FileInputStream("filePath1");
        @Cleanup OutputStream out = new FileOutputStream("filePath2");
        byte[] cache = new byte[1024];
        while(true) {
            int r = in.read(cache);
            if(r == -1) break;
            out.write(cache,0,r);
        }
    }
}



