package pojo;

public class Api {
    private String apiId;
    private String apiName;
    private String type;
    private String apiType;
    private String url;

    @Override
    public String toString() {
        return "Api{" +
                "apiId='" + apiId + '\'' +
                ", apiName='" + apiName + '\'' +
                ", type='" + type + '\'' +
                ", apiType='" + apiType + '\'' +
                ", url='" + url + '\'' +
                ", isAccessControled='" + isAccessControled + '\'' +
                '}';
    }

    public Api() {
    }

    public Api(String apiId, String apiName, String type, String apiType, String url, String isAccessControled) {
        this.apiId = apiId;
        this.apiName = apiName;
        this.type = type;
        this.apiType = apiType;
        this.url = url;
        this.isAccessControled = isAccessControled;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApiType() {
        return apiType;
    }

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIsAccessControled() {
        return isAccessControled;
    }

    public void setIsAccessControled(String isAccessControled) {
        this.isAccessControled = isAccessControled;
    }

    private String isAccessControled;
}
