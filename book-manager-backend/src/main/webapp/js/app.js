document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("bookForm");
  const list = document.getElementById("bookList");

  async function loadBooks() {
    const response = await fetch("api/books");
    const books = await response.json();
    list.innerHTML = "";
    books.forEach(book => {
      const li = document.createElement("li");
      li.textContent = `${book.title} - ${book.author}`;
      list.appendChild(li);
    });
  }

  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const book = {
      title: document.getElementById("title").value,
      author: document.getElementById("author").value
    };
    await fetch("api/books", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(book)
    });
    form.reset();
    await loadBooks();
  });

  loadBooks();
});