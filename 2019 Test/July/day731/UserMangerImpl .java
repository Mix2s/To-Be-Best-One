package proxy;

public class UserMangerImpl implements IUserManger{
    @Override
    public boolean addUserInfo(String string1,String string2) {
        System.out.println("UserInfoImpl.addUserInfo");
        return false;
    }

    @Override
    public boolean delUserInfo(int id) {
        System.out.println("UserInfoImpl.delUserInfo");
        return false;
    }

    @Override
    public boolean modifyUserInfo(String name, int id) {
        System.out.println("UserInfoImpl.modifyUserInfo");
        return false;
    }

    @Override
    public UserInfo queryUser(int id) {
        System.out.println("UserInfoImpl.queryUser");
        return null;
    }
}
