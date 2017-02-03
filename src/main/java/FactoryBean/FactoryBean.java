package FactoryBean;

import Bean.Car;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.BeanFactory;

import java.beans.BeanInfo;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yuyang21 on 2016/12/1.
 */
public class FactoryBean {
    private Map<String, Object> beanMap = new HashMap<String, Object>();

    //工厂初始化 读取xml文件
    public void init(String xml) {
        try {
            SAXReader reader = new SAXReader();//解析xml文件
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream ins = classLoader.getResourceAsStream(xml);//得到当前xml的classpath的绝对路径的URI
            Document doc = reader.read(ins);
            Element root = doc.getRootElement();//获取元素节点
            Element foo;
            //遍历bean
            for (Iterator i = root.elementIterator("bean"); i.hasNext(); ) {
                foo = (Element) i.next();
                Attribute id = foo.attribute("id");
                Attribute className = foo.attribute("class");
                //利用Java反射机制，通过class的名称获取Class对象
                Class bean = Class.forName(className.getText());
                //获取对应class的信息
                BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
                //获取其属性描述
                PropertyDescriptor pd[] = info.getPropertyDescriptors();
                //设置值的方法
                Method mSet = null;
                //创建一个对象
                Object obj = bean.newInstance();
                //遍历该bean的property属性
                for (Iterator ite = foo.elementIterator("property"); ite.hasNext();) {
                    Element foo2 = (Element) ite.next();
                    //获取该property的name属性
                    Attribute name = foo2.attribute("name");
                    String value = null;
                    //获取该property的子元素value的值
                    for(Iterator ite1 = foo2.elementIterator("value"); ite1.hasNext();) {
                        Element node = (Element) ite1.next();                                                                                           value = node.getText();
                        break;
                    }
                    for (int k = 0; k < pd.length; k++) {
                        if (pd[k].getName().equalsIgnoreCase(name.getText())) {                                                                         mSet = pd[k].getWriteMethod();
                            //利用Java的反射机制调用对象的某个set方法，并将值设进去
                            mSet.invoke(obj, value);
                        }
                    }
                }
                //将对象放入beanMap中，其中key为id值，value为对象
                beanMap.put(id.getText(), obj);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    /** *//**
     * 通过bean的id获取bean的对象.
     * @param beanName bean的id
     * @return 返回对应对象
     */
    public Object getBean(String beanName) {
        Object obj = beanMap.get(beanName);
        return obj;
    }
    /** *//**
     * 测试方法.
     * @param args
     */
    public static void main(String[] args) {
        FactoryBean factory = new FactoryBean();
        factory.init("spring-config.xml");
        Car car= (Car)  factory.getBean("car");
        car.setColor("红");
        System.out.println("CarBeanColor： "+car.getColor());
    }
}
