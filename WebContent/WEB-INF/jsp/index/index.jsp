<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pedido</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.3/jquery.min.js"></script>
	
<script type="text/javascript">
function numberFormat(texto) {
	return texto.replace(/\D/g,'');
}

function decimalMask(elemento, precisao) {
	var valor = elemento.value;
	valor = numberFormat(valor);
	if (valor.length > 0) {
		var parte1 = '';
		var parte2 = '';
		if (valor.length > precisao) {
			parte1 = valor.substring(0,valor.length-precisao);
			parte2 = valor.substring(valor.length-precisao,valor.length);
		} else {
			parte1 = '0';
			parte2 = valor.substring(0,valor.length);
		}
		while (parte2.length < precisao) {
			parte2 = '0'+parte2;
		}
		parte1 = parte1 - 0;
		parte1 = '' + parte1;
		if (parte1.length > 3) {
			var milhar = '';
			for (i=parte1.length;i>0;){
				if (milhar.length > 0) {
					milhar = '.' + milhar;
				}
				milhar = parte1.substring(i-3,i) + milhar;
				i = i-3;
			}
			parte1 = milhar;
		}
		var valorFinal = '';
		valorFinal = parte1;
		if (parte2.length > 0) {
			valorFinal = valorFinal + ',' + parte2;
		}
		elemento.value = valorFinal;
	} else {
		elemento.value = '';
	}
}

function dateMask(elemento) {
	var valor = elemento.value;
	valor = numberFormat(valor);
	var parte1 = '';
	var parte2 = '';
	var parte3 = '';
	if (valor.length < 2) {
		parte1 = valor.substring(0,valor.length);
	} else {
		parte1 = valor.substring(0,2);
	}
	if (valor.length < 4) {
		parte2 = valor.substring(2,valor.length);
	} else {
		parte2 = valor.substring(2,4);
	}
	if (valor.length < 8) {
		parte3 = valor.substring(4,valor.length);
	} else {
		parte3 = valor.substring(4,8);
	}
	var valorFinal = '';
	if (parte1.length > 0) {
		valorFinal = parte1;
	}
	if (parte2.length > 0) {
		valorFinal += '/' + parte2;
	}
	if (parte3.length > 0) {
		valorFinal += '/' + parte3;
	}
	elemento.value = valorFinal;
}

</script>
	
	
<script type="text/javascript">
$(function(){
	
	$('#mais').click(function(){
		
		var next = $('#lista tbody').children('tr').length + 1;
		
		$('#lista tbody').append('<tr>' + 
        	'<td><input type="text" name="nome"  /></td>' + 
            '<td><input type="text" name="qtd" style="text-align:right" id="qtd"/></td>' +
            '<td><input type="text" name="valorUnitario" style="text-align:right" onkeyup="decimalMask(this,2);" onblur="decimalMask(this,2);" /></td>' +
        '</tr>');
		
		$(':hidden').val(next);
		
		
		return false;
	});
	
	
	$(':text').live('focus',function(){
		$(this).closest('tr').addClass('input-focus');
	}).live('blur',function(){
		$(this).closest('tr').removeClass();
	});
});

</script>

</head>
<body>

	<form action="pedido/cadastra" onSubmit="return valida(this);" >
		<table>
			<thead>
				<tr>
					<td>
						<h3>Cadastro de Pedido</h3>
					</td>
				</tr>
				<tr>
					<td><label for="nomeInput">Nome do Cliente: </label></td>
					<td><input type="text" name="p.cliente" id="nomeInput"
						maxlength="200" size="50"></td>
				</tr>
				<tr>
					<td><label for="dataInput">Data: </label></td>
					<td><input type="text" name="p.data" id="dataInput" maxlength="10" onkeyup="dateMask(this);" onblur="dateMask(this);" style="text-align:right" ></td>
				</tr>
			</thead>
			</table>
			<table id="lista">
			
			<tbody>
				<tr>
					<td><label> Item </label></td>
					<td><label> Quantidade </label></td>
					<td><label> Valor Unitário </label></td>
				</tr>
			
				<tr>
					<td><input type="text" name="nome" ></td>
					<td><input type="text" name="qtd" style="text-align:right" id="qtd"></td>
					<td><input type="text" name="valorUnitario" style="text-align:right" onkeyup="decimalMask(this,2);" onblur="decimalMask(this,2);"></td>
				</tr>

			</tbody>
		</table>

		
		<input type="submit" value="Cadastrar" id="enviar">
		<input type="button" value="Adicionar Novo Item" name="add_input" id="mais">  
		


	</form>





</body>
</html>