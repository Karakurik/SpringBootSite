document.addEventListener('DOMContentLoaded', () => {

    document.querySelector(".nav").addEventListener("click", e => {
        if (e.target.className === 'genre') {
            update(e.target.value);
        }
    });

    function update(genre) {
        let urlString = "books?id=" + genre.id + "&name=" + genre.name + "&js=true"

        this.ajax(
            {
                type: "GET",
                url: urlString,
                success: function (data) {
                    let books = document.querySelector(".book_list")
                    books.empty()
                    books.append(data)
                }
            }
        )
    }
})
