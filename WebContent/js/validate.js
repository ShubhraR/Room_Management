
function validate(form) 
{
	var associateId = document.welcomeForm.Aid.value;
	var associateId = form.Aid.value;
	var email = form.eid.value;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if(associateId==""||email==""||form.date.value==""||form.slot.value==""||form.location.value==""||form.capacity.value=="")
	{
			alert("All fields are mandatory!");
			//form.Aid.focus();
			return false;
	}
	else if(associateId.value.length != 8) 
	{
			alert("Check the  Asociate id!!");
			form.Aid.value = "";
			form.Aid.focus();
			return false;
	}
	

	/*if(email.match(mailformat))
		{
		form.eid.focus();
		return true;
		}
		else
		{ 
		alert("Invalid email address!!");
		form.eid.focus();
		return false;
		}*/
	else
		{
	return true;
		}
}
		
		