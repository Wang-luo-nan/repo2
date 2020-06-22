package com.aaa.wang.mapper;

import com.aaa.wang.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    List<User> query1();

    @Select("select * from tb_user where username like concat('%',#{username},'%')")
    List<User> queryName(String username);

    @Select("select * from tb_user where username = #{username}")
    User findUserByName(String username);
    @Select("select m.menuname from t_user u,t_role r,t_user_role ur,t_menu_role mr,t_menu m where u.id = ur.roleid and ur.roleid = r.id and r.id = mr.roleid and mr.menuid = m.id and u.username = #{username}")
    Set<String> findPermissionByName(String username);


}