package cn.yiueil.meeting.handler.interceptor;

import cn.yiueil.meeting.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * __/\\\________/\\\____________/\\\\\\\\\\\_____________________________________________________________________________/\\\\\\________
 * _\///\\\____/\\\/____________\/////\\\///_____________________________________________________________________________\////\\\________
 * ___\///\\\/\\\/__________________\/\\\_________________________________________________________________/\\\______________\/\\\________
 * _____\///\\\/____________________\/\\\________________/\\\____/\\\_______________/\\\\\\\\\\____________\///______________\/\\\________
 * _______\/\\\_____________________\/\\\_______________\/\\\___\/\\\_____________/\\\/////////____________/\\\______________\/\\\________
 * _______\/\\\_____________________\/\\\_______________\/\\\___\/\\\____________/\\\\\\\\\\_______________\/\\\_____________\/\\\________
 * _______\/\\\_____________________\/\\\_______________\/\\\___\/\\\___________\//\\///////_______________\/\\\_____________\/\\\________
 * _______\/\\\__________________/\\\\\\\\\\\___________\//\\\\\\\\\_____________\//\\\\\\\\\\\\\___________\/\\\____________/\\\\\\\\\\\\\_
 * _______\///__________________\///////////_____________\/////////_______________\/////////////____________\///____________\/////////////__
 * Create by YIueil
 * Create time 2019/9/6
 * message
 */
public class ManageInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(ManageInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info("燕人张翼德在此");
        User manager = (User)request.getSession().getAttribute("manager");
        if(manager!=null){
            logger.info(manager.getName()+"大侠慢慢玩哦");
            return true;
        }
        logger.info(request.getRequestURI());
        logger.info("尔等休想前进一步");

        //转发
//        request.getRequestDispatcher("/login").forward(request, response);
        //重定向
      response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
