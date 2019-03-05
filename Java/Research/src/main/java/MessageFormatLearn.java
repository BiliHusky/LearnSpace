import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by yjw on 19-3-5.
 */
public class MessageFormatLearn {
    public static enum ErrorCode {
        ERROR_CODE01("Dir {0} not exist"),
        ERROR_CODE02("File {0} not exist");

        private String msg;
        private ErrorCode(String msg) {
            this.msg = msg;
        }

        public String getTemplate() {
            return msg;
        }
    }

    public static void main(String[] args) {
        String file = "/file1";
        System.out.println(MessageFormat.format(ErrorCode.ERROR_CODE01.getTemplate(), file));
    }
}
