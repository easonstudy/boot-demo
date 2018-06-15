启动 boot-sso      8081
     登入时保存用户信息至redis, 并存贮用户数据放在浏览器Cookie中

启动 boot-sso-test 8080
     拦截请求根据cookie值获取redis的用户信息并存贮

测试过程如下：

1:访问  http://localhost:8080/github/home 
    拦截获取Request的COOKIE值,        不存在跳转oot-sso登入界面
    根据COOKIE值 
        获取Redis的用户信息失败   不存在跳转oot-sso登入界面    
    1.1(未登入):跳转  http://localhost:8081/login?redirect=http://localhost:8080/github/home
        获取Redis的用户信息成功
    1.2(已登入):

3:跳至  http://localhost:8080/github/home 