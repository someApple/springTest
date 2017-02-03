package Service;

import dao.IPersonDao;
import dao.PersonDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yuyang21 on 2016/11/30.
 */
@Service("personService")
public class PersonService implements IPersonService {
    @Resource
    private PersonDao personDao ;
    /*private PersonDao personDao;*/
    public String processSave(){
        return "=====PersonService.processSave()======100"+personDao.save();

    }
   /* public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public PersonDao getPersonDao() {
        return personDao;
    }*/
}
