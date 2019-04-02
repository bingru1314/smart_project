package com.smart.frame.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编码与解码操作工具类
 * @version 1.0
 */
public final class CodecUtil {
    private static final Logger log = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将url编码
     * @param source url路径
     * @return 编码之后的url
     */
    public static String encodeURL(String source){
        String target=null;
        try {
            target = URLEncoder.encode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("encode url failure",e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     * 将url解码
     * @param source url路径
     * @return 解码之后的url
     */
    public static String decodeURL(String source){
        String target = null;
        try {
            target = URLDecoder.decode(source,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.error("decode url failure",e);
            throw new RuntimeException(e);
        }
        return target;
    }
}
