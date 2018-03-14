# manage-life-of-student

### 登录
http:101.132.185.161:8085/api/index/login

    {
        "number":92 //学号
        "password":123456 //默认密码
    }
### 添加今日任务
http:101.132.185.161:8085/api/task/addTodayTask

    {
        "userid":95
        "content": //任务内容
    }
### 查询任务
http:101.132.185.161:8085/api/task/queryTodayTask

    {
        "id":95  //用户id
    }
### 完成任务
http:101.132.185.161:8085/api/task/finishTodayTask

    {
        "id": 1//任务的id
        "userid": 92 
    }
### 删除任务
http:101.132.185.161:8085/api/task/deleteTodayTask

    {
        "id": 1 //任务的id
    }
### 查看今日进度
http:101.132.185.161:8085/api/task/queryCompletion

    {
        "id": 95 //用户id
    }
### 查看本周完成率
http:101.132.185.161:8085/api/week/queryWeekCompletion

    {
        user_id: 95
    }
### 查看好友今日进度
http:101.132.185.161:8085/api/schedule/querySchedule

    {
        number: 92  //模糊查询
    }
### 更改个人信息
http:101.132.185.161:8085/api/index/updateUser

    {
        number: 92
        password:
        phone:
        email:
    }
### 是否开启邮箱通知
http:101.132.185.161:8085/api/index/updateUser

    {
        number: 92
        type: 1//0表示不开启1表示开启
    }
### 查看账户信息
http:101.132.185.161:8085/api/index/findUserInfo

    {
        "id":92
    }
### 查看全部好友
http:101.132.185.161:8085/api/index/findAllUser

    {
        无
    }
### 通过具体id查找
http:101.132.185.161:8085/api/index/findUserInfo

    {
        id:
    }
    
### 添加动态内容 
http:101.132.185.161:8085/api/wall/add
    
    {
        userid:
        content:
    }
###  查找动态内容   
http:101.132.185.161:8085/api/wall/findAllWall

    {
        //无
    }
### 生成短信验证码    
101.132.185.161:8085/api/user/generCode

    {
        "phone":
    }
    
### 更新/绑定手机号
101.132.185.161:8085/api/user/updatephone

    {
        "id":,
        "phone":,
        "code":
    }
    
### 图片上传
101.132.185.161:8085/api/upload/image

    {
        "file":
        id:""
    }
    
### 文件上传
101.132.185.161:8085/api/upload/file

    {
        "file":
        id:""
    }
### 图片目录
101.132.185.161:8085/api/upload/findimage

    {
        "id":
    }
   
#### 文件目录
101.132.185.161:8085/api/upload/findfile

    {
        "id":
    }
