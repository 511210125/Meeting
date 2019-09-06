package cn.yiueil.meeting.mapper;


import cn.yiueil.meeting.entity.Login;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface LoginMapperCustom extends LoginMapper{
    @Select("select id,islogin from t_login where (name = #{key} or mail =#{key} or phone = #{key}) and passwd = #{passwd}")
    Login loginByKey(String key , String passwd);

    @Update("update t_login set islogin = true where id=#{id}")
    void loginStatusUpdate(Long id);

    //非重复校验
    @Select("SELECT COUNT(id) FROM t_user WHERE NAME = #{name}")
    int nameCheck(String name);

    @Select("SELECT COUNT(id) FROM t_user WHERE PHONE = #{phone}")
    int phoneCheck(String phone);

    @Select("SELECT COUNT(id) FROM t_user WHERE MAIL = #{mail}")
    int mailCheck(String mail);
}