<#import 'layout_reg.ftlh' as layout>
<#import '/spring.ftl' as spring>

<@layout.layout_reg "Онлайн библиотека::Вход">
    <div class="login_div">
        <p class="title">Вход:</p>
        <form method="POST" action="<@spring.url "/login" />" class="login_form">
            <label class="form-elem">
                <input type="email" name="email" size="20" placeholder="Email" value="${email!}"/>
            </label>
            <label class="form-elem">
                <input type="password" name="password" value="" size="20" placeholder="Пароль"/>
            </label>
            <p class="message">${message!}</p>
            <label class="form-elem">
                <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня
            </label>
            <label class="form-elem">
                <input type="submit" value="Войти" class="form-elem"/>
            </label>
            <p class="title"><a href="<@spring.url "/signUp" />">Создать аккаунт?</a></p>
            <p class="title"><a href="<@spring.url "/resetPassword" />">Забыли пароль?</a></p>
        </form>
    </div>
</@layout.layout_reg>
