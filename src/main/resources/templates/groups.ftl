<#assign title = "Groups">
<#assign path_prefix = "../../">

<#include "common/header.ftl">
<div class="container">
    <div class="row">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>View</th>
                </tr>
                </thead>
                <tbody>
            <#list group_list as group>
            <tr>
                <td>${group.id}</td>
                <td>${group.groupName}</td>
                <td><a href="groups/${group.id}">View students</a></td>
            </tr>
            </#list>
                </tbody>
            </table>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>

<#include "common/footer.ftl">