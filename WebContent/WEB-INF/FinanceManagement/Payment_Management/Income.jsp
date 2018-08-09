<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Other Incomes</title>
</head>
<body>
<a href="Finance_Manager/Payment_Manage/AddIncome">Add Income</a>
<div align="center">
		<h1>Other Incomes</h1>
		
		<table border="1">

			<th>Category</th>
			<th>Amount</th>			
			<th>Date</th>
			<c:forEach var="income" items="${IncomeFinanceList}">
				<tr>
					<td>${income.getDescription()}</td>
					<td>${income.getAmount()}</td>
					<td>${income.getPayment_date()}</td>
					<td><a href="Finance_Manager/Payment_Manage/UpdateIncome?id=${income.getPayment_id()}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="Finance_Manager/Payment_Manage/DeleteIncome?id=${income.getPayment_id()}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		
	</div>
	
</body>
</html>