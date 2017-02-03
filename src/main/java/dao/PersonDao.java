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
}
