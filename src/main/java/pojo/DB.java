package pojo;

public class DB {
    private String order;
    private String sql;

    public String getOrder() {
        return order;
    }

    public DB() {
    }

    @Override
    public String toString() {
        return "DB{" +
                "order='" + order + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }

    public DB(String order, String sql) {
        this.order = order;
        this.sql = sql;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
