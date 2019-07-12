	
  $(function(){

	    $(".burrowingsBtn").on("click", (function () {

			$.ajax({
				  url: "/list-patron-books",
				  data: {
					  personId: this.value
				  },
				  success: function( result ) {
					  console.log(result);
				    $( "#books-burrowed" ).html( result );
				  }
				});

	    }));

	  });