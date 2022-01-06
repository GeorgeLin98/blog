package com.george.blog.handler;

import com.george.blog.pojo.ResultVO;
import com.george.blog.util.MsgCodeDesc;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description 全局异常处理中心：对加了@Controller注解的方法进行拦截处理 AOP的实现
 * @date 2021.01.06
 * @author linzhuangze
 */
@ControllerAdvice
public class AllExceptionHandler {

    /**
     * @description 进行异常处理，处理Exception.
     * @date 2021.01.06
     * @author linzhuangze
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody //返回json数据
    public ResultVO doException(Exception ex){
        ex.printStackTrace();
        return ResultVO.fail(MsgCodeDesc.FAIL.getCode(), MsgCodeDesc.FAIL.getMsg());
    }
}
