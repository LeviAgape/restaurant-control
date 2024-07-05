CREATE TABLE restaurant(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name_restaurant TEXT NOT NULL,
    password TEXT NOT NULL,
    state TEXT NOT NULL,
    city TEXT NOT NULL,
    neighborhood TEXT NOT NULL,
    street_number INTEGER NOT NULL
);