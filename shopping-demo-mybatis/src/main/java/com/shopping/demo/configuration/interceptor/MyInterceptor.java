package com.shopping.demo.configuration.interceptor;

import com.shopping.demo.constants.ShopExceptionCode;
import com.shopping.demo.entity.OperLog;
import com.shopping.demo.entity.User;
import com.shopping.demo.exception.MyShopException;
import com.shopping.demo.repository.OperLogRepository;
import com.shopping.demo.service.UserService;
import com.shopping.demo.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

    @Autowired
    private UserService userService;
    @Autowired
    private OperLogRepository operLogRepository;

    /*{
        content-type:application/json,
        serviceId:username,
        signInfo: sha5加密(username + password(MD5加密转大写) + ts)
        ts:当前请求的时间戳（毫秒）
    }*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        try {

            String serviceId = request.getHeader("serviceId").trim();
            String signInfo = request.getHeader("signInfo").trim();
            String ts = request.getHeader("ts").trim();
            String reqBody = Util.getReqBodyStrByHeader(request);

            LOG.info("************serviceId************[{}]",serviceId);
            LOG.info("************signInfo*************[{}]",signInfo);
            LOG.info("************reqBody**************[{}]",reqBody);

//          校验签名是否正确
            User curUser = userService.findCurUserByUserNameOrMobile(serviceId);

            LOG.info("************curLoginUser*********[{}]",curUser.toString());

            String signStr = serviceId + curUser.getPassword() + ts;
            if(signInfo.equals(EncryptUtils.shaEncode(signStr))){
                ThreadLocalUtils.set(curUser);
                return true;
            } else {
                throw new MyShopException(ShopExceptionCode.SIGNATURE_ERROR,"签名错误");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
            ResponseUtils.failure(ShopExceptionCode.SIGNATURE_ERROR,"签名错误");
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) throws Exception {
        LOG.info("afterCompletion");
        User userDto = (User) ThreadLocalUtils.get();
        String code = CodeThreadLocal.get();
        String reqData = Util.getReqBodyStrByHeader(request);
        String apiInterface = request.getRequestURL().toString();
        String apiDescription = "";
//        if (object instanceof HandlerMethod) {
//            HandlerMethod handler = (HandlerMethod) object;
//            apiDescription = handler.getMethodAnnotation(ApiOperation.class).value();
//        }
        OperLog operLog = new OperLog();
        operLog.setUserId(userDto.getId());
        operLog.setUserName(userDto.getUserName());
        operLog.setTrueName(userDto.getTrueName());
        operLog.setMobileNum(userDto.getMobileNum());
        operLog.setApiInterface(apiInterface);
        operLog.setApiDescription(apiDescription);
        operLog.setRetCode(code);
        operLog.setReqData(reqData.length() > 65535 ? "新闻内容长度过长，不做存储" : reqData);
        operLog.setReqTime(DateTimeUtils.stampToDate(System.currentTimeMillis()+""));
        operLogRepository.save(operLog);

    }

}
