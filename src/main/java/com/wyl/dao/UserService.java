package com.wyl.dao;

import com.wyl.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserService {
    User getUserByName(String username);
    //注解用法不需要配置xml
    @Select("select * from user")
    List<User> getUser();
    //两个参数,我们需要使用 @Param 注解来指定每一个参数的对应关系
    @Select("select * from user where id = #{id} and username=#{name}")
    User getUserByIdAndName(@Param("id") int id, @Param("name") String username);
    //我们也可以 xml 和注解相结合使用，目前我们实际的项目中也是采用混用的方式，因为有时候 xml 方便
    //有时候注解方便，比如就上面这个问题来说，如果我们定义了上面的这个 UserMapper.xml
    // 那么我们完全可以使用 @ResultMap 注解来替代 @Results 注解
    @Select("select * from user where id = #{id}")
    @ResultMap("BaseResultMap")
    User getUser2(Long id);
}
