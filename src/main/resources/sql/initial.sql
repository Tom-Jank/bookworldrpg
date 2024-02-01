CREATE TABLE user_info (
  id integer PRIMARY KEY,
  username text,
  experience int,
  user_level integer
);

CREATE TABLE book (
  id integer PRIMARY KEY,
  title text,
  genre_id integer,
  author_id integer
);

CREATE TABLE genre (
  id integer PRIMARY KEY,
  name text
);

CREATE TABLE author (
  id integer PRIMARY KEY,
  name text
);

CREATE TABLE book_library (
  user_id integer references user_info(id),
  book_id integer references book(id),
  primary key (user_id, book_id)
);

ALTER TABLE genre ADD FOREIGN KEY (id) REFERENCES book (id);

ALTER TABLE author ADD FOREIGN KEY (id) REFERENCES book (id);