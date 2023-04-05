CREATE DATABASE IF NOT EXISTS sprint_management CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE sprint_management;

CREATE TABLE tasks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  points INT,
  duration DOUBLE,
  assigned_members JSON,
  deleted_at TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE sprints (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  start_date DATE,
  end_date DATE,
  task_status_id JSON,
  description VARCHAR(1000),
  project_id INT,
  deleted_at TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE projects (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(1000),
  deleted_at TIMESTAMP NULL DEFAULT NULL
);

CREATE TABLE task_statuses (
  id INT PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  first_name VARCHAR(255),
  last_name VARCHAR(255)
);

CREATE TABLE roles (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(1000)
);

CREATE TABLE permissions (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(1000)
);

CREATE TABLE user_has_role (
  id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  role_id INT NOT NULL
);

CREATE TABLE role_has_permission (
  id INT PRIMARY KEY AUTO_INCREMENT,
  role_id INT NOT NULL,
  permission_id INT NOT NULL
);

CREATE TABLE sprint_has_tasks (
  id INT PRIMARY KEY AUTO_INCREMENT,
  sprint_id INT NOT NULL,
  task_id INT NOT NULL,
  project_id INT NOT NULL,
  deleted_at TIMESTAMP NULL DEFAULT NULL
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
(3, 'sourav', '25d55ad283aa400af464c76d713c07ad', 'sourav@admin.com', 'Sourav', 'Sur');
(4, 'shaon', '25d55ad283aa400af464c76d713c07ad', 'shaon@admin.com', 'Shaon', 'Majumder');

INSERT INTO permissions (name, description) VALUES 
('Task Create', 'Permission to create a new task'),
('Task Delete', 'Permission to delete a task'),
('Task Update', 'Permission to update an existing task'),
('Copy Task ID', 'Permission to copy the task ID'),
('Sprint Create', 'Permission to create a new sprint'),
('Sprint Delete', 'Permission to delete a sprint'),
('Sprint Update', 'Permission to update an existing sprint'),
('Sprint Shift', 'Permission to shift tasks between sprints');



INSERT INTO roles (name, description) VALUES
('CTO', 'Responsible for technology strategy and innovation.'),
('Software Developer', 'Responsible for writing code and developing software.'),
('Project Manager', 'Responsible for managing projects and overseeing the development process.'),
('Quality Assurance Engineer', 'Responsible for testing software to ensure it meets quality standards.'),
('DevOps Engineer', 'Responsible for automating and streamlining the software delivery process, and managing the infrastructure that supports it.');

