import Bean.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by yuyang21 on 2016/11/29.
 */
public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable{
        //1.通过类加载器获取类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clasz = loader.loadClass("Car");
        //2.获取类的默认构造器对象并通过它实例化
        Constructor<Car> cns = clasz.getConstructor((Class[]) null);
        Car car = cns.newInstance();
        //3.通过反射设置属性
        Method setBrand = clasz.getMethod("setBrand",String.class);
        setBrand.invoke(car,"兰博基尼");
        Method setColor = clasz.getMethod("setColor",String.class);
        setColor.invoke(car,"白");
        Method setMaxSpeed = clasz.getMethod("setMaxSpeed",int.class);
        setMaxSpeed.invoke(car,200);
        return car;
    }
    public static void main(String[] args) throws Throwable {
       /* Car car = initByDefaultConst();
        car.introduce();*/
      /* Integer x = 1;
        int y = x;
        System.out.print(y);*/
    }
}
