<#import 'layout_reg.ftlh' as layout>
<#import '/spring.ftl' as spring>

<@layout.layout_reg "Онлайн библиотека::Востановление пароля">
    <div class="login_div">
        <p class="title">Введите новый пароль</p>
        <form method="POST" action="<@spring.url "/changePassword" />" class="login_form">
            <label style="display: none" class="form-elem">
                <input name="token" placeholder="Token" size="20" type="text" value="${token!}"/>
            </label>
            <label class="form-elem">
                <input type="password" name="password" value="" size="20" placeholder="Пароль"/>
            </label>
            <p class="message">${message!}</p>
            <label class="form-elem">
                <input type="submit" value="Подтвердить" class="form-elem"/>
            </label>
        </form>
    </div>
</@layout.layout_reg>
