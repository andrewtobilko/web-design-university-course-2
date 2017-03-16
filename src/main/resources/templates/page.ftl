<!DOCTYPE html>

<html lang="en">
    <body>
        <p>Id: <strong>${page.id}</strong></p>
        <p>URI: <strong>${page.identifier}</strong></p>
        <p>Language: <strong>${language}</strong></p>

        <hr>

        <#if localisedPage??>
            <div class="content">
                <h1>${localisedPage.title}</h1>
                <div>
                ${localisedPage.content}
                </div>
            </div>
        <#else>
            <div class="no-content">
                The page exists, but there is no content for the given language...
            </div>
        </#if>

    </body>
</html>