package utils;

import org.testng.ITestContext;
import pojo.Api;
import pojo.Case;
import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static Object[][] getDataProvider(String apiId, ITestContext context) {
        List<Case> cases = cases(apiId,context);
        Api api = api(apiId,context);
       Object[][] objects = new Object[cases.size()][2];
       for(int i = 0; i < cases.size();i++){
          Case cs =  cases.get(i);
           objects[i][0] = api;
           objects[i][1] = cs;
       }
        return objects;
    }

   public static List<Case> cases(String apiId,ITestContext context){
       List<Case> lists = (List<Case>) context.getAttribute("cases");
       List<Case> cases = new ArrayList<Case>();
       for (Case cs:lists){
           if(apiId.equals(cs.getApiId())){
                cases.add(cs);
           }
       }
       return cases;
   }

   public static Api api(String apiId,ITestContext context){
       List<Api> lists = (List<Api>) context.getAttribute("apis");
       for(Api api:lists){
           if(apiId.equals(api.getApiId())){
              return api;
           }
       }
       return null;
   }
}
