package com.anonym.spring.exception;

/**
 * @author 王培忠
 * @date 2020/8/2
 * @email 805705089@qq.com
 * @Description
 * @Reason ADDREASON
 * @since JDK 1.8
 */
public class MyReturnException extends RuntimeException {
    public MyReturnException(String message){
        super(message);
    }
}
