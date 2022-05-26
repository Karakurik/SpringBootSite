<#import 'books_layout.ftlh' as layout>
<#import '/spring.ftl' as spring>
<#import 'book_list.ftlh' as books>

<@layout.books_layout "Книги">
    <div class="book_list" id="book_list">
        <#if isBooksExists?? && isBooksExists = true >
            <h3>${RequestParameters.name!}</h3>
        <#else>
            <h3 style="color:red;">По запросу "${RequestParameters.name!}${RequestParameters.search_string!}" книги не
                найдены</h3>
            <h3>Мы рекомендуем вам прочитать эти книги</h3>
        </#if>

        <#list list as book>
            <div class="book_info">
                <div class="book_title">
                    <p>${book.getName()}</p>
                </div>
                <div class="book_image">
                    <img id="image" src="<@spring.url "/showImage?id=${book.getId()}"/>" height="250"
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
