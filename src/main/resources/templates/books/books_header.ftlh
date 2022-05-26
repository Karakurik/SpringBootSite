<#import '/spring.ftl' as spring>

<#macro books_header>
    <div class="header">
        <div class="logo">
            <img class="logo" src="<@spring.url "/static/images/book.jpg"/>" alt="Логотип" name="logo"/>
        </div>
        <div class="descr">
            <h3>
                Привет, друг! Это наша онлайн библиотека
                <#if isAdmin??>
                    <a style="color: #84bbf3" href="<@spring.url "/logout"/>">Выйти</a>
                    <br>
                    <#if isAdmin == true>
                        <a style="color: #84bbf3" href="<@spring.url "/admin/"/>">АдминПанель</a>
                    </#if>
                </#if>
            </h3>
        </div>

        <div class="search_form">
            <form name="search_form" action="<@spring.url "/books"/>" method="POST">
                <input type="text" name="searchString"
                       <#if search_string??>value=${search_string}</#if>
                       size="110"/>
                <input class="search_button" type="submit" value="Поиск" name="search_button"/>
                <select name="searchOption">
                    <option>Название</option>
                    <option>Автор</option>
                </select>
            </form>
        </div>
    </div>
</#macro>
