<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Manager</title>
    <script src="js/app.js"></script>
</head>
<body>
    <h1>Book Manager</h1>
    <form id="bookForm">
        <input type="text" id="title" placeholder="Titre" required>
        <input type="text" id="author" placeholder="Auteur" required>
        <button type="submit">Ajouter</button>
    </form>

    <h2>Liste des livres</h2>
    <ul id="bookList"></ul>
</body>
</html>