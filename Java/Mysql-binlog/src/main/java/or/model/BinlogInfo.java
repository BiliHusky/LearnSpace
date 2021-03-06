package or.model;
public class BinlogInfo {
    public BinlogInfo(String binlogName, Long fileSize) {
        this.binlogName = binlogName;
        this.fileSize = fileSize;
    }

    public String getBinlogName() {
        return binlogName;
    }

    public void setBinlogName(String binlogName) {
        this.binlogName = binlogName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    private String binlogName;
    private Long fileSize;
    // 省略Getter和Setter
}

