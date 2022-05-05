<#import 'layout_reg.ftlh' as layout>
<#import '/spring.ftl' as spring>

<@layout.layout_reg "Онлайн библиотека::Регистрация">
    <div class="login_div">
        <p class="title">Регистрация:</p>
        <form method="post" action="<@spring.url "/signUp"/>" class="login_form">
            <label class="registration-form-elem">
                <input type="text" name="firstName" placeholder="Имя" size="20">
            </label>
            <label class="registration-form-elem">
                <input type="text" name="lastName" placeholder="Фамилия" size="20">
            </label>
            <label class="registration-form-elem">
                <input type="email" name="email" placeholder="Email" size="20">
            </label>
            <label class="registration-form-elem">
                <input type="password" name="password" placeholder="Пароль" size="20">
            </label>
            <label class="registration-form-elem">
                <input type="password" name="passwordRepeat" placeholder="Повторите пароль" size="20">
            </label>
<#--            <p class="message">${message}</p>-->
            <br>
            <label class="registration-form-elem">
                <input type="submit" value="Зарегистрироваться">
            </label>
<#--            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">-->
            <p class="title"><a href="<@spring.url "/login"/>">Уже есть аккаунт?</a></p>
        </form>
    </div>
</@layout.layout_reg>
