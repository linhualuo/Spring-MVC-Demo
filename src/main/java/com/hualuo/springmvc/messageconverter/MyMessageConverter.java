package com.hualuo.springmvc.messageconverter;

import com.hualuo.springmvc.domain.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author Joseph
 * @create 2017/9/11 14:30
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj>{

    public MyMessageConverter() {
        super(new MediaType("application", "x-hualuo", Charset.forName("UTF-8")));
    }

    /**
     *
     * @param demoObj
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(DemoObj demoObj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "Hello: " + demoObj.getId() + "-" + demoObj.getName();
        outputMessage.getBody().write(out.getBytes());
    }

    /**
     * 只处理DemoObj这个类或者其派生类
     * @param clazz
     * @return
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        return DemoObj.class.isAssignableFrom(clazz);
    }

    /**
     * 处理请求的数据
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String tmp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArray = tmp.split("-");
        return new DemoObj(new Long(tempArray[0]), tempArray[1]);
    }
}
