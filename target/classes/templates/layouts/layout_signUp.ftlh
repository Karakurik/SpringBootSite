
<head>
    <title>${title}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="<spr"/resources/css/indexPageStyle.css"/>">
</head>
<body>
<div class="main">
    <#import "tags/header_signUp.ftlh" as header_signUp>
    <@header_signUp.header_signUp />
    <t:header_reg/>
    <jsp:doBody/>
</div>
</body>
</html>
