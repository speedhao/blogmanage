package com.speedhao.blogmanage.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil
{

    private static Logger logger = LoggerFactory.getLogger(LogUtil.class);

    /**
     * 输出调试信息
     * 
     * @param message
     */
    public static void debug(String message)
    {
        try
        {
            logger.debug(message);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 输出信息
     * 
     * @param message
     */
    public static void info(String message)
    {
        try
        {
            logger.info(message);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 输出错误信息
     * 
     * @param message
     */
    public static void error(String message)
    {
        try
        {
            logger.error(message);
        }
        catch (Exception ex)
        {
            logger.error(ex.getMessage());
        }
    }

    /**
     * 直接输出异常
     * 
     * @param throwable
     */
    public static void error(Throwable throwable)
    {
        logger.error(throwable.getMessage());
    }
}
