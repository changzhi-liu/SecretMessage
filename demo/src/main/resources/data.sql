drop table if exists UserDetail;
CREATE TABLE USERDETAIL (
  user_id BIGINT(40) NOT NULL auto_increment  primary key,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(50) NOT null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;




INSERT INTO UserDetail VALUES (1, 'Mike', '81dc9bdb52d04dc20036dbd8313ed055');

CREATE TABLE IF NOT EXISTS message (
    msg_index BIGINT(60) unsigned NOT null AUTO_INCREMENT,
    sender VARCHAR(50) NOT NULL,
    reciever VARCHAR(50) NOT NULL,
	sender_id BIGINT(40) NOT NULL,
    reciever_id BIGINT(40) NOT NULL,
    content VARCHAR(256),
    validation int not null,
    send_time timestamp,
	primary key (msg_index)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS friends (
    sender_id BIGINT(40) NOT NULL,
    reciever_id BIGINT(40) NOT NULL,
    msg_starting_index  INT UNSIGNED NOT NULL,
    msg_current_index  INT UNSIGNED NOT NULL,
    primary key (sender_id,reciever_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO UserDetail VALUES (1, 'a', 'a');
INSERT INTO UserDetail VALUES (2, 'b', 'b');
INSERT INTO UserDetail VALUES (3, 'c', 'c');

INSERT INTO friends VALUES (1, 2, 100, 100);
INSERT INTO friends VALUES (2, 1, 149, 149);
INSERT INTO friends VALUES (3, 1, 200, 200);
INSERT INTO friends VALUES (2, 3, 249, 249);
INSERT INTO friends VALUES (3, 2, 300, 300);
INSERT INTO friends VALUES (1, 3, 349, 349);






INSERT INTO  message 
    VALUES
    (0, 'a', 'b', 'HI', XXXX-XX-XX xx:xx:xx),
    (1, 'a', 'b', 'HOW ARE YOU', XXXX-XX-XX xx:xx:xx),
    (2, 'a', 'b', 'WANNA HANG OUT', XXXX-XX-XX xx:xx:xx),
    (50, 'b', 'a', 'I AM GREAT', XXXX-XX-XX xx:xx:xx),
    (51, 'b', 'a', 'HOW ABOUT YOU', XXXX-XX-XX xx:xx:xx);


