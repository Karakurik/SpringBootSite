document.addEventListener('DOMContentLoaded', () => {

    showImages()

    document.querySelector('#allBooks').addEventListener('click', () => {
        showAllBooks()
    })

    document.querySelector('#genreItem').addEventListener('click', () => {
        showBooksByGenre()
    })

    function showAllBooks() {
        $.ajax({
            type: "GET",
            url: "/books/genre",
            success: data => renderBooks(data),
            contentType: "text/html"
        })
    }

    function showBooksByGenre() {
        let url = "/books/genre?genre_id=" + genre.id.toString() + "&name=" + genre.name
        $.ajax({
            type: "GET",
            url: url,
            success: data => renderBooks(data),
            contentType: "text/html"
        })
    }

    document.querySelector(".nav").addEventListener("click", e => {
        if (e.target.className === 'genre') {
            update(e.target.value);
        }
    });


    function renderBooks(data) {
        let books = $('#book_list')
        books.html(data)
    }

    function showImages() {
        let id = document.querySelector('#image').id.toString()
        let url = "/showImage?id=" + id
        $.ajax({
            type: "GET",
            url: url
        })
    }
})
