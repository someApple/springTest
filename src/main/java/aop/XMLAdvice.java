package aop;

import org.aspectj.lang.JoinPoint;

/**
 * Created by yuyang21 on 2016/12/1.
 */
public class XMLAdvice {
    /**
     * 业务执行前执行
     */
    private void doBefore(JoinPoint joinPoint){
        System.out.println("-----doBefore().invoke-----");
        System.out.println(" 此处意在执行核心业务逻辑前，做一些安全性的判断等等");
        System.out.println(" 可通过joinPoint来获取所需要的内容");
        System.out.println("-----End of doBefore()------");
    }

}
