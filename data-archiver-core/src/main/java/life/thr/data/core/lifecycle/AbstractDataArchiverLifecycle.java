package life.thr.data.core.lifecycle;

import life.thr.data.core.bean.DataDestinationBean;
import life.thr.data.core.bean.DataSourceBean;
import life.thr.data.core.exception.DataArchiverException;

/**
 * @author qatang
 * @since 2017-01-04 14:25
 */
public abstract class AbstractDataArchiverLifecycle implements DataArchiverLifecycle {

    @Override
    public void execute() throws DataArchiverException {
        initialize();

        DataSourceBean dataSourceBean = read();

        dataSourceBean = assemble(dataSourceBean);

        DataDestinationBean dataDestinationBean = convert(dataSourceBean);

        process(dataDestinationBean);

        finalize(dataSourceBean,dataDestinationBean);
    }

    /**
     * 初始化
     * @throws DataArchiverException 数据归档异常
     */
    protected abstract void initialize() throws DataArchiverException;

    /**
     * 读取源数据
     * @return 源数据对象
     * @throws DataArchiverException 数据归档异常
     */
    protected abstract DataSourceBean read() throws DataArchiverException;

    /**
     * 拼装源数据
     * @param dataSourceBean 源数据对象
     * @return 拼接完的源数据对象
     * @throws DataArchiverException 数据归档异常
     */
    protected abstract DataSourceBean assemble(DataSourceBean dataSourceBean) throws DataArchiverException;

    /**
     * 数据转换
     * @param dataSourceBean 源数据对象
     * @return 目标数据对象
     * @throws DataArchiverException 数据归档异常
     */
    protected abstract DataDestinationBean convert(DataSourceBean dataSourceBean) throws DataArchiverException;

    /**
     * 处理目标数据
     * @param dataDestinationBean 目标数据对象
     * @throws DataArchiverException 数据归档异常
     */
    protected abstract void process(DataDestinationBean dataDestinationBean) throws DataArchiverException;

    /**
     * 归档完成
     * @param dataSourceBean 源数据对象
     * @param dataDestinationBean 目标数据对象
     * @throws DataArchiverException 数据归档异常
     */
    protected abstract void finalize(DataSourceBean dataSourceBean, DataDestinationBean dataDestinationBean) throws DataArchiverException;
}
