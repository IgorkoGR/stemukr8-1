<#assign title = "Tasks">
<#assign path_prefix = "../../">

<#include "common/header.ftl">
<div class="container">
        <#list listTasks as task>
            <tr>
                <td>${task.id}</td>
                <td>${task.taskTitle}</td>
                <td>${task.task}</td>
            </tr>
        </#list>
</div>

<#include "common/footer.ftl">