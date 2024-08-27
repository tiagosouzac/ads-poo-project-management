CREATE ROLE IF NOT EXISTS 'user_role';

GRANT SELECT, INSERT, UPDATE, DELETE ON project_management.* TO 'user_role';

CREATE USER 'user'@'127.0.0.1' IDENTIFIED BY 'password';

REVOKE ALL PRIVILEGES ON *.* FROM 'user'@'127.0.0.1';

GRANT 'user_role' TO 'user'@'127.0.0.1';

SET DEFAULT ROLE 'user_role' TO 'user'@'127.0.0.1';

FLUSH PRIVILEGES;