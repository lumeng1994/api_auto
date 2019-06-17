package utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.testng.Assert;
import pojo.Case;
import pojo.ResponseValidators;

import java.util.List;
import java.util.Map;

public class ValidatorsUtil {

    public static String getValidators(Case cases, Map<String, Object> map) {
        String result = (String) map.get("result");
        String responseValidators = cases.getResponseValidators();
        List<ResponseValidators> lists = JSONObject.parseArray(responseValidators, ResponseValidators.class);
        String actual = null;
        String excepted = null;
        String validator = "通过";
        for(ResponseValidators validators:lists){
            String jsonPathExp = validators.getJsonPath();
            actual = (String) JSONPath.read(result,jsonPathExp);
            excepted = validators.getExpected();
        }
        try {
            Assert.assertEquals(actual,excepted);
        }catch (Error e){
            validator = "不通过";
        }
        return validator;
    }
}
