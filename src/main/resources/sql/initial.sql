CREATE TABLE user_info (
  id serial PRIMARY KEY,
  username text,
  experience int,
  user_level integer
);

CREATE TABLE genre (
  id SERIAL PRIMARY KEY,
  name text
);

CREATE TABLE author (
  id SERIAL PRIMARY KEY,
  name text
);

CREATE TABLE book (
  id SERIAL PRIMARY KEY,
  title text,
  genre_id serial references genre(id),
  author_id serial references author(id),
  constraint unique_book unique (title, genre_id, author_id)
);

CREATE TABLE book_library (
  user_id integer references user_info(id),
  book_id integer references book(id),
  primary key (user_id, book_id)
);