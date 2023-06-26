CREATE TABLE IF NOT EXISTS user (
  id INT UNSIGNED NOT NULL PRIMARY KEY,
  user_name VARCHAR(15) NOT NULL,
  personal_signature VARCHAR(50),
  gender varchar(10) NOT NULL,
  INDEX(id),
  FOREIGN KEY(id) REFERENCES account(id)
);

CREATE TABLE IF NOT EXISTS account (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(32) NOT NULL UNIQUE,
  password varchar(10) NOT NULL,
  INDEX(id)
);

CREATE TABLE IF NOT EXISTS admin_account (
  id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(32) NOT NULL UNIQUE,
  password varchar(10) NOT NULL,
  INDEX(id)
);

CREATE TABLE IF NOT EXISTS user_preference (
  user_id INT UNSIGNED NOT NULL,
  tag VARCHAR(8) NOT NULL,
	CONSTRAINT PK_Preference PRIMARY KEY (user_id,tag),
  FOREIGN KEY (user_id) REFERENCES account(id),
  INDEX(user_id)
);

CREATE TABLE IF NOT EXISTS subscribe (
  user_id INT UNSIGNED NOT NULL,
	subscribed_id INT UNSIGNED NOT NULL,
	CONSTRAINT PK_Subscribe PRIMARY KEY (user_id,subscribed_id),
  FOREIGN KEY(subscribed_id) REFERENCES account(id),
	FOREIGN KEY(user_id) REFERENCES account(id),
  INDEX(user_id)
);

CREATE TABLE IF NOT EXISTS shot (
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNSIGNED NOT NULL,
	title VARCHAR(20) NOT NULL,
	content VARCHAR(50),
	total_thumb INT UNSIGNED NOT NULL,
	total_collect INT UNSIGNED NOT NULL,
	page_view INT UNSIGNED NOT NULL,
	time DATETIME NOT NULL,
	FOREIGN KEY(user_id) REFERENCES account(id),
  INDEX(id)
);

CREATE TABLE IF NOT EXISTS thumb_of_shot (
  shot_id INT UNSIGNED NOT NULL,
	thumber_id INT UNSIGNED NOT NULL,
	is_read BOOLEAN NOT NULL,
	CONSTRAINT PK_ShotThumb PRIMARY KEY (shot_id,thumber_id),
     FOREIGN KEY (shot_id) REFERENCES shot(id),
	FOREIGN KEY (thumber_id) REFERENCES account(id),
    INDEX(shot_id)
);

CREATE TABLE IF NOT EXISTS collect_of_shot (
    shot_id INT UNSIGNED NOT NULL,
    collector_id INT UNSIGNED NOT NULL,
	CONSTRAINT PK_ShotCollect PRIMARY KEY (shot_id,collector_id),
    FOREIGN KEY (shot_id) REFERENCES shot(id),
	FOREIGN KEY (collector_id) REFERENCES account(id),
    INDEX(shot_id)
);

CREATE TABLE IF NOT EXISTS shot_tags (
  shot_id INT UNSIGNED NOT NULL,
  tag VARCHAR(8) NOT NULL,
	CONSTRAINT PK_ShotTags PRIMARY KEY (shot_id,tag),
  FOREIGN KEY (shot_id) REFERENCES shot(id),
  INDEX(shot_id)
);

CREATE TABLE IF NOT EXISTS comment_of_shot (
  id INT UNSIGNED NOT NULL,
  shot_id INT UNSIGNED NOT NULL,
	parent_id INT UNSIGNED NOT NULL,
	commentator_id INT UNSIGNED NOT NULL,
  content VARCHAR(256) NOT NULL,
	time DATETIME NOT NULL,
	is_read BOOLEAN NOT NULL,
	CONSTRAINT PK_ShotTags PRIMARY KEY (shot_id,id),
  FOREIGN KEY (shot_id) REFERENCES shot(id),
	FOREIGN KEY (commentator_id) REFERENCES account(id),
  INDEX(shot_id)
);
-- 写triggers 要有爹

-- post---------------------------------
CREATE TABLE IF NOT EXISTS post (
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  user_id INT UNSIGNED NOT NULL,
	title VARCHAR(50) NOT NULL,
	content VARCHAR(512),
	total_thumb INT UNSIGNED NOT NULL,
	total_collect INT UNSIGNED NOT NULL,
	page_view INT UNSIGNED NOT NULL,
	time DATETIME NOT NULL,
	FOREIGN KEY(user_id) REFERENCES account(id),
  INDEX(id)
);

CREATE TABLE IF NOT EXISTS thumb_of_post (
  post_id INT UNSIGNED NOT NULL,
	thumber_id INT UNSIGNED NOT NULL,
	is_read BOOLEAN NOT NULL,
	CONSTRAINT PK_PostThumb PRIMARY KEY (post_id,thumber_id),
  FOREIGN KEY (post_id) REFERENCES post(id),
	FOREIGN KEY (thumber_id) REFERENCES account(id),
  INDEX(post_id)
);

CREATE TABLE IF NOT EXISTS collect_of_post (
  post_id INT UNSIGNED NOT NULL,
	collector_id INT UNSIGNED NOT NULL,
	CONSTRAINT PK_PostCollect PRIMARY KEY (post_id,collector_id),
  FOREIGN KEY (post_id) REFERENCES post(id),
	FOREIGN KEY (collector_id) REFERENCES account(id),
  INDEX(post_id)
);

CREATE TABLE IF NOT EXISTS comment_of_post(
	id INT UNSIGNED NOT NULL,
  post_id INT UNSIGNED NOT NULL,
	parent_id INT UNSIGNED NOT NULL,
	commentator_id INT UNSIGNED NOT NULL,
  content VARCHAR(256) NOT NULL,
	time DATETIME NOT NULL,
	is_read BOOLEAN NOT NULL,
	CONSTRAINT PK_ShotTags PRIMARY KEY (post_id,id),
  FOREIGN KEY (post_id) REFERENCES post(id),
	FOREIGN KEY (commentator_id) REFERENCES account(id),
  INDEX(post_id)
);

CREATE TABLE IF NOT EXISTS login_log (
  user_id INT UNSIGNED NOT NULL,
	time DATETIME NOT NULL,
	browser VARCHAR(16),
	CONSTRAINT PK_log PRIMARY KEY (user_id,time),
	FOREIGN KEY (user_id) REFERENCES account(id),
  INDEX(time)
);



