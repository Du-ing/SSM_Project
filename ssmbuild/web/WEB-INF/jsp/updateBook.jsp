<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <!--通过隐藏域来传递id-->
        <input type="hidden" name="bookId" value="${Qbook.bookId}">

        <div  class="form-group">
            <label for="bkname">书籍名称</label>
            <input type="text" name="bookName" id="bkname" class="form-control" value="${Qbook.bookName}" required>
        </div>
        <div  class="form-group">
            <label for="bkname">书籍数量</label>
            <input type="text" name="bookCounts" id="bkcounts" class="form-control" value="${Qbook.bookCounts}" required>
        </div>
        <div  class="form-group">
            <label for="bkname">书籍描述</label>
            <input type="text" name="detail" id="bkdetail" class="form-control" value="${Qbook.detail}" required>
        </div>
        <div  class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>
</div>
</body>
</html>
