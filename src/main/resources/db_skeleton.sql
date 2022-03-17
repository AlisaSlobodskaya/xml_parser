CREATE TABLE Books
(
    id          serial  not null,
    vendorCode  text    not null,
    author      text    not null,
    title       text    not null,
    genre       text    not null,
    price       numeric not null,
    publishDate date    not null,
    description text    not null
);