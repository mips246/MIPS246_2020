import com.tongji.controller.TeacherController;
import com.tongji.service.TeacherService;
import com.tongji.utils.MD5;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

/**
 * @author Ryan
 * @date 2020/8/14 9:15
 */
public class SmallTest {


    @Test
    public void test1(){
        String password= "123456";
        String MD5Password= MD5.next(password);
        System.out.println(MD5Password);
        if(MD5.next(password).equals(MD5Password)){
            System.out.println("密码正确");
        }
    }
    @Test
    public void test2() throws SQLException {
        //TeacherService teacherService = new TeacherService();
        //teacherService.getCourses("t15000001");
    }
}
