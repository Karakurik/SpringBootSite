<#import 'admin_header.ftlh' as header>
<#import '/spring.ftl' as spring>

<#macro admin_layout title>
    <html>
    <head>
        <title>${title}</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <script type="text/javascript" src="<@spring.url "static/js/confirm.js"/>"></script>
    </head>
    <body>
    <@header.admin_header/>
    <#nested>
    </body>
    </html>
</#macro>
