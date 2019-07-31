package proxy;

public interface IUserManger {
    public boolean addUserInfo(String name,String pass);

    public boolean delUserInfo(int id);

    public boolean modifyUserInfo(String name,int id);

    public UserInfo queryUser(int id);
}
