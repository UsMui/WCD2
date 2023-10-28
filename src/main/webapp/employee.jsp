<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="row">
        <div class="col-md-6">

            <h1>CREATE EMPLOYEE</h1>
            <form action="/employee-servlet" method="POST" enctype="multipart/form-data" class="mb-5">
                <div class="mb-3">
                    <label for="fullname" class="form-label">Full Name:</label>
                    <input type="text" class="form-control" id="fullname" name="fullname">
                </div>
                <div class="mb-3">
                    <label for="tel" class="form-label">Adress:</label>
                    <input type="text" class="form-control" id="tel" name="address">
                </div>
                <div class="mb-3">
                    <label for="birthday" class="form-label">Birthday:</label>
                    <input type="date" class="form-control" id="birthday" name="birthday">
                </div>
                <div class="mb-3">
                    <label for="tel" class="form-label">Position:</label>
                    <input type="text" class="form-control" id="position" name="position">
                </div>
                <div class="mb-3">
                    <label for="tel" class="form-label">Department:</label>
                    <input type="text" class="form-control" id="department" name="department">
                </div>

                <button type="submit" class="btn btn-primary">Create</button>

            </form>

            <form action="/employee-servlet" method="GET" class="d-inline">
                <button type="submit" class="btn btn-secondary">RESET</button>
            </form>

        </div>









</div>
</div>
</body>
</html>
