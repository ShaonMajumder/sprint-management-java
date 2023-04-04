# Sprint Management

## Table Design

<pre>
+-------------------+ +---------------------+ +----------------+ +---------------+
| tasks | | sprints | | projects | | task_statuses |
+-------------------+ +---------------------+ +----------------+ +---------------+
| id (PK) | | id (PK) | | id (PK) | | id |
| name | | name | | name | | name |
| points | | start_date | | description | +---------------+
| duration | | end_date | | deleted_at |
| assigned_members | | task_status_id (FK) | +----------------+
| deleted_at | | description |
+-------------------+ | project_id (FK) |
| deleted_at |
+---------------------+

+-------------------+ +-----------------+ +------------+
| users | | roles | | permissions|
+-------------------+ +-----------------+ +------------+
| id (PK) | | id (PK) | | id |
| username | | name | | name |
| password | | description | | description|
| email | +-----------------+ +------------+
| first_name |
| last_name |
+-------------------+
</pre>
