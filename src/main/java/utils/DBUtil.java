package utils;

import com.alibaba.fastjson.JSONObject;
import pojo.Case;
import pojo.DB;
import pojo.DBReslut;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DBUtil {
   static Properties prop = new Properties();
    public static String queryValiFieds(Case cs){
        String dbvalidator = cs.getDbValidators();
        if(dbvalidator != null && dbvalidator.trim().length() > 0){
            List<DB> dbs = JSONObject.parseArray(dbvalidator, DB.class);
            Map<String,Object> map = new HashMap<String, Object>();
            List<DBReslut> lists = new ArrayList<DBReslut>();
            String order = null;
            for(DB db:dbs){
                String url = (String) prop.get("jdbc.url");
                String username = (String) prop.get("jdbc.username");
                String password = (String) prop.get("jdbc.password");
                try {
                    Connection con = DriverManager.getConnection(url,username,password);
                    order = db.getOrder();
                    String sql = db.getSql();
                    PreparedStatement statement = con.prepareStatement(sql);
                    ResultSet resultSet =  statement.executeQuery();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int cellNum = metaData.getColumnCount();
                    while (resultSet.next()){
                        for(int i = 1; i <= cellNum; i++){
                            String cellName = metaData.getColumnName(i);
                            Object obj = resultSet.getObject(i);
                            map.put(cellName,obj);
                        }
                    }
                    DBReslut dbReslut = new DBReslut(order,map);
                    lists.add(dbReslut);
                    String dbResult = JSONObject.toJSONString(lists);
                    return dbResult;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

       return null;
    }

    public static void readToMsqlConfig() {
        try {
            InputStream stream = new FileInputStream(new File("src\\main\\resources\\dbConfig\\jdbc.properties"));
            prop.load(stream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
