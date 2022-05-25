<#import '/spring.ftl' as spring>
<#macro left_menu>

    <div class="sidebar1">
        <h4>Жанры:</h4>
        <ul class="nav">
            <#list genres! as genre>
                <li>
                    <a class="genre" id="genreItem"
                       href="<@spring.url "/books?genre_id=${genre.getId()}&name=${genre.getName()}"/>">${genre.getName()}</a>
                </li>
            </#list>
            <li>
                <a style="color: red" class="title" id="allBooks">ВСЕ</a>
            </li>
        </ul>
    </div>
</#macro>
