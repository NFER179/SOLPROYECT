$( "#form" ).submit( function( event ){
	
	event.preventDefault()
	
	//console.log( "Submitted" )
		
	let requestLogIn = $.ajax({
		method: this.method,
		url: this.action,
		data: { 
			user: $( "#usr" ).val(),
			pass: $( "#pwd" ).val()
		 }
	})
	
	requestLogIn.done( function( msg ){
		let jsonLogin = jQuery.parseJSON( msg ) 
		if ( jsonLogin.login.success == false ){
			$( "#wellcome" ).text( jsonLogin.login.error )
		}
	} )
	
	requestLogIn.fail( function(  ){
		$( "#wellcome" ).text( "Problemas en la cominicación con el servidor, por favor comuniquese con distribuidor." )
	} )
})