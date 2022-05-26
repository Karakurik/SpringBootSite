<#import 'layout_reg.ftlh' as layout>
<#import '/spring.ftl' as spring>

<@layout.layout_reg "Онлайн библиотека::Восстановление пароля">
    <div class="login_div">
        <p class="title">Ссылка для восстановления пароля отправлена на почту</p>
        <p class="message">${message!}</p>
    </div>
</@layout.layout_reg>
