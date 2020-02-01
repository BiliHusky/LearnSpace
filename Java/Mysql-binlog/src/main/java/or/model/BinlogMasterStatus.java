package or.model;
public class BinlogMasterStatus {
    public String getBinlogName() {
        return binlogName;
    }

    public void setBinlogName(String binlogName) {
        this.binlogName = binlogName;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    private String binlogName;
    private long position;
    // 省略Getter和Setter
}
