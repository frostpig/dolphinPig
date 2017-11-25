package com.frost.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by shuangshuangl on 2017/11/23.
 */


@Controller
@RequestMapping(value = "trace")
public class TraceController {
    /**
     * Trace
     * @param timeType
     * @return
     */
    @RequestMapping(value = "")
    public ModelAndView trace(@RequestParam(defaultValue = "1",required = false) Integer timeType) {

        Map<String, Object> map = new HashedMap();
        map.put("timeType", timeType);
        map.put("topNActive", "active");
        return new ModelAndView("trace", map);
    }

    @RequestMapping(value = "/detail")
    public ModelAndView traceDetail(@RequestParam(defaultValue = "1",required = false) Integer timeType) {

        Map<String, Object> map = new HashedMap();
        String data = "{\"total\":7,\"rows\":[\n" +
                "\t{\"id\":1,\"name\":\"All Tasks\",\"begin\":\"3/4/2010\",\"end\":\"3/20/2010\",\"progress\":60,\"iconCls\":\"icon-ok\"},\n" +
                "\t{\"id\":2,\"name\":\"Designing\",\"begin\":\"3/4/2010\",\"end\":\"3/10/2010\",\"progress\":100,\"_parentId\":1,\"state\":\"closed\"},\n" +
                "\t{\"id\":21,\"name\":\"Database\",\"persons\":2,\"begin\":\"3/4/2010\",\"end\":\"3/6/2010\",\"progress\":100,\"_parentId\":2},\n" +
                "\t{\"id\":22,\"name\":\"UML\",\"persons\":1,\"begin\":\"3/7/2010\",\"end\":\"3/8/2010\",\"progress\":100,\"_parentId\":2},\n" +
                "\t{\"id\":23,\"name\":\"Export Document\",\"persons\":1,\"begin\":\"3/9/2010\",\"end\":\"3/10/2010\",\"progress\":100,\"_parentId\":2},\n" +
                "\t{\"id\":3,\"name\":\"Coding\",\"persons\":2,\"begin\":\"3/11/2010\",\"end\":\"3/18/2010\",\"progress\":80},\n" +
                "\t{\"id\":4,\"name\":\"Testing\",\"persons\":1,\"begin\":\"3/19/2010\",\"end\":\"3/20/2010\",\"progress\":20}\n" +
                "],\"footer\":[\n" +
                "\t{\"name\":\"Total Persons:\",\"persons\":7,\"iconCls\":\"icon-sum\"}\n" +
                "]}\n";
       JSONObject json = JSONObject.parseObject(data);
        map.put("data", JSON.toJSONString(data));
     /*   map.put("timeType", timeType);
        map.put("topNActive", "active");*/
        return new ModelAndView("trace.detail", map);
    }
}
