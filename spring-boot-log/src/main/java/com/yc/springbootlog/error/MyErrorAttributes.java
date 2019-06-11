package com.yc.springbootlog.error;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * 给容器中 加入我们自己定义的ErrorAttributes
 * @author LX
 * @date 2019/6/5 - 18:38
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{

    /**
     *  返回值的map 就是 页面和json 能获取的所有字段
     */

    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {

        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);

        map.put("company", "atguigu");

        // 异常处理器携带的数据
        Map<String, Object> map1 = (Map<String, Object>) requestAttributes.getAttribute("map", 0);

        map.put("map", map1);

        System.out.println(map);

        return map;
    }
}
