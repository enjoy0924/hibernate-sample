package com.allere.hibernate.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;

/**
 * <p>
 * Created by JianjunTang
 * <p>
 * Date: 2015/4/8
 * <p>
 * Time: 17:48
 */
public final class CommonUtil {
    private CommonUtil() {
    }


    /**
     * 获取到uuid
     *
     * @return
     */
    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 打印错误日志
     *
     * @param e
     * @return
     */
    public static String printStackMessage(Throwable e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            //将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        if (null != sw) {
            return sw.toString();
        } else {
            return "no exception!";
        }
    }

    public static String replaceAllBlankOfString(String context) {
        context = context.replaceAll("\\n", "");
        context = context.replaceAll("\\t", "");
        context = context.replaceAll("\\r", "");
        context = context.replaceAll(" ", "");
        StringBuilder stringBuilder = new StringBuilder(context);
        return stringBuilder.toString();

    }
}
