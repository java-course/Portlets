<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="javax.portlet.*"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<script type="text/javascript">

    function getXmlHttp(){
        var xmlhttp;
        try {
            xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (E) {
                xmlhttp = false;
            }
        }
        if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
            xmlhttp = new XMLHttpRequest();
        }
        return xmlhttp;
    }

    function callAjax(url){
       // alert('call ajax!!!');
        var xmlhttp = getXmlHttp();
        var text = document.getElementById('text').value;
        xmlhttp.open('POST', url+"&text="+text, true);
        xmlhttp.onreadystatechange = function() {
            if (xmlhttp.readyState == 4) {
                if(xmlhttp.status == 200) {
                    document.getElementById('received_text').value = xmlhttp.responseText;
                }
            }
        };
        xmlhttp.send(null);
    }

</script>


<input type="text" value="" name="text" id="text"/>
<input type="text" value="" id="received_text"/>
<input type="button" value="Call Ajax" onclick="callAjax('<portlet:resourceURL/>'); return true;"/>
