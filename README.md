# stuweb
学生信息管理系统界面 vue+elementUi+springmvc      
这次期末实训在上次的基础上顺利了不少，学到了axios并发请求,比上次少用了vuex，用localStorage存储较多   
下次学着用react写写项目

1. NewsSSM 后台代码，需用idea运行，配置tomcat 
2. stuweb  前端代码 vue+vuex+elementUi,以下解释前端代码运行

>想法是vue-cli开启一个端口，tomcat开启一个，通过跨域请求信息，存储在数据库中

## stuweb

### Project setup
```
cd stuweb
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).

### 目录树
```js
├─stuweb
|   ├─.gitignore
|   ├─babel.config.js
|   ├─package-lock.json
|   ├─package.json
|   ├─vue.config.js
|   ├─src
|   |  ├─App.vue
|   |  ├─main.js
|   |  ├─views 
|   |  |   ├─admin.vue    //管理员主界面
|   |  |   ├─courseMsg.vue
|   |  |   ├─Login.vue
|   |  |   ├─studentCourse.vue  //课程信息
|   |  |   ├─studentGrade.vue  //成绩信息
|   |  |   ├─studentHome.vue  //学生主界面
|   |  |   └teacherHome.vue  //教师主界面
|   |  ├─util
|   |  |  └request.js
|   |  ├─store
|   |  |   ├─index.js
|   |  |   ├─admin
|   |  |   |   └index.js
|   |  ├─router
|   |  |   └index.js
|   |  ├─components
|   |  |     ├─AdminCourseMsg.vue   //课程管理
|   |  |     ├─AdminNoticeMsg.vue   //通知管理
|   |  |     ├─AdminStuMsg.vue     //学生信息管理
|   |  |     ├─AdminTeacMsg.vue //教师信息管理
|   |  |     ├─stuContent.vue
|   |  |     ├─studentMsg.vue
|   |  |     ├─stuHeader.vue
|   |  |     ├─teaHeader.vue
|   |  |     └teaMsg.vue
|   |  ├─assets
|   |  |   ├─classroom.png
|   |  |   ├─close.png
|   |  |   ├─credit.png
|   |  |   ├─dot.png
|   |  |   ├─library.jpg
|   |  |   ├─logo.jpg
|   |  |   ├─logo.png
|   |  |   ├─nami.jpg
|   |  |   ├─open.png
|   |  |   ├─search.png
|   |  |   ├─shut.png
|   |  |   ├─shut2.png
|   |  |   ├─teacher.png
|   |  |   └user.jpg
|   ├─public
|   |   ├─favicon.ico
|   |   ├─index.html
|   |   └student.png
```

#### 实现功能
1. 根据不同角色登录
2. 学生课表成绩查询，通知查看
3. 教师添加课程，管理学生成绩
4. 管理员用户管理，课程管理，通知管理

#### 项目部分截图
![登录界面](https://github.com/iiashin/student/blob/main/image/login.png)
![学生主界面](https://github.com/iiashin/student/blob/main/image/studenthome.png)
![学生课表](https://github.com/iiashin/student/blob/main/image/stucourse.png)
![教师主界面](https://github.com/iiashin/student/blob/main/image/teahome.png)
![管理员界面1](https://github.com/iiashin/student/blob/main/image/admin.png)


