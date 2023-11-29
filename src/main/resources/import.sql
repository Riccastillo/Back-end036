INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('heisenberg', '12345', 1, 'Walter', 'White', 'walter@uanl.edu.mx');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('TonyS', '123456', 1, 'Anthony', 'Soprano', 'tony@uanl.edu.mx');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (1,1)
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2,2)
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2,1)
