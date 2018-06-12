项目启动后访问地址: http://localhost:8080/swagger-ui.html

swagger2语法作用
@Api                 用于类                  表示标识这个类是swagger的资源
@ApiModel()          用于类                  表示对类进行说明，用于参数用实体类接收 

@ApiOperation()      用于方法；               表示一个http请求的操作
    value用于方法描述 
    notes用于提示内容 
    tags可以重新分组（视情况而用） 
    
@ApiParam()          用于方法，参数，字段说明； 表示对参数的添加元数据（说明或是否必填等） 
    name–参数名 
    value–参数说明 
    required–是否必填
    
@ApiModelProperty()  用于方法，字段           表示对model属性的说明或者数据操作更改 
    value–表示对象名 
    description–描述 
    都可省略 
    
@ApiImplicitParam()  用于方法                表示单独的请求参数
 
@ApiImplicitParams() 用于方法，              包含多个 @ApiImplicitParam
    name–参数ming 
    value–参数说明 
    dataType–数据类型 
    paramType–参数类型 
@ApiIgnore()         用于类，方法，方法参数   表示这个方法或者类被忽略 