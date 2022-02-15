<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Product</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
          integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css"
          integrity="sha512-NhSC1YmyruXifcj/KFRWoC561YpHpc5Jtzgvbuzx5VozKpWvQ+4nXhPdFgmx8xqexRcpAglTj9sIBWINXa8x5w=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        table, tr, td, th {
            padding: 5px;
        }
    </style>
</head>
<body>
<br>
<br>
<div class="col-lg-9 col-md-8">
    <h3>Add New Product</h3>
    <div class="card col-lg-8">
        <div class="card-body">
            <form action="/product?action=createPost" method="post">
                <table>
                    <tr>
                        <th>Name:</th>
                        <td>
                            <input type="text" name="name" size="60"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Price:</th>
                        <td>
                            <input type="text" name="price" size="60"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Quantity:</th>
                        <td>
                            <input type="text" name="quantity" size="60"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Color:</th>
                        <td>
                            <input type="text" name="color" size="60"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Description:</th>
                        <td>
                            <input type="text" name="description" size="60"/>
                        </td>
                    </tr>
                    <tr>
                        <th>Category:</th>
                        <td>
                            <select name="category">
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.getId_category()}">${category.getName_category()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="submit" class="btn btn-success">Create</button>
                            <button type="button" class="btn btn-outline-secondary" style="color: white"><a href="/product">Back</a></button>
                        </td>
                    </tr>
                    <tr>
                        <c:if test="${requestScope['check'] == true}">
                            <h5 style="color: red">Create Product Successful</h5>
                        </c:if>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
