package life.thr.data.archiver.core.lifecycle;

import life.thr.data.archiver.core.exception.DataArchiverException;

/**
 * 数据归档生命周期接口
 *
 * @author qatang
 * created on 2017-01-04 13:49
 */
public interface DataArchiverLifecycle {

    /**
     * 执行生命周期
     * @throws DataArchiverException 数据归档异常
     */
    void execute() throws DataArchiverException;
}
