<#assign title = "Teacher">
<#assign path_prefix = "../../">

<#include "common/header.ftl">
<div class="container">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div>
                <h1 class="text-center">Welcome, ${teacher_name}!</h1>
            </div>
            <div>
                <h2>View groups by <a href="${teacher_id}/groups">link</a></h2>
                <h2>View tasks by <a href="/task.html">link</a></h2>
            </div>
        </div>
        <div class="col-sm-3"></div>
        <div class="tasks_list">

        </div>
        <script
                src="https://code.jquery.com/jquery-3.2.1.min.js"
                integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
                crossorigin="anonymous"></script>
        <script>
            let taskList = $(".task_list");
            $.get("/api/tasks/2", (data) => {
                for(task in data.sections) {
                    taskList.append(`
                        <div class="task">
                            <p>
                                ${task.task}
                            </p>
                        </div>
                    `);
                }
            });
        </script>
    </div>
</div>

<#include "common/footer.ftl">