<!DOCTYPE html>

<html lang="en">
    <head>
        <link href="/css/style.css" rel="stylesheet" />
    </head>
    <body>
        <div class="general-information">
            <p class="general-information-item">Id: <strong>${page.id}</strong></p>
            <p class="general-information-item">URI: <strong>${page.identifier}</strong></p>
            <p class="general-information-item">Language: <strong>${language}</strong></p>

            <#assign isContainer = page.isContainerPage()?string('yes', 'no')>
            <p class="general-information-item">Container: <strong>${isContainer}</strong></p>
        </div>

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
                    <div class="child">
                        <a href="http://localhost:8080/publishedPages/${child.identifier}?language=${language}">/publishedPages/${child.identifier}</a>
                        <p class="child-id">id: ${child.id}</p>
                        <div class="content">
                            <#list child.localisedPages as k, v>
                                <#if k == language>
                                    <h5>${v.title}</h5>
                                    <div>${v.content}</div>
                                </#if>
                            </#list>
                        </div>
                    </div>
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