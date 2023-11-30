INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('heisenberg', '$2a$10$0aL4NdCsFD2PzzRSEM9E/u4yfBFhpU2edscKwggtSGyYUJjJvGrlG', 1, 'Walter', 'White', 'walter@uanl.edu.mx');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('TonyS', '$2a$10$o7APTfML7xfM8yrUgn6WVObd3HJtu0sYhJjxnuYO5ux44zuakIchG', 1, 'Anthony', 'Soprano', 'tony@uanl.edu.mx');

INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (1,1)
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2,2)
INSERT INTO usuarios_to_roles (user_id, rooles_id) VALUES (2,1)
