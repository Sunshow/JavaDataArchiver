package life.thr.data.archiver.core.exception;

/**
 * 统一异常, 其他自定义异常均继承
 *
 * @author qatang
 * created on 2017-01-04 13:52
 */
public class DataArchiverException extends RuntimeException {
    private static final long serialVersionUID = 9207428213606119781L;

    public DataArchiverException() {
        this("数据归档异常");
    }

    public DataArchiverException(String message) {
        super(message);
    }

    public DataArchiverException(Throwable cause) {
        super(cause);
    }

    public DataArchiverException(String message, Throwable cause) {
        super(message, cause);
    }
}
