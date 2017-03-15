<!DOCTYPE html>

<html lang="en">
    <body>
        <h1>Page id: ${page.id}</h1>
        <div></div>
        <#assign x = "UA">
        <select selected="${x}">
            <option value="EN">EN</option>
            <option value="UA">UA</option>
        </select>
        Language = ${x}
    </body>
</html>