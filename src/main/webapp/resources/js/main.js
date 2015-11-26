$(document).ready(function() {
	var CONTEXT_ROOT = "/familydoctor/";

	changeSpecialization = function() {
		var spec = $("#specialization").val();

		var options = "<option value='0'>-- Select doctor --</option>";
		if (spec == "") {
			$("#doctor").empty().append(options);
			return;
		}

		$.ajax({
			url : CONTEXT_ROOT + "specializations/" + spec,
			type : "GET",
			dataType : "json",
			contentType : 'application/json; charset=utf-8',
			success : function(response) {
				
				$.each(response, function(index, value) {
					options += "<option value='" + index + "'>"
							+ value + "</options>";
				});

				$("#doctor").empty().append(options);
			},
			error : function() {
				console.log("Error while request..")
			}
		});
	}
});