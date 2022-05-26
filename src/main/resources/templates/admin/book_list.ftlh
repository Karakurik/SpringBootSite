<#import 'admin_layout.ftlh' as layout>
<#import '/spring.ftl' as spring>

<@layout.admin_layout "Админ панель">
    <div class="row">
        <div class="container">
            <h3 class="text-center">List of Book</h3>
            <hr>
            <div class="container text-left">
                <a href="<@spring.url "/admin/new"/>" class="btn btn-success">Add New Book</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Page Count</th>
                    <th>Isbn</th>
                    <th>Genre</th>
                    <th>Author</th>
                    <th>Publish Date</th>
                    <th>Publisher</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <#list listBook as book>
                    <tr>
                        <td>${book.getId()}</td>
                        <td>${book.getName()}</td>
                        <td>${book.getPageCount()}</td>
                        <td>${book.getIsbn()}</td>
                        <td>${book.getGenre()}</td>
                        <td>${book.getAuthor()}</td>
                        <td>${book.getPublishDate()}</td>
                        <td>${book.getPublisher()}</td>
                        <td><a href="<@spring.url "/admin/edit?id=${book.getId()}"/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                            <a class="confirmation"
                               href="<@spring.url "/admin/delete?id=${book.getId()}"/>">Delete</a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@layout.admin_layout>
