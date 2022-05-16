<#import '/spring.ftl' as spring>
<#macro left_menu>
    <div class="sidebar1">
        <h4>Жанры:</h4>
        <ul class="nav">
            <#list genreService.getGenreList() as genre>
                <li>
                    <a href="<@spring.url "books?genre_id=${genre.getId()}&name=${genre.getName()}"/>">${genre.getName()}</a>
                </li>
            </#list>
        </ul>
    </div>
</#macro>
