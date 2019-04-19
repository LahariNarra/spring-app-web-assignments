<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
        <center>
            <h1>Welcome Online Banking Application</h1>
        </center>
        <div class="row" style="background-color:lavender;">
            <a class="nav-link" href="index.jsp">Home</a>
            <a class="nav-link" href="register.jsp">Open New Account</a>
            <a class="nav-link" href="withdraw.jsp">Withdraw</a>
            <a class="nav-link" href="deposit.jsp">Deposit</a>
            <a class="nav-link" href="fund.jsp">Fund Transfer</a>
            <a class="nav-link" href="check.jsp">CheckBalance</a>
            <a class="nav-link" href="account.jsp">Display Account Details</a>
            <a class="nav-link" href="search.jsp">Search Account </a>
            <a class="nav-link" href="selete.jsp">Delete Account </a>
            <a class="nav-link" href="update.jsp">Update Account </a>
        </div>
        <center>
            <h2>New User Registration</h2>
        </center>
        <form action ="/BankAppMvc/app/bank/newaccount" method ="post">
            <label for="Name">Account Holder Name</label>
            <input type ="text" class = "form-control" name="accountHolderName"  placeholder="Enter Account Holder Name" required>
            <br>
            <label for ="Account Type">Account Type</label>
            <select name = "accountType">
                <option value ="Savings">Savings</option>
                <option value = "Current">Current</option>
            </select>
            <br>
            <label for="Balance">Account Balance</label>
            <input type ="text" class = "form-control" name="accountBalance"  placeholder="Enter Account Balance" required>
            <br>

            <button type="submit" class="btn btn-primary">Open account</button>
        </form>
        </div>
</body>
</html>