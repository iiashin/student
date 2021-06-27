<%--
  Created by IntelliJ IDEA.
  User: 3T001
  Date: 2021/5/17
  Time: 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<style>
    video{
        height: 100px;
        width: 500px;
    }
</style>
<body>
<%--<h2><a href="${pageContext.request.contextPath}/allBooks">显示所有书籍</a> </h2>--%>
<%--<form action="insertStu">--%>
    <%--id:<input type="text" name="id"/>--%>
    <%--<br>--%>
    <%--t_name:<input type="text" name="t_name"/>--%>
    <%--<br>--%>
    <%--balance:<input type="text" name="balance"/>--%>
    <%--<br>--%>
    <%--gender:<input type="text" name="gender"/>--%>
    <%--<br>--%>
    <%--age:<input type="text" name="age"/>--%>
    <%--<br>--%>
    <%--<button>提交</button>--%>
<%--</form>--%>
<%--<hr/>--%>
<%--<form action="deleteStu">--%>
    <%--请输入删除id:<input type="text" name="id">--%>
    <%--<button>删除</button>--%>
<%--</form>--%>
<%--<hr>--%>
<%--<form action="updateStu">--%>
    <%--<a href=""--%>
       <%--请输入更新的id:<input type="text" name="id" />--%>
    <%--请输入更换的名字:<input type="text" name="t_name" />--%>
    <%--<button>更换</button>--%>
<%--</form>--%>
<%--<hr>--%>
<%--<form action="selStuById">--%>
    <%--请输入查找的id:<input type="text" name="id">--%>
    <%--<button>查找</button>--%>
<%--</form>--%>
<%--<hr>--%>
<%--<form action="selAllStu">--%>
    <%--<button>查找所有用户</button>--%>
<%--</form>--%>
<%--<img src=""/>--%>
<%--<button onclick=" download('https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2496571732,442429806&fm=26&gp=0.jpg')">点击</button>--%>
<button onclick="ajaxTest()">点击</button>
<form method="post" enctype="multipart/form-data" action="uploadPic">
    <input type="file" name="pic">
    <input type="text" name="user">
    <button>提交</button>
</form>
<a href="selCourseMsgByStuId?stu_id=18002&&term=1">测试课程</a>
<a href="selAllStu">所有学生</a>
<a href="selStuMsgByStuId?stu_id=18002">测试学生信息</a>

<%--<video controls="controls" autoplay="autoplay">--%>
    <%--your browser does not support the video tag--%>
    <%--<source src="http://localhost:8976/NewsSSM/bca02bfe-14e5-4349-8e4f-e9270d8367e3.mp4" type="video/mp4" />--%>
<%--</video>--%>
<form method="post" action="teacLogin">
    <input type="text" name="teac_id"/>
    <input type="text" name="password"/>
    <input type="submit"/>
</form>
</body>
<script>
    function ajaxTest() {
        var xmlhttp;
        if (window.XMLHttpRequest)
        {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp=new XMLHttpRequest();
        }
        else
        {// code for IE6, IE5
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function()
        {
            if (xmlhttp.readyState==4 && xmlhttp.status==200)
            {
                console.log(JSON.parse(xmlhttp.responseText));
            }
        }
        xmlhttp.open("GET","selAllStu",true);
        xmlhttp.send();

    }
    // function download(url){
    //     const xhr=new XMLHttpRequest();
    //     xhr.open('GET',url);
    //     xhr.responseType='blob';
    //     xhr.send();
    //     xhr.onload=function(){
    //         const fileBlob=xhr.response;
    //         console.log(fileBlob);
    //         //将blob转成url地址
    //         const fileUrl=URL.createObjectURL(fileBlob);
    //         console.log(fileUrl);
    //         document.querySelector('img').setAttribute('src',fileUrl);
    //     }
    // }
</script>
</html>
