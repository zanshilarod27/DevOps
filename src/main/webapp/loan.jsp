<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
function exportToExcel(tableID, filename = ''){
    var downloadurl;
    var dataFileType = 'application/vnd.ms-excel';
    var tableSelect = document.getElementById(tableID);
    var tableHTMLData = tableSelect.outerHTML.replace(/ /g, '%20');
    
    // Specify file name
    filename = filename?filename+'.xls':'export_excel_data.xls';
    
    // Create download link element
    downloadurl = document.createElement("a");
    
    document.body.appendChild(downloadurl);
    
    if(navigator.msSaveOrOpenBlob){
        var blob = new Blob(['\ufeff', tableHTMLData], {
            type: dataFileType
        });
        navigator.msSaveOrOpenBlob( blob, filename);
    }else{
        // Create a link to the file
        downloadurl.href = 'data:' + dataFileType + ', ' + tableHTMLData;
    
        // Setting the file name
        downloadurl.download = filename;
        
        //triggering the function
        downloadurl.click();
    }
}
</script>
</head>

<body bgcolor = "black">
<h1 align = "center"><font face = "Georgia" size = "6" color = "grey">LOAN REPAYMENT SCHEDULE</font></h1>
<h2 align = "center"><font face = "Cambria" size = "4" color = "grey"> For the loan amount: ${lamount} &pound, Annual Interest Rate: ${annrate}  % and Loan Period: ${lperiod} months</font></h2>
<table id="tblexportData" class="table" style="width:80%" border="1" cellpadding="10" align="center" bordercolor="white">
  <tr>
    <th><font face = "Georgia" size = "5" color="grey">Payment No</font></th>
    <th><font face = "Georgia" size = "5" color="grey">Payment Amount</font></th>
    <th><font face = "Georgia" size = "5" color="grey">Principal Amount Paid</font></th>
    <th><font face = "Georgia" size = "5" color="grey">Interest Amount Paid</font></th>
    <th><font face = "Georgia" size = "5" color="grey">Loan Outstanding Balance</font></th>
  </tr>
  <c:forEach items = "${listpayment}" var="list">
  <tr>
	<td align="center"><font face = "Cambria" size = "5" color="grey">${list.paynumber}</font></td>
  	<td align="center"><font face = "Cambria" size = "5" color="grey">${list.payamount}</font></td>
  	<td align="center"><font face = "Cambria" size = "5" color="grey">${list.principle}</font></td>
  	<td align="center"><font face = "Cambria" size = "5" color="grey">${list.interest}</font></td>
  	<td align="center"><font face = "Cambria" size = "5" color="grey">${list.outbal}</font></td>
  </tr> 
  </c:forEach> 
</table>
<br>
<center>
<img src="excelexport2.jpg" onclick="exportToExcel('tblexportData')" width="100" height="40"/>
</center>
</body>
</html>