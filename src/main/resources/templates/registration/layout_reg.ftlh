<#import '/spring.ftl' as spring>
<#import 'header_reg.ftlh' as header>
<#import 'head_reg.ftlh' as head>

<#macro layout_reg title>
    <html>
    <head>
        <title>${title}</title>
        <@head.head_reg/>
    </head>
    <body>
    <div class="main">
        <@header.header_reg/>
        <#nested>
    </div>
    </body>
    </html>
</#macro>
