package Service;

import zhanghao.Person;

/**
 * Created by yuyang21 on 2016/12/1.
 */
public class MyService {
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public Person Show(){
        System.out.print("\n 目标函数 person"+this.person+"\n");
        return person;
    }
}
