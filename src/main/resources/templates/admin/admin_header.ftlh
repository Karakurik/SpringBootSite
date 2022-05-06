<#import '/spring.ftl' as spring>

<#macro admin_header>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: dodgerblue">
            <div>
                <a href="<@spring.url "/admin/"/>" class="navbar-brand"> Book Management App </a>
            </div>

            <ul class="navbar-nav">
                <li><a href="<@spring.url "/admin/"/>" class="nav-link">Books</a></li>
            </ul>
        </nav>
    </header>
</#macro>
