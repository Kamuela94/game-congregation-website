CREATE TABLE Users(
	username VARCHAR2(32) NOT NULL,
	password VARCHAR2(64) NOT NULL,
	token VARCHAR2(128) NOT NULL,
	CONSTRAINT pk_username PRIMARY KEY(username)
);

CREATE TABLE Topics(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR2(32) NOT NULL,
	CONSTRAINT pk_topic_id PRIMARY KEY(id)
);

CREATE TABLE Posts(
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR2(128) NOT NULL,
	description VARCHAR2(256),
	url VARCHAR2(256),
	topic INT NOT NULL,
	CONSTRAINT pk_post_id PRIMARY KEY(id),
	CONSTRAINT fk_topic_id FOREIGN KEY(topic) REFERENCES Topics(id) ON DELETE CASCADE,
);

CREATE TABLE Comments(
	id INT NOT NULL AUTO_INCREMENT,
	user VARCHAR2(32) NOT NULL,
	comment VARCHAR2(256) NOT NULL,
	dateSent DATETIME() NOT NULL,
	CONSTRAINT pk_comment_id PRIMARY KEY(id),
	CONSTRAINT fk_user FOREIGN KEY(user) REFERENCES Users(username) ON DELETE CASCADE
);