package cn.yiueil.meeting.mapper;


import cn.yiueil.meeting.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LoginMapperCustom extends LoginMapper{
    @Select("select id,islogin from t_login where name = #{key} or mail =#{key} or phone = #{key} and passwd = #{passwd}")
    Login loginByKey(String key , String passwd);

    @Update("update t_login set islogin = 1 where id=#{id}")
    void loginStatusUpdate(Long id);
}