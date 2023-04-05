# Sprint Management

## User Instructions

default password : 12345678 for all users
And Users are : Admin, Shaon, Muhaimen, Sourav

## Table Design

<pre>
+------------------------+  +--------------------------+  +--------------------------+
|          tasks         |  |         sprints          |  |        projects          |
+------------------------+  +--------------------------+  +--------------------------+
| id          INT        |  | id           INT         |  | id          INT          |
| name       VARCHAR(255)|  | name         VARCHAR(255)|  | name        VARCHAR(255) |
| points      INT        |  | start_date   DATE        |  | description VARCHAR(1000)|
| duration    DOUBLE     |  | end_date     DATE        |  | deleted_at  TIMESTAMP    |
| assigned_members JSON  |  | task_status_id   JSON    |  +--------------------------+
| deleted_at  TIMESTAMP  |  | description VARCHAR(1000)| 
+------------------------+  | project_id  INT          |
                            | deleted_at  TIMESTAMP    |
                            +--------------------------+

+------------------------+  +------------------------+  +--------------------------+
|     task_statuses      |  |          users         |  |          roles           |
+------------------------+  +------------------------+  +--------------------------+
| id         INT         |  | id         INT         |  | id          INT          |
| name       VARCHAR(255)|  | username   VARCHAR(255)|  | name        VARCHAR(255) |
+------------------------+  | password   VARCHAR(255)|  | description VARCHAR(1000)|
                            | email      VARCHAR(255)|  +--------------------------+
                            | first_name VARCHAR(255)|   
                            | last_name  VARCHAR(255)|  
                            +------------------------+   
                                                        

+------------------------+  +------------------------+  +------------------------+
|  user_has_role         |  |  role_has_permissions  |  |   sprint_has_tasks     |
+------------------------+  +------------------------+  +------------------------+
| id          INT        |  | id            INT      |  | id          INT        |
| user_id     INT        |  | role_id       INT      |  | sprint_id  INT         |
| role_id     INT        |  | permission_id INT      |  | task_id    INT         |
+------------------------+  +------------------------+  | project_id INT         |
                                                        | deleted_at TIMESTAMP   |
                                                        +------------------------+
</pre>

## UI Design

### Mock Wireframes - Project Windows

<pre>
Window 0 :

+------------------------------------------------------------------+
|            Login To The System                [ - ] [ □ ]  [ X ] |
+------------------------------------------------------------------+
| User Name:    |______________________________|                   |
| Password:     |______________________________| [Backend Type:MD5]|
|               [ Login → ]                                        |
+------------------------------------------------------------------+


Window 1 :

+----------------------------------------------------------------------------+
|  Home                                                    [ - ] [ □ ] [ X ] |
+----------------------------------------------------------------------------+
|                                                                            |
|  [ Add New Project → ]     [ Add New Task into Backlog → ]                 |
|                                                                            |
|  [ Go To Projects List → ] [ Go To Tasks List → ]                          |
|                                                                            |
|  [ Go To Sprint Entry → ]  [ Go To Sprint List → ]                         |
|                                                                            |
+----------------------------------------------------------------------------+

 Window 2 :

+------------------------------------------------------+
|    Project Entry                  [ - ] [ □ ]  [ X ] |
+------------------------------------------------------+
|                     Project Name: |______________|   |
|                                                      |
|                      Description: |              |   |
|                                   |              |   |
|                                   |______________|   |
|                                                      |
|                           [Submit →]  [Return →]     |
+------------------------------------------------------+

Window 3:

 +----------------------------------------------------------------------------+
|    Project List                                         [ - ] [ □ ]  [ X ] |
+----------------------------------------------------------------------------+
| ID | Name       | Description                        | Actions             |
|----|------------|------------------------------------|---------------------|
| 1  | Project A  | This is a description.             | [Edit →][Archive →] |
| 2  | Project B  | This is another description.       | [Edit →][Archive →] |
| 3  | Project C  | This is a third description.       | [Edit →][Archive →] |
+----------------------------------------------------------------------------+
|    [Add Another Project →]  [Return →]                                     |
+----------------------------------------------------------------------------+

Window 4:

+--------------------------------------------------------+
|   Project Edit                       [ - ] [ □ ] [ X ] |
+--------------------------------------------------------+
| Project Name:   |_________________|                    |
|                                                        |
| Description:    |                      |               |
|                 |                      |               |
|                 |______________________|               |
|                                                        |
|                            [ Update → ]  [ Return → ]  |
+--------------------------------------------------------+


Window 5:
 ________________________________________________________
|                                    [ - ]  [ □ ]  [ X ] |
|________________________________________________________|
|                                                        |
|                  Task Entry to Backlog                 |
|                  _____________________                 |
|                                                        |
|  Task Name:                      |___________|         |
|                                                        |
|  Sprint Points:                  [       |▼]           |
|                                                        |
|  Duration:                       |____|    [       |▼] |
|                                                        |
|                 Assigned Members:                      |
|  [ ✓ ] User 1   [ ✓ ] User 2                           |
|  [ ✓ ] User 3   [ ✓ ] User 4                           |
|                                                        |
|                        [ Submit → ]                    |
|                                                        |
|               [ Return To Home → ]                     |
|________________________________________________________|


Window 6:
 ___________________________________
|    Task List           [+] [-]  X |
|-----------------------------------|
|  ID | Name | Points | Duration |  |
|-----------------------------------|
|  1  |  T1  |   5    |   1 Day  |  |
|-----------------------------------|
|  2  |  T2  |   3    |  2 Hours |  |
|-----------------------------------|
|  3  |  T3  |   8    |  3 Weeks |  |
|-----------------------------------|
|           [Add Another Task → ]   |
|           [Return To Home → ]     |
|___________________________________|


