<#import 'books_layout.ftlh' as layout>
<#import '/spring.ftl' as spring>

<@layout.books_layout "Книги">
    <div class="sidebar1">
        <h4>Жанры:</h4>
        <ul class="nav">
            <#list genres! as genre>
                <li>
                    <a class="genre" href="<@spring.url "books?genre_id=${genre.getId()}&name=${genre.getName()}"/>">${genre.getName()}</a>
                </li>
            </#list>
        </ul>
    </div>

    <div class="book_list">
        <#if list?has_content >
            <h3>${RequestParameters.name!}</h3>
        <#else>
            <h3 style="color:red;">По запросу "${RequestParameters.name!}${RequestParameters.search_string!}" книги не найдены</h3>
        </#if>

        <#list list as book>
            <div class="book_info">
                <div class="book_title">
                    <p>${book.getName()}</p>
                </div>
                <div class="book_image">
                    <img src="<@spring.url "/showImage?id=${book.getId()}"/>" height="250"
                         width="190" alt="Обложка"/>
                </div>
                <div class="book_details">
                    <br><strong>ISBN:</strong> ${book.getIsbn()}
                    <br><strong>Издательство:</strong> ${book.getPublisher()}

                    <br><strong>Количество страниц:</strong> ${book.getPageCount()}
                    <br><strong>Год издания:</strong> ${book.getPublishDate()}
                    <br><strong>Автор:</strong> ${book.getAuthor()}
                    <p style="margin:10px;"><a href="<@spring.url "/readBook?id=${book.getId()}"/>">Читать</a></p>
                </div>
            </div>
        </#list>
    </div>
</@layout.books_layout>
