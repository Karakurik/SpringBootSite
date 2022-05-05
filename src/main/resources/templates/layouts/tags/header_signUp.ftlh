<#ftl encoding="UTF-8"/>
<#import "spring.ftl" as spring/>

<#macro header_signUp>
    <header>
        <div class="content">
            <p class="title">
                <span class="text">
                    <img class="logo"
                         src="<@spring.url "/resources/images/book.jpg"/>"
                         width="77" height="77"
                         alt="Логотип">
                </span></p>
            <p class="title">Онлайн библиотека</p>
            <p style="text-align: center" class="text">Добро пожаловать в онлайн библиотеку.</p>
        </div>
    </header>
</#macro>
