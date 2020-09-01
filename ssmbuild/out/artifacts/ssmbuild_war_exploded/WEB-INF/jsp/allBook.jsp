<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <script>
        function deleteBook(id) {
            //用户安全提示
            if(confirm("您确定要删除该书籍吗？")){
                location.href = "${pageContext.request.contextPath}/book/deletBook?id="+id;
            }
        }
    </script>
</head>
<body>
    <div class="container">
       <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>书籍列表——显示所有书籍</small>
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 column">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">所有书籍</a>
                </div>
                <div class="col-md-4 column"></div>
                <div class="col-md-4 column form-inline">
                    <form action="${pageContext.request.contextPath}/book/queryBook" method="post">
                        <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称" required>
                        <input type="submit" class="btn btn-primary" value="查询">
                    </form>
                </div>
            </div>
       </div>

        <div class="row clearfix">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <!--书籍从后端查询到的list中遍历-->
                <tbody>
                    <c:if test="${bookList.size()>0}">
                        <c:forEach begin="0" end="${bookList.size()-1}" var="i">
                            <tr>
                                <td>${i+1}</td>
                                <td>${bookList.get(i).bookName}</td>
                                <td>${bookList.get(i).bookCounts}</td>
                                <td>${bookList.get(i).detail}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${bookList.get(i).bookId}">修改</a>
                                    &nbsp;|&nbsp;
                                    <a href="javascript:deleteBook(${bookList.get(i).bookId})" >删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
