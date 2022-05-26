<#import '/spring.ftl' as spring>
<#import '../books/books_header.ftlh' as header>

<#macro books_layout title>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link href="<@spring.url "/static/css/mainPageStyle.css"/>" rel="stylesheet" type="text/css">
        <title>${title}</title>
    </head>
    <body>
    <div class="container">
        <div class="header">
            <div class="logo">
                <img class="logo" src="<@spring.url "/static/images/book.jpg"/>" alt="Логотип" name="logo"/>
            </div>
            <div class="descr">
                <h3>
                    Привет, друг! Это наша онлайн библиотека
                </h3>
                <p class="title">
                    <a href="<@spring.url "/books"/>">Перейти к книгам</a>
                </p>
            </div>
        </div>
        <#nested>
    </div>
    </body>
    </html>
</#macro>
