### 方案一
#### 基本思路
继承`AbstractRoutingDataSource`，重写其`protected Object determineCurrentLookupKey()`,`AbstractRoutingDataSource`在每次请求的时候都会调用`DataSource determineTargetDataSource()`来决定当前使用的数据源，在`determineTargetDataSource()`中又会调用`determineCurrentLookupKey()`来决定当前调用的key,然后从自身缓存的数据源`private Map<Object, DataSource> resolvedDataSources`选取一个做为当前数据源。
#### 实现方式
使用注解+AOP的方式，在需要多数据源的方法上增加注解标识，然后在调用此方法之前，获取方法的注解上的标识，设置当前方法执行所使用的数据源，调用之后清除标识，如果没有数据源标识则指定一个默认数据源。对于多个请求线程隔离的问题，可以使用`ThreadLocal`进行线程隔离，是线程间互不影响
，具体实现见`DataSourceRouteHolder`。
#### 主要实现类：
`DataSourceAspect`:切面，设置当前选择的数据源的key
`DynamicDataSource`:动态数据源key的获取
`RoutingConfig`:主要数据源的bean配置
`InfoServiceImpl`:实际调用的类
`MultiSource1ApplicationTests`:单测



### 方案二
#### 实现方式
注册多个`Jdbctemplate`bean,每个`Jdbctemplate`是不同的数据源，使用的时候用`@Qualifier("jdbcTemplate2")`来区分注入，从而达到使用不同数据源的效果。
#### 主要实现类
`TempleConfig`:配置类
`InfoServiceImpl`:实际调用的类
`MultiSource1ApplicationTests`:单测

### 优缺点
方案一在单个方法中只能使用一个数据源，但是使用比较方便，数据源的切换都是自动的，方案二在单个方法中可以使用多个数据源，但是要依赖于自己的调用方式。

