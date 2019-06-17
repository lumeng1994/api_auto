package pojo;

public class Case {
    private String caseId;
    private String desc;
    private String apiId;
    private String params;
    private String isPositive;
    private String responseValidators;
    private String actualResponseData;
    private String responseValidationResult;
    private String dbValidators;
    private String queryResultBefore;
    private String queryResultAfter;

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Case{" +
                "caseId='" + caseId + '\'' +
                ", desc='" + desc + '\'' +
                ", apiId='" + apiId + '\'' +
                ", params='" + params + '\'' +
                ", isPositive='" + isPositive + '\'' +
                ", responseValidators='" + responseValidators + '\'' +
                ", actualResponseData='" + actualResponseData + '\'' +
                ", responseValidationResult='" + responseValidationResult + '\'' +
                ", dbValidators='" + dbValidators + '\'' +
                ", queryResultBefore='" + queryResultBefore + '\'' +
                ", queryResultAfter='" + queryResultAfter + '\'' +
                '}';
    }

    public String getIsPositive() {
        return isPositive;
    }

    public Case(String caseId, String desc, String apiId, String params, String isPositive, String responseValidators, String actualResponseData, String responseValidationResult, String dbValidators, String queryResultBefore, String queryResultAfter) {
        this.caseId = caseId;
        this.desc = desc;
        this.apiId = apiId;
        this.params = params;
        this.isPositive = isPositive;
        this.responseValidators = responseValidators;
        this.actualResponseData = actualResponseData;
        this.responseValidationResult = responseValidationResult;
        this.dbValidators = dbValidators;
        this.queryResultBefore = queryResultBefore;
        this.queryResultAfter = queryResultAfter;
    }

    public void setIsPositive(String isPositive) {
        this.isPositive = isPositive;
    }

    public Case() {
    }

    public String getResponseValidators() {
        return responseValidators;
    }

    public void setResponseValidators(String responseValidators) {
        this.responseValidators = responseValidators;
    }

    public String getActualResponseData() {
        return actualResponseData;
    }

    public void setActualResponseData(String actualResponseData) {
        this.actualResponseData = actualResponseData;
    }

    public String getResponseValidationResult() {
        return responseValidationResult;
    }

    public void setResponseValidationResult(String responseValidationResult) {
        this.responseValidationResult = responseValidationResult;
    }

    public String getDbValidators() {
        return dbValidators;
    }

    public void setDbValidators(String dbValidators) {
        this.dbValidators = dbValidators;
    }

    public String getQueryResultBefore() {
        return queryResultBefore;
    }

    public void setQueryResultBefore(String queryResultBefore) {
        this.queryResultBefore = queryResultBefore;
    }

    public String getQueryResultAfter() {
        return queryResultAfter;
    }

    public void setQueryResultAfter(String queryResultAfter) {
        this.queryResultAfter = queryResultAfter;
    }
}
