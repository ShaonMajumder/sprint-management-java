## Project Windows

## Window 0

**Label** [Login To The System | Make the font size big]

**Label** [ User Name: ] --- Input Text []

**Label** [ Password: ] --- Input Text Secret [] Backend Type : MD5

**Button** [ Login ] -> Redirect To Window 1

## Window 1

**Button** [ Add New Project ] -> Redirect to Window 2

**Button** [ Add New Task into Backlog ] -> Redirect to Window 5

**Button** [ Go To Projects List ] -> Redirect to Window 3

**Button** [ Go To Tasks List ] -> Redirect to Window 6

**Button** [ Go To Sprint Entry ] -> Redirect to Window 8

**Button** [ Go To Sprint List ] -> Redirect to Window 9

## Window 2

**Label** [Project Entry | Make the font size big]

**Label** [ Project Name: ] --- Input Text []

**Label** [ Description: ] --- Text Area []

**Button** [ Submit ]

**Button** [ Return To Home ]

## Window 3

**Label** [Project List]

**Table**

ID | Name | Description | Actions( **Buttons**[Edit -> Redirect to Window 4,Archive -> Soft Delete] )

**Button** [Add Another Project] -> Redirect to Window 2

**Button** [ Return To Home ]

## Window 4 (Optional)

**Label** [Project Edit | Make the font size big]

**Label** [ Project Name: ] --- Input Text []

**Label** [ Description: ] --- Text Area []

**Button** [ Update ]

**Button** [ Return To Home ]

## Window 5

**Label** [Task Entry to Backlog | Make the font size big]

**Label** [ Task Name: ] --- Input Text []

**Label** [ Sprint Points: ] --- Select Option []

**Label** [ Duration: ] --- Input Text [Integer] --- Select Option [Minutes,Hours,Days,Weeks,Months]

**Label** [ Assigned Members: ] --- Check Boxes [ Options will be populate from Users table]

**Button** [ Submit ]

**Button** [ Return To Home ]

## Window 6

**Label** [Task List]

**Table**

ID | Name | Sprint Points | Duration | Members | Actions( **Buttons**[Edit -> Redirect to Window 7,Archive -> Soft Delete] )

**Button** [Add Another Project] -> Redirect to Window 2

**Button** [ Return To Home ]

## Window 7 (Optional)

**Label** [Task Edit | Make the font size big]

**Label** [ Task Name: ] --- Input Text []

**Label** [ Sprint Points: ] --- Select Option [Selected]

**Label** [ Duration: ] --- Input Text [Integer] --- Select Option [Minutes,Hours,Days,Weeks,Months] Selected

**Label** [ Assigned Members: ] --- Check Boxes [ Options will be populate from Users table]

**Button** [ Update ]

**Button** [ Return To Home ]

## Window 8

**Label** [Sprint Entry | Make the font size big]

**Label** [ Sprint Name: ] --- Input Text []

**Label** [ Start date: ] --- Calendar []

**Label** [ End date: ] --- Calendar []

**Label** [ Description: ] --- Text Area []

**Label** [ Project ID: ] --- Select Option []

**Button** [ Submit ]

**Button** [ Return To Home ]## Project Windows

## Window 0

**Label** [Login To The System | Make the font size big]

**Label** [ User Name: ] --- Input Text []

**Label** [ Password: ] --- Input Text Secret [] Backend Type : MD5

**Button** [ Login ] -> Redirect To Window 1

## Window 1

**Button** [ Add New Project ] -> Redirect to Window 2

**Button** [ Add New Task into Backlog ] -> Redirect to Window 5

**Button** [ Go To Projects List ] -> Redirect to Window 3

**Button** [ Go To Tasks List ] -> Redirect to Window 6

**Button** [ Go To Sprint Entry ] -> Redirect to Window 8

**Button** [ Go To Sprint List ] -> Redirect to Window 9

## Window 2

**Label** [Project Entry | Make the font size big]

