<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Other Expenses</title>
</head>
<body>

<a href="Finance_Manager/Payment_Manage/AddExpenses">Add Expense</a>
<div align="center">
		<h1>Other Expenses</h1>
		
		<table border="1">

			<th>Category</th>
			<th>Amount</th>			
			<th>Date</th>
			<c:forEach var="expenses" items="${ExpensesFinanceList}">
				<tr>
					<td>${expenses.getDescription()}</td>
					<td>${expenses.getAmount()}</td>
					<td>${expenses.getPayment_date()}</td>
					<td><a href="Finance_Manager/Payment_Manage/UpdateExpenses?id=${expenses.getPayment_id()}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="Finance_Manager/Payment_Manage/DeleteExpenses?id=${expenses.getPayment_id()}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		
	</div>
	
</body>
</html>