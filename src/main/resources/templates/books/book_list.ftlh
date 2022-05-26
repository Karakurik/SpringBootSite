<#import '/spring.ftl' as spring>

<#list list as book>
    <div class="book_info">
        <div class="book_title">
            <p>${book.getName()}</p>
        </div>
        <div class="book_image">
            <#assign book=book>
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