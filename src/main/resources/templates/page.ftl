<!DOCTYPE html>

<html lang="en">
    <body>
        <p>Id: <strong>${page.id}</strong></p>
        <p>URI: <strong>${page.identifier}</strong></p>
        <p>Language: <strong>${language}</strong></p>

        <#assign isContainer = page.isContainerPage()?string('yes', 'no')>
        <p>Container: <strong>${isContainer}</strong></p>

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

        <hr>
        <#-- children -->

        <#if page.children?? && (page.children?size > 0)>
            <div class="children">
                <p>Children:</p>
                <#list page.children as child>
                    <p>
                        <a href="http://localhost:8080/publishedPages/${child.identifier}?language=UA">http://localhost:8080/publishedPages/${child.identifier}</a>
                    </p>
                </#list>
            </div>
        <#else>
            <div class="no-children">
                There is no children...
            </div>
        </#if>

        <hr>
        <#-- parent -->

        <#if page.parent??>
            <div class="parent">
                <p>Parent:</p>
                <a href="http://localhost:8080/publishedPages/${page.parent.identifier}?language=UA">http://localhost:8080/publishedPages/${page.parent.identifier}</a>
            </div>
        <#else>
            <div class="no-parent">
                There is no parent...
            </div>
        </#if>


    </body>
</html>