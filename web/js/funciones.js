$(documento).ready(function(){
    $("tr #btnDelete").click()(function(){
        var idp=$(this).parent().find("#idp").val();
        eliminar(idp);
        
});
    
    function eliminar(idp){
        var url="controlador?accion=delete";
        $.ajax({
                type: 'POST',
                url: url,
                data: "idp ="+idp,
                succes: function(data,textStatus, jqXHR){
                    alert("Registro eliminado!");
                }
        })
    } //$(" tr #Cantidad").click(function(){
      /// var idp=$(this).parent().find("#idpro").va;
      //* var cantidad=$(this).parent().find("#Cantidad").val();
       //var url= "cont?accion=ActualizarCantidad";
       //$.ajax({
          // type='POST',
          //* url:url,
          // data: "idp="+idp+"$Cantidad"+ cantidad,
          // succes: function (data, textStatus, jqXHR){
                //location.href="controlador?accion=carrito" ;   
          // }
           
      // });
       
    //});
});

