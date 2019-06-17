package pojo;

import java.util.Map;

public class DBReslut {
    private String order;
    private Map<String,Object> result;

    public DBReslut() {
    }

    @Override
    public String toString() {
        return "DBReslut{" +
                "order='" + order + '\'' +
                ", result=" + result +
                '}';
    }

    public DBReslut(String order, Map<String, Object> result) {
        this.order = order;
        this.result = result;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
}
