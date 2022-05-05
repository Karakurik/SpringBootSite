<#ftl encoding="UTF-8"/>
<html lang="ru">
<#import "spring.ftl" as spring/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="<@spring.url "/static/css/indexPageStyle.css"/>">
    <title>Онлайн библиотека::Регистрация</title>
</head>

<body>
<div class="main">
    <header>
        <div class="content">
            <p class="title">
                <span class="text">
                    <img class="logo"
                         src="<@spring.url "/static/images/book.jpg"/>"
                         width="77" height="77"
                         alt="Логотип">
                </span></p>
            <p class="title">Онлайн библиотека</p>
            <p style="text-align: center" class="text">Добро пожаловать в онлайн библиотеку.</p>
        </div>
    </header>
    <div class="login_div">
        <p class="title">Регистрация:</p>
        <form class="login_form" method="post">
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
                <input type="text" name="username" placeholder="Юзернейм" size="20">
            </label>
            <label class="registration-form-elem">
                <input type="password" name="password" placeholder="Пароль" size="20">
            </label>
            <label class="registration-form-elem">
                <input type="password" name="passwordRepeat" placeholder="Повторите пароль" size="20">
            </label>
            <#--        <p class="message">${message}</p>-->
            <br>
            <label class="registration-form-elem">
                <input type="submit" value="Зарегистрироваться">
            </label>
            <p class="title"><a href="<@spring.url "/login"/>">Уже есть аккаунт?</a></p>
        </form>
    </div>
</div>
<body>
