package aop;

/**
 * Created by yuyang21 on 2016/12/1.
 */
public class UserManagerImpl implements UserManager {
    public String findUserById(int userId) {
        System.out.println("---------UserManagerImpl.findUserById()--------");
        if (userId <= 0) {
            throw new IllegalArgumentException("该用户不存在!");
        }
        return "张三";
    }
}
