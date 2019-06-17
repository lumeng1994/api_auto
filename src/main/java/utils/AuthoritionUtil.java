package utils;

import org.apache.http.Header;
import pojo.Api;
import pojo.Case;

import java.util.HashMap;
import java.util.Map;

public class AuthoritionUtil {
    public static Map<String,Object> cookie = new HashMap<String, Object>();
    public static void getCookie(Api api, Case cases) {
        if("2".equals(api.getApiId())&&"1".equals(cases.getIsPositive())){
            Map<String,Object> map =  HttpUtil.request(api,cases);
            Header[] headers = (Header[]) map.get("headers");
            for(Header header:headers){
                if("Set-Cookie".equals(header.getName())&&header.getValue().contains("JSESSIONID")){
                    String[] values =  header.getValue().split(";");
                    for(String value:values){
                        if(value.contains("JSESSIONID")){
                            AuthoritionUtil.cookie.put("cookie",value);
                        }
                    }
                }
            }

        }
    }
}
