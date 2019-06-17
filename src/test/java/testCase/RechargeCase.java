package testCase;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import utils.DataUtil;
import utils.Log;

public class RechargeCase extends BaseCase {
    @DataProvider(name = "datas")
    public Object[][] dataProvider(ITestContext context){
        Log.info("开始测试充值数据");

        return DataUtil.getDataProvider("3",context);
    }
}
