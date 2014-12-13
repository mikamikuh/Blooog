<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jsp"%>
<div class="container">
	<form class="form-horizontal" action='${action}' method="POST">
		<fieldset>
			<div id="legend">
				<legend class="">${caption}</legend>
			</div>
			<div class="control-group">
				<label class="control-label" for="title">Title</label>
				<div class="controls">
					<input type="text" id="title" name="title" placeholder=""
						class="input-xlarge">
				</div>
			</div>

			<div class="control-group">
				<label class="control-label" for="body">Body</label>
				<div class="controls">
					<textarea class="controlls" rows="5" id="body" name="body"></textarea>
				</div>
			</div>

			<div class="control-group">
				<!-- Button -->
				<div class="controls">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</fieldset>
	</form>
</div>
<%@ include file="common/footer.jsp"%>