**Label** [ Project Name: ] --- Input Text []

**Label** [ Description: ] --- Text Area []

**Button** [ Submit ]

**Button** [ Return To Home ]

## Window 3

**Label** [Project List]

**Table**

ID | Name | Description | Actions( **Buttons**[Edit -> Redirect to Window 4,Archive -> Soft Delete] )

**Button** [Add Another Project] -> Redirect to Window 2

**Button** [ Return To Home ]

## Window 4 (Optional)

**Label** [Project Edit | Make the font size big]

**Label** [ Project Name: ] --- Input Text []

**Label** [ Description: ] --- Text Area []

**Button** [ Update ]

**Button** [ Return To Home ]

## Window 5

**Label** [Task Entry to Backlog | Make the font size big]

**Label** [ Task Name: ] --- Input Text []

**Label** [ Sprint Points: ] --- Select Option []

**Label** [ Duration: ] --- Input Text [Integer] --- Select Option [Minutes,Hours,Days,Weeks,Months]

**Label** [ Assigned Members: ] --- Check Boxes [ Options will be populate from Users table]

**Button** [ Submit ]

**Button** [ Return To Home ]

## Window 6

**Label** [Task List]

**Table**

ID | Name | Sprint Points | Duration | Members | Actions( **Buttons**[Edit -> Redirect to Window 7,Archive -> Soft Delete] )

**Button** [Add Another Project] -> Redirect to Window 2

**Button** [ Return To Home ]

## Window 7 (Optional)

**Label** [Task Edit | Make the font size big]

**Label** [ Task Name: ] --- Input Text []

**Label** [ Sprint Points: ] --- Select Option [Selected]

**Label** [ Duration: ] --- Input Text [Integer] --- Select Option [Minutes,Hours,Days,Weeks,Months] Selected

**Label** [ Assigned Members: ] --- Check Boxes [ Options will be populate from Users table]

**Button** [ Update ]

**Button** [ Return To Home ]

## Window 8

**Label** [Sprint Entry | Make the font size big]

**Label** [ Sprint Name: ] --- Input Text []

**Label** [ Start date: ] --- Calendar []

**Label** [ End date: ] --- Calendar []

**Label** [ Description: ] --- Text Area []

**Label** [ Project ID: ] --- Select Option []

**Button** [ Submit ]

**Button** [ Return To Home ]

## Window 9

**Label** [Sprint List]

**Label** [ Sprint Name: ] --- Input Text []
**Label** [ Start date: ] --- Calendar []
**Label** [ End date: ] --- Calendar []
**Label** [ Description: ] --- Text Area []
**Label** [ Project ID: ] --- Select Option []

Table
ID | Sprint Name | Start date | End date | Project Name | Actions( Buttons[Manage Tasks -> Redirect To Window 12,Add Tasks -> Redirect to Window 11,Edit -> Redirect to Window 10,Archive -> Soft Delete] )

Button [Add Another Sprint] -> Redirect to Window 8
Button [ Return To Home ]

## Window 10 (Optional)

**Label** [Sprint Edit | Make the font size big]
**Label** [ Sprint Name: ] --- Input Text []
**Label** [ Start date: ] --- Calendar []Selected
**Label** [ End date: ] --- Calendar []Selected
**Label** [ Description: ] --- Text Area []
**Label** [ Project ID: ] --- Select Option []Selected

Button [ Submit ]
Button [ Return To Home ]

## Window 11

**Label** [Task Adding to Sprint `Name` | Make the font size big]
**Label** [ Select Task Name: ] --- Select Option []Selected --- button[Add Task]

Task Table
ID | Name | Sprint Points | Duration | Members | Action [Remove Task]

## Window 12

**Label** [Manage Tasks of Sprint | Make the font size big]

Task Table
ID | Name | Sprint Points | Duration | Members(Not Updatable) | Change Task Status(Select Options[]) | Shift to Sprint(Select Options[])
