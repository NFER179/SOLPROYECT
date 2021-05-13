userTable.find( 'tbody' ).find('td').click( function(){

    frmUserDetails.toggle( 'slow', function(){
        
    } )

    let id_value = $(this).text()

    $.each( json_user_data, function( id, values ){
        $.each( values, function( id02, values02 ){
            if( values02.Id == id_value ) {
                CompleteForm( values02 )
            }
        } )
    } ) 
} )

frmUserDetails.submit( function(){

    // let nameVal = nptName.val()
    // let lastNameVal = nptLastName.val()

    console.log( 'start with post method' )

    $.ajax({
        type: frmUserDetails.attr( 'method' ),
        url: form.attr( 'action' ),
        data: form.serialize(),
        success: function( data ) {
            let result = data

            console.log( result )
        }
    })
} )

function CompleteForm( jsonArgs ){
    nptName.attr( "value", jsonArgs.FirstName )
    nptLastName.attr( "value", jsonArgs.LastName )
    frmUserDetails.toggle( 'slow' )
}