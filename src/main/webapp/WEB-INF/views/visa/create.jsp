<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create visa</title>
</head>

<body>
    <form action="${pageContext.request.contextPath}/visa" method="post">
        <ul>
            <li>
                <label for="nom">Nom</label>
                <input type="text" id="nom" name="nom">
            </li>
            <li>
                <label for="prenom">Prenom</label>
                <input type="text" id="prenom" name="prenom">
            </li>
            <li>
                <label for="date_naissance">Date de naissance</label>
                <input type="date" id="date_naissance" name="date_naissance">
            </li>
            <li>
                <label for="lieu_naissance">Lieu de naissance</label>
                <input type="text" id="lieu_naissance" name="lieu_naissance">
            </li>
            <li>
                <label for="situation_familiale">Situation familiale</label>
                <select name="situation_familiale" id="situation_familiale">
                    <option value="mariee">mariee</option>
                    <option value="celibataire">celibataire</option>
                </select>
            </li>
            <li>
                <label for="ancienne_adresse">Ancienne adresse</label>
                <input type="text" id="ancienne_adresse" name="ancienne_adresse">
            </li>
            <li>
                <label for="adresse_actuelle">Adresse actuelle</label>
                <input type="text" id="adresse_actuelle" name="adresse_actuelle">
            </li>
            <li>
                <label for="nationalite">Nationalite</label>
                <input type="text" id="nationalite" name="nationalite">
            </li>
            <li>
                <label for="profession">Profession</label>
                <input type="text" id="profession" name="profession">
            </li>
            <li>
                <button type="submit">Creer visa</button>
            </li>
        </ul>
    </form>
</body>

</html>
