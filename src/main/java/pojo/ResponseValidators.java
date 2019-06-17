package pojo;

public class ResponseValidators {
    private String jsonPath;
    private String expected;

    public String getJsonPath() {
        return jsonPath;
    }

    @Override
    public String toString() {
        return "ResponseValidators{" +
                "jsonPath='" + jsonPath + '\'' +
                ", expected='" + expected + '\'' +
                '}';
    }

    public ResponseValidators() {
    }

    public ResponseValidators(String jsonPath, String expected) {
        this.jsonPath = jsonPath;
        this.expected = expected;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

    public String getExpected() {
        return expected;
    }

    public void setExpected(String expected) {
        this.expected = expected;
    }
}
