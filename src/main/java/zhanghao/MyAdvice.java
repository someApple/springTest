package zhanghao;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import static javafx.scene.input.KeyCode.O;

/**
 * Created by yuyang21 on 2016/12/1.
 */
public class MyAdvice {
    public void beforeShow(JoinPoint joinPoint){
        System.out.println("前置通知");
    }
    public void afterReturnShow(Object o){
        System.out.println("后置通知 正常退出不包含抛异常情况的通知");
    }
    public void afterThrowing(Throwable e){
        System.out.println("异常通知 方法抛出异常退出时执行的通知");
    }
    public void afterShow(){
        System.out.println("最终通知 无论抛出异常与否");
    }
    //获取目标
    public Object Around(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("环绕通知");
        Object object = null;
        try{
            Object[] objects = jp.getArgs();//返回目标方法的参数
            object =jp.proceed();//获取目标方法的返回值
            ((Person)object).setName("呵呵哒");
        }catch (Throwable e){
                System.out.print("---");
        }

        return "在方法的调用前后完成自定义的行为，也可以选择不执行";
    }
}
