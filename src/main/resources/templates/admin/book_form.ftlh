<#import 'admin_layout.ftlh' as layout>
<#import '/spring.ftl' as spring>

<@layout.admin_layout "Админ панель">
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <#if update??>
                    <form action="<@spring.url "/admin/update"/>" method="post"/>
                </#if>
                <#if addNew??>
                    <form action="<@spring.url "/admin/insert"/>" method="post"/>
                </#if>
                <caption>
                    <h2>
                        <#if update?? >
                            Edit Book
                        </#if>
                        <#if addNew??>
                            Add New Book
                        </#if>
                    </h2>
                </caption>
                <#if update??>
                    <input type="hidden" name="id" value=${book.getId()}>
                </#if>

                <fieldset class="form-group">
                    <label>Name</label>
                    <input type="text"
                           <#if book??>value='${book.getName()}'</#if>
                           class="form-control" name="name" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Page Count</label>
                    <input type="text"
                           <#if book??>value=${book.getPageCount()}</#if>
                           class="form-control" name="page_count" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Isbn</label>
                    <input type="text"
                           <#if book??>value=${book.getIsbn()}</#if>
                           class="form-control" name="isbn">
                </fieldset>

                <fieldset class="form-group">
                    <label>Genre</label>
                    <input type="text"
                           <#if book??>value=${book.getGenre()}</#if>
                           class="form-control" name="genre">
                </fieldset>

                <fieldset class="form-group">
                    <label>Author</label>
                    <input type="text"
                           <#if book??>value=${book.getAuthor()}</#if>
                           class="form-control" name="author">
                </fieldset>

                <fieldset class="form-group">
                    <label>Publish Year</label>
                    <input type="text"
                           <#if book??>value='${book.getPublishDate()}'</#if>
                           class="form-control" name="publish_date">
                </fieldset>

                <fieldset class="form-group">
                    <label>Publisher</label>
                    <input type="text"
                           <#if book??>value=${book.getPublisher()}</#if>
                           class="form-control" name="publisher">
                </fieldset>

                <fieldset class="form-group">
                    <label>Content</label> <input type="file" name="file">
                </fieldset>

                <#if message??>
                    <p style="color: red" class="message">${message}</p>
                </#if>

                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</@layout.admin_layout>
