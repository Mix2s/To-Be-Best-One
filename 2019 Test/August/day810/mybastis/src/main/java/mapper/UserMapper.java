package mapper;

import bz.UserBZ;
import poEx.UserEx;

import java.util.List;

public interface UserMapper {
    public List<UserEx> queryUserByZH(UserBZ userBz) throws Exception;

    public int queryUserByZH2(UserBZ userBZ) throws Exception;

    public List<UserEx> queryUserByotherName() throws Exception;

    public List<UserEx> queryUserByotherName2() throws Exception;
}
