package utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import pojo.Api;
import pojo.Case;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpUtil {

    public static Map<String,Object> get(Api api, Case cs){
        String url = api.getUrl();
        String params = cs.getParams();
        String param = jsonToString(params);
        HttpGet httpGet = new HttpGet(url+"?"+param);
        getToCookie(api, httpGet);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String result = EntityUtils.toString(response.getEntity());
            Header[] headers = response.getAllHeaders();
            int statusCode = response.getStatusLine().getStatusCode();
            map.put("result",result);
            map.put("headers",headers);
            map.put("statusCode",statusCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
    public static Map<String,Object> post(Api api, Case cs){
       String url = api.getUrl();
       String params = cs.getParams();
       String apiType = api.getApiType();
        HttpPost httpPost = new HttpPost(url);
        Map<String,Object> map = new HashMap<String, Object>();
        getToCookie(api, httpPost);
        try {
           if("form".equals(apiType)){
              String param =  jsonToString(params);
              httpPost.setEntity(new StringEntity(param));
              httpPost.addHeader(new BasicHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8"));
           }else if("json".equals(apiType)){
               httpPost.setEntity(new StringEntity(params));
               httpPost.addHeader(new BasicHeader("Content-Type","application/json;charset=utf-8"));
           }
           CloseableHttpClient httpClient = HttpClients.createDefault();
           CloseableHttpResponse response = httpClient.execute(httpPost);
           int statusCode = response.getStatusLine().getStatusCode();
           Header[] headers = response.getAllHeaders();
           String result = EntityUtils.toString(response.getEntity());
           map.put("statusCode",statusCode);
           map.put("headers",headers);
           map.put("result",result);
       }catch (IOException e){
           e.getStackTrace();
       }
        return map;
    }

    public static void getToCookie(Api api, HttpRequest request) {
        if("1".equals(api.getIsAccessControled())){
            String cookie = (String) AuthoritionUtil.cookie.get("cookie");
            request.addHeader("Cookie",cookie);
        }
    }

    public static String jsonToString(String params){
        Map<String,Object> map = (Map<String, Object>) JSONObject.parse(params);
       Set<String> keys = map.keySet();
       StringBuffer sb = new StringBuffer();
       for(String key:keys){
           sb.append(key).append("=").append(map.get(key)).append("&");
       }
       String param = sb.substring(0,sb.lastIndexOf("&"));
       return param;
    }

    public static Map<String,Object> request(Api api,Case cases){
        if("get".equals(api.getType())){
           return   HttpUtil.get(api,cases);
        }else if("post".equals(api.getType())){
          return    HttpUtil.post(api,cases);
        }
        return null;
    }

    @Test
    public void test(Api api,Case cs){
//        String params = "{\"mobilephone\":\"18813989202\",\"pwd\":\"\"}";
//        System.out.println(jsonToString(params));


    }

}
