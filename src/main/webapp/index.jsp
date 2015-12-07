<!DOCTYPE html>
<%
    String url = request.getRequestURL().toString();
%>
<html>
    <head>
        <title>lapps-soap-restifier</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>A sample LAPPS-SOAP restifier webservice</h1>

        <p>You can test the service using curl or wget as follows:</p>
        <ul>
            <li>Download the provided <a href="input.json">input file</a></li>
            <li>Run curl: 
                <p>
                    <code> curl -H GET <%=url%>soap/getMetadata?endpoint=http://vassar.lappsgrid.org/invoker/anc:stanford.tagger_2.0.0</code>
                </p>
                <p>
                    <code> curl -H 'content-type: text/json' --data-binary @input.json -X POST <%=url%>soap/execute?endpoint=http://vassar.lappsgrid.org/invoker/anc:stanford.tokenizer_2.0.0</code>
                </p>
            </li>

        </ul>
    </body>
</html>
