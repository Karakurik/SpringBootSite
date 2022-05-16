<#import '/spring.ftl' as spring>
<#import 'books_head.ftlh' as head>
<#import 'books_header.ftlh' as header>
<#import 'left_menu.ftlh' as left_menu>
<#import 'books_footer.ftlh' as footer>

<#macro books_layout title>
    <html>
    <head>
        <@head.books_head/>
        <title>${title}</title>
    </head>
    <body>
    <div class="container">
        <@header.books_header/>
<#--        <@left_menu.left_menu/>-->
        <#nested>
        <@footer.books_footer/>
    </div>
    </body>
    </html>
</#macro>
