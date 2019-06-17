package pojo;

public class WriteToExcel {
    private String caseId;
    private String cellName;
    private String valiResult;

    @Override
    public String toString() {
        return "WriteToExcel{" +
                "caseId='" + caseId + '\'' +
                ", cellName='" + cellName + '\'' +
                ", valiResult='" + valiResult + '\'' +
                '}';
    }

    public WriteToExcel(String caseId, String cellName, String valiResult) {
        this.caseId = caseId;
        this.cellName = cellName;
        this.valiResult = valiResult;
    }

    public WriteToExcel() {
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getValiResult() {
        return valiResult;
    }

    public void setValiResult(String valiResult) {
        this.valiResult = valiResult;
    }
}
