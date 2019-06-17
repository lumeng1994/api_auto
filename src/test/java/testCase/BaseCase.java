package testCase;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import org.apache.http.Header;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pojo.Api;
import pojo.Case;
import pojo.ResponseValidators;
import utils.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BaseCase {
    @BeforeSuite
    public void init(ITestContext context){
        List<Api> apis = ExcelUtil.readExcel(Api.class,0);
        List<Case> cases = ExcelUtil.readExcel(Case.class,1);
        context.setAttribute("apis",apis);
        context.setAttribute("cases",cases);
        DBUtil.readToMsqlConfig();
        Log.info("读取准备数据。。。");
    }



    @Test(dataProvider = "datas")
    public void test(Api api,Case cases){
        //数据前验证
        String dbValidators = DBUtil.queryValiFieds(cases);
        if(dbValidators != null){
            ExcelUtil.saveAllWrite(cases.getCaseId(),"QueryResultBefore",dbValidators);
        }
        AuthoritionUtil.getCookie(api, cases);
        Map<String,Object> map =  HttpUtil.request(api,cases);
        String result = (String) map.get("result");
        String validator = ValidatorsUtil.getValidators(cases, map);
        System.out.println(validator);
        ExcelUtil.saveAllWrite(cases.getCaseId(),"ResponseValidationResult", validator);
        ExcelUtil.saveAllWrite(cases.getCaseId(),"ActualResponseData", result);
        //数据后验证
        if(dbValidators != null){
            ExcelUtil.saveAllWrite(cases.getCaseId(),"QueryResultAfter",dbValidators);
        }
        Log.info("验证数据及保存数据。。。");

//      Map<String,Object>  maps = (Map<String, Object>) JSONObject.parse(result);
//      Set<String> keys = maps.keySet();
//       for(String key:keys){
//           System.out.println("result:"+key+":"+maps.get(key));
//       }
//        Header[] headers = (Header[]) map.get("headers");
//        Object statusCode =  map.get("statusCode");
//        System.out.println("headers:"+ Arrays.toString(headers));
//        System.out.println("statusCode:"+statusCode);
    }

    @AfterSuite
    public void end(){
    ExcelUtil.excAllWrite();
        Log.info("把数据写入文件完毕");

    }


}
