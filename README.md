# JavaDataArchiver

## 目标

构建一个通用的数据归档中间件

- 适配多种数据源
- 适配多种归档方式

## 何时归档

当面对以下需求时，可能需要归档：

- 数据集过大影响性能，通过归档拆分冷热数据
- 将数据从一个数据源迁移/复制到另一个数据源

## 适用范围

按照特定排序条件，不会随着时间变化而发生 **排序变化** 和 **数据变化** 的数据源（数据的不可变性）

### 典型数据

- 订单类数据（完成后的订单在一段时间后不再可变）
- 日志类数据（不可变）

## 生命周期

* 初始化(initialize)

* 检验(validate)

* 处理源数据(process-sources)

* 转换(convert)

* 处理目标数据(process-destination)

* 验证(verify)

## 快速开始

### 配置数据源

在 **conf/datasource** 目录下添加 **sample_src.properties**

    datasource.jdbc.driverClassName=com.mysql.jdbc.Driver
    datasource.jdbc.url=jdbc:mysql://localhost:3306/db_sample_src?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true&zeroDateTimeBehavior=convertToNull
    datasource.jdbc.username=sample
    datasource.jdbc.password=sample
    datasource.jdbc.maxActive=10
    datasource.jdbc.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

在 **conf/datasource** 目录下添加 **sample_des.properties**

    datasource.jdbc.driverClassName=com.mysql.jdbc.Driver
    datasource.jdbc.url=jdbc:mysql://localhost:3306/db_sample_des?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true&zeroDateTimeBehavior=convertToNull
    datasource.jdbc.username=sample
    datasource.jdbc.password=sample
    datasource.jdbc.maxActive=10
    datasource.jdbc.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

### 配置归档任务

在 **conf/archiver** 目录下添加 **sample.properties**

    archiver.scanner.interval=1000
    archiver.src.datasource=sample_src
    archiver.des.datasource=sample_des
    archiver.src.table.name=sample_table_src
    archiver.des.table.name=sample_table_des

### 启动服务
