import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

/**
 * Created by yuyang21 on 2016/11/30.
 */
public class PsersonServiceTest {
    private BeanFactory  factory = null;
    @Test
    public void before(){
        factory = new ClassPathXmlApplicationContext("WEB-INF/spring-config.xml");
    }

}
