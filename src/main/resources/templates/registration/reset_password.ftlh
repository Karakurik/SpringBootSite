<#import 'layout_reg.ftlh' as layout>
<#import '/spring.ftl' as spring>

<@layout.layout_reg "Онлайн библиотека::Востановление пароля">
    <div class="login_div">
        <p class="title">Восстановление пароля:</p>
        <form method="POST" action="<@spring.url "/resetPassword" />" class="login_form">
            <label class="form-elem">
                <input type="email" name="email" size="20" placeholder="Email" value="${email!}"/>
            </label>
            <p class="message">${message!}</p>
            <label class="form-elem">
                <input type="submit" value="Сбросить пароль" class="form-elem"/>
            </label>
            <p class="title"><a href="<@spring.url "/login" />">Вспомнили пароль?</a></p>
        </form>
    </div>
</@layout.layout_reg>
