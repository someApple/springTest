package dao;

import org.springframework.stereotype.Repository;

/**
 * Created by yuyang21 on 2016/11/30.
 */
@Repository("persionDao")
public class PersonDao implements IPersonDao {
    public String save(){
       return "===========白兰===========";
    }
    public void pop(){
        System.out.print("bailan");
        System.out.print("bailan");
        System.out.print("bailan");
        System.out.print("bailan");
        System.out.print("bailan");
    }
}
