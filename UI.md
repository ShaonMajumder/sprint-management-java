## Project Windows

### Window 0

**Label** [Login To The System | Make the font size big]

**Label** [ User Name: ] --- Input Text []

**Label** [ Password: ] --- Input Text Secret [] Backend Type : MD5

**Button** [ Login ] -> Redirect To Window 1

### Window 1

**Button** [ Add New Project ] -> Redirect to Window 2

**Button** [ Add New Task into Backlog ] -> Redirect to Window 5

**Button** [ Go To Projects List ] -> Redirect to Window 3

**Button** [ Go To Tasks List ] -> Redirect to Window 6

**Button** [ Go To Sprint Entry ] -> Redirect to Window 8

**Button** [ Go To Sprint List ] -> Redirect to Window 9

### Window 2

**Label** [Project Entry | Make the font size big]

**Label** [ Project Name: ] --- Input Text []

**Label** [ Description: ] --- Text Area []

**Button** [ Submit ]

**Button** [ Return To Home ]

### Window 3

**Label** [Project List]

**Table**

ID | Name | Description | Actions( **Buttons**[Edit -> Redirect to Window 4,Archive -> Soft Delete] )

**Button** [Add Another Project] -> Redirect to Window 2

**Button** [ Return To Home ]

### Window 4 (Optional)

**Label** [Project Edit | Make the font size big]

**Label** [ Project Name: ] --- Input Text []

**Label** [ Description: ] --- Text Area []

**Button** [ Update ]

**Button** [ Return To Home ]

### Window 5

**Label** [Task Entry to Backlog | Make the font size big]

**Label** [ Task Name: ] --- Input Text []

**Label** [ Sprint Points: ] --- Select Option []

**Label** [ Duration: ] --- Input Text [Integer] --- Select Option [Minutes,Hours,Days,Weeks,Months]

**Label** [ Assigned Members: ] --- Check Boxes [ Options will be populate from Users table]

**Button** [ Submit ]

**Button** [ Return To Home ]

### Window 6

**Label** [Task List]

**Table**

ID | Name | Sprint Points | Duration | Members | Actions( **Buttons**[Edit -> Redirect to Window 7,Archive -> Soft Delete] )

**Button** [Add Another Project] -> Redirect to Window 2

**Button** [ Return To Home ]

### Window 7 (Optional)

**Label** [Task Edit | Make the font size big]

**Label** [ Task Name: ] --- Input Text []

**Label** [ Sprint Points: ] --- Select Option [Selected]

**Label** [ Duration: ] --- Input Text [Integer] --- Select Option [Minutes,Hours,Days,Weeks,Months] Selected

**Label** [ Assigned Members: ] --- Check Boxes [ Options will be populate from Users table]

**Button** [ Update ]

**Button** [ Return To Home ]

### Window 8

**Label** [Sprint Entry | Make the font size big]

**Label** [ Sprint Name: ] --- Input Text []

**Label** [ Start date: ] --- Calendar []

**Label** [ End date: ] --- Calendar []

**Label** [ Description: ] --- Text Area []

**Label** [ Project ID: ] --- Select Option []

**Button** [ Submit ]

**Button** [ Return To Home ]

### Window 9

**Label** [Sprint List | | Make the font size big]

Table
ID | Sprint Name | Start date | End date | Project Name | Actions( Buttons[Manage Tasks -> Redirect To Window 12,Add Tasks -> Redirect to Window 11,Edit -> Redirect to Window 10,Archive -> Soft Delete] )

Button [Add Another Sprint] -> Redirect to Window 8
Button [ Return To Home ]

### Window 10 (Optional)

**Label** [Sprint Edit | Make the font size big]
**Label** [ Sprint Name: ] --- Input Text []
**Label** [ Start date: ] --- Calendar []Selected
**Label** [ End date: ] --- Calendar []Selected
**Label** [ Description: ] --- Text Area []
**Label** [ Project ID: ] --- Select Option []Selected

Button [ Submit ]
Button [ Return To Home ]

### Window 11

**Label** [Task Adding to Sprint `Name` | Make the font size big]
**Label** [ Select Task Name: ] --- Select Option []Selected --- button[Add Task]

Task Table
ID | Name | Sprint Points | Duration | Members | Action [Remove Task]
Button [ Return To Home ]

### Window 12

**Label** [Manage Tasks of Sprint | Make the font size big]

Task Table
ID | Name | Sprint Points | Duration | Members(Not Updatable) | Change Task Status(Select Options[]) | Shift to Sprint(Select Options[])
Button [ Return To Home ]

### Window Drawing

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
|                     Description:   ______________    |
|                                   [              ]   |
|                                   [              ]   |
|                                   [______________]   |
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
| Description:                                           |
|   ______________________                               |
|  [                      ]                              |
|  [                      ]                              |
|  [______________________]                              |
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
|  Sprint Points:                  [     ▼   ]           |
|                                                        |
|  Duration:                       [____]    [     ▼   ] |
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
|   ____________________________________
|  [                                    ]    |
|  [                                    ]    |
|  [                                    ]    |
|  [____________________________________]    |
|                                            |
|  Project Name: [ Select ]v                 |
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
|                       [ Return To Home → ]                       |
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
