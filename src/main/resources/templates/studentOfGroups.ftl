<#assign title = "Students Of Groups">
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
                    <th>Username</th>
                    <th>Email</th>
                    <th>Gradebook</th>
                </tr>
                </thead>
                <tbody>
            <#list student_list as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.email}</td>
                <td><a href="/view/gradebook/${user.id}">View gradebook</a></td>
            </tr>
            </#list>
                </tbody>
            </table>
        </div>
        <div class="col-sm-2"></div>
    </div>
</div>

<#include "common/footer.ftl">