Window 7:

 _____________________________________
|    Task Edit             [+] [-]  X |
|_____________________________________|
|  Task Name:           |______|      |
|                                     |
|  Sprint Points:       [    |▼]      |
|  Duration: |_____| [Minutes |▼]     |
|                                     |
|  Assigned Members:                  |
|  [ ✓ ] Member 1                     |
|  [ ✓ ] Member 2                     |
|  [ ✓ ] Member 3                     |
|  [ ✓ ] Member 4                     |
|  [ ✓ ] Member 5                     |
|                                     |
|   [Update → ]   [Return To Home → ] |
|_____________________________________|

Window 8:
 ____________________________________________
|             Sprint Entry        [+] [-]  X |
|____________________________________________|
|  Sprint Name:          |______________|    |
|                                            |
|  Start date:           [  /  /    ] ▼      |
|                                            |
|  End date:             [  /  /    ] ▼      |
|                                            |
|  Description:                              |
|  |                                    |    |
|  |                                    |    |
|  |                                    |    |
|  |____________________________________|    |
|                                            |
|  Project Name: [ Select |▼]                |
|                                            |
|      [Submit → ]       [Return to Home → ] |
|____________________________________________|

Window 9:
 _________________________________________________________________________________________________
|  Sprint List                                                                         [+] [-]  X |
|_________________________________________________________________________________________________|
|  ID |SprintName| Start date | End date   | Project ID|                  Actions                 |
|-----|----------|------------|------------|-----------|------------------------------------------|
| 001 | Sprint 1 | 2023-04-10 | 2023-04-20 | Project 1 | Tasks [Manage → ] [Add → ] [Edit → ] [x] |
| 002 | Sprint 2 | 2023-04-22 | 2023-05-02 | Project 2 | Tasks [Manage → ] [Add → ] [Edit → ] [x] |
| 003 | Sprint 3 | 2023-05-04 | 2023-05-14 | Project 3 | Tasks [Manage → ] [Add → ] [Edit → ] [x] |
|_____|__________|____________|____________|___________|__________________________________________|
|                          [Add Another SPrint → ]                                                |
|                          [Return To Home → ]                                                    |
 -------------------------------------------------------------------------------------------------

Window 10:
 ___________________________________________________________
|                 Sprint Edit                    [+] [-]  X |
|___________________________________________________________|
| Sprint Name:   |__________|                               |
| Start date:    [ / / ] ▼                                  |
| End date:      [ / / ] ▼                                  |
|                 ____________________                      |
|  Description   [                    ]                     |
|                [                    ]                     |
|                [____________________]                     |
|                                                           |
| Project ID:    [ Select Option |▼]                        |
|___________________________________________________________|
|                      [ Submit → ]  [ Return To Home → ]   |
 -----------------------------------------------------------

Window 11:
 ________________________________________________________________
|           Task Adding to Sprint `Name`               [+] [-] X |
|________________________________________________________________|
| Select Task Name: [ Select Option |▼]  [ Add Task → ]          |
|                                                                |
| ID | Name | Sprint Points | Duration | Members | Actions       |
|----|------|---------------|----------|---------|---------------|
|    |      |               |          |         | [Remove → ]   |
|    |      |               |          |         | [Remove → ]   |
|    |      |               |          |         | [Remove → ]   |
|    |      |               |          |         | [Remove → ]   |
|    |      |               |          |         | [Remove → ]   |
|    |      |               |          |         | [Remove → ]   |
|    |      |               |          |         | [Remove → ]   |
|    |      |               |          |         | [Remove → ]   |
|    |      |               |          |         | [Remove → ]   |
|    |      |               |          |         | [Remove → ]   |
|________________________________________________________________|
|                       [ Return To Home → ]                     |
 ----------------------------------------------------------------

Window 12:

 _____________________________________________________________________________________
|                                  Manage Tasks of Sprint                   [+] [-] X |
|_____________________________________________________________________________________|
| ID | Name | SPoints | Duration |   Members  |    Task Status    |   Shift Sprint    |
|----|------|---------|----------|------------|---------------------------------------|
| 1  | Task1| 5       | 2 weeks  | John, Mary |     [ Status |▼]  | [Sprint No |▼]    |
| 2  | Task2| 3       | 1 week   | Bob, Sue   |     [ Status |▼]  | [Sprint No |▼]    |
| 3  | Task3| 2       | 3 days   | Jane       |     [ Status |▼]  | [Sprint No |▼]    |
|_____________________________________________________________________________________|
|                            [ Submit → ]                                             |
|                            [ Return To Home → ]                                     |
 -------------------------------------------------------------------------------------

</pre>

## Technologies
- Front-end: Java UI Frames
- Back-end: Java and Mysql

## Contributors
- Supervisor : Dr. Md. Ezharul Islam
- Team : 

        Shaon Majumder (CSE202301040)

        Turag Muhaimen

        Sourav Sur

## Team - Project Roles

The project team will consist of the following members:

- Project Supervisor : Dr. Md. Ezharul Islam

- Product Owner(Scrum) : Dr. Md. Ezharul Islam

- Scrum Master : Shaon Majumder &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Holding Scrum meeting & Scrum Tasks)

- Project Manager : Shaon Majumder &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Team Co-ordination)

- System Analyst : Shaon Majumder &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(System Design)

- Database Administratior : Shaon Majumder &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Database Design)

- Front-end Developer : Shaon Majumder, Turag Muhaimen &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(UI Implementation)

- Back-end Developer : Shaon Majumder, Turag Muhaimen &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(AI & Logics)

- UI/UX Designer : Shaon Majumder &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Wireframe Mocking & Drawing)

- QA Engineer : Sourav Sur &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Testing User Experience)

- Overall Assists : Sourav Sur