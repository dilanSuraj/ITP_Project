<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<!-- The Modal -->
	<div class="modal fade" id="price_popup">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Update Payment Status</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">


					<label>Update Payment Status</label>
					
						<div class="col-sm-10">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="gridRadios"
									id="gridRadios1" value="option1" checked> <label
									class="form-check-label" for="gridRadios1"> UnPaid </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio" name="gridRadios"
									id="gridRadios2" value="option2"> <label
									class="form-check-label" for="gridRadios2"> Paid </label>
							</div>

						</div>
					
				</div>


				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Update</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>