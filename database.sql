DROP DATABASE IF EXISTS sprint_management;
CREATE DATABASE IF NOT EXISTS sprint_management CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE sprint_management;

CREATE TABLE IF NOT EXISTS projects (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(1000),
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS sprints (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(1000),
  start_date DATE,
  end_date DATE,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS tasks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(1000),
  points INT,
  duration DOUBLE,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS task_statuses (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255),
  email VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS roles (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(1000),
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS permissions (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(1000),
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS user_has_role (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  role_id INT,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS role_has_permissions (
  id INT PRIMARY KEY AUTO_INCREMENT,
  role_id INT,
  permission_id INT,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS project_sprint_has_tasks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  project_id INT,
  sprint_id INT,
  task_id INT,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS task_has_members (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT,
  task_id INT,
  created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  deleted_at TIMESTAMP NULL
);

INSERT INTO task_statuses (id, name) VALUES
(1, 'Open'),
(2, 'In Progress'),
(3, 'Dev Complete'),
(4, 'Test In Progress'),
(5, 'Bug'),
(6, 'Completed'),
(7, 'Closed');

INSERT INTO `users` (`id`, `username`, `password`, `email`, `first_name`, `last_name`) VALUES
(1, 'admin', '25d55ad283aa400af464c76d713c07ad', 'admin@admin.com', 'Primary', 'Admin'),
(2, 'turag', '25d55ad283aa400af464c76d713c07ad', 'turag@admin.com', 'Turag', 'Muhaimen'),
(3, 'sourav', '25d55ad283aa400af464c76d713c07ad', 'sourav@admin.com', 'Sourav', 'Sur'),
(4, 'shaon', '25d55ad283aa400af464c76d713c07ad', 'shaon@admin.com', 'Shaon', 'Majumder');

INSERT INTO permissions (name, description) VALUES 
('Task Create', 'Permission to CREATE IF NOT EXISTS a new task'),
('Task Delete', 'Permission to delete a task'),
('Task Update', 'Permission to update an existing task'),
('Copy Task ID', 'Permission to copy the task ID'),
('Sprint Create', 'Permission to CREATE IF NOT EXISTS a new sprint'),
('Sprint Delete', 'Permission to delete a sprint'),
('Sprint Update', 'Permission to update an existing sprint'),
('Sprint Shift', 'Permission to shift tasks between sprints');

INSERT INTO roles (name, description) VALUES
('CTO', 'Responsible for technology strategy and innovation.'),
('Software Developer', 'Responsible for writing code and developing software.'),
('Project Manager', 'Responsible for managing projects and overseeing the development process.'),
('Quality Assurance Engineer', 'Responsible for testing software to ensure it meets quality standards.'),
('DevOps Engineer', 'Responsible for automating and streamlining the software delivery process, and managing the infrastructure that supports it.');

INSERT INTO projects (name, description) VALUES
('Project A', 'This is the description for Project A.'),
('Project B', 'This is the description for Project B.'),
('Project C', 'This is the description for Project C.');
