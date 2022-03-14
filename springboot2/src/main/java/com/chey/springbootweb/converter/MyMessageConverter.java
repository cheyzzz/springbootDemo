package com.chey.springbootweb.converter;

import com.chey.springbootweb.pojo.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;


/**
 * @Author chey
 * @Date 2022-02-14 15:13
 * @Describe 自定义消息转换器 输出自定义类型数据格式
 */
public class MyMessageConverter implements HttpMessageConverter<Person> {


    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;//不支持读  即传入参数
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);//若类型为person则可写
    }
    //统计所有messageconverter能生产出哪些数据类型
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/type_person");//使写出内容满足自定义类型格式
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    //自定义协议的写出
    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //获得数据
        String data = person.getName()+";"+person.getAge()+";"+person.getPet();
        //写出
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());

    }
}
